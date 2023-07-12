package com.chrynan.navigation.sample.compose

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.chrynan.navigation.ExperimentalNavigationApi
import com.chrynan.navigation.compose.NavigationContainer
import com.chrynan.navigation.compose.rememberNavigator
import com.chrynan.navigation.goBack
import com.chrynan.navigation.goTo
import com.chrynan.navigation.sample.compose.example.MultipleContextSample
import com.chrynan.navigation.sample.compose.example.SingleContextSample

@OptIn(ExperimentalNavigationApi::class)
@Composable
fun App() {
    val navigator = rememberNavigator(AppDestination.MAIN_SCREEN)

    MaterialTheme {
        NavigationContainer(
            navigator = navigator,
            modifier = Modifier.fillMaxSize()
        ) { (destination, _) ->
            when (destination) {
                AppDestination.MAIN_SCREEN -> MainScreen(
                    modifier = Modifier.matchParentSize(),
                    onSingleContextSelected = { navigator.goTo(AppDestination.SINGLE_CONTEXT_EXAMPLE) },
                    onMultipleContextSelected = { navigator.goTo(AppDestination.MULTIPLE_CONTEXT_EXAMPLE) }
                )

                AppDestination.SINGLE_CONTEXT_EXAMPLE -> SingleContextSample(
                    modifier = Modifier.matchParentSize(),
                    onClose = { navigator.goBack() }
                )

                AppDestination.MULTIPLE_CONTEXT_EXAMPLE -> MultipleContextSample(
                    modifier = Modifier.matchParentSize(),
                    onClose = { navigator.goBack() }
                )
            }
        }
    }
}

@Composable
private fun MainScreen(
    modifier: Modifier = Modifier,
    onSingleContextSelected: () -> Unit,
    onMultipleContextSelected: () -> Unit
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Button(
            modifier = Modifier.defaultMinSize(minWidth = 100.dp),
            onClick = onSingleContextSelected
        ) {
            Text("Single Context Example")
        }

        Button(
            modifier = Modifier.defaultMinSize(minWidth = 100.dp)
                .padding(top = 16.dp),
            onClick = onMultipleContextSelected
        ) {
            Text("Multiple Context Example")
        }
    }
}

enum class AppDestination {

    MAIN_SCREEN,
    SINGLE_CONTEXT_EXAMPLE,
    MULTIPLE_CONTEXT_EXAMPLE
}
