@file:Suppress("unused")

package com.chrynan.navigation

/**
 * A [Navigator] is responsible for coordinating the navigation between the different UI component groupings in an
 * application.
 *
 * A [Navigator] is platform and UI framework dependent, so each implementation depends on the particular UI framework
 * used, for example, Jetpack Compose.
 */
interface Navigator<Destination : NavigationDestination, Context : NavigationContext<Destination>> {

    /**
     * The [NavigatorState] for this [Navigator] instance. This can be used to subscribe to destination or context
     * changes, or get the current state values.
     */
    val state: NavigatorState<Destination, Context>

    /**
     * Navigates to the provided [event].
     *
     * @param [event] The [DestinationEvent] that represents the navigation action to be performed.
     */
    fun navigate(event: DestinationEvent<Destination>): Boolean

    /**
     * Determines whether the [Navigator] can navigate back in the stack in the current [Context].
     *
     * @return `true` if this [Navigator] can navigate back, `false` otherwise.
     */
    fun canGoBack(): Boolean

    /**
     * Changes the current [Context] to the provided [context] value. The displayed [Destination] will top destination
     * value in the stack associated with the provided [context], or the provided context's
     * [NavigationContext.initialDestination] if there is currently no existing stack for the provided [context].
     *
     * @param [context] The [NavigationContext] to change to.
     */
    fun changeContext(context: Context)

    companion object
}

/**
 * Performs a back navigation operation by removing the top destination from the stack in the current [Context] and
 * displaying the next destination in the list. If this [Navigator] cannot navigate back, then this function will
 * do nothing.
 *
 * @return `true` if the back navigation operation was successful, `false` otherwise.
 */
fun <Destination : NavigationDestination, Context : NavigationContext<Destination>> Navigator<Destination, Context>.goBack(): Boolean =
    navigate(event = DestinationEvent.Back())

/**
 * Performs an "up" navigation. An "up" navigation is similar to a "back" navigation but may be slightly different.
 * For instance, on Android, the "left arrow" button in the toolbar component of an application, performs the "up"
 * operation, which is slightly different from the phones back button which performs a "back" operation.
 *
 * Currently, this defaults to the same operation as the [goBack] function.
 *
 * @return `true` if the back navigation operation was successful, `false` otherwise.
 */
fun <Destination : NavigationDestination, Context : NavigationContext<Destination>> Navigator<Destination, Context>.goUp(): Boolean =
    navigate(event = DestinationEvent.Up())

/**
 * Goes to the provided [destination] using the provided stack duplicate content [strategy]. Depending on the
 * provided [strategy] and the current [Context] stack, this will either clear the current [Context] stack to the
 * last value that equals the provided [destination], or add the provided [destination] to the top of the current
 * [Context] stack.
 *
 * @param [destination] The [NavigationDestination] that is to be navigated to and added to the current [Context]
 * stack.
 * @param [strategy] The [StackDuplicateContentStrategy] defining what to do when there are duplicate [Destination]
 * values within the current [Context] stack.
 *
 * @return `true` if the back navigation operation was successful, `false` otherwise.
 */
fun <Destination : NavigationDestination, Context : NavigationContext<Destination>> Navigator<Destination, Context>.goTo(
    destination: Destination,
    strategy: StackDuplicateContentStrategy
): Boolean = navigate(event = DestinationEvent.To(destination = destination, strategy = strategy))

/**
 * Goes to the provided [destination] using the provided stack duplicate content [strategy]. Depending on the current
 * [Context] stack, this will either clear the current [Context] stack to the last value that equals the provided
 * [destination], or add the provided [destination] to the top of the current [Context] stack.
 *
 * @param [destination] The [NavigationDestination] that is to be navigated to and added to the current [Context]
 * stack.
 */
// Note: This is needed because defaults aren't working for @Composable functions for interfaces.
fun <Destination : Any, Context : NavigationContext<Destination>> Navigator<Destination, Context>.goTo(destination: Destination) =
    goTo(destination = destination, strategy = StackDuplicateContentStrategy.CLEAR_STACK)

abstract class BaseNavigatorImpl<Destination : NavigationDestination, Context : NavigationContext<Destination>, State : BaseNavigatorStateImpl<Destination, Context>>(
    final override val state: State
) : ViewModel(),
    Navigator<Destination, Context> {

    private val contextKeyStack = mutableMapOf(state.initialContext to mutableListOf(state.initialDestination))

    final override fun navigate(event: DestinationEvent<Destination>): Boolean =
        when (event) {
            is DestinationEvent.Back -> goBack()
            is DestinationEvent.Up -> goUp()
            is DestinationEvent.To -> goTo(destination = event.destination, strategy = event.strategy)
        }

    final override fun canGoBack(): Boolean {
        val currentKeyStack = contextKeyStack[state.currentContext] ?: mutableListOf()

        return currentKeyStack.size > 1
    }

    final override fun changeContext(context: Context) {
        if (context == state.currentContext) return

        val keyStack = contextKeyStack[context]

        if (keyStack.isNullOrEmpty()) {
            val key = context.initialDestination
            val newKeyStack = mutableListOf(key)
            contextKeyStack[context] = newKeyStack
            state.change(destination = key, context = context)
        } else {
            val key = keyStack.last()
            state.change(destination = key, context = context)
        }
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || other !is BaseNavigatorImpl<*, *, *>) return false

        if (state != other.state) return false
        if (contextKeyStack != other.contextKeyStack) return false

        return true
    }

    override fun hashCode(): Int {
        var result = state.hashCode()

        result = 31 * result + contextKeyStack.hashCode()

        return result
    }

    override fun toString(): String =
        "BaseNavigatorImpl(" +
                "state=$state, " +
                "contextKeyStack=$contextKeyStack)"

    @Suppress("MemberVisibilityCanBePrivate")
    protected fun goTo(destination: Destination, strategy: StackDuplicateContentStrategy): Boolean {
        val currentScope = state.currentContext
        val currentKeyStack = contextKeyStack[currentScope] ?: mutableListOf()

        // If we are already displaying this key on the current scoped stack, then return.
        if (destination == currentKeyStack.lastOrNull()) return false

        if (strategy == StackDuplicateContentStrategy.CLEAR_STACK && currentKeyStack.contains(destination)) {
            // Go Back to the content with the provided key using the updated content
            var lastKey = currentKeyStack.lastOrNull()

            while (lastKey != null && lastKey != destination) {
                currentKeyStack.removeLast()
                lastKey = currentKeyStack.lastOrNull()
            }

            // Replace the content with the updated content
            contextKeyStack[currentScope] = currentKeyStack
            state.change(destination = destination)
        } else {
            // Go to the provided content
            currentKeyStack.add(destination)
            contextKeyStack[currentScope] = currentKeyStack
            state.change(destination = destination)
        }

        return true
    }

    @Suppress("MemberVisibilityCanBePrivate")
    protected fun goBack(): Boolean {
        val wentBack = canGoBack()

        if (wentBack) {
            val currentScope = state.currentContext
            val currentKeyStack = contextKeyStack[currentScope] ?: mutableListOf()
            currentKeyStack.removeLast()
            contextKeyStack[currentScope] = currentKeyStack
            state.change(destination = currentKeyStack.last())
        }

        return wentBack
    }

    @Suppress("MemberVisibilityCanBePrivate")
    protected fun goUp(): Boolean =
        goBack()
}

internal class NavigatorImpl<Destination : NavigationDestination, Context : NavigationContext<Destination>>(
    initialContext: Context
) : BaseNavigatorImpl<Destination, Context, NavigatorStateImpl<Destination, Context>>(
    state = NavigatorStateImpl(initialContext = initialContext)
)
