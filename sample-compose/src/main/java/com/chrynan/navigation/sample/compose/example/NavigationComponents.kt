package com.chrynan.navigation.sample.compose.example

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.vector.ImageVector
import com.chrynan.navigation.NavigationContext
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
sealed class AppDestination {

    @Serializable
    object Home : AppDestination()

    @Serializable
    object Search : AppDestination()

    @Serializable
    object Settings : AppDestination()

    @Serializable
    data class Details(
        @SerialName(value = "item_id") val itemId: Int
    ) : AppDestination()
}

@Serializable
enum class AppContext(
    val title: String,
    val icon: ImageVector,
    override val initialDestination: AppDestination
) : NavigationContext<AppDestination> {

    HOME(title = "Home", icon = Icons.Default.Home, initialDestination = AppDestination.Home),

    SEARCH(title = "Search", icon = Icons.Default.Search, initialDestination = AppDestination.Search),

    SETTINGS(title = "Settings", icon = Icons.Default.Settings, initialDestination = AppDestination.Settings)
}
