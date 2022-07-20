@file:Suppress("unused")

package com.chrynan.navigation.compose

import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.remember

actual interface Saver<Original, Saveable : Any>

actual fun <T> autoSaver(): Saver<T, Any> = object : Saver<T, Any> {}

@Composable
internal actual fun <T> internalRememberSaveable(
    vararg inputs: Any?,
    stateSaver: Saver<T, out Any>,
    key: String?,
    init: () -> MutableState<T>
): MutableState<T> = remember(inputs, key, calculation = init)

@Composable
internal actual fun <T : Any> internalRememberSaveable(
    vararg inputs: Any?,
    saver: Saver<T, out Any>,
    key: String?,
    init: () -> T
): T = remember(inputs, key, calculation = init)
