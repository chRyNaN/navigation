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

    Div {
        navigator.content(contentKey)
    }
}

@Composable
@ExperimentalNavigationApi
internal actual fun <T> InternalNavContainer(
    navigator: BaseComposeNavigatorByKeyViewModel<T>
) {
    val contentKey by navigator.keyChanges.collectAsState(initial = navigator.initialKey)

    Div {
        navigator.content(contentKey)
    }
}
