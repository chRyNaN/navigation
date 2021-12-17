@file:Suppress("unused")

package com.chrynan.navigation.compose

import androidx.compose.runtime.Composable

@Composable
@ExperimentalNavigationApi
internal expect fun <T> InternalNavContainer(navigator: BaseComposeNavigatorByContentViewModel<T>)

@Composable
@ExperimentalNavigationApi
internal expect fun <T> InternalNavContainer(navigator: BaseComposeNavigatorByKeyViewModel<T>)

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
fun <T> NavContainer(navigator: BaseComposeNavigatorByContentViewModel<T>) {
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
 * @see [rememberNavigatorByIntent]
 */
@Composable
@ExperimentalNavigationApi
fun <T> NavContainer(navigator: BaseComposeNavigatorByKeyViewModel<T>) {
    InternalNavContainer(navigator = navigator)
}
