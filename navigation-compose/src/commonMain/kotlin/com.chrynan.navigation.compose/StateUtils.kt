@file:Suppress("unused")

package com.chrynan.navigation.compose

import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState

/**
 * Obtains the changes to the [ComposeNavigator.currentKey] value and returns it as a [State]. This allows it to be
 * used in a [Composable] and cause recomposition when the value changes.
 *
 * If you just need to get the current key value and do not need to cause recomposition when the value changes, simply
 * use the [ComposeNavigator.currentKey] property.
 *
 * **Note:** Internally this function uses the [ComposeNavigator.keyChanges] Flow and the [collectAsState] function
 * using the [ComposeNavigator.currentKey] as the initial value.
 *
 * @see [ComposeNavigator.currentKey]
 * @see [ComposeNavigator.keyChanges]
 * @see [collectAsState]
 */
@ExperimentalNavigationApi
@Composable
fun <Key> ComposeNavigator<Key>.currentKeyAsState(initialCurrentKey: Key): State<Key> =
    keyChanges.collectAsState(initial = initialCurrentKey)

/**
 * Obtains the changes to the [ComposeNavigator.currentKey] value and returns it as a [State]. This allows it to be
 * used in a [Composable] and cause recomposition when the value changes.
 *
 * If you just need to get the current key value and do not need to cause recomposition when the value changes, simply
 * use the [ComposeNavigator.currentKey] property.
 *
 * **Note:** Internally this function uses the [ComposeNavigator.keyChanges] Flow and the [collectAsState] function
 * using the [ComposeNavigator.currentKey] as the initial value.
 *
 * @see [ComposeNavigator.currentKey]
 * @see [ComposeNavigator.keyChanges]
 * @see [collectAsState]
 */
// **Note:** For some reason adding a default value to the `initialCurrentKey` parameter in the [currentKeyAsState]
// function is causing an issue so this function is needed for the default case.
@ExperimentalNavigationApi
@Composable
fun <Key> ComposeNavigator<Key>.currentKeyAsState(): State<Key> =
    keyChanges.collectAsState(initial = currentKey)

/**
 * Obtains the changes to the [ComposeContextNavigator.currentContext] value and returns it as a [State]. This allows it
 * to be used in a [Composable] and cause recomposition when the value changes.
 *
 * If you just need to get the current scope value and do not need to cause recomposition when the value changes, simply
 * use the [ComposeContextNavigator.currentContext] property.
 *
 * **Note:** Internally this function uses the [ComposeContextNavigator.contextChanges] Flow and the [collectAsState]
 * function using the [ComposeContextNavigator.currentContext] as the initial value.
 *
 * @see [ComposeContextNavigator.currentContext]
 * @see [ComposeContextNavigator.contextChanges]
 * @see [collectAsState]
 */
@ExperimentalNavigationApi
@Composable
fun <Context, Key> ComposeContextNavigator<Context, Key>.currentContextAsState(initialCurrentScope: Context): State<Context> =
    contextChanges.collectAsState(initial = initialCurrentScope)

/**
 * Obtains the changes to the [ComposeContextNavigator.currentContext] value and returns it as a [State]. This allows it
 * to be used in a [Composable] and cause recomposition when the value changes.
 *
 * If you just need to get the current scope value and do not need to cause recomposition when the value changes, simply
 * use the [ComposeContextNavigator.currentContext] property.
 *
 * **Note:** Internally this function uses the [ComposeContextNavigator.contextChanges] Flow and the [collectAsState]
 * function using the [ComposeContextNavigator.currentContext] as the initial value.
 *
 * @see [ComposeContextNavigator.currentContext]
 * @see [ComposeContextNavigator.contextChanges]
 * @see [collectAsState]
 */
// **Note:** For some reason adding a default value to the `initialCurrentScope` parameter in the [currentScopeAsState]
// function is causing an issue so this function is needed for the default case.
@ExperimentalNavigationApi
@Composable
fun <Context, Key> ComposeContextNavigator<Context, Key>.currentContextAsState(): State<Context> =
    contextChanges.collectAsState(initial = currentContext)
