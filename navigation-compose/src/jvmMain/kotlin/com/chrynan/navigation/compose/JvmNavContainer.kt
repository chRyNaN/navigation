package com.chrynan.navigation.compose

import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue

@Composable
@ExperimentalNavigationApi
internal actual fun <T> InternalNavContainer(
    navigator: BaseComposeNavigatorByContentViewModel<T>
) {
    val contentKey by navigator.keyChanges.collectAsState(initial = navigator.initialKey)

    val scope = object : ComposeNavigationContentScope<T> {

        override val navigator: ComposeStackNavigatorByContent<T> = navigator
    }

    Box {
        navigator.apply {
            scope.content(contentKey)
        }
    }
}

@Composable
@ExperimentalNavigationApi
internal actual fun <T, S : ComposeNavigationKeyScope<T>> InternalNavContainer(
    navigator: BaseComposeNavigatorByKeyViewModel<T, S>,
    scope: S
) {
    val contentKey by navigator.keyChanges.collectAsState(initial = navigator.initialKey)

    Box {
        navigator.apply {
            scope.content(contentKey)
        }
    }
}
