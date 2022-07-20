@file:Suppress("unused")

package com.chrynan.navigation.compose

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import com.chrynan.navigation.*

/**
 * Creates and remembers a [ComposeNavigationDestinationState] that can navigate with a key. This allows for specifying the [Composable]
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
 * **Note:** That it is typical to use a [ComposeNavigationDestinationState] with a [NavContainer] to display the [Composable] content
 * and listen to changes.
 *
 * **Note:** This function differs slightly from the [rememberNavigator] function in that it only uses a single
 * scope of type [Nothing]. This means that scopes cannot be changed on the returned [ComposeNavigatorImpl].
 *
 * @see [rememberNavigator]
 */
@ExperimentalNavigationApi
@Composable
fun <Destination : NavigationDestination> rememberNavigator(
    initialDestination: Destination,
    destinationSaver: Saver<Destination, Any> = autoSaver(),
    contextSaver: Saver<SingleNavigationContext<Destination>, Any> = autoSaver()
): Navigator<Destination, SingleNavigationContext<Destination>> = remember {
    ComposeNavigatorImpl(
        initialContext = SingleNavigationContext(initialDestination = initialDestination),
        destinationSaver = destinationSaver,
        contextSaver = contextSaver
    )
}

/**
 * Creates and remembers a [ComposeNavigationDestinationState] that can navigate with a key. This allows for specifying the [Composable]
 * content up front when creating this [ComposeNavigatorByKey] and simply navigating with a key from the
 * [ComposeNavigatorByKey.goTo] function.
 *
 * Example usage:
 * ```kotlin
 * val navigator = rememberNavigatorByKey(
 *     initialContext = BottomNavBarItem.HELLO,
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
 * navigator.changeContext(BottomNavBarItem.GOODBYE)
 * ```
 *
 * **Note:** That it is typical to use a [ComposeNavigationDestinationState] with a [NavContainer] to display the [Composable] content
 * and listen to changes.
 *
 * **Note:** That this function differs slightly from the [rememberNavigator] function in that this function allows
 * changing of scopes, which is useful for more complex navigation.
 *
 * @see [rememberNavigator]
 */
@ExperimentalNavigationApi
@Composable
fun <Destination : NavigationDestination, Context : NavigationContext<Destination>> rememberNavigator(
    initialContext: Context,
    destinationSaver: Saver<Destination, Any> = autoSaver(),
    contextSaver: Saver<Context, Any> = autoSaver()
): Navigator<Destination, Context> = remember {
    ComposeNavigatorImpl(
        initialContext = initialContext,
        destinationSaver = destinationSaver,
        contextSaver = contextSaver
    )
}
