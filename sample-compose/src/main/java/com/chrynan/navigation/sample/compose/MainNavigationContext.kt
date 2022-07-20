package com.chrynan.navigation.sample.compose

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.vector.ImageVector
import com.chrynan.navigation.NavigationContext

enum class MainNavigationContext(
    val title: String,
    val icon: ImageVector,
    override val initialDestination: Destination
) : NavigationContext<Destination> {

    HOME(title = "Home", icon = Icons.Default.Home, initialDestination = Destination.HOME),

    SETTINGS(title = "Settings", icon = Icons.Default.Settings, initialDestination = Destination.SETTINGS)
}
