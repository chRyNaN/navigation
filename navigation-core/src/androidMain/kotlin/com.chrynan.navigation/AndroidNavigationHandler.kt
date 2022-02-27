package com.chrynan.navigation

/**
 * A [NavigationHandler] used on the Android platform that uses an [AndroidNavigationScope].
 */
interface AndroidNavigationHandler<Intent : NavigationIntent> :
    NavigationEventHandler<Intent, AndroidNavigationScope>
