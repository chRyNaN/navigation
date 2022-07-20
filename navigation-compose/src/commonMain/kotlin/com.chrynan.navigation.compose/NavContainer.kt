package com.chrynan.navigation.compose

import androidx.compose.runtime.Composable
import com.chrynan.navigation.ExperimentalNavigationApi
import com.chrynan.navigation.NavigationContext
import com.chrynan.navigation.NavigationDestination
import com.chrynan.navigation.Navigator

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
