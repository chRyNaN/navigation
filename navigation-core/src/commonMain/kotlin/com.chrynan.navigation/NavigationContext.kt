package com.chrynan.navigation

/**
 * Represents a navigation context, or a container of a back stack of [Key]s. Navigation can take place within a
 * [NavigationContext] typically by changing [Key] values. But an application may have multiple [NavigationContext]s
 * that can be changed and navigated through. This allows for more complex navigation paradigms, such as retaining
 * multiple back stacks for a bottom navigation UI component.
 */
interface NavigationContext<Key> {

    /**
     * The initial key value that should be displayed when first changing to this [NavigationContext] before any other
     * navigation was performed.
     */
    val initialKey: Key
}
