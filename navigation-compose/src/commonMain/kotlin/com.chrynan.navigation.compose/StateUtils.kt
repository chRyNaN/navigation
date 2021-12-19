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
fun <T> ComposeNavigator<T>.currentKeyAsState(): State<T?> = keyChanges.collectAsState(initial = currentKey)
