@file:Suppress("unused")

package com.chrynan.navigation

/**
 * Creates a [Navigator] using the provided [initialContext].
 *
 * Example usage:
 * ```
 * val navigator = navigator(initialContext = AppContext.Home)
 *
 * navigator.goTo(destination)
 * ```
 */
fun <Destination : NavigationDestination, Context : NavigationContext<Destination>> navigator(
    initialContext: Context
): Navigator<Destination, Context> = NavigatorImpl(initialContext = initialContext)

/**
 * Creates a [Navigator] with a [SingleNavigationContext] using the provided [initialDestination].
 *
 * Example usage:
 * ```
 * val navigator = navigator(initialDestination = destination)
 *
 * navigator.goTo(otherDestination)
 * ```
 */
fun <Destination : NavigationDestination> navigator(
    initialDestination: Destination
): Navigator<Destination, SingleNavigationContext<Destination>> =
    NavigatorImpl(initialContext = SingleNavigationContext(initialDestination = initialDestination))
