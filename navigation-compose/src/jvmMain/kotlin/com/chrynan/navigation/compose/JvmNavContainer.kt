package com.chrynan.navigation.compose

import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.chrynan.navigation.ExperimentalNavigationApi
import com.chrynan.navigation.NavigationContext
import com.chrynan.navigation.NavigationDestination
import com.chrynan.navigation.Navigator

@Suppress("unused")
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
