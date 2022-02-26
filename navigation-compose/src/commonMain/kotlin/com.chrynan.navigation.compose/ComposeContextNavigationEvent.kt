@file:Suppress("unused")

package com.chrynan.navigation.compose

/**
 *
 * @param [keyBackStackCount] The amount of keys in the back stack when first navigating to this [context].
 */
internal data class ComposeContextNavigationEvent<Context, Key>(
    val context: Context,
    val keyBackStackCount: Int
)
