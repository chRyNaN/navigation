@file:Suppress("unused")

package com.chrynan.navigation.compose

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import com.chrynan.navigation.NavigationIntent
import com.chrynan.navigation.Navigator

/**
 * Creates and remembers a [ComposeNavigator] that can navigate with a key and [Composable] content. This allows for
 * explicitly specifying the [Composable] content to navigate to at the [ComposeNavigatorByContent.goTo] function call
 * site. Meaning the [Composable] content is more flexible and doesn't need to specified upfront when creating this
 * [ComposeNavigatorByContent].
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
 *
 * // Goes back to the initial content: "Hello":
 * navigator.goBack()
 * ```
 *
 * **Note:** That it is typical to use a [ComposeNavigator] with a [NavContainer] to display the [Composable] content
 * and listen to changes.
 */
@ExperimentalNavigationApi
@Composable
fun <T> rememberNavigatorByContent(
    initialKey: T,
    initialContent: @Composable ComposeNavigationContentScope<T>.() -> Unit
): ComposeNavigatorByContentViewModel<T> = remember {
    ComposeNavigatorByContentViewModel(
        initialKey = initialKey,
        initialContent = initialContent
    )
}

/**
 * Creates and remembers a [ComposeNavigator] that can navigate with a key. This allows for specifying the [Composable]
 * content up front when creating this [ComposeNavigatorByKey] and simply navigating with a key from the
 * [ComposeNavigatorByKey.goTo] function.
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
 *
 * // Goes back to the initial content: "Hello":
 * navigator.goBack()
 * ```
 *
 * **Note:** That it is typical to use a [ComposeNavigator] with a [NavContainer] to display the [Composable] content
 * and listen to changes.
 */
@ExperimentalNavigationApi
@Composable
fun <T> rememberNavigatorByKey(
    initialKey: T,
    content: @Composable ComposeNavigationKeyScope<T>.(key: T) -> Unit
): ComposeNavigatorByKeyViewModel<T> = remember {
    ComposeNavigatorByKeyViewModel(
        initialKey = initialKey,
        content = content
    )
}

/**
 * Creates and remembers a [ComposeNavigator] that can navigate with a [NavigationIntent] as a key. This allows for
 * specifying the [Composable] content up front when creating this [ComposeNavigatorByKey] and simply navigating with
 * a [NavigationIntent] key from the [ComposeNavigatorByKey.goTo] function. The returned [ComposeNavigator] implements
 * the [Navigator] interface.
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
 *
 * // Goes back to the initial content: "Hello":
 * navigator.goBack()
 * ```
 *
 * **Note:** That it is typical to use a [ComposeNavigator] with a [NavContainer] to display the [Composable] content
 * and listen to changes.
 */
@ExperimentalNavigationApi
@Composable
fun <I : NavigationIntent> rememberNavigatorByIntent(
    initialIntent: I,
    content: @Composable ComposeNavigationIntentScope<I>.(intent: I) -> Unit
): ComposeNavigationIntentNavigatorByKeyViewModel<I> = remember {
    ComposeNavigationIntentNavigatorByKeyViewModel(
        initialKey = initialIntent,
        content = content
    )
}
