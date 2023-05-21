@file:Suppress("unused")

package com.chrynan.navigation

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * A component that encapsulates the various navigation policies for a [Navigator].
 */
sealed interface NavigationStrategy {

    /**
     * Represents the approach to take when adding a [NavigationDestination] to a navigation [Stack] and there already
     * exists the same item in the [Stack].
     */
    @Serializable
    enum class DuplicateDestination(val serialName: String) {

        /**
         * When a duplicate [NavigationDestination] is added to a navigation [Stack], all the items on top of the existing
         * duplicate item in the stack are cleared off. For instance, consider the following stack of items (the first item
         * being the bottom of the stack and the last item being the top of the stack): `[A, B, C, D]`. If we were to add a
         * value of `A` to the top of the stack, it would be considered a duplicate since `A` already exists as the first
         * item in the stack. Adding the value of `A` to this stack using a [CLEAR_TO_ORIGINAL] strategy would result in
         * the stack looking as follows: `[A]`. All the items are popped off the stack (or "cleared") until the original
         * item. This has the result of navigating to the item still, but altering the stack so that the item is back on
         * top.
         */
        @SerialName(value = "clear_to_original")
        CLEAR_TO_ORIGINAL(serialName = "clear_to_original"),

        /**
         * When a duplicate [NavigationDestination] is added to a navigation [Stack], the duplicate item is added on top of
         * the stack. For instance, consider the following stack of items (the first item being the bottom of the stack and
         * the last item being the top of the stack): `[A, B, C, D]`. If we were to add a value of `A` to the top of the
         * stack, it would be considered a duplicate since `A` already exists as the first item in the stack. Adding the
         * value of `A` to this stack using an [ALLOW_DUPLICATES] strategy would result in the stack looking as follows:
         * `[A, B, C, D, A]`. This has the result of navigating to the item still, allowing duplicates, and without
         * altering the rest of the stack.
         */
        @SerialName(value = "allow_duplicates")
        ALLOW_DUPLICATES(serialName = "allow_duplicates");

        companion object
    }

    /**
     * Represents the type of supported back navigation. An [IN_CONTEXT] value indicates that navigation to the
     * previous [NavigationDestination] in the current [NavigationContext] should occur. An [ACROSS_CONTEXTS] value
     * indicates that navigation across [NavigationContext]s is allowed, meaning that navigation can either be to
     * the previous [NavigationDestination] within the current [NavigationContext] or to the previous
     * [NavigationContext] depending on whether the previous [NavigationEvent] was a
     * [NavigationEvent.Forward.Destination] or [NavigationEvent.Forward.Context] event.
     */
    @Serializable
    enum class BackwardsNavigation(val serialName: String) {

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

    /**
     * Represents the approach for retaining the [NavigationDestination] data structures associated with a particular
     * [NavigationContext], when navigating to other [NavigationContext]s. A [RETAIN] value indicates that the
     * [NavigationDestination] data structure associated with a [NavigationContext] should be kept when navigation to a
     * different [NavigationContext], so that the state can be restored when navigating back. A [CLEAR] value indicates
     * that the [NavigationDestination] data structure associated with a [NavigationContext] should be cleared before
     * navigating to a different [NavigationContext], so that the [NavigationContext.initialDestination] value will be
     * displayed when navigating back.
     */
    @Serializable
    enum class DestinationRetention(val serialName: String) {

        @SerialName(value = "retain")
        RETAIN(serialName = "retain"),

        @SerialName(value = "clear")
        CLEAR(serialName = "clear")
    }
}
