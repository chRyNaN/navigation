@file:Suppress("unused")

package com.chrynan.navigation

/**
 * A [Navigator] that navigates using [NavigationEvent]s. This is typically the base [Navigator] but not every UI
 * framework can use it, such as Jetpack Compose, so it is separate from the [Navigator] interface.
 */
interface NavigationEventNavigator<Intent : NavigationIntent> : Navigator,
    StackNavigator {

    /**
     * Navigates to the provided [event].
     */
    fun navigate(event: NavigationEvent<Intent>)

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
fun <Intent : NavigationIntent> NavigationEventNavigator<Intent>.goUp() =
    navigate(event = NavigationEvent.Up())

/**
 * A convenience function for calling [NavigationEventNavigator.navigate] with [NavigationEvent.To].
 */
fun <Intent : NavigationIntent> NavigationEventNavigator<Intent>.goTo(intent: Intent) =
    navigate(event = NavigationEvent.To(intent = intent))
