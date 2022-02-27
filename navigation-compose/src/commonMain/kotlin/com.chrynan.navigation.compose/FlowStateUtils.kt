@file:Suppress("unused")

package com.chrynan.navigation.compose

import androidx.compose.runtime.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.suspendCancellableCoroutine
import kotlinx.coroutines.withContext
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.EmptyCoroutineContext
import kotlin.experimental.ExperimentalTypeInference

/**
 * Similar to the [collectAsState] function but allows providing the [MutableState] to be used.
 *
 * @see [collectAsState]
 */
@Composable
internal fun <T : R, R> Flow<T>.collectAsStateIn(
    state: MutableState<R>,
    context: CoroutineContext = EmptyCoroutineContext
): State<R> = produceStateIn(state = state, this, context) {
    if (context == EmptyCoroutineContext) {
        collect { value = it }
    } else withContext(context) {
        collect { value = it }
    }
}

/**
 * Similar to the [produceState] function but allows providing the [MutableState] to be used.
 *
 * @see [produceState]
 */
@Composable
@OptIn(ExperimentalTypeInference::class)
private fun <T> produceStateIn(
    state: MutableState<T>,
    @BuilderInference producer: suspend ProduceStateScope<T>.() -> Unit
): State<T> {
    val result = remember { state }

    LaunchedEffect(Unit) {
        ProduceStateScopeImpl(result, coroutineContext).producer()
    }

    return result
}

/**
 * Similar to the [produceState] function but allows providing the [MutableState] to be used.
 *
 * @see [produceState]
 */
@Composable
@OptIn(ExperimentalTypeInference::class)
private fun <T> produceStateIn(
    state: MutableState<T>,
    vararg keys: Any?,
    @BuilderInference producer: suspend ProduceStateScope<T>.() -> Unit
): State<T> {
    val result = remember { state }

    @Suppress("CHANGING_ARGUMENTS_EXECUTION_ORDER_FOR_NAMED_VARARGS")
    (LaunchedEffect(keys = keys) {
        ProduceStateScopeImpl(state = result, coroutineContext = coroutineContext).producer()
    })

    return result
}

private class ProduceStateScopeImpl<T>(
    state: MutableState<T>,
    override val coroutineContext: CoroutineContext
) : ProduceStateScope<T>, MutableState<T> by state {

    override suspend fun awaitDispose(onDispose: () -> Unit): Nothing {
        try {
            suspendCancellableCoroutine<Nothing> { }
        } finally {
            onDispose()
        }
    }
}
