package com.chrynan.navigation.compose

import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable

@Composable
@ExperimentalNavigationApi
internal actual fun <Context, Key> InternalNavContainer(
    navigator: ComposeNavigatorByContentViewModel<Context, Key>
) {
    val contentKey = rememberSaveable(navigator.keySaver) { mutableStateOf(navigator.initialKey) }

    navigator.keyChanges.collectAsStateIn(state = contentKey)

    val scope = object : ComposeNavigationContentScope<Context, Key> {

        override val navigator: ComposeNavigatorByContentViewModel<Context, Key> = navigator
    }

    Box {
        navigator.apply {
            scope.content(contentKey.value)
        }
    }
}

@Composable
@ExperimentalNavigationApi
internal actual fun <Context, Key, NavigationScope : ComposeNavigationKeyScope<Context, Key>> InternalNavContainer(
    navigator: BaseComposeNavigatorByKeyViewModel<Context, Key, NavigationScope>,
    scope: NavigationScope
) {
    val contentKey = rememberSaveable(navigator.keySaver) { mutableStateOf(navigator.initialKey) }

    navigator.keyChanges.collectAsStateIn(state = contentKey)

    Box {
        navigator.apply {
            scope.content(contentKey.value)
        }
    }
}
