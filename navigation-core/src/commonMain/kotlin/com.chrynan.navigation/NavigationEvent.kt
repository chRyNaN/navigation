@file:Suppress("unused")

package com.chrynan.navigation

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Represents a navigation event that is sent to a [Navigator] to coordinate the navigation between UI components, such
 * as "screens" within an application. A [NavigationEvent] can be a [NavigationEvent.Forward.Destination] representing
 * a change in a [NavigationDestination] in the current context, a [NavigationEvent.Forward.Context] representing a
 * change in [NavigationContext], or a [NavigationEvent.Backward] representing a back tracking of a previous
 * [NavigationEvent].
 *
 * @see [Navigator.dispatch]
 */
@Serializable
sealed class NavigationEvent<D : NavigationDestination, C : NavigationContext<D>> private constructor() {

    /**
     * The amount of milliseconds that have elapsed on the system when the event occurred.
     *
     * **Note:** This is not safe to persist or use between system reboots.
     */
    abstract val elapsedMilliseconds: Long

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
     * previous [NavigationContext] before a change in context.
     *
     * @property [elapsedMilliseconds] The amount of milliseconds that have elapsed on the system when the event
     * occurred. **Note:** This is not safe to persist or use between system reboots.
     */
    @Serializable
    @SerialName(value = "back")
    class Backward<D : NavigationDestination, C : NavigationContext<D>> internal constructor(
        @SerialName(value = "instant") override val elapsedMilliseconds: Long = elapsedSystemTime().inWholeMilliseconds
    ) : NavigationEvent<D, C>() {

        override val direction: Direction = Direction.BACKWARDS

        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (other !is Backward<*, *>) return false

            return elapsedMilliseconds == other.elapsedMilliseconds
        }

        override fun hashCode(): Int =
            elapsedMilliseconds.hashCode()

        override fun toString(): String =
            "NavigationEvent.Backward(elapsedMilliseconds=$elapsedMilliseconds, direction=$direction)"
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
         * @property [elapsedMilliseconds] The amount of milliseconds that have elapsed on the system when the event
         * occurred. **Note:** This is not safe to persist or use between system reboots.
         * @property [destination] The [NavigationDestination] to go to. This value will be added to the top of the [Stack]
         * of destinations within the current [NavigationContext].
         */
        @Serializable
        @SerialName(value = "destination")
        class Destination<D : NavigationDestination, C : NavigationContext<D>> internal constructor(
            @SerialName(value = "instant") override val elapsedMilliseconds: Long = elapsedSystemTime().inWholeMilliseconds,
            @SerialName(value = "destination") val destination: D
        ) : Forward<D, C>() {

            override fun equals(other: Any?): Boolean {
                if (this === other) return true
                if (other !is Destination<*, *>) return false

                if (elapsedMilliseconds != other.elapsedMilliseconds) return false

                return destination == other.destination
            }

            override fun hashCode(): Int {
                var result = elapsedMilliseconds.hashCode()
                result = 31 * result + destination.hashCode()
                return result
            }

            override fun toString(): String =
                "NavigationEvent.Forward.Destination(elapsedMilliseconds=$elapsedMilliseconds, destination=$destination, direction=$direction)"
        }

        /**
         * A [NavigationEvent] that changes the current [NavigationContext].
         *
         * @property [elapsedMilliseconds] The amount of milliseconds that have elapsed on the system when the event
         * occurred. **Note:** This is not safe to persist or use between system reboots.
         * @property [context] The [NavigationContext] to go to.
         */
        @Serializable
        @SerialName(value = "context")
        class Context<D : NavigationDestination, C : NavigationContext<D>> internal constructor(
            @SerialName(value = "instant") override val elapsedMilliseconds: Long = elapsedSystemTime().inWholeMilliseconds,
            @SerialName(value = "context") val context: C
        ) : Forward<D, C>() {

            override fun equals(other: Any?): Boolean {
                if (this === other) return true
                if (other !is Context<*, *>) return false

                if (elapsedMilliseconds != other.elapsedMilliseconds) return false

                return context == other.context
            }

            override fun hashCode(): Int {
                var result = elapsedMilliseconds.hashCode()
                result = 31 * result + context.hashCode()
                return result
            }

            override fun toString(): String =
                "NavigationEvent.Forward.Context(elapsedMilliseconds=$elapsedMilliseconds, context=$context, direction=$direction)"
        }
    }

    companion object
}
