@file:Suppress("unused")

package com.chrynan.navigation.compose

/**
 *
 * @param [keyBackStackCount] The amount of keys in the back stack when first navigating to this [scope].
 */
internal data class ComposeScopeNavigationEvent<Scope, Key>(
    val scope: Scope,
    val keyBackStackCount: Int
)
