package com.chrynan.navigation.sample.compose

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.vector.ImageVector

enum class MainScope(
    val title: String,
    val icon: ImageVector
) {

    HOME(title = "Home", icon = Icons.Default.Home),
    SETTINGS(title = "Settings", icon = Icons.Default.Settings)
}
