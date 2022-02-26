@file:Suppress("unused")

package com.chrynan.navigation

/**
 * Handles the navigation from a [Navigator].
 */
fun interface NavigationHandler<Event : Any, Scope : NavigationScope> {

    /**
     * Handles the actual navigation to a different part of the app defined by the provided [event]
     * using the [Scope] scope.
     */
    fun Scope.onNavigate(event: Event)

    companion object
}
