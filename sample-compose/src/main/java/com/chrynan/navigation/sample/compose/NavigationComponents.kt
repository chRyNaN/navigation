package com.chrynan.navigation.sample.compose

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.vector.ImageVector
import com.chrynan.navigation.NavigationContext

sealed class AppDestination {

    object Home : AppDestination()

    object Search : AppDestination()

    object Settings : AppDestination()

    data class Details(val itemId: Int) : AppDestination()
}

enum class AppContext(
    val title: String,
    val icon: ImageVector,
    override val initialDestination: AppDestination
) : NavigationContext<AppDestination> {

    HOME(title = "Home", icon = Icons.Default.Home, initialDestination = AppDestination.Home),

    SEARCH(title = "Search", icon = Icons.Default.Search, initialDestination = AppDestination.Search),

    SETTINGS(title = "Settings", icon = Icons.Default.Settings, initialDestination = AppDestination.Settings)
}
