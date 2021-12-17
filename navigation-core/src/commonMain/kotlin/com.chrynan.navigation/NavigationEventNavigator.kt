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
