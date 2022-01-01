package com.chrynan.navigation.sample.compose

import android.os.Bundle
import androidx.activity.compose.BackHandler
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.material.*
import com.chrynan.navigation.compose.ExperimentalNavigationApi
import com.chrynan.navigation.compose.NavContainer
import com.chrynan.navigation.compose.goTo
import com.chrynan.navigation.compose.rememberNavigatorByKey

@OptIn(ExperimentalNavigationApi::class)
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val navigator = rememberNavigatorByKey(
                initialScope = MainScope.HOME,
                initialKeys = { scope ->
                    when (scope) {
                        MainScope.HOME -> NavKey.HOME
                        MainScope.SETTINGS -> NavKey.SETTINGS
                    }
                },
                content = { key ->
                    when (key) {
                        NavKey.HOME -> {
                            Column {
                                Text("Home")

                                Button(onClick = { navigator.goTo(NavKey.DETAILS) }) {
                                    Text("Details")
                                }
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
            )

            Column {
                NavContainer(navigator)

                BackHandler { navigator.goBack() }

                BottomNavigation {
                    MainScope.values().forEach { scope ->
                        BottomNavigationItem(
                            selected = false,
                            onClick = { navigator.changeScope(scope) },
                            label = { Text(scope.title) },
                            icon = { Image(imageVector = scope.icon, contentDescription = null) }
                        )
                    }
                }
            }
        }
    }
}
