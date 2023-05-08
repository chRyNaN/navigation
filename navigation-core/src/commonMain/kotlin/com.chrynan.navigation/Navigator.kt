@file:Suppress("unused")

package com.chrynan.navigation

/**
 * A [Navigator] is responsible for coordinating the navigation between the different UI component groupings in an
 * application.
 *
 * A [Navigator] is platform and UI framework dependent, so each implementation depends on the particular UI framework
 * used, for example, Jetpack Compose.
 */
interface Navigator<Destination : NavigationDestination, Context : NavigationContext<Destination>> {

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
 * Performs a back navigation operation by removing the top destination from the stack in the current [Context] and
 * displaying the next destination in the list. If this [Navigator] cannot navigate back, then this function will
 * do nothing.
 *
 * @return `true` if the back navigation operation was successful, `false` otherwise.
 */
fun <Destination : NavigationDestination, Context : NavigationContext<Destination>> Navigator<Destination, Context>.goBack(): Boolean =
    false // navigate(event = DestinationEvent.Back())

/**
 * Performs an "up" navigation. An "up" navigation is similar to a "back" navigation but may be slightly different.
 * For instance, on Android, the "left arrow" button in the toolbar component of an application, performs the "up"
 * operation, which is slightly different from the phones back button which performs a "back" operation.
 *
 * Currently, this defaults to the same operation as the [goBack] function.
 *
 * @return `true` if the back navigation operation was successful, `false` otherwise.
 */
fun <Destination : NavigationDestination, Context : NavigationContext<Destination>> Navigator<Destination, Context>.goUp(): Boolean =
    false // navigate(event = DestinationEvent.Up())

/**
 * Goes to the provided [destination] using the provided stack duplicate content [strategy]. Depending on the
 * provided [strategy] and the current [Context] stack, this will either clear the current [Context] stack to the
 * last value that equals the provided [destination], or add the provided [destination] to the top of the current
 * [Context] stack.
 *
 * @param [destination] The [NavigationDestination] that is to be navigated to and added to the current [Context]
 * stack.
 * @param [strategy] The [StackDuplicateDestinationStrategy] defining what to do when there are duplicate [Destination]
 * values within the current [Context] stack.
 *
 * @return `true` if the back navigation operation was successful, `false` otherwise.
 */
fun <Destination : NavigationDestination, Context : NavigationContext<Destination>> Navigator<Destination, Context>.goTo(
    destination: Destination,
    strategy: StackDuplicateDestinationStrategy
): Boolean = false // navigate(event = DestinationEvent.To(destination = destination, strategy = strategy))

/**
 * Goes to the provided [destination] using the provided stack duplicate content [strategy]. Depending on the current
 * [Context] stack, this will either clear the current [Context] stack to the last value that equals the provided
 * [destination], or add the provided [destination] to the top of the current [Context] stack.
 *
 * @param [destination] The [NavigationDestination] that is to be navigated to and added to the current [Context]
 * stack.
 */
// Note: This is needed because defaults aren't working for @Composable functions for interfaces.
fun <Destination : Any, Context : NavigationContext<Destination>> Navigator<Destination, Context>.goTo(destination: Destination) =
    goTo(destination = destination, strategy = StackDuplicateDestinationStrategy.CLEAR_TO_ORIGINAL)

/**
 * Changes the current [Context] to the provided [context] value. The displayed [Destination] will top destination
 * value in the stack associated with the provided [context], or the provided context's
 * [NavigationContext.initialDestination] if there is currently no existing stack for the provided [context].
 *
 * @param [context] The [NavigationContext] to change to.
 */
fun <Destination : Any, Context : NavigationContext<Destination>> Navigator<Destination, Context>.changeContext(context: Context): Boolean =
    false // TODO
