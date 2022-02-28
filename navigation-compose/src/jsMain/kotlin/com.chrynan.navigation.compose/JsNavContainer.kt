package com.chrynan.navigation.compose

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.chrynan.navigation.ExperimentalNavigationApi
import org.jetbrains.compose.web.dom.Div

@Composable
@ExperimentalNavigationApi
internal actual fun <Context, Key> InternalNavContainer(
    navigator: ComposeNavigatorByContentViewModel<Context, Key>
) {
    val contentKey by navigator.keyChanges.collectAsState(initial = navigator.initialKey)

    val scope = object : ComposeNavigationContentScope<Context, Key> {

        override val navigator: ComposeNavigatorByContentViewModel<Context, Key> = navigator
    }

    Div {
        navigator.apply {
            scope.content(contentKey)
        }
    }
}

@Composable
@ExperimentalNavigationApi
internal actual fun <Context, Key, NavigationScope : ComposeNavigationKeyScope<Context, Key>> InternalNavContainer(
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
