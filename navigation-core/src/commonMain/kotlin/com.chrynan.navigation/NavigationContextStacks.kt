package com.chrynan.navigation

import kotlinx.serialization.KSerializer
import kotlinx.serialization.Serializable
import kotlinx.serialization.builtins.MapSerializer
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.descriptors.buildClassSerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

/**
 * A component that wraps a [Map] of [NavigationContext] to [MutableStack] of [NavigationDestination]s and provides
 * convenience functions for accessing and altering the values. Note that this component is mutable.
 */
@Serializable(with = NavigationContextStacksSerializer::class)
internal class NavigationContextStacks<Destination : NavigationDestination, Context : NavigationContext<Destination>> internal constructor(
    internal val initialContext: Context,
    contextStacks: Map<Context, Stack<Destination>> = emptyMap()
) {

    private val destinationStacksByContext: MutableMap<Context, MutableStack<Destination>> =
        mutableMapOf(initialContext to mutableStackOf(initialContext.initialDestination)).apply {
            contextStacks.entries.forEach { entry ->
                this[entry.key] = entry.value.toMutableStack()
            }
        }

    /**
     * Retrieves the [Stack] of [Destination]s for the provided [Context].
     */
    operator fun get(context: Context): Stack<Destination> =
        destinationStacksByContext[context]?.toStack() ?: stackOf(context.initialDestination)

    /**
     * Sets the [Stack] for the provided [Context]. Note that this does not perform a check to make sure that the
     * initial destination is correct.
     */
    operator fun set(context: Context, destinations: Stack<Destination>) {
        destinationStacksByContext[context] = destinations.toMutableStack()
    }

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
     * Pushes the provided [destination] to the top of the [Stack] of [Destination]s for the provided [context], but
     * if the provided [destination] already exists in the [Stack] of [Destination]s for the provided [context], all
     * the items on top of it will be popped from the stack.
     */
    fun pushDropping(context: Context, destination: Destination) {
        val stack = destinationStacksByContext[context] ?: mutableStackOf(context.initialDestination)

        val index = stack.indexOf(destination)

        if (index == -1) {
            stack.push(destination)
        } else {
            val dropCount = (stack.size - (stack.size - index)) + 1

            stack.drop(dropCount)

            stack.push(destination)
        }

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
     * Clears the stack for the provided [context] and resets it back to its initial state.
     */
    fun clear(context: Context) {
        destinationStacksByContext[context] = mutableStackOf(context.initialDestination)
    }

    /**
     * Clears all the [Stack]s of [Destination]s for all the [Context]s. This resets the internal data structure back
     * to its initial state.
     */
    fun clearAll() {
        destinationStacksByContext.clear()
        destinationStacksByContext[initialContext] = mutableStackOf(initialContext.initialDestination)
    }

    /**
     * Returns a [Map] of the [Context] to [Stack] of [Destination]s.
     */
    fun toMap(): Map<Context, Stack<Destination>> = destinationStacksByContext
}

/**
 * Pops the top destination off the provided [context] stack and returns the new top destination, or `null` if the
 * provided [context] stack could not be popped (there must be at least one item in the stack at all times).
 */
internal fun <Destination : NavigationDestination, Context : NavigationContext<Destination>> NavigationContextStacks<Destination, Context>.popToPreviousDestinationForContext(
    context: Context
): Destination? {
    this.pop(context) ?: return null

    return this.peek(context)
}

/**
 * A [KSerializer] for [NavigationContextStacks].
 */
internal class NavigationContextStacksSerializer<Destination : NavigationDestination, Context : NavigationContext<Destination>> internal constructor(
    destinationSerializer: KSerializer<Destination>,
    private val contextSerializer: KSerializer<Context>
) : KSerializer<NavigationContextStacks<Destination, Context>> {

    private val stackSerializer = StackSerializer(destinationSerializer)
    private val mapSerializer = MapSerializer(contextSerializer, stackSerializer)

    override val descriptor: SerialDescriptor = buildClassSerialDescriptor(serialName = "NavigationContextStacks") {
        element(elementName = "initialContext", descriptor = contextSerializer.descriptor)
        element(elementName = "context_stacks", descriptor = mapSerializer.descriptor)
    }

    override fun serialize(encoder: Encoder, value: NavigationContextStacks<Destination, Context>) {
        encoder.encodeSerializableValue(serializer = contextSerializer, value = value.initialContext)
        encoder.encodeSerializableValue(serializer = mapSerializer, value = value.toMap())
    }

    override fun deserialize(decoder: Decoder): NavigationContextStacks<Destination, Context> {
        val initialContext = decoder.decodeSerializableValue(deserializer = contextSerializer)
        val contextStacks = decoder.decodeSerializableValue(deserializer = mapSerializer)

        return NavigationContextStacks(
            initialContext = initialContext,
            contextStacks = contextStacks
        )
    }
}
