@file:Suppress("unused")

package com.chrynan.navigation

/**
 * Represents a store of navigation state information that is useful for a [Navigator].
 */
sealed interface NavigationStateStore<Destination : NavigationDestination, Context : NavigationContext<Destination>> {

    /**
     * A [NavigationState] of [NavigationEvent]s.
     */
    val event: NavigationState<NavigationEvent<Destination, Context>?>

    /**
     * A [NavigationState] of [NavigationDestination]s.
     */
    val destination: NavigationState<Destination>

    /**
     * A [NavigationState] of [NavigationContext]s.
     */
    val context: NavigationState<Context>

    companion object
}

/**
 * A mutable version of a [NavigationStateStore].
 */
internal sealed interface MutableNavigationStateStore<Destination : NavigationDestination, Context : NavigationContext<Destination>> :
    NavigationStateStore<Destination, Context> {

    /**
     * Dispatches the provided navigation [event] which mutates the underlying state values.
     *
     * @return `true` if the navigation event was handled, or `false` if the event could not be handled (ex: a back
     * navigation event was provided but there are no destinations to go back to). If `false` is returned, the
     * underlying state values were not mutated.
     */
    fun dispatch(event: NavigationEvent<Destination, Context>): Boolean

    /**
     * Resets the underlying state values back to their initial values.
     */
    fun reset()
}

/**
 * Creates a [MutableNavigationStateStore] instance with the provided [initialContext] value.
 */
internal fun <Destination : NavigationDestination, Context : NavigationContext<Destination>> mutableNavigationStateStoreOf(
    initialContext: Context,
    duplicateStrategy: StackDuplicateDestinationStrategy = StackDuplicateDestinationStrategy.ALLOW_DUPLICATES
): MutableNavigationStateStore<Destination, Context> =
    MapBasedMutableNavigationStateStore(initialContext = initialContext, duplicateStrategy = duplicateStrategy)

/**
 * A [MutableNavigationStateStore] implementation that stores [NavigationContext]s and their associated
 * [NavigationDestination] [Stack]s in an in-memory [Map].
 */
internal class MapBasedMutableNavigationStateStore<Destination : NavigationDestination, Context : NavigationContext<Destination>> internal constructor(
    private val initialContext: Context,
    private val duplicateStrategy: StackDuplicateDestinationStrategy = StackDuplicateDestinationStrategy.ALLOW_DUPLICATES // TODO
) : MutableNavigationStateStore<Destination, Context> {

    override val event: NavigationState<NavigationEvent<Destination, Context>?>
        get() = mutableEvent
    override val destination: NavigationState<Destination>
        get() = mutableDestination
    override val context: NavigationState<Context>
        get() = mutableContext

    private val mutableEvent = mutableNavigationStateOf<NavigationEvent<Destination, Context>?>(initial = null)
    private val mutableDestination = mutableNavigationStateOf(initial = initialContext.initialDestination)
    private val mutableContext = mutableNavigationStateOf(initial = initialContext)

    private val navigationStacks = NavigationContextStacks(initialContext = initialContext)
    private val forwardNavigationEventStack = mutableStackOf<NavigationEvent.Forward<Destination, Context>>()

    override fun dispatch(event: NavigationEvent<Destination, Context>): Boolean =
        when (event) {
            is NavigationEvent.Backward -> goBack(event = event)

            is NavigationEvent.Forward.Destination -> {
                forwardNavigationEventStack.push(event)

                val context = peekCurrentContext()

                navigationStacks.push(context = context, destination = event.destination)

                updateState(
                    event = event,
                    context = context,
                    destination = event.destination
                )

                true
            }

            is NavigationEvent.Forward.Context -> {
                forwardNavigationEventStack.push(event)

                updateState(
                    event = event,
                    context = event.context,
                    destination = navigationStacks.peek(context = event.context)
                )

                true
            }
        }

    override fun reset() {
        mutableContext.reset()
        mutableDestination.reset()
        mutableContext.reset()

        navigationStacks.clear()
        forwardNavigationEventStack.clear()
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is MapBasedMutableNavigationStateStore<*, *>) return false

        if (initialContext != other.initialContext) return false
        if (duplicateStrategy != other.duplicateStrategy) return false
        if (event != other.event) return false
        if (destination != other.destination) return false

        return context == other.context
    }

    override fun hashCode(): Int {
        var result = initialContext.hashCode()
        result = 31 * result + duplicateStrategy.hashCode()
        result = 31 * result + event.hashCode()
        result = 31 * result + destination.hashCode()
        result = 31 * result + context.hashCode()
        return result
    }

    override fun toString(): String =
        "MapBasedMutableNavigationStateStore(initialContext=$initialContext, duplicateStrategy=$duplicateStrategy, event=$event, destination=$destination, context=$context)"

    private fun goBack(event: NavigationEvent.Backward<Destination, Context>): Boolean {
        if (forwardNavigationEventStack.isEmpty()) return false

        when (val currentEvent = forwardNavigationEventStack.pop()) {
            is NavigationEvent.Forward.Context -> {
                // If we can't navigate back across contexts, return false
                if (event.kind != NavigationEvent.Backward.Kind.ACROSS_CONTEXTS) {
                    // Add the current event back on to the stack before we return false, because we can't perform the
                    // action, so we don't want to change the stack from when we started.
                    forwardNavigationEventStack.push(currentEvent)

                    return false
                }

                // Get the current context after we popped the last context change from the top of the stack.
                val newContext = peekCurrentContext()

                updateState(
                    event = event,
                    context = newContext,
                    destination = navigationStacks.peek(context = newContext)
                )

                return true
            }

            is NavigationEvent.Forward.Destination -> {
                val context = peekCurrentContext()
                val destination = popToPreviousDestinationForContext(context = context) ?: return false

                updateState(
                    event = event,
                    context = context,
                    destination = destination
                )

                return true
            }
        }
    }

    private fun updateState(
        event: NavigationEvent<Destination, Context>,
        context: Context,
        destination: Destination
    ) {
        this.mutableContext.update(state = context)
        this.mutableDestination.update(state = destination)
        this.mutableEvent.update(state = event)
    }

    private fun peekCurrentContext(): Context =
        forwardNavigationEventStack
            .filterIsInstance<NavigationEvent.Forward.Context<Destination, Context>>()
            .lastOrNull()?.context ?: initialContext

    /**
     * Pops the top destination off the provided [context] stack and returns the new top destination, or `null` if the
     * provided [context] stack could not be popped (there must be at least one item in the stack at all times).
     */
    private fun popToPreviousDestinationForContext(context: Context): Destination? {
        navigationStacks.pop(context) ?: return null

        return navigationStacks.peek(context)
    }
}
