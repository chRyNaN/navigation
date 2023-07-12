@file:Suppress("unused")

package com.chrynan.navigation

import kotlinx.serialization.KSerializer
import kotlinx.serialization.Serializable
import kotlinx.serialization.builtins.nullable
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.descriptors.buildClassSerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

/**
 * Represents a store of navigation state information that is useful for a [Navigator].
 */
@Serializable(with = NavigationStateStoreSerializer::class)
sealed interface NavigationStateStore<Destination : NavigationDestination, Context : NavigationContext<Destination>> {

    /**
     * A [NavigationState] of [NavigationEvent]s.
     */
    val event: NavigationState<NavigationEvent<Destination, Context>?>

    /**
     * A [NavigationState] of [NavigationDestination]s.
     */
    val destination: NavigationState<Destination>

    /**
     * A [NavigationState] of [NavigationContext]s.
     */
    val context: NavigationState<Context>

    companion object
}

/**
 * A mutable version of a [NavigationStateStore].
 */
@Serializable(with = MutableNavigationStateStoreSerializer::class)
internal sealed interface MutableNavigationStateStore<Destination : NavigationDestination, Context : NavigationContext<Destination>> :
    NavigationStateStore<Destination, Context> {

    /**
     * Updates this [NavigationStateStore]'s state values to the provided values. Each parameter value defaults to its
     * associated current value, which means if the value is not explicitly provided when invoking this function, then
     * that state value will not change.
     */
    fun update(
        event: NavigationEvent<Destination, Context>? = this.event.current,
        destination: Destination = this.destination.current,
        context: Context = this.context.current
    )

    /**
     * Resets the underlying state values back to their initial values.
     */
    fun reset()

    companion object
}

/**
 * Creates a [MutableNavigationStateStore] instance with the provided [initialContext] value.
 */
internal fun <Destination : NavigationDestination, Context : NavigationContext<Destination>> mutableNavigationStateStoreOf(
    initialContext: Context,
    initialEvent: NavigationEvent<Destination, Context>? = null,
    initialDestination: Destination = initialContext.initialDestination,
    currentContext: Context = initialContext,
    currentEvent: NavigationEvent<Destination, Context>? = initialEvent,
    currentDestination: Destination = initialDestination
): MutableNavigationStateStore<Destination, Context> =
    MutableNavigationStateStoreImpl(
        initialContext = initialContext,
        initialEvent = initialEvent,
        initialDestination = initialDestination,
        currentContext = currentContext,
        currentEvent = currentEvent,
        currentDestination = currentDestination
    )

/**
 * Converts this [NavigationStateStore] into a [MutableNavigationStateStore] instance.
 */
internal fun <Destination : NavigationDestination, Context : NavigationContext<Destination>> NavigationStateStore<Destination, Context>.toMutableNavigationStateStore(): MutableNavigationStateStore<Destination, Context> =
    if (this is MutableNavigationStateStore) {
        this
    } else {
        MutableNavigationStateStoreImpl(
            initialContext = context.initial,
            initialEvent = event.initial,
            initialDestination = destination.initial,
            currentContext = context.current,
            currentEvent = event.current,
            currentDestination = destination.current
        )
    }

/**
 * A [MutableNavigationStateStore] implementation that stores [NavigationContext]s and their associated
 * [NavigationDestination] [Stack]s in an in-memory [Map].
 */
internal class MutableNavigationStateStoreImpl<Destination : NavigationDestination, Context : NavigationContext<Destination>> internal constructor(
    initialEvent: NavigationEvent<Destination, Context>?,
    initialDestination: Destination,
    initialContext: Context,
    currentContext: Context,
    currentEvent: NavigationEvent<Destination, Context>?,
    currentDestination: Destination
) : MutableNavigationStateStore<Destination, Context> {

    override val event: NavigationState<NavigationEvent<Destination, Context>?>
        get() = mutableEvent
    override val destination: NavigationState<Destination>
        get() = mutableDestination
    override val context: NavigationState<Context>
        get() = mutableContext

    private val mutableEvent: MutableNavigationState<NavigationEvent<Destination, Context>?> =
        mutableNavigationStateOf(initial = initialEvent, current = currentEvent)
    private val mutableDestination: MutableNavigationState<Destination> =
        mutableNavigationStateOf(initial = initialDestination, current = currentDestination)
    private val mutableContext: MutableNavigationState<Context> =
        mutableNavigationStateOf(initial = initialContext, current = currentContext)

    override fun update(event: NavigationEvent<Destination, Context>?, destination: Destination, context: Context) {
        this.mutableContext.update(state = context)
        this.mutableDestination.update(state = destination)
        this.mutableEvent.update(state = event)
    }

    override fun reset() {
        mutableContext.reset()
        mutableDestination.reset()
        mutableEvent.reset()
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is MutableNavigationStateStoreImpl<*, *>) return false

        if (event != other.event) return false
        if (destination != other.destination) return false
        if (context != other.context) return false

        return context == other.context
    }

    override fun hashCode(): Int {
        var result = event.hashCode()
        result = 31 * result + destination.hashCode()
        result = 31 * result + context.hashCode()
        return result
    }

    override fun toString(): String =
        "MutableNavigationStateStoreImpl(event=$event, destination=$destination, context=$context)"
}

/**
 * A [KSerializer] for [NavigationStateStore].
 */
internal class NavigationStateStoreSerializer<Destination : NavigationDestination, Context : NavigationContext<Destination>> internal constructor(
    destinationSerializer: KSerializer<Destination>,
    contextSerializer: KSerializer<Context>
) : KSerializer<NavigationStateStore<Destination, Context>> {

    private val eventStateSerializer =
        NavigationState.serializer(NavigationEvent.serializer(destinationSerializer, contextSerializer).nullable)
    private val destinationStateSerializer = NavigationState.serializer(destinationSerializer)
    private val contextStateSerializer = NavigationState.serializer(contextSerializer)

    override val descriptor: SerialDescriptor = buildClassSerialDescriptor(serialName = "NavigationStateStore") {
        element(
            elementName = "event",
            descriptor = eventStateSerializer.descriptor
        )
        element(elementName = "destination", descriptor = destinationStateSerializer.descriptor)
        element(elementName = "context", descriptor = contextStateSerializer.descriptor)
    }

    override fun serialize(encoder: Encoder, value: NavigationStateStore<Destination, Context>) {
        val compositeEncoder = encoder.beginStructure(descriptor)
        compositeEncoder.encodeSerializableElement(
            serializer = eventStateSerializer,
            descriptor = descriptor,
            index = 0,
            value = value.event
        )
        compositeEncoder.encodeSerializableElement(
            serializer = destinationStateSerializer,
            descriptor = descriptor,
            index = 1,
            value = value.destination
        )
        compositeEncoder.encodeSerializableElement(
            serializer = contextStateSerializer,
            descriptor = descriptor,
            index = 2,
            value = value.context
        )
        compositeEncoder.endStructure(descriptor)
    }

    override fun deserialize(decoder: Decoder): NavigationStateStore<Destination, Context> {
        val compositeDecoder = decoder.beginStructure(descriptor)
        val event = compositeDecoder.decodeSerializableElement(
            deserializer = eventStateSerializer,
            descriptor = descriptor,
            index = 0
        )
        val destination = compositeDecoder.decodeSerializableElement(
            deserializer = destinationStateSerializer,
            descriptor = descriptor,
            index = 1
        )
        val context = compositeDecoder.decodeSerializableElement(
            deserializer = contextStateSerializer,
            descriptor = descriptor,
            index = 2
        )
        compositeDecoder.endStructure(descriptor)

        return mutableNavigationStateStoreOf(
            initialEvent = event.initial,
            currentEvent = event.current,
            initialDestination = destination.initial,
            currentDestination = destination.current,
            initialContext = context.initial,
            currentContext = context.current
        )
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true

        if (other !is NavigationStateStoreSerializer<*, *>) return false

        return descriptor == other.descriptor
    }

    override fun hashCode(): Int =
        descriptor.hashCode()

    override fun toString(): String =
        "NavigationStateStoreSerializer(descriptor=$descriptor)"
}

/**
 * A [KSerializer] for [MutableNavigationStateStore].
 */
internal class MutableNavigationStateStoreSerializer<Destination : NavigationDestination, Context : NavigationContext<Destination>> internal constructor(
    destinationSerializer: KSerializer<Destination>,
    contextSerializer: KSerializer<Context>
) : KSerializer<MutableNavigationStateStore<Destination, Context>> {

    private val eventStateSerializer =
        NavigationState.serializer(NavigationEvent.serializer(destinationSerializer, contextSerializer).nullable)
    private val destinationStateSerializer = NavigationState.serializer(destinationSerializer)
    private val contextStateSerializer = NavigationState.serializer(contextSerializer)

    override val descriptor: SerialDescriptor = buildClassSerialDescriptor(serialName = "NavigationStateStore") {
        element(
            elementName = "event",
            descriptor = eventStateSerializer.descriptor
        )
        element(elementName = "destination", descriptor = destinationStateSerializer.descriptor)
        element(elementName = "context", descriptor = contextStateSerializer.descriptor)
    }

    override fun serialize(encoder: Encoder, value: MutableNavigationStateStore<Destination, Context>) {
        val compositeEncoder = encoder.beginStructure(descriptor)
        compositeEncoder.encodeSerializableElement(
            serializer = eventStateSerializer,
            descriptor = descriptor,
            index = 0,
            value = value.event
        )
        compositeEncoder.encodeSerializableElement(
            serializer = destinationStateSerializer,
            descriptor = descriptor,
            index = 1,
            value = value.destination
        )
        compositeEncoder.encodeSerializableElement(
            serializer = contextStateSerializer,
            descriptor = descriptor,
            index = 2,
            value = value.context
        )
        compositeEncoder.endStructure(descriptor)
    }

    override fun deserialize(decoder: Decoder): MutableNavigationStateStore<Destination, Context> {
        val compositeDecoder = decoder.beginStructure(descriptor)
        val event = compositeDecoder.decodeSerializableElement(
            deserializer = eventStateSerializer,
            descriptor = descriptor,
            index = 0
        )
        val destination = compositeDecoder.decodeSerializableElement(
            deserializer = destinationStateSerializer,
            descriptor = descriptor,
            index = 1
        )
        val context = compositeDecoder.decodeSerializableElement(
            deserializer = contextStateSerializer,
            descriptor = descriptor,
            index = 2
        )
        compositeDecoder.endStructure(descriptor)

        return mutableNavigationStateStoreOf(
            initialEvent = event.initial,
            currentEvent = event.current,
            initialDestination = destination.initial,
            currentDestination = destination.current,
            initialContext = context.initial,
            currentContext = context.current
        )
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true

        if (other !is NavigationStateStoreSerializer<*, *>) return false

        return descriptor == other.descriptor
    }

    override fun hashCode(): Int =
        descriptor.hashCode()

    override fun toString(): String =
        "MutableNavigationStateStoreSerializer(descriptor=$descriptor)"
}
