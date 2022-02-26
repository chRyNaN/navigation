package com.chrynan.navigation.compose

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import org.jetbrains.compose.web.dom.Div

@Composable
@ExperimentalNavigationApi
internal actual fun <Context, Key> InternalNavContainer(
    navigator: BaseComposeNavigatorByContentViewModel<Context, Key>
) {
    val contentKey by navigator.keyChanges.collectAsState(initial = navigator.initialKey)

    val scope = object : ComposeNavigationContentScope<Key> {

        override val navigator: ComposeStackNavigatorByContent<Key> = navigator
    }

    Div {
        navigator.apply {
            scope.content(contentKey)
        }
    }
}

@Composable
@ExperimentalNavigationApi
internal actual fun <Context, Key, NavigationScope : ComposeNavigationKeyScope<Key>> InternalNavContainer(
    navigator: BaseComposeNavigatorByKeyViewModel<Context, Key, NavigationScope>,
    scope: NavigationScope
) {
    val contentKey by navigator.keyChanges.collectAsState(initial = navigator.initialKey)

    Div {
        navigator.apply {
            scope.content(contentKey)
        }
    }
}
