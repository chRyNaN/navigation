@file:Suppress("unused")

package com.chrynan.navigation

/**
 * Handles the navigation from a [Navigator].
 */
fun interface NavigationHandler<I : NavigationIntent, S : NavigationScope> {

    /**
     * Handles the actual navigation to a different part of the app defined by the provided [event]
     * using the [S] scope.
     */
    fun S.onNavigate(event: NavigationEvent<I>)

    companion object
}
