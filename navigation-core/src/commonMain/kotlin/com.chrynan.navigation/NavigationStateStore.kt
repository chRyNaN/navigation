@file:Suppress("unused")

package com.chrynan.navigation

/**
 * Represents a store of navigation state information that is useful for a [Navigator].
 */
interface NavigationStateStore<Destination : NavigationDestination, Context : NavigationContext<Destination>> {

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
}

/**
 * A mutable version of a [NavigationStateStore].
 */
internal interface MutableNavigationStateStore<Destination : NavigationDestination, Context : NavigationContext<Destination>> :
    NavigationStateStore<Destination, Context> {

    /**
     * Dispatches the provided navigation [event] which mutates the underlying state values.
     */
    fun dispatch(event: NavigationEvent<Destination, Context>)

    /**
     * Resets the underlying state values back to their initial values.
     */
    fun reset()
}

/**
 * Creates a [MutableNavigationStateStore] instance with the provided [initialContext] value.
 */
internal fun <Destination : NavigationDestination, Context : NavigationContext<Destination>> mutableNavigationStateStoreOf(
    initialContext: Context
): MutableNavigationStateStore<Destination, Context> =
    MapBasedMutableNavigationStateStore(initialContext = initialContext)

/**
 * A [MutableNavigationStateStore] implementation that stores [NavigationContext]s and their associated
 * [NavigationDestination] [Stack]s in an in-memory [Map].
 */
internal class MapBasedMutableNavigationStateStore<Destination : NavigationDestination, Context : NavigationContext<Destination>> internal constructor(
    initialContext: Context
) : MutableNavigationStateStore<Destination, Context> {

    override val event = mutableNavigationStateOf<NavigationEvent<Destination, Context>?>(initial = null)
    override val destination = mutableNavigationStateOf(initial = initialContext.initialDestination)
    override val context = mutableNavigationStateOf(initial = initialContext)

    private val map = mutableMapOf(initialContext to mutableStackOf(initialContext.initialDestination))

    override fun dispatch(event: NavigationEvent<Destination, Context>) {
        this.event.update(event)

        TODO("Not yet implemented")
    }

    override fun reset() {
        event.reset()
        destination.reset()
        context.reset()

        map.clear()
        map[context.initial] = mutableStackOf(context.initial.initialDestination)
    }
}
