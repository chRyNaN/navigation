package com.chrynan.navigation

/**
 * A [Navigator] that retains a stack of navigation items and can handle back navigation.
 */
interface StackNavigator : Navigator {

    fun canGoBack(): Boolean

    fun goBack(): Boolean

    companion object
}
