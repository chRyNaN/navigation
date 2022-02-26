@file:Suppress("unused")

package com.chrynan.navigation

/**
 * A [Navigator] that navigates using [NavigationEvent]s. This is typically the base [Navigator] but not every UI
 * framework can use it, such as Jetpack Compose, so it is separate from the [Navigator] interface.
 */
interface NavigationEventNavigator<I : NavigationIntent> : Navigator {

    /**
     * Navigates to the provided [event].
     */
    fun navigate(event: NavigationEvent<I>)
}

/**
 * A convenience function for calling [NavigationEventNavigator.navigate] with [NavigationEvent.Back].
 */
fun <I : NavigationIntent> NavigationEventNavigator<I>.goBack() =
    navigate(event = NavigationEvent.Back())

/**
 * A convenience function for calling [NavigationEventNavigator.navigate] with [NavigationEvent.Up].
 */
fun <I : NavigationIntent> NavigationEventNavigator<I>.goUp() =
    navigate(event = NavigationEvent.Up())

/**
 * A convenience function for calling [NavigationEventNavigator.navigate] with [NavigationEvent.To].
 */
fun <I : NavigationIntent> NavigationEventNavigator<I>.goTo(intent: I) =
    navigate(event = NavigationEvent.To(intent = intent))
