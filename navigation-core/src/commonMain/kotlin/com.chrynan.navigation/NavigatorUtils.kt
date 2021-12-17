@file:Suppress("unused")

package com.chrynan.navigation

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
