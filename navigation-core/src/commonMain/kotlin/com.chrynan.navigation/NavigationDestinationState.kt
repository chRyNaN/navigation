package com.chrynan.navigation

import kotlinx.coroutines.flow.Flow

interface NavigationDestinationState<Destination : NavigationDestination> {

    val initialDestination: Destination

    val currentDestination: Destination

    val destinationChanges: Flow<Destination>

    companion object
}
