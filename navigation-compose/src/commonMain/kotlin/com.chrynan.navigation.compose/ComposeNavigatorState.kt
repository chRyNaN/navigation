@file:Suppress("unused")

package com.chrynan.navigation.compose

import com.chrynan.navigation.*

@ExperimentalNavigationApi
interface ComposeNavigationDestinationState<Destination : NavigationDestination> :
    NavigationDestinationState<Destination> {

    val destinationSaver: Saver<Destination, Any>

    companion object
}

@ExperimentalNavigationApi
interface ComposeNavigationContextState<Destination : NavigationDestination, Context : NavigationContext<Destination>> :
    NavigationContextState<Destination, Context> {

    val contextSaver: Saver<Context, Any>

    companion object
}

@ExperimentalNavigationApi
interface ComposeNavigatorState<Destination : NavigationDestination, Context : NavigationContext<Destination>> :
    ComposeNavigationDestinationState<Destination>,
    ComposeNavigationContextState<Destination, Context> {

    companion object
}

@ExperimentalNavigationApi
internal class ComposeNavigatorStateImpl<Destination : NavigationDestination, Context : NavigationContext<Destination>>(
    initialContext: Context,
    override val destinationSaver: Saver<Destination, Any>,
    override val contextSaver: Saver<Context, Any>
) : BaseNavigatorStateImpl<Destination, Context>(initialContext = initialContext),
    ComposeNavigatorState<Destination, Context> {

    companion object
}
