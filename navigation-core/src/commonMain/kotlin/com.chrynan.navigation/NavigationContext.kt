package com.chrynan.navigation

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Represents a navigation context, or a container of a back stack of [Destination]s. Navigation can take place within
 * a [NavigationContext] typically by changing [Destination] values. But an application may have multiple
 * [NavigationContext]s that can be changed and navigated through. This allows for more complex navigation paradigms,
 * such as retaining multiple back stacks for a bottom navigation UI component.
 *
 * @property [initialDestination] The initial [NavigationDestination] to be displayed when this [NavigationContext] is
 * first loaded.
 *
 * Example usage:
 *
 * ```kotlin
 * enum class AppContext(override val initialDestination: String) : NavigationContext<String> {
 *
 *     HOME(initialDestination = "Home"),
 *     FEED(initialDestination = "Feed"),
 *     SETTINGS(initialDestination = "Settings")
 * }
 * ```
 */
interface NavigationContext<Destination : NavigationDestination> {

    /**
     * The initial key value that should be displayed when first changing to this [NavigationContext] before any other
     * navigation was performed.
     */
    val initialDestination: Destination

    companion object
}

/**
 * An implementation of the [NavigationContext] interface that doesn't have multiple contexts. Typically, a
 * [NavigationContext] will either be a sealed class or an enum representing the different contexts for navigation.
 * This is common, for instance, for a UI with a bottom navigation bar, where each navigation item in that bottom
 * navigation bar component would be a different context. Each context would retain its own stack of destinations in
 * the [Navigator]. However, sometimes it may be preferable to have only a single context for navigation, and in this
 * case, this class can be used.
 *
 * **Note:** That this class has an internal constructor and therefore can only be constructed from within this
 * library. This is by design to prevent providing numerous instances of the [SingleNavigationContext] in the
 * [Navigator.changeContext] function.
 *
 * Example usage:
 *
 * ```kotlin
 * SingleNavigationContext(initialDestination = "Home")
 * ```
 */
@Serializable
class SingleNavigationContext<Destination : NavigationDestination> internal constructor(
    @SerialName(value = "initial_destination") override val initialDestination: Destination
) : NavigationContext<Destination> {

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is SingleNavigationContext<*>) return false

        return initialDestination == other.initialDestination
    }

    override fun hashCode(): Int =
        initialDestination.hashCode()

    override fun toString(): String =
        "SingleNavigationContext(initialDestination=$initialDestination)"
}
