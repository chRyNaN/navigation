@file:Suppress("unused")

package com.chrynan.navigation.compose

import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState

actual typealias Saver<Original, Saveable> = androidx.compose.runtime.saveable.Saver<Original, Saveable>

actual fun <T> autoSaver(): Saver<T, Any> = androidx.compose.runtime.saveable.autoSaver()

@Composable
internal actual fun <T> internalRememberSaveable(
    vararg inputs: Any?,
    stateSaver: Saver<T, out Any>,
    key: String?,
    init: () -> MutableState<T>
): MutableState<T> =
    androidx.compose.runtime.saveable.rememberSaveable(inputs = inputs, stateSaver = stateSaver, key = key, init = init)

@Composable
internal actual fun <T : Any> internalRememberSaveable(
    vararg inputs: Any?,
    saver: Saver<T, out Any>,
    key: String?,
    init: () -> T
): T = androidx.compose.runtime.saveable.rememberSaveable(inputs = inputs, saver = saver, key = key, init = init)
