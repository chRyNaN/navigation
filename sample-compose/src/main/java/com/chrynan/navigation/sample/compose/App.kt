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
import com.chrynan.navigation.compose.rememberNavigatorByKey

@ExperimentalNavigationApi
@Composable
fun App() {
    val navigator = rememberNavigatorByKey(
        initialContext = MainNavigationContext.HOME,
        content = { key ->
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                when (key) {
                    NavKey.HOME -> {
                        Text("Home", style = MaterialTheme.typography.h2)

                        Button(
                            modifier = Modifier.padding(top = 20.dp),
                            onClick = { navigator.goTo(NavKey.DETAILS) }
                        ) {
                            Text("Details")
                        }
                    }
                    NavKey.SETTINGS -> {
                        Text("Settings", style = MaterialTheme.typography.h2)
                    }
                    NavKey.DETAILS -> {
                        Text("Details", style = MaterialTheme.typography.h2)
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
