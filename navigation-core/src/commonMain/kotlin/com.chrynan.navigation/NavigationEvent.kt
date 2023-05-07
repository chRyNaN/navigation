@file:Suppress("unused")

package com.chrynan.navigation

import kotlinx.datetime.Clock
import kotlinx.datetime.Instant
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Represents a navigation event that is sent to a [Navigator] to coordinate the navigation between UI components, such
 * as "screens" within an application. A [NavigationEvent] can be a [NavigationEvent.Destination] representing a change
 * in a [NavigationDestination] in the current context, a [NavigationEvent.Context] representing a change in
 * [NavigationContext], or a [NavigationEvent.Back] representing a back tracking of a previous [NavigationEvent].
 *
 * @see [Navigator.navigate]
 */
@Serializable
sealed class NavigationEvent private constructor() {

    /**
     * The [Instant] that the event occurred.
     */
    abstract val instant: Instant

    /**
     * A [NavigationEvent] that represents a reversal of a previous navigation event. A [Back] navigation event can be
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
    class Back internal constructor(
        @SerialName(value = "instant") override val instant: Instant = Clock.System.now(),
        @SerialName(value = "kind") val kind: Kind
    ) : NavigationEvent() {

        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (other !is Back) return false

            if (instant != other.instant) return false

            return kind == other.kind
        }

        override fun hashCode(): Int {
            var result = instant.hashCode()
            result = 31 * result + kind.hashCode()
            return result
        }

        override fun toString(): String =
            "NavigationEvent.Back(instant=$instant, type=$kind)"

        /**
         * Represents the type of supported back navigation. An [IN_CONTEXT] value indicates that navigation to the
         * previous [NavigationDestination] in the current [NavigationContext] should occur. An [ACROSS_CONTEXTS] value
         * indicates that navigation across [NavigationContext]s is allowed, meaning that navigation can either be to
         * the previous [NavigationDestination] within the current [NavigationContext] or to the previous
         * [NavigationContext] depending on whether the previous [NavigationEvent] was a [NavigationEvent.Destination]
         * or [NavigationEvent.Context] event.
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
             * [NavigationEvent.Destination] or [NavigationEvent.Context] event
             */
            @SerialName(value = "across_context")
            ACROSS_CONTEXTS(serialName = "across_context")
        }
    }

    /**
     * A [NavigationEvent] that changes the [NavigationDestination] within the current [NavigationContext].
     *
     * @property [instant] The [Instant] that the event occurred.
     * @property [destination] The [NavigationDestination] to go to. This value will be added to the top of the [Stack]
     * of destinations within the current [NavigationContext].
     */
    @Serializable
    @SerialName(value = "destination")
    class Destination<D : NavigationDestination> internal constructor(
        @SerialName(value = "instant") override val instant: Instant = Clock.System.now(),
        @SerialName(value = "destination") val destination: D
    ) : NavigationEvent() {

        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (other !is Destination<*>) return false

            if (instant != other.instant) return false

            return destination == other.destination
        }

        override fun hashCode(): Int {
            var result = instant.hashCode()
            result = 31 * result + destination.hashCode()
            return result
        }

        override fun toString(): String =
            "NavigationEvent.Destination(instant=$instant, destination=$destination)"
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
    ) : NavigationEvent() {

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
            "NavigationEvent.Context(instant=$instant, context=$context)"
    }

    companion object
}
