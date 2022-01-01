package com.chrynan.navigation.compose

import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue

@Composable
@ExperimentalNavigationApi
internal actual fun <Scope, Key> InternalNavContainer(
    navigator: BaseComposeNavigatorByContentViewModel<Scope, Key>
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
}

@Composable
@ExperimentalNavigationApi
internal actual fun <Scope, Key, NavigationScope : ComposeNavigationKeyScope<Key>> InternalNavContainer(
    navigator: BaseComposeNavigatorByKeyViewModel<Scope, Key, NavigationScope>,
    scope: NavigationScope
) {
    val contentKey by navigator.keyChanges.collectAsState(initial = navigator.initialKey)

    Box {
        navigator.apply {
            scope.content(contentKey)
        }
    }
}
