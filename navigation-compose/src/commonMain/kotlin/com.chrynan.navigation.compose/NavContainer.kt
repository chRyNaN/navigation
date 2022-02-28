@file:Suppress("unused")

package com.chrynan.navigation.compose

import androidx.compose.runtime.Composable
import com.chrynan.navigation.NavigationIntent

@Composable
@ExperimentalNavigationApi
internal expect fun <Context, Key> InternalNavContainer(navigator: ComposeNavigatorByContentViewModel<Context, Key>)

@Composable
@ExperimentalNavigationApi
internal expect fun <Context, Key, NavigationScope : ComposeNavigationKeyScope<Context, Key>> InternalNavContainer(
    navigator: BaseComposeNavigatorByKeyViewModel<Context, Key, NavigationScope>,
    scope: NavigationScope
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
fun <Context, Key> NavContainer(navigator: ComposeNavigatorByContentViewModel<Context, Key>) {
    InternalNavContainer(navigator = navigator)

    navigator.isInitialized = true
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
fun <Context, Key> NavContainer(navigator: ComposeNavigatorByKeyViewModel<Context, Key>) {
    val scope = object : ComposeNavigationKeyScope<Context, Key> {

        override val navigator: ComposeNavigatorByKeyViewModel<Context, Key>
            get() = navigator
    }

    InternalNavContainer(navigator = navigator, scope = scope)

    navigator.isInitialized = true
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
fun <Context, Intent : NavigationIntent> NavContainer(navigator: ComposeNavigationIntentNavigatorByKeyViewModel<Context, Intent>) {
    val scope = object : ComposeNavigationIntentScope<Context, Intent> {

        override val navigator: ComposeNavigationIntentNavigatorByKeyViewModel<Context, Intent>
            get() = navigator
    }

    InternalNavContainer(navigator = navigator, scope = scope)

    navigator.isInitialized = true
}
