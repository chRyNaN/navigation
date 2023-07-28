@file:Suppress("unused")

package com.chrynan.navigation

import kotlinx.serialization.KSerializer
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.descriptors.buildClassSerialDescriptor
import kotlinx.serialization.descriptors.element
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

/**
 * A [Navigator] is responsible for coordinating the navigation between the different UI component groupings in an
 * application. It is a stateful component that reacts to [NavigationEvent]s that are emitted via calls to the
 * navigation functions ([push], [popDestination], and [push]) and updates its stored state values which can be
 * accessed via its state [store]. It is up to the user of a [Navigator] to subscribe to the state changes of this
 * component and update the associated UI accordingly.
 *
 * ## Example usage:
 *
 * ```kotlin
 * // Create a Navigator instance.
 * val navigator = Navigator(initialContext = mainAppContext)
 *
 * // Listen to destination changes and update the UI accordingly.
 * navigator.store.destination.changes
 *     .onEach { destination ->
 *         // Update the UI
 *     }
 *     .launchIn(coroutineScope)
 *
 * // Perform navigation to different destinations.
 * navigator.goTo(destination = Destinations.HOME)
 * ```
 *
 * @see [Navigator] The [Navigator] constructor function for creating an instance of this interface.
 * @see [push] For navigating to a new [NavigationDestination] within the current [NavigationContext].
 * @see [popDestination] For navigating backward to the previous [NavigationDestination] within the current
 * [NavigationContext].
 * @see [popContext] For navigating backward to the previous [NavigationContext].
 * @see [push] For navigating to a different [NavigationContext].
 */
@ExperimentalNavigationApi
@Serializable(with = NavigatorSerializer::class)
sealed interface Navigator<Destination : NavigationDestination, Context : NavigationContext<Destination>> {

    /**
     * The [NavigationStateStore] containing the latest [NavigationState]s for each navigation value. This is useful to
     * get the initial, current, or subscribe to the changes in value of the different navigation components.
     */
    val store: NavigationStateStore<Destination, Context>

    /**
     * Dispatches the provided navigation [event] which mutates the underlying state values if the navigation event can
     * be performed.
     *
     * > [!Note] The creation of [NavigationEvent]s is handled internally within this library's components,
     * > therefore, instead of invoking this function explicitly, use the [popDestination], [push], and [push]
     * > functions.
     *
     * @param [event] The [NavigationEvent] that represents the navigation action to be performed.
     *
     * @return `true` if the navigation event was handled, or `false` if the event could not be handled (ex: a back
     * navigation event was provided but there are no destinations to go back to). If `false` is returned, the
     * underlying state values were not mutated.
     */
    fun dispatch(event: NavigationEvent<Destination, Context>): Boolean

    /**
     * Determines whether this [Navigator] can navigate back to a previous destination in the current context.
     *
     * @return `true` if this [Navigator] can navigate back to a previous destination in the current context, `false`
     * otherwise.
     */
    fun canPopDestination(): Boolean

    /**
     * Determines whether this [Navigator] can navigate back to a previous context.
     *
     * @return `true` if this [Navigator] can navigate back to a previous context, `false` otherwise.
     */
    fun canPopContext(): Boolean

    /**
     * Resets this [Navigator] back to its initial state.
     */
    fun reset()

    companion object
}

/**
 * Performs a back navigation operation, if possible, by removing the top [NavigationDestination] within the current
 * [NavigationContext]. If this [Navigator] cannot navigate to a previous [NavigationDestination], then this function
 * will do nothing and return `false`.
 *
 * @return `true` if the back navigation operation was successful, `false` otherwise.
 */
@ExperimentalNavigationApi
fun <Destination : NavigationDestination, Context : NavigationContext<Destination>> Navigator<Destination, Context>.popDestination(): Boolean =
    dispatch(event = NavigationEvent.Backward.Destination())

/**
 * Performs a back navigation operation, if possible, by moving to the previous [NavigationContext]. If this
 * [Navigator] cannot navigate to a previous [NavigationContext], then this function will do nothing and return
 * `false`.
 *
 * @return `true` if the back navigation operation was successful, `false` otherwise.
 */
@ExperimentalNavigationApi
fun <Destination : NavigationDestination, Context : NavigationContext<Destination>> Navigator<Destination, Context>.popContext(): Boolean =
    dispatch(event = NavigationEvent.Backward.Context())

/**
 * Navigates to the provided [destination] in the current [NavigationContext]. Depending on the provided
 * [NavigationStrategy.DuplicateDestination] when creating this [Navigator], and the current [Context] stack, this will
 * either clear the current [Context] stack to the last value that equals the provided [destination], or add the
 * provided [destination] to the top of the current [Context] stack.
 *
 * @param [destination] The [NavigationDestination] that is to be navigated to and added to the current [Context]
 * stack.
 *
 * @return `true` if the navigation operation was successful, `false` otherwise.
 */
@ExperimentalNavigationApi
fun <Destination : NavigationDestination, Context : NavigationContext<Destination>> Navigator<Destination, Context>.push(
    destination: Destination
): Boolean = dispatch(event = NavigationEvent.Forward.Destination(destination = destination))

/**
 * Changes the current [Context] to the provided [context] value. The displayed [Destination] will be the top
 * destination value in the stack associated with the provided [context], or the provided context's
 * [NavigationContext.initialDestination] if there is currently no existing stack for the provided [context].
 *
 * @param [context] The [NavigationContext] to change to.
 *
 * @return `true` if the navigation operation was successful, `false` otherwise.
 */
@ExperimentalNavigationApi
fun <Destination : NavigationDestination, Context : NavigationContext<Destination>> Navigator<Destination, Context>.push(
    context: Context
): Boolean = dispatch(event = NavigationEvent.Forward.Context(context = context))

/**
 * Convenience function for the [Navigator.push] function.
 *
 * > [!Warning] This function is deprecated and will be replaced with the [Navigator.push] function.
 *
 * @see [Navigator.push]
 */
@Deprecated(
    message = "",
    level = DeprecationLevel.WARNING,
    replaceWith = ReplaceWith(
        expression = "com.chrynan.navigation.Navigator.push"
    )
)
@ExperimentalNavigationApi
fun <Destination : NavigationDestination, Context : NavigationContext<Destination>> Navigator<Destination, Context>.goTo(
    destination: Destination
): Boolean = dispatch(event = NavigationEvent.Forward.Destination(destination = destination))

/**
 * Convenience function for the [Navigator.push] function.
 *
 * > [!Warning] This function is deprecated and will be replaced with the [Navigator.push] function.
 *
 * @see [Navigator.push]
 */
@Deprecated(
    message = "",
    level = DeprecationLevel.WARNING,
    replaceWith = ReplaceWith(
        expression = "com.chrynan.navigation.Navigator.push"
    )
)
@ExperimentalNavigationApi
fun <Destination : NavigationDestination, Context : NavigationContext<Destination>> Navigator<Destination, Context>.changeContext(
    context: Context
): Boolean = dispatch(event = NavigationEvent.Forward.Context(context = context))

/**
 * Creates a [Navigator] instance with the provided values.
 *
 * @param [initialContext] The initial [NavigationContext] value to start at for this [Navigator].
 * @param [duplicateDestinationStrategy] The [NavigationStrategy.DuplicateDestination] strategy for handling of
 * duplicate destination content within a [Context] stack. Read the documentation on
 * [NavigationStrategy.DuplicateDestination] for more information about the supported operations. Defaults to
 * [NavigationStrategy.DuplicateDestination.ALLOW_DUPLICATES].
 * @param [destinationRetentionStrategy] The [NavigationStrategy.DestinationRetention] strategy for handling of
 * destination stacks within a [Context] when navigating between different [NavigationContext]s. Read the documentation
 * on [NavigationStrategy.DestinationRetention] for more information about the supported operations. Defaults to
 * [NavigationStrategy.DestinationRetention.RETAIN].
 */
@ExperimentalNavigationApi
fun <Destination : NavigationDestination, Context : NavigationContext<Destination>> Navigator(
    initialContext: Context,
    duplicateDestinationStrategy: NavigationStrategy.DuplicateDestination = NavigationStrategy.DuplicateDestination.ALLOW_DUPLICATES,
    destinationRetentionStrategy: NavigationStrategy.DestinationRetention = NavigationStrategy.DestinationRetention.RETAIN
): Navigator<Destination, Context> =
    NavigatorImpl(
        initialContext = initialContext,
        duplicateDestinationStrategy = duplicateDestinationStrategy,
        destinationRetentionStrategy = destinationRetentionStrategy
    )

/**
 * Creates a [Navigator] instance with the provided values using the [SingleNavigationContext].
 *
 * @param [initialDestination] The initial [NavigationDestination] value to start at for this [Navigator].
 * @param [duplicateDestinationStrategy] The [NavigationStrategy.DuplicateDestination] strategy for handling of
 * duplicate destination content within a [NavigationContext] stack. Read the documentation on
 * [NavigationStrategy.DuplicateDestination] for more information about the supported operations. Defaults to
 * [NavigationStrategy.DuplicateDestination.ALLOW_DUPLICATES].
 * @param [destinationRetentionStrategy] The [NavigationStrategy.DestinationRetention] strategy for handling of
 * destination stacks within a [NavigationContext] when navigating between different [NavigationContext]s. Read the
 * documentation on [NavigationStrategy.DestinationRetention] for more information about the supported operations.
 * Defaults to [NavigationStrategy.DestinationRetention.RETAIN].
 */
@ExperimentalNavigationApi
fun <Destination : NavigationDestination> Navigator(
    initialDestination: Destination,
    duplicateDestinationStrategy: NavigationStrategy.DuplicateDestination = NavigationStrategy.DuplicateDestination.ALLOW_DUPLICATES,
    destinationRetentionStrategy: NavigationStrategy.DestinationRetention = NavigationStrategy.DestinationRetention.RETAIN
): Navigator<Destination, SingleNavigationContext<Destination>> =
    NavigatorImpl(
        initialContext = SingleNavigationContext(initialDestination = initialDestination),
        duplicateDestinationStrategy = duplicateDestinationStrategy,
        destinationRetentionStrategy = destinationRetentionStrategy
    )

/**
 * Represents a snapshot of a [Navigator] that can be persisted and obtained later to create a [Navigator] with the
 * same values of this snapshot.
 */
@Serializable
@ExperimentalNavigationApi
internal class NavigatorSnapshot<Destination : NavigationDestination, Context : NavigationContext<Destination>> internal constructor(
    @SerialName(value = "initial_context") val initialContext: Context,
    @SerialName(value = "duplication_destination_strategy") val duplicateDestinationStrategy: NavigationStrategy.DuplicateDestination,
    @SerialName(value = "destination_retention_strategy") val destinationRetentionStrategy: NavigationStrategy.DestinationRetention,
    @SerialName(value = "state_store") val stateStore: NavigationStateStore<Destination, Context>,
    @SerialName(value = "context_stacks") val contextStacks: NavigationContextStacks<Destination, Context>,
    @SerialName(value = "context_event_stack") val contextEventStack: MutableStack<NavigationEvent.Forward.Context<Destination, Context>>
) {

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || this::class != other::class) return false

        if (other !is NavigatorSnapshot<*, *>) return false

        if (initialContext != other.initialContext) return false
        if (duplicateDestinationStrategy != other.duplicateDestinationStrategy) return false
        if (destinationRetentionStrategy != other.destinationRetentionStrategy) return false
        if (stateStore != other.stateStore) return false
        if (contextStacks != other.contextStacks) return false

        return contextEventStack == other.contextEventStack
    }

    override fun hashCode(): Int {
        var result = initialContext.hashCode()
        result = 31 * result + duplicateDestinationStrategy.hashCode()
        result = 31 * result + destinationRetentionStrategy.hashCode()
        result = 31 * result + stateStore.hashCode()
        result = 31 * result + contextStacks.hashCode()
        result = 31 * result + contextEventStack.hashCode()
        return result
    }

    override fun toString(): String =
        "NavigatorSnapshot(" +
                "initialContext=$initialContext, " +
                "duplicateDestinationStrategy=$duplicateDestinationStrategy, " +
                "destinationRetentionStrategy=$destinationRetentionStrategy, " +
                "stateStore=$stateStore, " +
                "contextStacks=$contextStacks, " +
                "contextEventStack=$contextEventStack)"
}

/**
 * An implementation of the [Navigator] interface.
 */
@ExperimentalNavigationApi
internal class NavigatorImpl<Destination : NavigationDestination, Context : NavigationContext<Destination>> :
    Navigator<Destination, Context> {

    internal constructor(
        initialContext: Context,
        duplicateDestinationStrategy: NavigationStrategy.DuplicateDestination = NavigationStrategy.DuplicateDestination.ALLOW_DUPLICATES,
        destinationRetentionStrategy: NavigationStrategy.DestinationRetention = NavigationStrategy.DestinationRetention.RETAIN
    ) {
        this.initialContext = initialContext
        this.duplicateDestinationStrategy = duplicateDestinationStrategy
        this.destinationRetentionStrategy = destinationRetentionStrategy
        this.mutableStore = mutableNavigationStateStoreOf(initialContext = initialContext)
        this.navigationStacks = NavigationContextStacks(initialContext = initialContext)
        this.contextEventStack = mutableStackOf(NavigationEvent.Forward.Context(context = initialContext))
    }

    internal constructor(snapshot: NavigatorSnapshot<Destination, Context>) {
        this.initialContext = snapshot.initialContext
        this.duplicateDestinationStrategy = snapshot.duplicateDestinationStrategy
        this.destinationRetentionStrategy = snapshot.destinationRetentionStrategy
        this.mutableStore = snapshot.stateStore.toMutableNavigationStateStore()
        this.navigationStacks = snapshot.contextStacks
        this.contextEventStack = snapshot.contextEventStack
    }

    private val initialContext: Context
    private val duplicateDestinationStrategy: NavigationStrategy.DuplicateDestination
    private val destinationRetentionStrategy: NavigationStrategy.DestinationRetention

    private val mutableStore: MutableNavigationStateStore<Destination, Context>

    private val navigationStacks: NavigationContextStacks<Destination, Context>

    private val contextEventStack: MutableStack<NavigationEvent.Forward.Context<Destination, Context>>

    override val store: NavigationStateStore<Destination, Context>
        get() = mutableStore

    override fun dispatch(event: NavigationEvent<Destination, Context>): Boolean =
        when (event) {
            is NavigationEvent.Backward -> handleBack(event = event)

            is NavigationEvent.Forward.Destination -> handleDestination(event = event)

            is NavigationEvent.Forward.Context -> handleContext(event = event)
        }

    override fun canPopContext(): Boolean =
        contextEventStack.size > 1 // There must always be at least one item (the initial item) in the stack.

    override fun canPopDestination(): Boolean =
        navigationStacks.get(context = store.context.current).size > 1 // There must always be at least one item (the initial item) in the stack.

    override fun reset() {
        // Reset the store
        mutableStore.reset()

        // Clear the stack values
        navigationStacks.clearAll()
        contextEventStack.clear()

        // Reset the stack values
        // The NavigationStacks component already handles that internally.
        contextEventStack.push(NavigationEvent.Forward.Context(context = initialContext))
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is NavigatorImpl<*, *>) return false

        if (initialContext != other.initialContext) return false
        if (duplicateDestinationStrategy != other.duplicateDestinationStrategy) return false
        if (destinationRetentionStrategy != other.destinationRetentionStrategy) return false
        if (mutableStore != other.mutableStore) return false
        if (navigationStacks != other.navigationStacks) return false
        if (contextEventStack != other.contextEventStack) return false

        return store == other.store
    }

    override fun hashCode(): Int {
        var result = initialContext.hashCode()
        result = 31 * result + duplicateDestinationStrategy.hashCode()
        result = 31 * result + destinationRetentionStrategy.hashCode()
        result = 31 * result + mutableStore.hashCode()
        result = 31 * result + navigationStacks.hashCode()
        result = 31 * result + contextEventStack.hashCode()
        result = 31 * result + store.hashCode()
        return result
    }

    override fun toString(): String =
        "NavigatorImpl(" +
                "initialContext=$initialContext, " +
                "duplicateDestinationStrategy=$duplicateDestinationStrategy, " +
                "destinationRetentionStrategy=$destinationRetentionStrategy, " +
                "contextEventStack=$contextEventStack, " +
                "store=$store)"

    /**
     * Creates a [NavigatorSnapshot] from the current state of this [Navigator] instance. This can be used to later
     * create a [Navigator] instance with the same values.
     */
    fun snapshot(): NavigatorSnapshot<Destination, Context> =
        NavigatorSnapshot(
            initialContext = this.initialContext,
            duplicateDestinationStrategy = this.duplicateDestinationStrategy,
            destinationRetentionStrategy = this.destinationRetentionStrategy,
            stateStore = this.mutableStore,
            contextStacks = this.navigationStacks,
            contextEventStack = this.contextEventStack
        )

    /**
     * Performs the destination change operation for the provided [NavigationEvent.Forward.Destination] event.
     */
    private fun handleDestination(event: NavigationEvent.Forward.Destination<Destination, Context>): Boolean {
        val context = store.context.current

        if (duplicateDestinationStrategy == NavigationStrategy.DuplicateDestination.ALLOW_DUPLICATES) {
            navigationStacks.push(context = context, destination = event.destination)
        } else {
            navigationStacks.pushDropping(context = context, destination = event.destination)
        }

        mutableStore.update(
            event = event,
            destination = event.destination
        )

        return true
    }

    /**
     * Performs the context change operation for the provided [NavigationEvent.Forward.Context] event.
     */
    private fun handleContext(event: NavigationEvent.Forward.Context<Destination, Context>): Boolean {
        contextEventStack.push(event)

        if (destinationRetentionStrategy == NavigationStrategy.DestinationRetention.CLEAR) {
            navigationStacks.clear(context = event.context)
        }

        mutableStore.update(
            event = event,
            context = event.context,
            destination = navigationStacks.peek(context = event.context)
        )

        return true
    }

    /**
     * Performs the back operation for the provided [NavigationEvent.Backward] event.
     */
    private fun handleBack(event: NavigationEvent.Backward<Destination, Context>): Boolean {
        when (event) {
            is NavigationEvent.Backward.Context -> {
                if (!canPopContext()) return false

                contextEventStack.pop()

                // Get the current context after we popped the last context change from the top of the stack.
                val newCurrentContextEvent = contextEventStack.peek()
                val newDestination = navigationStacks.get(context = newCurrentContextEvent.context).peek()

                mutableStore.update(
                    event = event,
                    context = newCurrentContextEvent.context,
                    destination = newDestination
                )

                return true
            }

            is NavigationEvent.Backward.Destination -> {
                if (!canPopDestination()) return false

                val context = store.context.current
                val destination = navigationStacks.popToPreviousDestinationForContext(context = context) ?: return false

                mutableStore.update(
                    event = event,
                    context = context,
                    destination = destination
                )

                return true
            }
        }
    }
}

/**
 * A [KSerializer] for the [Navigator] component.
 */
@ExperimentalNavigationApi
internal class NavigatorSerializer<Destination : NavigationDestination, Context : NavigationContext<Destination>> internal constructor(
    destinationSerializer: KSerializer<Destination>,
    private val contextSerializer: KSerializer<Context>
) : KSerializer<Navigator<Destination, Context>> {

    private val stateStoreSerializer = NavigationStateStore.serializer(destinationSerializer, contextSerializer)
    private val contextStacksSerializer = NavigationContextStacks.serializer(destinationSerializer, contextSerializer)
    private val contextEventStackSerializer =
        StackSerializer(NavigationEvent.Forward.Context.serializer(destinationSerializer, contextSerializer))

    override val descriptor: SerialDescriptor = buildClassSerialDescriptor("Navigator") {
        element(elementName = "initial_context", descriptor = contextSerializer.descriptor)
        element<NavigationStrategy.DuplicateDestination>(elementName = "duplication_destination_strategy")
        element<NavigationStrategy.DestinationRetention>(elementName = "destination_retention_strategy")
        element(elementName = "state_store", descriptor = stateStoreSerializer.descriptor)
        element(elementName = "context_stacks", descriptor = contextStacksSerializer.descriptor)
        element(elementName = "context_event_stack", descriptor = contextStacksSerializer.descriptor)
    }

    override fun serialize(encoder: Encoder, value: Navigator<Destination, Context>) {
        require(value is NavigatorImpl) { "Only NavigatorImpl is supported for serialization." }

        val snapshot = value.snapshot()

        val compositeEncoder = encoder.beginStructure(descriptor)
        compositeEncoder.encodeSerializableElement(
            descriptor = descriptor,
            index = 0,
            serializer = contextSerializer,
            value = snapshot.initialContext
        )
        compositeEncoder.encodeSerializableElement(
            descriptor = descriptor,
            index = 1,
            serializer = NavigationStrategy.DuplicateDestination.serializer(),
            value = snapshot.duplicateDestinationStrategy
        )
        compositeEncoder.encodeSerializableElement(
            descriptor = descriptor,
            index = 2,
            serializer = NavigationStrategy.DestinationRetention.serializer(),
            value = snapshot.destinationRetentionStrategy
        )
        compositeEncoder.encodeSerializableElement(
            descriptor = descriptor,
            index = 3,
            serializer = stateStoreSerializer,
            value = snapshot.stateStore
        )
        compositeEncoder.encodeSerializableElement(
            descriptor = descriptor,
            index = 4,
            serializer = contextStacksSerializer,
            value = snapshot.contextStacks
        )
        compositeEncoder.encodeSerializableElement(
            descriptor = descriptor,
            index = 5,
            serializer = contextEventStackSerializer,
            value = snapshot.contextEventStack
        )
        compositeEncoder.endStructure(descriptor)
    }

    override fun deserialize(decoder: Decoder): Navigator<Destination, Context> {
        val compositeDecoder = decoder.beginStructure(descriptor)
        val initialContext = compositeDecoder.decodeSerializableElement(
            descriptor = descriptor,
            index = 0,
            deserializer = contextSerializer
        )
        val duplicateDestinationStrategy = compositeDecoder.decodeSerializableElement(
            descriptor = descriptor,
            index = 1,
            deserializer = NavigationStrategy.DuplicateDestination.serializer()
        )
        val destinationRetentionStrategy = compositeDecoder.decodeSerializableElement(
            descriptor = descriptor,
            index = 2,
            deserializer = NavigationStrategy.DestinationRetention.serializer()
        )
        val stateStore = compositeDecoder.decodeSerializableElement(
            descriptor = descriptor,
            index = 3,
            deserializer = stateStoreSerializer
        )
        val contextStacks = compositeDecoder.decodeSerializableElement(
            descriptor = descriptor,
            index = 4,
            deserializer = contextStacksSerializer
        )
        val contextEventStack = compositeDecoder.decodeSerializableElement(
            descriptor = descriptor,
            index = 5,
            deserializer = contextEventStackSerializer
        )
        compositeDecoder.endStructure(descriptor)

        val snapshot = NavigatorSnapshot(
            initialContext = initialContext,
            duplicateDestinationStrategy = duplicateDestinationStrategy,
            destinationRetentionStrategy = destinationRetentionStrategy,
            stateStore = stateStore,
            contextStacks = contextStacks,
            contextEventStack = contextEventStack.toMutableStack()
        )

        return NavigatorImpl(snapshot = snapshot)
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is NavigatorSerializer<*, *>) return false

        if (contextSerializer != other.contextSerializer) return false
        if (descriptor != other.descriptor) return false
        if (stateStoreSerializer != other.stateStoreSerializer) return false
        if (contextStacksSerializer != other.contextStacksSerializer) return false

        return contextEventStackSerializer == other.contextEventStackSerializer
    }

    override fun hashCode(): Int {
        var result = contextSerializer.hashCode()
        result = 31 * result + descriptor.hashCode()
        result = 31 * result + stateStoreSerializer.hashCode()
        result = 31 * result + contextStacksSerializer.hashCode()
        result = 31 * result + contextEventStackSerializer.hashCode()
        return result
    }

    override fun toString(): String =
        "NavigatorSerializer(" +
                "contextSerializer=$contextSerializer, " +
                "descriptor=$descriptor, " +
                "stateStoreSerializer=$stateStoreSerializer, " +
                "contextStacksSerializer=$contextStacksSerializer, " +
                "contextEventStackSerializer=$contextEventStackSerializer)"
}
