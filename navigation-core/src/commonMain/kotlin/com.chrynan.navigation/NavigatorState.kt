package com.chrynan.navigation

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.map

/**
 * Represents the state of a [Navigator], including providing the currently displayed [NavigationDestination] and
 * [NavigationContext] values.
 */
interface NavigatorState<Destination : NavigationDestination, Context : NavigationContext<Destination>> :
    NavigationDestinationState<Destination>,
    NavigationContextState<Destination, Context> {

    /**
     * Determines whether this component is currently initialized, typically meaning that it is ready for use.
     */
    val isInitialized: Boolean

    companion object
}

abstract class BaseNavigatorStateImpl<Destination : NavigationDestination, Context : NavigationContext<Destination>>(
    final override val initialContext: Context
) : NavigatorState<Destination, Context> {

    final override var isInitialized: Boolean = false

    final override val currentContext: Context
        get() = mutableStateFlow.value.context

    final override val contextChanges: Flow<Context>
        get() = mutableStateFlow.asStateFlow()
            .map { it.context }

    final override val initialDestination: Destination = initialContext.initialDestination

    final override val currentDestination: Destination
        get() = mutableStateFlow.value.destination

    final override val destinationChanges: Flow<Destination>
        get() = mutableStateFlow.asStateFlow()
            .map { it.destination }

    private val mutableStateFlow = MutableStateFlow(Event(context = initialContext, destination = initialDestination))

    fun change(
        destination: Destination = currentDestination,
        context: Context = currentContext
    ) {
        mutableStateFlow.value = Event(destination = destination, context = context)
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || this::class != other::class) return false

        other as BaseNavigatorStateImpl<*, *>

        if (initialContext != other.initialContext) return false
        if (isInitialized != other.isInitialized) return false
        if (currentContext != other.currentContext) return false
        if (initialDestination != other.initialDestination) return false
        if (currentDestination != other.currentDestination) return false

        return true
    }

    override fun hashCode(): Int {
        var result = initialContext.hashCode()

        result = 31 * result + isInitialized.hashCode()
        result = 31 * result + currentContext.hashCode()
        result = 31 * result + initialDestination.hashCode()
        result = 31 * result + currentDestination.hashCode()

        return result
    }

    override fun toString(): String {
        return "NavigatorStateImpl(" +
                "initialContext=$initialContext, " +
                "isInitialized=$isInitialized, " +
                "currentContext=$currentContext, " +
                "initialDestination=$initialDestination, " +
                "currentDestination=$currentDestination)"
    }

    private data class Event<Destination : NavigationDestination, Context : NavigationContext<Destination>>(
        val context: Context,
        val destination: Destination
    )
}

internal class NavigatorStateImpl<Destination : NavigationDestination, Context : NavigationContext<Destination>>(
    initialContext: Context
) : BaseNavigatorStateImpl<Destination, Context>(initialContext = initialContext)
