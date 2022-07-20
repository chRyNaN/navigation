@file:Suppress("unused")

package com.chrynan.navigation.compose

import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import com.chrynan.navigation.*

/**
 * Obtains the changes to the [ComposeNavigationDestinationState.currentDestination] value and returns it as a [State]. This allows it to be
 * used in a [Composable] and cause recomposition when the value changes.
 *
 * If you just need to get the current key value and do not need to cause recomposition when the value changes, simply
 * use the [ComposeNavigationDestinationState.currentDestination] property.
 *
 * **Note:** Internally this function uses the [ComposeNavigationDestinationState.destinationChanges] Flow and the [collectAsState] function
 * using the [ComposeNavigationDestinationState.currentDestination] as the initial value.
 *
 * @see [ComposeNavigationDestinationState.currentDestination]
 * @see [ComposeNavigationDestinationState.destinationChanges]
 * @see [collectAsState]
 */
@ExperimentalNavigationApi
@Composable
fun <Destination : NavigationDestination> NavigationDestinationState<Destination>.currentDestinationAsState(
    initialCurrentKey: Destination
): State<Destination> = destinationChanges.collectAsState(initial = initialCurrentKey)

/**
 * Obtains the changes to the [ComposeNavigationDestinationState.currentDestination] value and returns it as a [State]. This allows it to be
 * used in a [Composable] and cause recomposition when the value changes.
 *
 * If you just need to get the current key value and do not need to cause recomposition when the value changes, simply
 * use the [ComposeNavigationDestinationState.currentDestination] property.
 *
 * **Note:** Internally this function uses the [ComposeNavigationDestinationState.destinationChanges] Flow and the [collectAsState] function
 * using the [ComposeNavigationDestinationState.currentDestination] as the initial value.
 *
 * @see [ComposeNavigationDestinationState.currentDestination]
 * @see [ComposeNavigationDestinationState.destinationChanges]
 * @see [collectAsState]
 */
// **Note:** For some reason adding a default value to the `initialCurrentKey` parameter in the [currentKeyAsState]
// function is causing an issue so this function is needed for the default case.
@ExperimentalNavigationApi
@Composable
fun <Destination : NavigationDestination> NavigationDestinationState<Destination>.currentDestinationAsState(): State<Destination> =
    destinationChanges.collectAsState(initial = currentDestination)

/**
 * Obtains the changes to the [ComposeNavigationContextState.currentContext] value and returns it as a [State]. This allows it
 * to be used in a [Composable] and cause recomposition when the value changes.
 *
 * If you just need to get the current scope value and do not need to cause recomposition when the value changes, simply
 * use the [ComposeNavigationContextState.currentContext] property.
 *
 * **Note:** Internally this function uses the [ComposeNavigationContextState.contextChanges] Flow and the [collectAsState]
 * function using the [ComposeNavigationContextState.currentContext] as the initial value.
 *
 * @see [ComposeNavigationContextState.currentContext]
 * @see [ComposeNavigationContextState.contextChanges]
 * @see [collectAsState]
 */
@ExperimentalNavigationApi
@Composable
fun <Destination : NavigationDestination, Context : NavigationContext<Destination>> NavigationContextState<Destination, Context>.currentContextAsState(
    initialCurrentContext: Context
): State<Context> = contextChanges.collectAsState(initial = initialCurrentContext)

/**
 * Obtains the changes to the [ComposeNavigationContextState.currentContext] value and returns it as a [State]. This allows it
 * to be used in a [Composable] and cause recomposition when the value changes.
 *
 * If you just need to get the current scope value and do not need to cause recomposition when the value changes, simply
 * use the [ComposeNavigationContextState.currentContext] property.
 *
 * **Note:** Internally this function uses the [ComposeNavigationContextState.contextChanges] Flow and the [collectAsState]
 * function using the [ComposeNavigationContextState.currentContext] as the initial value.
 *
 * @see [ComposeNavigationContextState.currentContext]
 * @see [ComposeNavigationContextState.contextChanges]
 * @see [collectAsState]
 */
// **Note:** For some reason adding a default value to the `initialCurrentScope` parameter in the [currentScopeAsState]
// function is causing an issue so this function is needed for the default case.
@ExperimentalNavigationApi
@Composable
fun <Destination : NavigationDestination, Context : NavigationContext<Destination>> NavigationContextState<Destination, Context>.currentContextAsState(): State<Context> =
    contextChanges.collectAsState(initial = currentContext)
