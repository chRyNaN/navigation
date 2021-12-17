@file:Suppress("unused")

package com.chrynan.navigation

import android.app.Activity

internal class AndroidNavigator<I : NavigationIntent>(
    private val handler: AndroidNavigationHandler<I>,
    private val scope: AndroidNavigationScope
) : NavigationEventNavigator<I> {

    override fun navigate(event: NavigationEvent<I>) {
        handler.apply {
            scope.onNavigate(event = event)
        }
    }
}

/**
 * Creates a [Navigator] using the provided [Activity] in the [AndroidNavigationScope] and the provided [handler].
 *
 * Example usage:
 * ```
 * val navigator = navigator(activity, AndroidNavigationHandler { event ->
 *     when (event) {
 *         is NavigationEvent.Back -> activity.onBackPressed()
 *         is NavigationEvent.Up -> activity.onBackPressed()
 *         is NavigationEvent.To -> { ... }
 *     }
 * })
 *
 * navigator.goBack()
 * ```
 */
fun <I : NavigationIntent> navigator(
    activity: Activity,
    handler: AndroidNavigationHandler<I>
): NavigationEventNavigator<I> {
    val scope = AndroidNavigationScope(activity = activity)

    return AndroidNavigator(handler = handler, scope = scope)
}

/**
 * Creates a [Navigator] using the provided [Activity] in the [AndroidNavigationScope] and the provided [onGoBack],
 * [onGoUp], and [onGoTo] functions to construct an [AndroidNavigationHandler].
 *
 * Example usage:
 * ```
 * val navigator = navigator<NavigationIntent>(activity = activity, onGoTo = { navigationIntent ->
 *     activity.startActivity(...)
 * })
 *
 * navigator.goBack()
 * ```
 */
fun <I : NavigationIntent> navigator(
    activity: Activity,
    onGoBack: () -> Unit = { activity.onBackPressed() },
    onGoUp: () -> Unit = { activity.onBackPressed() },
    onGoTo: (intent: I) -> Unit
): NavigationEventNavigator<I> {
    val scope = AndroidNavigationScope(activity = activity)

    return AndroidNavigator(
        handler = { event ->
            when (event) {
                is NavigationEvent.Back -> onGoBack()
                is NavigationEvent.Up -> onGoUp()
                is NavigationEvent.To -> onGoTo(event.intent)
            }
        },
        scope = scope
    )
}
