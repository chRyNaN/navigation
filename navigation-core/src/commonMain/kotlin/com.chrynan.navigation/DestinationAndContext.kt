@file:Suppress("unused")

package com.chrynan.navigation

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * A wrapper class around a [NavigationDestination] and an associated [NavigationContext].
 */
@Serializable
class DestinationAndContext<Destination : NavigationDestination, Context : NavigationContext<Destination>>(
    @SerialName(value = "destination") val destination: Destination,
    @SerialName(value = "context") val context: Context
) {

    /**
     * Creates a copy of this [DestinationAndContext] instance, overriding the provided values.
     */
    fun copy(
        destination: Destination = this.destination,
        context: Context = this.context
    ): DestinationAndContext<Destination, Context> = DestinationAndContext(
        destination = destination,
        context = context
    )

    operator fun component1(): Destination = destination

    operator fun component2(): Context = context

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is DestinationAndContext<*, *>) return false

        if (context != other.context) return false

        return destination == other.destination
    }

    override fun hashCode(): Int {
        var result = context.hashCode()
        result = 31 * result + destination.hashCode()
        return result
    }

    override fun toString(): String =
        "DestinationAndContext(destination=$destination, context=$context)"
}
