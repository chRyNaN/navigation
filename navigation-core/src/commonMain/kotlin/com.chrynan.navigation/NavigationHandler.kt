@file:Suppress("unused")

package com.chrynan.navigation

/**
 * Handles the navigation from a [Navigator].
 */
fun interface NavigationHandler<NavigationValue : Any, Scope : NavigationScope> {

    /**
     * Handles the actual navigation to a different part of the app defined by the provided [value]
     * using the [Scope] scope.
     */
    fun Scope.onNavigate(value: NavigationValue)

    companion object
}
