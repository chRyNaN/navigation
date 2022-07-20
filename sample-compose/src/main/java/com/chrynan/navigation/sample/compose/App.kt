package com.chrynan.navigation.sample.compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.chrynan.navigation.ExperimentalNavigationApi
import com.chrynan.navigation.compose.NavContainer
import com.chrynan.navigation.compose.goTo
import com.chrynan.navigation.compose.rememberNavigator

@ExperimentalNavigationApi
@Composable
fun App() {
    val navigator = rememberNavigator(
        initialContext = MainNavigationContext.HOME
    )

    Column {
        Box(modifier = Modifier.weight(1f)) {
            NavContainer(navigator)
        }

        NavContainer(navigator = navigator) { context, destination ->

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
