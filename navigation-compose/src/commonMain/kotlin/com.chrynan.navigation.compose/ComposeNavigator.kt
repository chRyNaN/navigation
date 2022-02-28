@file:Suppress("unused")

package com.chrynan.navigation.compose

import androidx.compose.runtime.Composable
import kotlinx.coroutines.flow.Flow
import com.chrynan.navigation.StackDuplicateContentStrategy
import com.chrynan.navigation.Navigator

@ExperimentalNavigationApi
interface ComposeNavigator<Key> : Navigator {

    val initialKey: Key

    val currentKey: Key

    val keyChanges: Flow<Key>

    val isInitialized: Boolean

    val keySaver: Saver<Key, Any>

    companion object
}

@ExperimentalNavigationApi
interface ComposeContextNavigator<Context, Key> : ComposeNavigator<Key> {

    val initialContext: Context

    val currentContext: Context

    val contextChanges: Flow<Context>

    fun changeContext(to: Context)

    companion object
}

@ExperimentalNavigationApi
interface ComposeNavigatorByContent<Context, Key> : ComposeNavigator<Key>,
    ComposeContextNavigator<Context, Key> {

    @Composable
    fun goTo(
        key: Key,
        strategy: StackDuplicateContentStrategy,
        content: @Composable ComposeNavigationContentScope<Context, Key>.() -> Unit
    )

    companion object
}

// Note: This is needed because defaults aren't working for @Composable functions for interfaces.
@Suppress("unused")
@ExperimentalNavigationApi
@Composable
fun <Context, Key> ComposeNavigatorByContent<Context, Key>.goTo(
    key: Key,
    content: @Composable ComposeNavigationContentScope<Context, Key>.() -> Unit
) =
    goTo(key = key, strategy = StackDuplicateContentStrategy.CLEAR_STACK, content = content)

@ExperimentalNavigationApi
interface ComposeNavigatorByKey<Context, Key> : ComposeNavigator<Key>,
    ComposeContextNavigator<Context, Key> {

    fun goTo(
        key: Key,
        strategy: StackDuplicateContentStrategy
    )

    companion object
}

// Note: This is needed because defaults aren't working for @Composable functions for interfaces.
@Suppress("unused")
@ExperimentalNavigationApi
fun <Context, Key> ComposeNavigatorByKey<Context, Key>.goTo(key: Key) =
    goTo(key = key, strategy = StackDuplicateContentStrategy.CLEAR_STACK)
