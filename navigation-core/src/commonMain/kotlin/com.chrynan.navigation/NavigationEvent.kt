@file:Suppress("unused")

package com.chrynan.navigation

/**
 * An event that is sent to a [Navigator] to coordinate the navigation between screens.
 *
 * @see [Navigator.navigate]
 * @see [NavigationHandler.onNavigate]
 */
sealed class NavigationEvent<Intent : NavigationIntent> {

    class Back<Intent : NavigationIntent> internal constructor() : NavigationEvent<Intent>()

    class Up<Intent : NavigationIntent> internal constructor() : NavigationEvent<Intent>()

    data class To<Intent : NavigationIntent> internal constructor(val intent: Intent) : NavigationEvent<Intent>()

    companion object
}
