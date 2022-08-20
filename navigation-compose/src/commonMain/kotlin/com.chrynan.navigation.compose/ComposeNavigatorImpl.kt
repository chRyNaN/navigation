package com.chrynan.navigation.compose

import com.chrynan.navigation.*

@ExperimentalNavigationApi
internal class ComposeNavigatorImpl<Destination : NavigationDestination, Context : NavigationContext<Destination>>(
    initialContext: Context
) : BaseNavigatorImpl<Destination, Context, ComposeNavigatorStateImpl<Destination, Context>>(
    state = ComposeNavigatorStateImpl(initialContext = initialContext)
)
