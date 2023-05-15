package com.chrynan.navigation

import kotlinx.serialization.KSerializer
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

/**
 * A component that wraps a [Map] of [NavigationContext] to [MutableStack] of [NavigationDestination]s and provides
 * convenience functions for accessing and altering the values. Note that this component is mutable.
 */
@Serializable(with = NavigationContextStacksSerializer::class)
internal class NavigationContextStacks<Destination : NavigationDestination, Context : NavigationContext<Destination>> internal constructor(
    internal val initialContext: Context
) {

    /**
     * A read-only version of the internal context map stack state.
     */
    internal val contextStacks: Map<Context, Stack<Destination>>
        get() = destinationStacksByContext

    private val destinationStacksByContext =
        mutableMapOf(initialContext to mutableStackOf(initialContext.initialDestination))

    /**
     * Retrieves the [Stack] of [Destination]s for the provided [Context].
     */
    operator fun get(context: Context): Stack<Destination> =
        destinationStacksByContext[context]?.toStack() ?: stackOf(context.initialDestination)

    /**
     * Retrieves the current [Destination] on top of the [Stack] for the provided [Context] without removing it.
     */
    fun peek(context: Context): Destination =
        get(context = context).peekOrNull() ?: context.initialDestination

    /**
     * Removes and returns the [Destination] on top of the [Stack] for the provided [Context], or `null` if the item
     * cannot be removed. There must always be at least one item within a [Destination] [Stack], attempting to remove
     * that item will fail and return `null` instead.
     */
    fun pop(context: Context): Destination? {
        val stack = destinationStacksByContext[context] ?: return null

        if (stack.size <= 1) return null

        val removed = stack.pop()

        destinationStacksByContext[context] = stack

        return removed
    }

    /**
     * Pushes the provided [destination] to the top of the [Stack] of [Destination]s for the provided [context].
     */
    fun push(context: Context, destination: Destination) {
        val stack = destinationStacksByContext[context] ?: mutableStackOf(context.initialDestination)

        stack.push(destination)

        destinationStacksByContext[context] = stack
    }

    /**
     * Pushes all the provided [destinations] to the top of the [Stack] of [Destination]s for the provided [context].
     */
    fun pushAll(context: Context, destinations: Stack<Destination>) {
        val stack = destinationStacksByContext[context] ?: mutableStackOf(context.initialDestination)

        destinations.forEach { destination -> stack.push(destination) }

        destinationStacksByContext[context] = stack
    }

    /**
     * Clears all the [Stack]s of [Destination]s for all the [Context]s. This resets the internal data structure back
     * to its initial state.
     */
    fun clear() {
        destinationStacksByContext.clear()
        destinationStacksByContext[initialContext] = mutableStackOf(initialContext.initialDestination)
    }
}

/**
 * Represents a snapshot of a [NavigationContextStacks] that can be persisted and obtained later to create a
 * [NavigationContextStacks] with the same values of this snapshot.
 */
@Serializable
internal class PersistedNavigationContextStacksSnapshot<Destination : NavigationDestination, Context : NavigationContext<Destination>> internal constructor(
    @SerialName(value = "initial_context") val initialContext: Context,
    @SerialName(value = "context_stacks") val contextStacks: Map<Context, Stack<Destination>>
) {

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is PersistedNavigationContextStacksSnapshot<*, *>) return false

        if (initialContext != other.initialContext) return false

        return contextStacks == other.contextStacks
    }

    override fun hashCode(): Int {
        var result = initialContext.hashCode()
        result = 31 * result + contextStacks.hashCode()
        return result
    }

    override fun toString(): String =
        "PersistedNavigationContextStacksSnapshot(initialContext=$initialContext, contextStacks=$contextStacks)"
}

/**
 * A [KSerializer] for [NavigationContextStacks].
 */
internal class NavigationContextStacksSerializer<Destination : NavigationDestination, Context : NavigationContext<Destination>> internal constructor(
    destinationSerializer: KSerializer<Destination>,
    contextSerializer: KSerializer<Context>
) : KSerializer<NavigationContextStacks<Destination, Context>> {

    private val delegateSerializer =
        PersistedNavigationContextStacksSnapshot.serializer(destinationSerializer, contextSerializer)

    override val descriptor: SerialDescriptor
        get() = delegateSerializer.descriptor

    override fun serialize(encoder: Encoder, value: NavigationContextStacks<Destination, Context>) {
        val snapshot = PersistedNavigationContextStacksSnapshot(
            initialContext = value.initialContext,
            contextStacks = value.contextStacks
        )

        delegateSerializer.serialize(encoder = encoder, value = snapshot)
    }

    override fun deserialize(decoder: Decoder): NavigationContextStacks<Destination, Context> {
        val snapshot = delegateSerializer.deserialize(decoder = decoder)

        return NavigationContextStacks(initialContext = snapshot.initialContext).apply {
            snapshot.contextStacks.forEach { (context, destinations) ->
                this.pushAll(context = context, destinations = destinations)
            }
        }
    }
}
