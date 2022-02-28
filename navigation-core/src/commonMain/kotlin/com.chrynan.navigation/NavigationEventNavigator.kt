@file:Suppress("unused")

package com.chrynan.navigation

/**
 * A [Navigator] that navigates using [NavigationEvent]s. This is typically the base [Navigator] but not every UI
 * framework can use it, such as Jetpack Compose, so it is separate from the [Navigator] interface.
 */
interface NavigationEventNavigator<NavigationValue> : Navigator,
    StackNavigator {

    /**
     * Navigates to the provided [event].
     */
    fun navigate(event: NavigationEvent<NavigationValue>)

    override fun goBack() =
        if (canGoBack()) {
            navigate(event = NavigationEvent.Back())
            true
        } else {
            false
        }
}

/**
 * A convenience function for calling [NavigationEventNavigator.navigate] with [NavigationEvent.Up].
 */
fun <NavigationValue> NavigationEventNavigator<NavigationValue>.goUp() =
    navigate(event = NavigationEvent.Up())

/**
 * A convenience function for calling [NavigationEventNavigator.navigate] with [NavigationEvent.To].
 */
fun <NavigationValue> NavigationEventNavigator<NavigationValue>.goTo(intent: NavigationValue) =
    navigate(event = NavigationEvent.To(value = intent))
