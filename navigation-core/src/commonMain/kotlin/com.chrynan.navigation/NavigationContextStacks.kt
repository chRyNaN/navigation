package com.chrynan.navigation

/**
 * A component that wraps a [Map] of [NavigationContext] to [MutableStack] of [NavigationDestination]s and provides
 * convenience functions for accessing and altering the values. Note that this component is mutable.
 */
internal class NavigationContextStacks<Destination : NavigationDestination, Context : NavigationContext<Destination>> internal constructor(
    private val initialContext: Context
) {

    private val destinationStacksByContext =
        mutableMapOf(initialContext to mutableStackOf(initialContext.initialDestination))

    /**
     * Retrieves the [Stack] of [Destination]s for the provided [Context].
     */
    operator fun get(context: Context): Stack<Destination> =
        destinationStacksByContext[context]?.toStack() ?: stackOf(context.initialDestination)

    /**
     * Retrieves the current [Destination] on top of the [Stack] for the provided [Context] without removing it.
     */
    fun peek(context: Context): Destination =
        get(context = context).peekOrNull() ?: context.initialDestination

    /**
     * Removes and returns the [Destination] on top of the [Stack] for the provided [Context], or `null` if the item
     * cannot be removed. There must always be at least one item within a [Destination] [Stack], attempting to remove
     * that item will fail and return `null` instead.
     */
    fun pop(context: Context): Destination? {
        val stack = destinationStacksByContext[context] ?: return null

        if (stack.size <= 1) return null

        val removed = stack.pop()

        destinationStacksByContext[context] = stack

        return removed
    }

    /**
     * Pushes the provided [destination] to the top of the [Stack] of [Destination]s for the provided [context].
     */
    fun push(context: Context, destination: Destination) {
        val stack = destinationStacksByContext[context] ?: mutableStackOf(context.initialDestination)

        stack.push(destination)

        destinationStacksByContext[context] = stack
    }

    /**
     * Clears all the [Stack]s of [Destination]s for all the [Context]s. This resets the internal data structure back
     * to its initial state.
     */
    fun clear() {
        destinationStacksByContext.clear()
        destinationStacksByContext[initialContext] = mutableStackOf(initialContext.initialDestination)
    }
}
