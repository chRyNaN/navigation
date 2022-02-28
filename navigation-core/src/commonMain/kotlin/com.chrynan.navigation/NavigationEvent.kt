@file:Suppress("unused")

package com.chrynan.navigation

/**
 * An event that is sent to a [Navigator] to coordinate the navigation between screens.
 *
 * @see [Navigator.navigate]
 * @see [NavigationHandler.onNavigate]
 */
sealed class NavigationEvent<NavigationValue> {

    class Back<NavigationValue> internal constructor() : NavigationEvent<NavigationValue>()

    class Up<NavigationValue> internal constructor() : NavigationEvent<NavigationValue>()

    data class To<NavigationValue> internal constructor(val value: NavigationValue) : NavigationEvent<NavigationValue>()

    companion object
}
