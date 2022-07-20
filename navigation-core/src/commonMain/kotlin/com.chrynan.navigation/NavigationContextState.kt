package com.chrynan.navigation

import kotlinx.coroutines.flow.Flow

interface NavigationContextState<Destination : NavigationDestination, Context : NavigationContext<Destination>> {

    val initialContext: Context

    val currentContext: Context

    val contextChanges: Flow<Context>

    companion object
}
