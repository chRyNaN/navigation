@file:Suppress("unused")

package com.chrynan.navigation.compose

import com.chrynan.navigation.*

@ExperimentalNavigationApi
interface ComposeNavigationDestinationState<Destination : NavigationDestination> :
    NavigationDestinationState<Destination> {

    companion object
}

@ExperimentalNavigationApi
interface ComposeNavigationContextState<Destination : NavigationDestination, Context : NavigationContext<Destination>> :
    NavigationContextState<Destination, Context> {

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
    initialContext: Context
) : BaseNavigatorStateImpl<Destination, Context>(initialContext = initialContext),
    ComposeNavigatorState<Destination, Context> {

    companion object
}
