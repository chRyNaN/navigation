package com.chrynan.navigation.sample.compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.chrynan.navigation.ExperimentalNavigationApi
import com.chrynan.navigation.compose.NavigationContainer
import com.chrynan.navigation.compose.rememberNavigator

@ExperimentalNavigationApi
@Composable
fun App() {
    val navigator = rememberNavigator(initialContext = MainNavigationContext.HOME)

    Column {
        Box(modifier = Modifier.weight(1f)) {
            NavigationContainer(navigator = navigator) { context, destination ->
                when (destination) {
                    Destination.HOME -> Text("Home Screen")
                    Destination.DETAILS -> Text("Details Screen")
                    Destination.SETTINGS -> Text("Settings Screen")
                }
            }
        }

        BottomNavigation {
            MainNavigationContext.values().forEach { context ->
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
