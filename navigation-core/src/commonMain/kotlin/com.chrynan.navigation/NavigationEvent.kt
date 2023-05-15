@file:Suppress("unused")

package com.chrynan.navigation

import kotlinx.datetime.Clock
import kotlinx.datetime.Instant
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Represents a navigation event that is sent to a [Navigator] to coordinate the navigation between UI components, such
 * as "screens" within an application. A [NavigationEvent] can be a [NavigationEvent.Forward.Destination] representing
 * a change in a [NavigationDestination] in the current context, a [NavigationEvent.Forward.Context] representing a
 * change in [NavigationContext], or a [NavigationEvent.Backward] representing a back tracking of a previous
 * [NavigationEvent].
 *
 * @see [Navigator.navigate]
 */
@Serializable
sealed class NavigationEvent<D : NavigationDestination, C : NavigationContext<D>> private constructor() {

    /**
     * The [Instant] that the event occurred.
     */
    abstract val instant: Instant

    /**
     * The navigation direction for this event.
     */
    abstract val direction: Direction

    /**
     * Represents a direction for a [NavigationEvent]. A [NavigationEvent] can either be a [FORWARDS] direction event,
     * meaning the change is added to a [Stack], or a [BACKWARDS] direction event, meaning the change causes a removal
     * from a [Stack].
     */
    @Serializable
    enum class Direction(val serialName: String) {

        /**
         * The associated [NavigationEvent] causes a removal of a previous event change from a [Stack].
         */
        @SerialName(value = "backwards")
        BACKWARDS(serialName = "backwards"),

        /**
         * The associated [NavigationEvent] causes an addition of the change to a [Stack].
         */
        @SerialName(value = "forwards")
        FORWARDS(serialName = "forwards")
    }

    /**
     * A [NavigationEvent] that represents a reversal of a previous navigation event. A [Backward] navigation event can be
     * used to go to the previous [NavigationDestination] within the current [NavigationContext], or going back to a
     * previous [NavigationContext] before a change in context. The type of back navigation that is supported is
     * defined by the provided [kind] property.
     *
     * @property [instant] The [Instant] that the event occurred.
     * @property [kind] The [Kind] of supported back navigation (across contexts or just destinations within the
     * current context).
     */
    @Serializable
    @SerialName(value = "back")
    class Backward<D : NavigationDestination, C : NavigationContext<D>> internal constructor(
        @SerialName(value = "instant") override val instant: Instant = Clock.System.now(),
        @SerialName(value = "kind") val kind: Kind
    ) : NavigationEvent<D, C>() {

        override val direction: Direction = Direction.BACKWARDS

        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (other !is Backward<*, *>) return false

            if (instant != other.instant) return false

            return kind == other.kind
        }

        override fun hashCode(): Int {
            var result = instant.hashCode()
            result = 31 * result + kind.hashCode()
            return result
        }

        override fun toString(): String =
            "NavigationEvent.Backward(instant=$instant, type=$kind, direction=$direction)"

        /**
         * Represents the type of supported back navigation. An [IN_CONTEXT] value indicates that navigation to the
         * previous [NavigationDestination] in the current [NavigationContext] should occur. An [ACROSS_CONTEXTS] value
         * indicates that navigation across [NavigationContext]s is allowed, meaning that navigation can either be to
         * the previous [NavigationDestination] within the current [NavigationContext] or to the previous
         * [NavigationContext] depending on whether the previous [NavigationEvent] was a
         * [NavigationEvent.Forward.Destination] or [NavigationEvent.Forward.Context] event.
         */
        @Serializable
        enum class Kind(val serialName: String) {

            /**
             * Indicates that navigation to the previous [NavigationDestination] in the current [NavigationContext]
             * should occur
             */
            @SerialName(value = "in_context")
            IN_CONTEXT(serialName = "in_context"),

            /**
             * Indicates that navigation across [NavigationContext]s is allowed, meaning that navigation can either be
             * to the previous [NavigationDestination] within the current [NavigationContext] or to the previous
             * [NavigationContext] depending on whether the previous [NavigationEvent] was a
             * [NavigationEvent.Forward.Destination] or [NavigationEvent.Forward.Context] event
             */
            @SerialName(value = "across_context")
            ACROSS_CONTEXTS(serialName = "across_context")
        }
    }

    /**
     * A [NavigationEvent] that represents a forward movement, or addition of a navigation change. These events can be
     * reversed by a [Backward] event. There are two forward navigation events: [Destination] representing a change in
     * destination on the current context stack, and [Context] representing a change in the context.
     */
    @Serializable
    @SerialName(value = "forward")
    sealed class Forward<D : NavigationDestination, C : NavigationContext<D>> private constructor() :
        NavigationEvent<D, C>() {

        override val direction: Direction = Direction.FORWARDS

        /**
         * A [NavigationEvent] that changes the [NavigationDestination] within the current [NavigationContext].
         *
         * @property [instant] The [Instant] that the event occurred.
         * @property [destination] The [NavigationDestination] to go to. This value will be added to the top of the [Stack]
         * of destinations within the current [NavigationContext].
         */
        @Serializable
        @SerialName(value = "destination")
        class Destination<D : NavigationDestination, C : NavigationContext<D>> internal constructor(
            @SerialName(value = "instant") override val instant: Instant = Clock.System.now(),
            @SerialName(value = "destination") val destination: D
        ) : Forward<D, C>() {

            override fun equals(other: Any?): Boolean {
                if (this === other) return true
                if (other !is Destination<*, *>) return false

                if (instant != other.instant) return false

                return destination == other.destination
            }

            override fun hashCode(): Int {
                var result = instant.hashCode()
                result = 31 * result + destination.hashCode()
                return result
            }

            override fun toString(): String =
                "NavigationEvent.Forward.Destination(instant=$instant, destination=$destination, direction=$direction)"
        }

        /**
         * A [NavigationEvent] that changes the current [NavigationContext].
         *
         * @property [instant] The [Instant] that the event occurred.
         * @property [context] The [NavigationContext] to go to.
         */
        @Serializable
        @SerialName(value = "context")
        class Context<D : NavigationDestination, C : NavigationContext<D>> internal constructor(
            @SerialName(value = "instant") override val instant: Instant = Clock.System.now(),
            @SerialName(value = "context") val context: C
        ) : Forward<D, C>() {

            override fun equals(other: Any?): Boolean {
                if (this === other) return true
                if (other !is Context<*, *>) return false

                if (instant != other.instant) return false

                return context == other.context
            }

            override fun hashCode(): Int {
                var result = instant.hashCode()
                result = 31 * result + context.hashCode()
                return result
            }

            override fun toString(): String =
                "NavigationEvent.Forward.Context(instant=$instant, context=$context, direction=$direction)"
        }
    }

    companion object
}
