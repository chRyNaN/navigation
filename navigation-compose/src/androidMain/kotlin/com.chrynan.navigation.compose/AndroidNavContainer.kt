package com.chrynan.navigation.compose

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue

@Composable
@ExperimentalNavigationApi
internal actual fun <Context, Key> InternalNavContainer(
    navigator: BaseComposeNavigatorByContentViewModel<Context, Key>
) {
    val contentKey by navigator.keyChanges.collectAsState(initial = navigator.initialKey)

    val scope = object : ComposeNavigationContentScope<Key> {

        override val navigator: ComposeStackNavigatorByContent<Key> = navigator
    }

    Box {
        navigator.apply {
            scope.content(contentKey)
        }
    }

    BackHandler { navigator.goBack() }
}

@Composable
@ExperimentalNavigationApi
internal actual fun <Context, Key, NavigationScope : ComposeNavigationKeyScope<Key>> InternalNavContainer(
    navigator: BaseComposeNavigatorByKeyViewModel<Context, Key, NavigationScope>,
    scope: NavigationScope
) {
    val contentKey by navigator.keyChanges.collectAsState(initial = navigator.initialKey)

    Box {
        navigator.apply {
            scope.content(contentKey)
        }
    }

    BackHandler { navigator.goBack() }
}
