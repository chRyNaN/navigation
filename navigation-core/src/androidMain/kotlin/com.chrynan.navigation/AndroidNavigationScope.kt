@file:Suppress("unused")

package com.chrynan.navigation

import android.app.Activity

/**
 * A [NavigationScope] used on the Android platform that has access to a parent [Activity] that can be used to change
 * Activities or Fragments.
 */
interface AndroidNavigationScope : NavigationScope {

    val activity: Activity
}

internal class SimpleAndroidNavigationScope(
    override val activity: Activity,
) : AndroidNavigationScope

@Suppress("FunctionName")
internal fun AndroidNavigationScope(
    activity: Activity,
): AndroidNavigationScope = SimpleAndroidNavigationScope(
    activity = activity
)
