@file:Suppress("unused")

package com.chrynan.navigation

/**
 * A [Navigator] is responsible for coordinating the navigation between the different UI component groupings in an
 * application.
 *
 * A [Navigator] is platform and UI framework dependent, so each implementation depends on the particular UI framework
 * used, for example, Jetpack Compose.
 */
sealed interface Navigator<Destination : NavigationDestination, Context : NavigationContext<Destination>> {

    /**
     * The [NavigationStateStore] containing the latest [NavigationState]s for each navigation value. This is useful to
     * get the initial, current, or subscribe to the changes in value of the different navigation components.
     */
    val store: NavigationStateStore<Destination, Context>

    /**
     * Navigates to the provided [event].
     *
     * @param [event] The [NavigationEvent] that represents the navigation action to be performed.
     *
     * @return `true` if the navigation event was successful and the state was altered, or `false` otherwise.
     */
    fun navigate(event: NavigationEvent<Destination, Context>): Boolean

    /**
     * Determines whether the [Navigator] can navigate back in the stack in the current [Context].
     *
     * @return `true` if this [Navigator] can navigate back, `false` otherwise.
     */
    fun canGoBack(): Boolean

    companion object
}

/**
 * Performs a back navigation operation, if possible, by removing the top [NavigationEvent.Forward] event from the
 * internal navigation stack. If this [Navigator] cannot navigate back, then this function will do nothing and return
 * `false`.
 *
 * @param [kind] The kind of supported back navigation (across different navigation stacks or in the current navigation
 * stack). Read the documentation on [NavigationEvent.Backward.Kind] for more information about the operations that are
 * supported. Defaults to [NavigationEvent.Backward.Kind.IN_CONTEXT]
 *
 * @return `true` if the back navigation operation was successful, `false` otherwise.
 */
fun <Destination : NavigationDestination, Context : NavigationContext<Destination>> Navigator<Destination, Context>.goBack(
    kind: NavigationEvent.Backward.Kind = NavigationEvent.Backward.Kind.IN_CONTEXT
): Boolean = navigate(event = NavigationEvent.Backward(kind = kind))

/**
 * Navigates to the provided [destination] in the current [NavigationContext]. Depending on the
 * provided [StackDuplicateDestinationStrategy] when creating this [Navigator], and the current [Context] stack, this
 * will either clear the current [Context] stack to the last value that equals the provided [destination], or add the
 * provided [destination] to the top of the current [Context] stack.
 *
 * @param [destination] The [NavigationDestination] that is to be navigated to and added to the current [Context]
 * stack.
 *
 * @return `true` if the navigation operation was successful, `false` otherwise.
 */
fun <Destination : NavigationDestination, Context : NavigationContext<Destination>> Navigator<Destination, Context>.goTo(
    destination: Destination
): Boolean = navigate(event = NavigationEvent.Forward.Destination(destination = destination))

/**
 * Changes the current [Context] to the provided [context] value. The displayed [Destination] will be the top
 * destination value in the stack associated with the provided [context], or the provided context's
 * [NavigationContext.initialDestination] if there is currently no existing stack for the provided [context].
 *
 * @param [context] The [NavigationContext] to change to.
 *
 * @return `true` if the navigation operation was successful, `false` otherwise.
 */
fun <Destination : Any, Context : NavigationContext<Destination>> Navigator<Destination, Context>.changeContext(context: Context): Boolean =
    navigate(event = NavigationEvent.Forward.Context(context = context))
