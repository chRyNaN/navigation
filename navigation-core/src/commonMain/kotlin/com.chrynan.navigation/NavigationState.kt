@file:Suppress("unused")

package com.chrynan.navigation

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.serialization.KSerializer
import kotlinx.serialization.Serializable
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

/**
 * A generic wrapper around the state of a navigation component. This provides a way to access the retained [initial]
 * state value, the [current] state value, and [changes] to the state value.
 *
 * Though this component can be generally useful for any type of state management, it is meant for use within the
 * context of this navigation library (hence, the name of the component), and is exposed so that the wrapped state
 * values can be accessed. This component is a sealed interface so that it cannot be inherited outside of this library,
 * and creation of the component is internal. If you need something like this component externally, consider using a
 * state management library like [cycle](https://github.com/chRyNaN/cycle).
 */
@Serializable(with = NavigationStateSerializer::class)
sealed interface NavigationState<T> {

    /**
     * The initial state value when this component was first created. This value does not change when the wrapped state
     * value changes, so subsequent calls to access this property will always return the same value.
     */
    val initial: T

    /**
     * The current state value. This value can change over time, so subsequent calls to access this property can return
     * different values. Use the [changes] property to subscribe to the changes.
     */
    val current: T

    /**
     * The changes in the underlying wrapped state value. This is a shareable [Flow] that can be subscribed to for the
     * purposes of listening to state changes.
     */
    val changes: Flow<T>

    companion object
}

/**
 * A mutable version of [NavigationState] that allows changing of the underlying wrapped state value.
 */
internal sealed interface MutableNavigationState<T> : NavigationState<T> {

    /**
     * Updates the [current] state value to be the provided [state] value. This will cause the [state] value to be
     * emitted to [changes].
     */
    fun update(state: T)

    /**
     * Resets the state back to its [initial] value. This will cause the [initial] value to be emitted to [changes].
     */
    fun reset()

    companion object
}

/**
 * Creates a [MutableNavigationState] instance.
 */
internal fun <T> mutableNavigationStateOf(initial: T): MutableNavigationState<T> =
    StateFlowMutableNavigationState(initial = initial)

/**
 * An implementation of a [NavigationState] and [MutableNavigationState] backed by a provided [MutableStateFlow].
 */
internal class StateFlowMutableNavigationState<T> internal constructor(
    override val initial: T
) : MutableNavigationState<T> {

    private val stateFlow: MutableStateFlow<T> = MutableStateFlow(value = initial)

    override val current: T
        get() = stateFlow.value

    override val changes: Flow<T>
        get() = stateFlow

    override fun update(state: T) {
        stateFlow.value = state
    }

    override fun reset() {
        stateFlow.value = initial
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is StateFlowMutableNavigationState<*>) return false

        if (stateFlow != other.stateFlow) return false

        return initial == other.initial
    }

    override fun hashCode(): Int {
        var result = stateFlow.hashCode()
        result = 31 * result + (initial?.hashCode() ?: 0)
        return result
    }

    override fun toString(): String =
        "StateFlowMutableNavigationState(initial=$initial, current=$current, changes=$changes)"
}

/**
 * Represents a snapshot of a [NavigationState] that can be persisted and obtained later to create a [NavigationState]
 * with the same values of this snapshot.
 */
@Serializable
internal class PersistedNavigationStateSnapshot<T>(
    val initial: T,
    val current: T
) {

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is PersistedNavigationStateSnapshot<*>) return false

        if (initial != other.initial) return false
        return current == other.current
    }

    override fun hashCode(): Int {
        var result = initial?.hashCode() ?: 0
        result = 31 * result + (current?.hashCode() ?: 0)
        return result
    }

    override fun toString(): String =
        "PersistedNavigationStateSnapshot(initial=$initial, current=$current)"
}

/**
 * A [KSerializer] for a [NavigationState].
 */
internal class NavigationStateSerializer<T> internal constructor(
    elementSerializer: KSerializer<T>
) : KSerializer<NavigationState<T>> {

    private val delegateSerializer = PersistedNavigationStateSnapshot.serializer(elementSerializer)

    override val descriptor: SerialDescriptor
        get() = delegateSerializer.descriptor

    override fun serialize(encoder: Encoder, value: NavigationState<T>) {
        val snapshot = PersistedNavigationStateSnapshot(initial = value.initial, current = value.current)

        delegateSerializer.serialize(encoder = encoder, value = snapshot)
    }

    override fun deserialize(decoder: Decoder): NavigationState<T> {
        val snapshot = delegateSerializer.deserialize(decoder = decoder)

        return mutableNavigationStateOf(initial = snapshot.initial).apply {
            this.update(state = snapshot.current)
        }
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true

        if (other !is NavigationStateSerializer<*>) return false

        return delegateSerializer == other.delegateSerializer
    }

    override fun hashCode(): Int =
        delegateSerializer.hashCode()

    override fun toString(): String =
        "NavigationStateSerializer(delegateSerializer=$delegateSerializer)"
}
