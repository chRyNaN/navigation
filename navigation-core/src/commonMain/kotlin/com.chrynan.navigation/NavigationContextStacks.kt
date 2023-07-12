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

            destinationStacksByContext[context] = stack
        } else {
            val dropCount = (stack.size - (stack.size - index)) + 1

            val newStack = stack.toList().drop(dropCount).toMutableStack()

            newStack.push(destination)

            destinationStacksByContext[context] = newStack
        }
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

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is NavigationContextStacks<*, *>) return false

        if (initialContext != other.initialContext) return false

        return destinationStacksByContext == other.destinationStacksByContext
    }

    override fun hashCode(): Int {
        var result = initialContext.hashCode()
        result = 31 * result + destinationStacksByContext.hashCode()
        return result
    }

    override fun toString(): String =
        "NavigationContextStacks(" +
                "initialContext=$initialContext, " +
                "destinationStacksByContext=$destinationStacksByContext)"
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
        val compositeEncoder = encoder.beginStructure(descriptor)
        compositeEncoder.encodeSerializableElement(
            serializer = contextSerializer,
            descriptor = descriptor,
            index = 0,
            value = value.initialContext
        )
        compositeEncoder.encodeSerializableElement(
            serializer = mapSerializer,
            descriptor = descriptor,
            index = 1,
            value = value.toMap()
        )
        compositeEncoder.endStructure(descriptor)
    }

    override fun deserialize(decoder: Decoder): NavigationContextStacks<Destination, Context> {
        val compositeDecoder = decoder.beginStructure(descriptor)
        val initialContext = compositeDecoder.decodeSerializableElement(
            deserializer = contextSerializer,
            descriptor = descriptor,
            index = 0
        )
        val contextStacks = compositeDecoder.decodeSerializableElement(
            deserializer = mapSerializer,
            descriptor = descriptor,
            index = 1
        )
        compositeDecoder.endStructure(descriptor)

        return NavigationContextStacks(
            initialContext = initialContext,
            contextStacks = contextStacks
        )
    }
}
