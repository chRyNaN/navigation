@file:Suppress("unused")

package com.chrynan.navigation

internal enum class TestDestination {

    HOME,
    FAVORITES,
    SETTINGS,
    ITEM_DETAILS,
    CHANNEL_DETAILS
}

internal sealed class TestContext : NavigationContext<TestDestination> {

    object Home : TestContext() {

        override val initialDestination: TestDestination = TestDestination.HOME
    }

    object Favorites : TestContext() {

        override val initialDestination: TestDestination = TestDestination.FAVORITES
    }

    object Settings : TestContext() {

        override val initialDestination: TestDestination = TestDestination.SETTINGS
    }
}
