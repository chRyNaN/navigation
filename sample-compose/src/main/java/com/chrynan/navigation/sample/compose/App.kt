package com.chrynan.navigation.sample.compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.chrynan.navigation.compose.ExperimentalNavigationApi
import com.chrynan.navigation.compose.NavContainer
import com.chrynan.navigation.compose.goTo
import com.chrynan.navigation.compose.rememberNavigatorByKey

@ExperimentalNavigationApi
@Composable
fun App() {
    val navigator = rememberNavigatorByKey(
        initialContext = MainScope.HOME,
        initialKeys = { scope ->
            when (scope) {
                MainScope.HOME -> NavKey.HOME
                MainScope.SETTINGS -> NavKey.SETTINGS
            }
        },
        content = { key ->
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                when (key) {
                    NavKey.HOME -> {
                        Text("Home")

                        Button(modifier = Modifier.padding(top = 20.dp), onClick = { navigator.goTo(NavKey.DETAILS) }) {
                            Text("Details")
                        }
                    }
                    NavKey.SETTINGS -> {
                        Text("Settings")
                    }
                    NavKey.DETAILS -> {
                        Text("Details")
                    }
                }
            }
        }
    )

    Column {
        Box(modifier = Modifier.weight(1f)) {
            NavContainer(navigator)
        }

        BottomNavigation {
            MainScope.values().forEach { scope ->
                BottomNavigationItem(
                    selected = false,
                    onClick = { navigator.changeContext(scope) },
                    label = { Text(scope.title) },
                    icon = { Image(imageVector = scope.icon, contentDescription = null) }
                )
            }
        }
    }
}
