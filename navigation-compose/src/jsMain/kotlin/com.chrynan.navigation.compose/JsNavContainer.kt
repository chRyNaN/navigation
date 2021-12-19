package com.chrynan.navigation.compose

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import org.jetbrains.compose.web.dom.Div

@Composable
@ExperimentalNavigationApi
internal actual fun <T> InternalNavContainer(
    navigator: BaseComposeNavigatorByContentViewModel<T>
) {
    val contentKey by navigator.keyChanges.collectAsState(initial = navigator.initialKey)

    val scope = object : ComposeNavigationContentScope<T> {

        override val navigator: ComposeStackNavigatorByContent<T> = navigator
    }

    Div {
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

    Div {
        navigator.apply {
            scope.content(contentKey)
        }
    }
}
