@file:Suppress("unused")

package com.chrynan.navigation

/**
 * An event that is sent to a [Navigator] to coordinate the navigation between screens.
 *
 * @see [Navigator.navigate]
 * @see [NavigationHandler.onNavigate]
 */
sealed class NavigationEvent<Destination : NavigationDestination> {

    class Back<Destination : NavigationDestination> internal constructor() : NavigationEvent<Destination>()

    class Up<Destination : NavigationDestination> internal constructor() : NavigationEvent<Destination>()

    data class To<Destination : NavigationDestination> internal constructor(
        val destination: Destination,
        val strategy: StackDuplicateContentStrategy = StackDuplicateContentStrategy.CLEAR_STACK
    ) : NavigationEvent<Destination>()

    companion object
}
