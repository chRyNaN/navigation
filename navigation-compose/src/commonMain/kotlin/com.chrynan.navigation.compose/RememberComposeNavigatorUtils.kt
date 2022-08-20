@file:Suppress("unused")

package com.chrynan.navigation.compose

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import com.chrynan.navigation.*

/**
 * Creates and remembers a [Navigator]. A [Navigator] can be used to navigate between different UI content in an
 * application.
 *
 * Example usage:
 * ```kotlin
 * val navigator = rememberNavigator(initialDestination = "Greeting")
 *
 * // The NavContainer will start by displaying the initial content, which in this case is "Hello"
 * NavContainer(navigator) { _, key ->
 *     when (key) {
 *         "Greeting" -> Text("Hello")
 *         "Farewell" -> Text("Good-bye")
 *         else -> Text("Unexpected Key: $key")
 *     }
 * }
 *
 * // The above NavContainer will display "Good Bye" after the following call:
 * navigator.goTo("Farewell")
 *
 * // Goes back to the initial content: "Hello":
 * navigator.goBack()
 * ```
 *
 * **Note:** Use the [NavContainer] to display the [Composable] content for the current navigation context and keys.
 *
 * **Note:** This function differs slightly from the [rememberNavigator] function in that it only uses a single
 * scope of type [Nothing]. This means that scopes cannot be changed on the returned [ComposeNavigatorImpl].
 *
 * @see [rememberNavigator]
 */
@ExperimentalNavigationApi
@Composable
fun <Destination : NavigationDestination> rememberNavigator(
    initialDestination: Destination
): Navigator<Destination, SingleNavigationContext<Destination>> = remember {
    ComposeNavigatorImpl(initialContext = SingleNavigationContext(initialDestination = initialDestination))
}

/**
 * Creates and remembers a [Navigator]. A [Navigator] can be used to navigate between different UI content in an
 * application.
 *
 * Example usage:
 * ```kotlin
 * val navigator = rememberNavigator(initialContext = BottomNavBarItem.HELLO)
 *
 * // The NavContainer will start by displaying the initial content, which in this case is "Hello"
 * NavContainer(navigator) { context, key ->
 *         when (key) {
 *             "Greeting" -> Text("Hello")
 *             "Farewell" -> Text("Good-bye")
 *             else -> Text("Unexpected Key: $key")
 *         }
 *     }
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
 * **Note:** Use the [NavContainer] to display the [Composable] content for the current navigation context and keys.
 *
 * **Note:** That this function differs slightly from the [rememberNavigator] function in that this function allows
 * changing of scopes, which is useful for more complex navigation.
 *
 * @see [rememberNavigator]
 */
@ExperimentalNavigationApi
@Composable
fun <Destination : NavigationDestination, Context : NavigationContext<Destination>> rememberNavigator(
    initialContext: Context
): Navigator<Destination, Context> = remember {
    ComposeNavigatorImpl(initialContext = initialContext)
}
