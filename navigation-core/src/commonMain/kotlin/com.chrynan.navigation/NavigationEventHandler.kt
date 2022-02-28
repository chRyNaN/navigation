@file:Suppress("unused")

package com.chrynan.navigation

/**
 * A [NavigationHandler] that provides distinct functions for each of the possible
 * [NavigationEvent]s.
 */
interface NavigationEventHandler<NavigationValue, Scope : NavigationScope> :
    NavigationHandler<NavigationEvent<NavigationValue>, Scope>,
    StackNavigationHandler<NavigationEvent<NavigationValue>, Scope> {

    fun Scope.onGoBack()

    fun Scope.onGoUp()

    fun Scope.onGoTo(value: NavigationValue)

    override fun Scope.onNavigate(value: NavigationEvent<NavigationValue>) =
        when (value) {
            is NavigationEvent.Back -> onGoBack()
            is NavigationEvent.Up -> onGoUp()
            is NavigationEvent.To -> onGoTo(value = value.value)
        }

    override fun Scope.canGoBack(): Boolean = false

    companion object
}
