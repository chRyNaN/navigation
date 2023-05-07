package com.chrynan.navigation.compose

import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import com.chrynan.navigation.NavigationState
import kotlinx.coroutines.flow.StateFlow

/**
 * Converts the [NavigationState.changes] of this [NavigationState] to a Jetpack Compose [State] so that every change
 * causes a recomposition of the calling [Composable] function.
 */
@Composable
fun <T> NavigationState<T>.collectAsState(): State<T> =
    (this.changes as? StateFlow<T>)?.collectAsState() ?: this.changes.collectAsState(initial = this.initial)
