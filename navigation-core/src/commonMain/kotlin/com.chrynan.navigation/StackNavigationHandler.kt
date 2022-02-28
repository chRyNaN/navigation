package com.chrynan.navigation

/**
 * An extension on the [NavigationHandler] that provides functions to determine back navigation capability.
 */
interface StackNavigationHandler<NavigationValue : Any, Scope : NavigationScope> :
    NavigationHandler<NavigationValue, Scope> {

    /**
     * Determines whether a back navigation can be handled.
     */
    fun Scope.canGoBack(): Boolean

    companion object
}
