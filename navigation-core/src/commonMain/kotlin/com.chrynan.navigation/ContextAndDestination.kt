@file:Suppress("unused")

package com.chrynan.navigation

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * A wrapper class around a [NavigationContext] and an associated [NavigationDestination].
 */
@Serializable
class ContextAndDestination<Context : NavigationContext<Destination>, Destination : NavigationDestination>(
    @SerialName(value = "context") val context: Context,
    @SerialName(value = "destination") val destination: Destination
) {

    /**
     * Creates a copy of this [ContextAndDestination] instance, overriding the provided values.
     */
    fun copy(
        context: Context = this.context,
        destination: Destination = this.destination
    ): ContextAndDestination<Context, Destination> = ContextAndDestination(
        context = context,
        destination = destination
    )

    operator fun component1(): Context = context

    operator fun component2(): Destination = destination

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is ContextAndDestination<*, *>) return false

        if (context != other.context) return false

        return destination == other.destination
    }

    override fun hashCode(): Int {
        var result = context.hashCode()
        result = 31 * result + destination.hashCode()
        return result
    }

    override fun toString(): String =
        "ContextAndDestination(context=$context, destination=$destination)"
}
