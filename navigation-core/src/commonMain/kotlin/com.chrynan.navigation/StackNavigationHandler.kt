package com.chrynan.navigation

/**
 * An extension on the [NavigationHandler] that provides functions to determine back navigation capability.
 */
interface StackNavigationHandler<Event : Any, Scope : NavigationScope> : NavigationHandler<Event, Scope> {

    /**
     * Determines whether a back navigation can be handled.
     */
    fun Scope.canGoBack(): Boolean

    companion object
}
