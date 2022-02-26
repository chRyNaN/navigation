package com.chrynan.navigation

/**
 * Represents an intent to move to a different screen in the application. This is similar to an Intent from the MVI
 * design pattern, but for navigation purposes.
 *
 * For example:
 * ```
 * sealed class HomeScreenIntent : NavigationIntent {
 *
 *     object Feed : HomeScreenIntent()
 * }
 * ```
 */
interface NavigationIntent {

    companion object
}
