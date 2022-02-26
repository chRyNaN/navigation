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
 * ```kotlin
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
 *
 * **Note:** This function differs slightly from the [rememberNavigatorByContent] function in that it only uses a single
 * scope of type [Nothing]. This means that scopes cannot be changed on the returned
 * [ComposeNavigatorByContentViewModel].
 *
 * @see [rememberNavigatorByContent]
 */
@ExperimentalNavigationApi
@Composable
fun <Key> rememberNavigatorByContent(
    initialKey: Key,
    initialContent: @Composable ComposeNavigationContentScope<Key>.() -> Unit
): ComposeNavigatorByContentViewModel<Nothing?, Key> = remember {
    ComposeNavigatorByContentViewModel(
        initialContext = null,
        initialKeysAndContent = { initialKey to initialContent }
    )
}

/**
 * Creates and remembers a [ComposeNavigator] that can navigate with a key and [Composable] content. This allows for
 * explicitly specifying the [Composable] content to navigate to at the [ComposeNavigatorByContent.goTo] function call
 * site. Meaning the [Composable] content is more flexible and doesn't need to specified upfront when creating this
 * [ComposeNavigatorByContent].
 *
 * Example usage:
 * ```kotlin
 * val navigator = rememberNavigatorByContent(
 *                     initialScope = BottomNavBarItem.HOME,
 *                     initialKeysAndContent = { scope ->
 *                         when (scope) {
 *                             is BottomNavBarItem.HOME -> "Greeting" to { Text("Hello") }
 *                         }
 *                     }
 *                 )
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
 *
 * **Note:** That this function differs slightly from the [rememberNavigatorByContent] function in that this function
 * allows changing of scopes, which is useful for more complex navigation.
 *
 * @see [rememberNavigatorByContent]
 */
@ExperimentalNavigationApi
@Composable
fun <Context, Key> rememberNavigatorByContent(
    initialContext: Context,
    initialKeysAndContent: (Context) -> Pair<Key, @Composable ComposeNavigationContentScope<Key>.() -> Unit>
): ComposeNavigatorByContentViewModel<Context, Key> = remember {
    ComposeNavigatorByContentViewModel(
        initialContext = initialContext,
        initialKeysAndContent = initialKeysAndContent
    )
}

/**
 * Creates and remembers a [ComposeNavigator] that can navigate with a key. This allows for specifying the [Composable]
 * content up front when creating this [ComposeNavigatorByKey] and simply navigating with a key from the
 * [ComposeNavigatorByKey.goTo] function.
 *
 * Example usage:
 * ```kotlin
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
 *
 * **Note:** This function differs slightly from the [rememberNavigatorByKey] function in that it only uses a single
 * scope of type [Nothing]. This means that scopes cannot be changed on the returned [ComposeNavigatorByKeyViewModel].
 *
 * @see [rememberNavigatorByKey]
 */
@ExperimentalNavigationApi
@Composable
fun <Key> rememberNavigatorByKey(
    initialKey: Key,
    content: @Composable ComposeNavigationKeyScope<Key>.(key: Key) -> Unit
): ComposeNavigatorByKeyViewModel<Nothing?, Key> = remember {
    ComposeNavigatorByKeyViewModel(
        initialScope = null,
        initialKeys = { initialKey },
        content = content
    )
}

/**
 * Creates and remembers a [ComposeNavigator] that can navigate with a key. This allows for specifying the [Composable]
 * content up front when creating this [ComposeNavigatorByKey] and simply navigating with a key from the
 * [ComposeNavigatorByKey.goTo] function.
 *
 * Example usage:
 * ```kotlin
 * val navigator = rememberNavigatorByKey(
 *     initialScope = BottomNavBarItem.HELLO,
 *     initialKeys = { scope ->
 *         when(scope) {
 *             BottomNavBarItem.HELLO -> "Greeting"
 *             BottomNavBarItem.GOODBYE -> "Farewell"
 *             ...
 *         }
 *     },
 *     content = { key ->
 *         when(key) {
 *             "Greeting" -> Text("Hello")
 *             "Farewell" -> Text("Good-bye")
 *             else -> Text("Unexpected Key: $key")
 *         }
 *     }
 * )
 *
 * // The NavContainer will start by displaying the initial content, which in this case is "Hello"
 * NavContainer(navigator)
 *
 * // The above NavContainer will display "Good Bye" after the following call:
 * navigator.goTo("Farewell")
 *
 * // Goes back to the initial content: "Hello":
 * navigator.goBack()
 *
 * // Changes the scope to BottomNavBarItem.GOODBYE and displays its initial key, which in this case is "Farewell"
 * navigator.changeScope(BottomNavBarItem.GOODBYE)
 * ```
 *
 * **Note:** That it is typical to use a [ComposeNavigator] with a [NavContainer] to display the [Composable] content
 * and listen to changes.
 *
 * **Note:** That this function differs slightly from the [rememberNavigatorByKey] function in that this function allows
 * changing of scopes, which is useful for more complex navigation.
 *
 * @see [rememberNavigatorByKey]
 */
@ExperimentalNavigationApi
@Composable
fun <Context, Key> rememberNavigatorByKey(
    initialContext: Context,
    initialKeys: (Context) -> Key,
    content: @Composable ComposeNavigationKeyScope<Key>.(key: Key) -> Unit
): ComposeNavigatorByKeyViewModel<Context, Key> = remember {
    ComposeNavigatorByKeyViewModel(
        initialScope = initialContext,
        initialKeys = initialKeys,
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
 * ```kotlin
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
 *
 * **Note:** This function differs slightly from the [rememberNavigatorByIntent] function in that it only uses a single
 * scope of type [Nothing]. This means that scopes cannot be changed on the returned
 * [ComposeNavigationIntentNavigatorByKeyViewModel].
 *
 * @see [rememberNavigatorByIntent]
 */
@ExperimentalNavigationApi
@Composable
fun <Intent : NavigationIntent> rememberNavigatorByIntent(
    initialIntent: Intent,
    content: @Composable ComposeNavigationIntentScope<Intent>.(intent: Intent) -> Unit
): ComposeNavigationIntentNavigatorByKeyViewModel<Nothing?, Intent> = remember {
    ComposeNavigationIntentNavigatorByKeyViewModel(
        initialScope = null,
        initialKeys = { initialIntent },
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
 * ```kotlin
 * val navigator = rememberNavigatorByKey(
 *     initialScope = BottomNavBarItem.HELLO,
 *     initialKeys = { scope ->
 *         when(scope) {
 *             BottomNavBarItem.HELLO -> HomeNavigationIntent.Greeting
 *             BottomNavBarItem.GOODBYE -> HomeNavigationIntent.Farewell
 *             ...
 *         }
 *     },
 *     content = { navigationIntent ->
 *         when(navigationIntent) {
 *             HomeNavigationIntent.Greeting -> Text("Hello")
 *             HomeNavigationIntent.Farewell -> Text("Good-bye")
 *         }
 *     }
 * )
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
 *
 * **Note:** That this function differs slightly from the [rememberNavigatorByIntent] function in that this function
 * allows changing of scopes, which is useful for more complex navigation.
 *
 * @see [rememberNavigatorByIntent]
 */
@ExperimentalNavigationApi
@Composable
fun <Context, Intent : NavigationIntent> rememberNavigatorByIntent(
    initialContext: Context,
    initialIntents: (Context) -> Intent,
    content: @Composable ComposeNavigationIntentScope<Intent>.(intent: Intent) -> Unit
): ComposeNavigationIntentNavigatorByKeyViewModel<Context, Intent> = remember {
    ComposeNavigationIntentNavigatorByKeyViewModel(
        initialScope = initialContext,
        initialKeys = initialIntents,
        content = content
    )
}
