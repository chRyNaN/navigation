package com.chrynan.navigation.compose

import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.chrynan.navigation.ExperimentalNavigationApi
import com.chrynan.navigation.NavigationContext
import com.chrynan.navigation.NavigationDestination
import com.chrynan.navigation.Navigator

/**
 * A [Composable] that listens to navigation context and destination changes from the provided [navigator] and calls
 * the provided [content] [Composable] function with the latest values.
 *
 * Example usage:
 * ```kotlin
 * NavContainer(navigator) { context, destination ->
 *     Text("context = $context; destination = $destination")
 * }
 * ```
 */
@Composable
@ExperimentalNavigationApi
fun <Destination : NavigationDestination, Context : NavigationContext<Destination>> NavContainer(
    navigator: Navigator<Destination, Context>,
    content: @Composable ComposeNavigationScope.(context: Context, destination: Destination) -> Unit
) {
    val context = navigator.state.currentContextAsState()
    val destination = navigator.state.currentDestinationAsState()

    content(ComposeNavigationScope, context.value, destination.value)
}

/**
 * A [Composable] that listens to navigation context and destination changes from the provided [navigator] and calls
 * the provided [content] [Composable] function with the latest values.
 *
 * Example usage:
 * ```kotlin
 * NavContainer(
 *     navigator = navigator,
 *     modifier = modifier
 * ) { context, destination ->
 *     Text("context = $context; destination = $destination")
 * }
 * ```
 */
@Composable
@ExperimentalNavigationApi
fun <Destination : NavigationDestination, Context : NavigationContext<Destination>> NavContainer(
    navigator: Navigator<Destination, Context>,
    modifier: Modifier,
    content: @Composable ComposeNavigationScope.(context: Context, destination: Destination) -> Unit
) {
    val context = navigator.state.currentContextAsState()
    val destination = navigator.state.currentDestinationAsState()

    Box(modifier = modifier) {
        content(ComposeNavigationScope, context.value, destination.value)
    }
}
