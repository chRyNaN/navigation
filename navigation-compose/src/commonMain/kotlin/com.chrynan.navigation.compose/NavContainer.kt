@file:Suppress("unused")

package com.chrynan.navigation.compose

import androidx.compose.runtime.Composable
import com.chrynan.navigation.NavigationIntent

@Composable
@ExperimentalNavigationApi
internal expect fun <T> InternalNavContainer(navigator: BaseComposeNavigatorByContentViewModel<T>)

@Composable
@ExperimentalNavigationApi
internal expect fun <T, S : ComposeNavigationKeyScope<T>> InternalNavContainer(
    navigator: BaseComposeNavigatorByKeyViewModel<T, S>,
    scope: S
)

/**
 * Displays the content from a [navigator] in this [Composable] UI Container.
 *
 * When the [navigator] changes its content, even outside this [NavContainer], it will be reflected within this UI
 * container.
 *
 * Example usage:
 * ```
 * val navigator = rememberNavigatorByContent("Greeting") { Text("Hello") }
 *
 * // The NavContainer will start by displaying the initial content, which in this case is "Hello".
 * NavContainer(navigator)
 *
 * // The above NavContainer will display "Good-bye" after the following call:
 * navigator.goTo("Farewell") { Text("Good-bye") }
 * ```
 *
 * @see [rememberNavigatorByContent]
 */
@Composable
@ExperimentalNavigationApi
fun <T> NavContainer(navigator: ComposeNavigatorByContentViewModel<T>) {
    InternalNavContainer(navigator = navigator)
}

/**
 * Displays the content from a [navigator] in this [Composable] UI Container.
 *
 * When the [navigator] changes its content, even outside this [NavContainer], it will be reflected within this UI
 * container.
 *
 * Example usage:
 * ```
 * val navigator = rememberNavigatorByKey("Greeting") { key ->
 *     when(key) {
 *         "Greeting" -> Text("Hello")
 *         "Farewell" -> Text("Good-bye")
 *         else -> Text("Unexpected Key: $key")
 *     }
 * }
 *
 * // The NavContainer will start by displaying the initial content, which in this case is "Hello"
 * NavContainer(navigator)
 *
 * // The above NavContainer will display "Good Bye" after the following call:
 * navigator.goTo("Farewell")
 * ```
 *
 * @see [rememberNavigatorByKey]
 */
@Composable
@ExperimentalNavigationApi
fun <T> NavContainer(navigator: ComposeNavigatorByKeyViewModel<T>) {
    val scope = object : ComposeNavigationKeyScope<T> {

        override val navigator: ComposeStackNavigatorByKey<T>
            get() = navigator
    }

    InternalNavContainer(navigator = navigator, scope = scope)
}

/**
 * Displays the content from a [navigator] in this [Composable] UI Container.
 *
 * When the [navigator] changes its content, even outside this [NavContainer], it will be reflected within this UI
 * container.
 *
 * Example usage:
 * ```
 * val navigator = rememberNavigatorByKey(HomeNavigationIntent.Greeting) { navigationIntent ->
 *     when(navigationIntent) {
 *         HomeNavigationIntent.Greeting -> Text("Hello")
 *         HomeNavigationIntent.Farewell -> Text("Good-bye")
 *     }
 * }
 *
 * // The NavContainer will start by displaying the initial content, which in this case is "Hello"
 * NavContainer(navigator)
 *
 * // The above NavContainer will display "Good Bye" after the following call:
 * navigator.goTo(HomeNavigationIntent.Farewell)
 * ```
 *
 * @see [rememberNavigatorByIntent]
 */
@Composable
@ExperimentalNavigationApi
fun <T : NavigationIntent> NavContainer(navigator: ComposeNavigationIntentNavigatorByKeyViewModel<T>) {
    val scope = object : ComposeNavigationIntentScope<T> {

        override val navigator: ComposeNavigationIntentStackNavigatorByKey<T>
            get() = navigator
    }

    InternalNavContainer(navigator = navigator, scope = scope)
}
