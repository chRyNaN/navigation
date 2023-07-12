package com.chrynan.navigation.compose

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.chrynan.navigation.*

/**
 * A [Composable] that listens to navigation context and destination changes from the provided [navigator] and calls
 * the provided [content] [Composable] function with the latest values.
 *
 * Example usage:
 * ```kotlin
 * NavContainer(
 *     navigator = navigator,
 *     modifier = modifier
 * ) { (context, destination) ->
 *     Text("context = $context; destination = $destination")
 * }
 * ```
 */
@Suppress("FunctionName")
@Composable
@ExperimentalNavigationApi
fun <Destination : NavigationDestination, Context : NavigationContext<Destination>> NavigationContainer(
    navigator: Navigator<Destination, Context>,
    modifier: Modifier = Modifier,
    content: @Composable BoxScope.(destinationAndContext: DestinationAndContext<Destination, Context>) -> Unit
) {
    val context = navigator.store.context.collectAsState()
    val destination = navigator.store.destination.collectAsState()

    Box(modifier = modifier) {
        content(this, DestinationAndContext(context = context.value, destination = destination.value))
    }
}
