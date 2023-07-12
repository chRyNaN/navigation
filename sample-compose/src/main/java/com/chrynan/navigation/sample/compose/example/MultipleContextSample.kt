package com.chrynan.navigation.sample.compose.example

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.chrynan.navigation.ExperimentalNavigationApi
import com.chrynan.navigation.changeContext
import com.chrynan.navigation.compose.NavigationContainer
import com.chrynan.navigation.compose.rememberNavigator
import com.chrynan.navigation.goBack
import com.chrynan.navigation.goTo
import com.chrynan.navigation.sample.compose.composable.Items

@ExperimentalNavigationApi
@Composable
fun MultipleContextSample(
    modifier: Modifier = Modifier,
    onClose: () -> Unit
) {
    val navigator = rememberNavigator(initialContext = AppContext.HOME)

    BackHandler {
        if (!navigator.goBack()) {
            onClose()
        }
    }

    Column(modifier = modifier) {
        Box(modifier = Modifier.weight(1f)) {
            NavigationContainer(navigator = navigator) { (context, destination) ->
                when (destination) {
                    is AppDestination.Home -> Items(
                        modifier = Modifier.matchParentSize(),
                        onItemClick = {
                            navigator.goTo(destination = AppDestination.Details(itemId = it))
                        },
                        header = {
                            Text(text = context.title, style = MaterialTheme.typography.h6)
                        })

                    is AppDestination.Details -> Text("${context.title}: ${destination.itemId}")
                    is AppDestination.Settings -> Text(context.title)
                    is AppDestination.Search -> Text(context.title)
                }
            }
        }

        BottomNavigation {
            AppContext.values().forEach { context ->
                BottomNavigationItem(
                    selected = false,
                    onClick = { navigator.changeContext(context) },
                    label = { Text(context.title) },
                    icon = { Image(imageVector = context.icon, contentDescription = null) }
                )
            }
        }
    }
}
