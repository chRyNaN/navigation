@file:Suppress("unused")

package com.chrynan.navigation.compose

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import com.chrynan.navigation.*
import com.chrynan.parcelable.compose.rememberSavable
import com.chrynan.parcelable.core.Parcelable
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.KSerializer
import kotlinx.serialization.serializer

/**
 * Creates and remembers a [Navigator] with a [SingleNavigationContext]. A [Navigator] can be used to navigate between
 * different UI content in an application.
 *
 * Example usage:
 * ```kotlin
 * val navigator = rememberNavigator(initialDestination = "Greeting")
 * ```
 *
 * @param [initialDestination] The initial [NavigationDestination] value to start at for this [Navigator].
 * @param [duplicateDestinationStrategy] The [NavigationStrategy.DuplicateDestination] strategy for handling of
 * duplicate destination content within a [NavigationContext] stack. Read the documentation on
 * [NavigationStrategy.DuplicateDestination] for more information about the supported operations. Defaults to
 * [NavigationStrategy.DuplicateDestination.ALLOW_DUPLICATES].
 * @param [backwardsNavigationStrategy] The [NavigationStrategy.BackwardsNavigation] strategy of supported back
 * navigation (across contexts or just destinations within the current context). Read the documentation on
 * [NavigationStrategy.BackwardsNavigation] for more information about the operations that are supported. Defaults to
 * [NavigationStrategy.BackwardsNavigation.IN_CONTEXT].
 * @param [destinationRetentionStrategy] The [NavigationStrategy.DestinationRetention] strategy for handling of
 * destination stacks within a [NavigationContext] when navigating between different [NavigationContext]s. Read the
 * documentation on [NavigationStrategy.DestinationRetention] for more information about the supported operations.
 * Defaults to [NavigationStrategy.DestinationRetention.RETAIN].
 *
 * @return A remembered [Navigator] instance constructed using the provided values.
 *
 * @see [rememberNavigator] For a version of this function that supports multiple [NavigationContext]s.
 * @see [rememberSavableNavigator] For a version of this function that saves the navigator across configuration
 * changes.
 * @see [NavigationContainer] To display the [Composable] content for the current navigation context and keys.
 * @see [Navigator] For constructor functions that can be invoked outside [Composable] functions.
 */
@ExperimentalNavigationApi
@Composable
fun <Destination : NavigationDestination> rememberNavigator(
    initialDestination: Destination,
    duplicateDestinationStrategy: NavigationStrategy.DuplicateDestination = NavigationStrategy.DuplicateDestination.ALLOW_DUPLICATES,
    backwardsNavigationStrategy: NavigationStrategy.BackwardsNavigation = NavigationStrategy.BackwardsNavigation.IN_CONTEXT,
    destinationRetentionStrategy: NavigationStrategy.DestinationRetention = NavigationStrategy.DestinationRetention.RETAIN
): Navigator<Destination, SingleNavigationContext<Destination>> = remember {
    Navigator(
        initialDestination = initialDestination,
        duplicateDestinationStrategy = duplicateDestinationStrategy,
        backwardsNavigationStrategy = backwardsNavigationStrategy,
        destinationRetentionStrategy = destinationRetentionStrategy
    )
}

/**
 * Creates and remembers a [Navigator] with a [SingleNavigationContext]. A [Navigator] can be used to navigate between
 * different UI content in an application.
 *
 * Example usage:
 * ```kotlin
 * val navigator = rememberNavigator(initialContext = MainContext.HOME)
 * ```
 *
 * @param [initialContext] The initial [NavigationContext] value to start at for this [Navigator].
 * @param [duplicateDestinationStrategy] The [NavigationStrategy.DuplicateDestination] strategy for handling of
 * duplicate destination content within a [Context] stack. Read the documentation on
 * [NavigationStrategy.DuplicateDestination] for more information about the supported operations. Defaults to
 * [NavigationStrategy.DuplicateDestination.ALLOW_DUPLICATES].
 * @param [backwardsNavigationStrategy] The [NavigationStrategy.BackwardsNavigation] strategy of supported back
 * navigation (across contexts or just destinations within the current context). Read the documentation on
 * [NavigationStrategy.BackwardsNavigation] for more information about the operations that are supported. Defaults to
 * [NavigationStrategy.BackwardsNavigation.IN_CONTEXT].
 * @param [destinationRetentionStrategy] The [NavigationStrategy.DestinationRetention] strategy for handling of
 * destination stacks within a [Context] when navigating between different [NavigationContext]s. Read the documentation
 * on [NavigationStrategy.DestinationRetention] for more information about the supported operations. Defaults to
 * [NavigationStrategy.DestinationRetention.RETAIN].
 *
 * @return A remembered [Navigator] instance constructed using the provided values.
 *
 * @see [rememberNavigator] For a version of this function with only a single [NavigationContext].
 * @see [rememberSavableNavigator] For a version of this function that saves the navigator across configuration
 * changes.
 * @see [NavigationContainer] To display the [Composable] content for the current navigation context and keys.
 * @see [Navigator] For constructor functions that can be invoked outside [Composable] functions.
 */
@ExperimentalNavigationApi
@Composable
fun <Destination : NavigationDestination, Context : NavigationContext<Destination>> rememberNavigator(
    initialContext: Context,
    duplicateDestinationStrategy: NavigationStrategy.DuplicateDestination = NavigationStrategy.DuplicateDestination.ALLOW_DUPLICATES,
    backwardsNavigationStrategy: NavigationStrategy.BackwardsNavigation = NavigationStrategy.BackwardsNavigation.IN_CONTEXT,
    destinationRetentionStrategy: NavigationStrategy.DestinationRetention = NavigationStrategy.DestinationRetention.RETAIN
): Navigator<Destination, Context> = remember {
    Navigator(
        initialContext = initialContext,
        duplicateDestinationStrategy = duplicateDestinationStrategy,
        backwardsNavigationStrategy = backwardsNavigationStrategy,
        destinationRetentionStrategy = destinationRetentionStrategy
    )
}

/**
 * Creates, remembers and saves a [Navigator] with a [SingleNavigationContext]. A [Navigator] can be used to navigate
 * between different UI content in an application. This differs from the [rememberNavigator] function in that it allows
 * restoring the [Navigator] state between configuration changes via the [rememberSavable] function and using the
 * provided [KSerializer]s.
 *
 * Example usage:
 * ```kotlin
 * val navigator = rememberNavigator(initialDestination = "Greeting")
 * ```
 *
 * @param [initialDestination] The initial [NavigationDestination] value to start at for this [Navigator].
 * @param [parcelable] The [Parcelable] instance that is used to store and retrieve the [Navigator] instance between
 * configuration changes.
 * @param [destinationSerializer] The [KSerializer] for the [Destination] type.
 * @param [duplicateDestinationStrategy] The [NavigationStrategy.DuplicateDestination] strategy for handling of
 * duplicate destination content within a [NavigationContext] stack. Read the documentation on
 * [NavigationStrategy.DuplicateDestination] for more information about the supported operations. Defaults to
 * [NavigationStrategy.DuplicateDestination.ALLOW_DUPLICATES].
 * @param [backwardsNavigationStrategy] The [NavigationStrategy.BackwardsNavigation] strategy of supported back
 * navigation (across contexts or just destinations within the current context). Read the documentation on
 * [NavigationStrategy.BackwardsNavigation] for more information about the operations that are supported. Defaults to
 * [NavigationStrategy.BackwardsNavigation.IN_CONTEXT].
 * @param [destinationRetentionStrategy] The [NavigationStrategy.DestinationRetention] strategy for handling of
 * destination stacks within a [NavigationContext] when navigating between different [NavigationContext]s. Read the
 * documentation on [NavigationStrategy.DestinationRetention] for more information about the supported operations.
 * Defaults to [NavigationStrategy.DestinationRetention.RETAIN].
 *
 * @return A remembered [Navigator] instance constructed using the provided values.
 *
 * @see [rememberNavigator] For a version of this function that supports multiple [NavigationContext]s.
 * @see [rememberSavableNavigator] For a version of this function that saves the navigator across configuration
 * changes.
 * @see [NavigationContainer] To display the [Composable] content for the current navigation context and keys.
 * @see [Navigator] For constructor functions that can be invoked outside [Composable] functions.
 */
@ExperimentalSerializationApi
@ExperimentalNavigationApi
@Composable
inline fun <reified Destination : NavigationDestination> rememberSavableNavigator(
    initialDestination: Destination,
    parcelable: Parcelable = Parcelable.Default,
    destinationSerializer: KSerializer<Destination> = parcelable.serializersModule.serializer(),
    duplicateDestinationStrategy: NavigationStrategy.DuplicateDestination = NavigationStrategy.DuplicateDestination.ALLOW_DUPLICATES,
    backwardsNavigationStrategy: NavigationStrategy.BackwardsNavigation = NavigationStrategy.BackwardsNavigation.IN_CONTEXT,
    destinationRetentionStrategy: NavigationStrategy.DestinationRetention = NavigationStrategy.DestinationRetention.RETAIN
): Navigator<Destination, SingleNavigationContext<Destination>> =
    rememberSavable(
        parcelable = parcelable,
        serializer = Navigator.serializer(
            destinationSerializer,
            SingleNavigationContext.serializer(destinationSerializer)
        )
    ) {
        Navigator(
            initialDestination = initialDestination,
            duplicateDestinationStrategy = duplicateDestinationStrategy,
            backwardsNavigationStrategy = backwardsNavigationStrategy,
            destinationRetentionStrategy = destinationRetentionStrategy
        )
    }

/**
 * Creates, remembers and saves a [Navigator] with a [SingleNavigationContext]. A [Navigator] can be used to navigate
 * between different UI content in an application. This differs from the [rememberNavigator] function in that it allows
 * restoring the [Navigator] state between configuration changes via the [rememberSavable] function and using the
 * provided [KSerializer]s.
 *
 * Example usage:
 * ```kotlin
 * val navigator = rememberNavigator(initialDestination = "Greeting")
 * ```
 *
 * @param [initialContext] The initial [NavigationContext] value to start at for this [Navigator].
 * @param [parcelable] The [Parcelable] instance that is used to store and retrieve the [Navigator] instance between
 * configuration changes.
 * @param [destinationSerializer] The [KSerializer] for the [Destination] type.
 * @param [contextSerializer] The [KSerializer] for the [Context] type.
 * @param [duplicateDestinationStrategy] The [NavigationStrategy.DuplicateDestination] strategy for handling of
 * duplicate destination content within a [NavigationContext] stack. Read the documentation on
 * [NavigationStrategy.DuplicateDestination] for more information about the supported operations. Defaults to
 * [NavigationStrategy.DuplicateDestination.ALLOW_DUPLICATES].
 * @param [backwardsNavigationStrategy] The [NavigationStrategy.BackwardsNavigation] strategy of supported back
 * navigation (across contexts or just destinations within the current context). Read the documentation on
 * [NavigationStrategy.BackwardsNavigation] for more information about the operations that are supported. Defaults to
 * [NavigationStrategy.BackwardsNavigation.IN_CONTEXT].
 * @param [destinationRetentionStrategy] The [NavigationStrategy.DestinationRetention] strategy for handling of
 * destination stacks within a [NavigationContext] when navigating between different [NavigationContext]s. Read the
 * documentation on [NavigationStrategy.DestinationRetention] for more information about the supported operations.
 * Defaults to [NavigationStrategy.DestinationRetention.RETAIN].
 *
 * @return A remembered [Navigator] instance constructed using the provided values.
 *
 * @see [rememberNavigator] For a version of this function that supports multiple [NavigationContext]s.
 * @see [rememberSavableNavigator] For a version of this function that saves the navigator across configuration
 * changes.
 * @see [NavigationContainer] To display the [Composable] content for the current navigation context and keys.
 * @see [Navigator] For constructor functions that can be invoked outside [Composable] functions.
 */
@ExperimentalSerializationApi
@ExperimentalNavigationApi
@Composable
inline fun <reified Destination : NavigationDestination, reified Context : NavigationContext<Destination>> rememberSavableNavigator(
    initialContext: Context,
    parcelable: Parcelable = Parcelable.Default,
    destinationSerializer: KSerializer<Destination> = parcelable.serializersModule.serializer(),
    contextSerializer: KSerializer<Context> = parcelable.serializersModule.serializer(),
    duplicateDestinationStrategy: NavigationStrategy.DuplicateDestination = NavigationStrategy.DuplicateDestination.ALLOW_DUPLICATES,
    backwardsNavigationStrategy: NavigationStrategy.BackwardsNavigation = NavigationStrategy.BackwardsNavigation.IN_CONTEXT,
    destinationRetentionStrategy: NavigationStrategy.DestinationRetention = NavigationStrategy.DestinationRetention.RETAIN
): Navigator<Destination, Context> =
    rememberSavable(
        parcelable = parcelable,
        serializer = Navigator.serializer(
            destinationSerializer,
            contextSerializer
        )
    ) {
        Navigator(
            initialContext = initialContext,
            duplicateDestinationStrategy = duplicateDestinationStrategy,
            backwardsNavigationStrategy = backwardsNavigationStrategy,
            destinationRetentionStrategy = destinationRetentionStrategy
        )
    }
