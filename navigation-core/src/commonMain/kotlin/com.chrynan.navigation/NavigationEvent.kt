@file:Suppress("unused")

package com.chrynan.navigation

/**
 * An event that is sent to a [Navigator] to coordinate the navigation between screens.
 *
 * @see [Navigator.navigate]
 */
sealed class NavigationEvent<Destination : NavigationDestination> private constructor() {

    /**
     * Represents a request to navigate back to the previous screen.
     */
    class Back<Destination : NavigationDestination> internal constructor() : NavigationEvent<Destination>()

    /**
     * Represents a request to navigate up to the previous screen in this context.
     */
    class Up<Destination : NavigationDestination> internal constructor() : NavigationEvent<Destination>()

    /**
     * Represents a request to navigate to the provided [destination].
     */
    data class To<Destination : NavigationDestination> internal constructor(
        val destination: Destination,
        val strategy: StackDuplicateContentStrategy = StackDuplicateContentStrategy.CLEAR_STACK
    ) : NavigationEvent<Destination>()

    companion object
}
