@file:Suppress("unused")

package com.chrynan.navigation

/**
 * A [NavigationHandler] that provides distinct functions for each of the possible
 * [NavigationEvent]s.
 */
interface NavigationEventHandler<I : NavigationIntent, S : NavigationScope> :
    NavigationHandler<I, S> {

    fun S.onGoBack()

    fun S.onGoUp()

    fun S.onGoTo(intent: I)

    override fun S.onNavigate(event: NavigationEvent<I>) =
        when (event) {
            is NavigationEvent.Back -> onGoBack()
            is NavigationEvent.Up -> onGoUp()
            is NavigationEvent.To -> onGoTo(intent = event.intent)
        }

    companion object
}
