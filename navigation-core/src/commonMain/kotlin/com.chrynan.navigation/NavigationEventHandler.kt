@file:Suppress("unused")

package com.chrynan.navigation

/**
 * A [NavigationHandler] that provides distinct functions for each of the possible
 * [NavigationEvent]s.
 */
interface NavigationEventHandler<Intent : NavigationIntent, Scope : NavigationScope> :
    NavigationHandler<NavigationEvent<Intent>, Scope>,
    StackNavigationHandler<NavigationEvent<Intent>, Scope> {

    fun Scope.onGoBack()

    fun Scope.onGoUp()

    fun Scope.onGoTo(intent: Intent)

    override fun Scope.onNavigate(event: NavigationEvent<Intent>) =
        when (event) {
            is NavigationEvent.Back -> onGoBack()
            is NavigationEvent.Up -> onGoUp()
            is NavigationEvent.To -> onGoTo(intent = event.intent)
        }

    override fun Scope.canGoBack(): Boolean = false

    companion object
}
