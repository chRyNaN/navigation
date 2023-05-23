package com.chrynan.navigation.sample.compose.example

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.chrynan.navigation.ExperimentalNavigationApi
import com.chrynan.navigation.compose.NavigationContainer
import com.chrynan.navigation.compose.rememberNavigator
import com.chrynan.navigation.goBack
import com.chrynan.navigation.goTo
import com.chrynan.navigation.sample.compose.composable.Items

@Composable
@ExperimentalNavigationApi
fun SingleContextSample(
    modifier: Modifier = Modifier,
    onClose: () -> Unit
) {
    val navigator = rememberNavigator<AppDestination>(initialDestination = AppDestination.Home)

    BackHandler {
        if (!navigator.goBack()) {
            onClose()
        }
    }

    NavigationContainer(
        navigator = navigator,
        modifier = Modifier.fillMaxSize()
    ) { destination ->
        when (destination) {
            is AppDestination.Home -> Items(
                modifier = Modifier.matchParentSize(),
                onItemClick = {
                    navigator.goTo(destination = AppDestination.Details(itemId = it))
                },
                header = {
                    Text(text = "Home", style = MaterialTheme.typography.h6)
                })

            is AppDestination.Details -> Column(
                modifier = Modifier.matchParentSize(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = "Details", style = MaterialTheme.typography.h6)

                Text(text = "Item ${destination.itemId}", style = MaterialTheme.typography.subtitle1)
            }

            else -> {}
        }
    }
}
