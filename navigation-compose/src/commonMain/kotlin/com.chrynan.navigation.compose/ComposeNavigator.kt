package com.chrynan.navigation.compose

import androidx.compose.runtime.Composable
import kotlinx.coroutines.flow.Flow
import com.chrynan.navigation.NavStackDuplicateContentStrategy
import com.chrynan.navigation.Navigator

@ExperimentalNavigationApi
interface ComposeNavigator<T> : Navigator {

    val initialKey: T

    val currentKey: T?

    val keyChanges: Flow<T>

    val isInitialized: Boolean

    companion object
}

@ExperimentalNavigationApi
interface ComposeNavigatorByContent<T> : ComposeNavigator<T> {

    @Composable
    fun goTo(
        key: T,
        strategy: NavStackDuplicateContentStrategy,
        content: @Composable ComposeNavigationContentScope<T>.() -> Unit
    )
}

// Note: This is needed because defaults aren't working for @Composable functions for interfaces.
@Suppress("unused")
@ExperimentalNavigationApi
@Composable
fun <T> ComposeNavigatorByContent<T>.goTo(key: T, content: @Composable ComposeNavigationContentScope<T>.() -> Unit) =
    goTo(key = key, strategy = NavStackDuplicateContentStrategy.CLEAR_STACK, content = content)

@ExperimentalNavigationApi
interface ComposeNavigatorByKey<T> : ComposeNavigator<T> {

    fun goTo(
        key: T,
        strategy: NavStackDuplicateContentStrategy
    )
}

// Note: This is needed because defaults aren't working for @Composable functions for interfaces.
@Suppress("unused")
@ExperimentalNavigationApi
fun <T> ComposeNavigatorByKey<T>.goTo(key: T) =
    goTo(key = key, strategy = NavStackDuplicateContentStrategy.CLEAR_STACK)

@ExperimentalNavigationApi
interface ComposeStackNavigator<T> : ComposeNavigator<T> {

    fun canGoBack(): Boolean
}

@ExperimentalNavigationApi
interface ComposeStackNavigatorByContent<T> : ComposeStackNavigator<T>,
    ComposeNavigatorByContent<T> {

    @Composable
    fun goBack(): Boolean
}

@ExperimentalNavigationApi
interface ComposeStackNavigatorByKey<T> : ComposeStackNavigator<T>,
    ComposeNavigatorByKey<T> {

    fun goBack(): Boolean
}
