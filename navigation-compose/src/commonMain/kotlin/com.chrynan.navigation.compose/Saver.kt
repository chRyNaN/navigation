package com.chrynan.navigation.compose

import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState

/**
 * A component that can convert the type of the [Original] into the type of [Saveable] so that it can be serialized,
 * saved, restored. This component is meant to represent the androidx.compose.runtime.saveable.Saver interface, but
 * that component is not available for Jetpack Compose Web, so this expected interface is defined in the common source
 * set. The Android and JVM targets should simply use a typealias to delegate to the
 * androidx.compose.runtime.saveable.Saver interface. The JavaScript target should provide a default implementation.
 */
expect interface Saver<Original, Saveable : Any>

/**
 * Retrieves a default implementation of a [Saver] interface which does not perform any conversion. Similar to the
 * [Saver] interface, this function is meant to represent the androidx.compose.runtime.saveable.autoSaver function, but
 * that function is not available for Jetpack Compose Web, so this expected function is defined in the common source
 * set. The Android and JVM targets should simply delegate to the androidx.compose.runtime.saveable.autoSaver function.
 * The JavaScript target should provide a default implementation.
 */
expect fun <T> autoSaver(): Saver<T, Any>

@Composable
internal expect fun <T> internalRememberSaveable(
    vararg inputs: Any?,
    stateSaver: Saver<T, out Any>,
    key: String? = null,
    init: () -> MutableState<T>
): MutableState<T>

@Composable
internal expect fun <T : Any> internalRememberSaveable(
    vararg inputs: Any?,
    saver: Saver<T, out Any> = autoSaver(),
    key: String? = null,
    init: () -> T
): T

@Suppress("unused")
@Composable
fun <T> rememberSaveable(
    vararg inputs: Any?,
    stateSaver: Saver<T, out Any>,
    key: String? = null,
    init: () -> MutableState<T>
): MutableState<T> = internalRememberSaveable(inputs = inputs, stateSaver = stateSaver, key = key, init = init)

@Suppress("unused")
@Composable
fun <T : Any> rememberSaveable(
    vararg inputs: Any?,
    saver: Saver<T, out Any> = autoSaver(),
    key: String? = null,
    init: () -> T
): T = internalRememberSaveable(inputs = inputs, saver = saver, key = key, init = init)
