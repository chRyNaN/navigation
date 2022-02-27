@file:Suppress("unused")

package com.chrynan.navigation

/**
 * An event that is sent to a [Navigator] to coordinate the navigation between screens.
 *
 * @see [Navigator.navigate]
 * @see [NavigationHandler.onNavigate]
 */
sealed class NavigationEvent<I : NavigationIntent> {

    class Back<I : NavigationIntent> internal constructor() : NavigationEvent<I>()

    class Up<I : NavigationIntent> internal constructor() : NavigationEvent<I>()

    data class To<I : NavigationIntent> internal constructor(val intent: I) : NavigationEvent<I>()

    companion object
}
