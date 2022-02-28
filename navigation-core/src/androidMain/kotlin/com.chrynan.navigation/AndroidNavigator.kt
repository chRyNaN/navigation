@file:Suppress("unused")

package com.chrynan.navigation

import android.app.Activity

internal class AndroidNavigator<Intent : NavigationIntent>(
    private val handler: AndroidNavigationHandler<Intent>,
    private val scope: AndroidNavigationScope
) : NavigationEventNavigator<Intent> {

    override fun navigate(event: NavigationEvent<Intent>) {
        handler.apply {
            scope.onNavigate(event = event)
        }
    }

    override fun canGoBack(): Boolean = handler.run { scope.canGoBack() }
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
fun <Intent : NavigationIntent> navigator(
    activity: Activity,
    handler: AndroidNavigationHandler<Intent>
): NavigationEventNavigator<Intent> {
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
fun <Intent : NavigationIntent> navigator(
    activity: Activity,
    canGoBack: () -> Boolean = { false },
    onGoBack: () -> Unit = { activity.onBackPressed() },
    onGoUp: () -> Unit = { activity.onBackPressed() },
    onGoTo: (intent: Intent) -> Unit
): NavigationEventNavigator<Intent> {
    val scope = AndroidNavigationScope(activity = activity)

    return AndroidNavigator(
        handler = object : AndroidNavigationHandler<Intent> {

            override fun AndroidNavigationScope.onGoBack() = onGoBack()

            override fun AndroidNavigationScope.onGoUp() = onGoUp()

            override fun AndroidNavigationScope.onGoTo(intent: Intent) = onGoTo(intent)

            override fun AndroidNavigationScope.canGoBack(): Boolean = canGoBack()
        },
        scope = scope
    )
}
