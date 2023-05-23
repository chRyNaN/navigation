//[navigation-compose](../../index.md)/[com.chrynan.navigation.compose](index.md)/[rememberSavableNavigator](remember-savable-navigator.md)

# rememberSavableNavigator

[common]\

@ExperimentalSerializationApi

@[ExperimentalNavigationApi](../../../navigation-core/navigation-core/com.chrynan.navigation/-experimental-navigation-api/index.md)

@[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)

inline fun &lt;[Destination](remember-savable-navigator.md) : [NavigationDestination](../../../navigation-core/com.chrynan.navigation/-navigation-destination/index.md)&gt; [rememberSavableNavigator](remember-savable-navigator.md)(initialDestination: [Destination](remember-savable-navigator.md), parcelable: Parcelable = Parcelable.Default, destinationSerializer: KSerializer&lt;[Destination](remember-savable-navigator.md)&gt; = Parcelable.serializersModule.serializer(), duplicateDestinationStrategy: [NavigationStrategy.DuplicateDestination](../../../navigation-core/navigation-core/com.chrynan.navigation/-navigation-strategy/-duplicate-destination/index.md) = NavigationStrategy.DuplicateDestination.ALLOW_DUPLICATES, backwardsNavigationStrategy: [NavigationStrategy.BackwardsNavigation](../../../navigation-core/navigation-core/com.chrynan.navigation/-navigation-strategy/-backwards-navigation/index.md) = NavigationStrategy.BackwardsNavigation.IN_CONTEXT, destinationRetentionStrategy: [NavigationStrategy.DestinationRetention](../../../navigation-core/navigation-core/com.chrynan.navigation/-navigation-strategy/-destination-retention/index.md) = NavigationStrategy.DestinationRetention.RETAIN): [Navigator](../../../navigation-core/navigation-core/com.chrynan.navigation/-navigator/index.md)&lt;[Destination](remember-savable-navigator.md), [SingleNavigationContext](../../../navigation-core/navigation-core/com.chrynan.navigation/-single-navigation-context/index.md)&lt;[Destination](remember-savable-navigator.md)&gt;&gt;

Creates, remembers and saves a [Navigator](../../../navigation-core/navigation-core/com.chrynan.navigation/-navigator/index.md) with a [SingleNavigationContext](../../../navigation-core/navigation-core/com.chrynan.navigation/-single-navigation-context/index.md). A [Navigator](../../../navigation-core/navigation-core/com.chrynan.navigation/-navigator/index.md) can be used to navigate between different UI content in an application. This differs from the [rememberNavigator](remember-navigator.md) function in that it allows restoring the [Navigator](../../../navigation-core/navigation-core/com.chrynan.navigation/-navigator/index.md) state between configuration changes via the rememberSavable function and using the provided KSerializers.

Example usage:

```kotlin
val navigator = rememberNavigator(initialDestination = "Greeting")
```

#### Return

A remembered [Navigator](../../../navigation-core/navigation-core/com.chrynan.navigation/-navigator/index.md) instance constructed using the provided values.

#### Parameters

common

| | |
|---|---|
| initialDestination | The initial [NavigationDestination](../../../navigation-core/com.chrynan.navigation/-navigation-destination/index.md) value to start at for this [Navigator](../../../navigation-core/navigation-core/com.chrynan.navigation/-navigator/index.md). |
| parcelable | The Parcelable instance that is used to store and retrieve the [Navigator](../../../navigation-core/navigation-core/com.chrynan.navigation/-navigator/index.md) instance between configuration changes. |
| destinationSerializer | The KSerializer for the [Destination](remember-savable-navigator.md) type. |
| duplicateDestinationStrategy | The [NavigationStrategy.DuplicateDestination](../../../navigation-core/navigation-core/com.chrynan.navigation/-navigation-strategy/-duplicate-destination/index.md) strategy for handling of duplicate destination content within a [NavigationContext](../../../navigation-core/navigation-core/com.chrynan.navigation/-navigation-context/index.md) stack. Read the documentation on [NavigationStrategy.DuplicateDestination](../../../navigation-core/navigation-core/com.chrynan.navigation/-navigation-strategy/-duplicate-destination/index.md) for more information about the supported operations. Defaults to [NavigationStrategy.DuplicateDestination.ALLOW_DUPLICATES](../../../navigation-core/navigation-core/com.chrynan.navigation/-navigation-strategy/-duplicate-destination/-a-l-l-o-w_-d-u-p-l-i-c-a-t-e-s/index.md). |
| backwardsNavigationStrategy | The [NavigationStrategy.BackwardsNavigation](../../../navigation-core/navigation-core/com.chrynan.navigation/-navigation-strategy/-backwards-navigation/index.md) strategy of supported back navigation (across contexts or just destinations within the current context). Read the documentation on [NavigationStrategy.BackwardsNavigation](../../../navigation-core/navigation-core/com.chrynan.navigation/-navigation-strategy/-backwards-navigation/index.md) for more information about the operations that are supported. Defaults to [NavigationStrategy.BackwardsNavigation.IN_CONTEXT](../../../navigation-core/navigation-core/com.chrynan.navigation/-navigation-strategy/-backwards-navigation/-i-n_-c-o-n-t-e-x-t/index.md). |
| destinationRetentionStrategy | The [NavigationStrategy.DestinationRetention](../../../navigation-core/navigation-core/com.chrynan.navigation/-navigation-strategy/-destination-retention/index.md) strategy for handling of destination stacks within a [NavigationContext](../../../navigation-core/navigation-core/com.chrynan.navigation/-navigation-context/index.md) when navigating between different [NavigationContext](../../../navigation-core/navigation-core/com.chrynan.navigation/-navigation-context/index.md)s. Read the documentation on [NavigationStrategy.DestinationRetention](../../../navigation-core/navigation-core/com.chrynan.navigation/-navigation-strategy/-destination-retention/index.md) for more information about the supported operations. Defaults to [NavigationStrategy.DestinationRetention.RETAIN](../../../navigation-core/navigation-core/com.chrynan.navigation/-navigation-strategy/-destination-retention/-r-e-t-a-i-n/index.md). |

#### See also

| | |
|---|---|
| [rememberNavigator](remember-navigator.md) | For a version of this function that supports multiple [NavigationContext](../../../navigation-core/navigation-core/com.chrynan.navigation/-navigation-context/index.md)s. |
| [rememberSavableNavigator](remember-savable-navigator.md) | For a version of this function that saves the navigator across configuration changes. |
| [NavigationContainer](-navigation-container.md) | To display the [Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html) content for the current navigation context and keys. |
| [Navigator](../../../navigation-core/navigation-core/com.chrynan.navigation/-navigator/index.md) | For constructor functions that can be invoked outside [Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html) functions. |

[common]\

@ExperimentalSerializationApi

@[ExperimentalNavigationApi](../../../navigation-core/navigation-core/com.chrynan.navigation/-experimental-navigation-api/index.md)

@[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)

inline fun &lt;[Destination](remember-savable-navigator.md) : [NavigationDestination](../../../navigation-core/com.chrynan.navigation/-navigation-destination/index.md), [Context](remember-savable-navigator.md) : [NavigationContext](../../../navigation-core/navigation-core/com.chrynan.navigation/-navigation-context/index.md)&lt;[Destination](remember-savable-navigator.md)&gt;&gt; [rememberSavableNavigator](remember-savable-navigator.md)(initialContext: [Context](remember-savable-navigator.md), parcelable: Parcelable = Parcelable.Default, destinationSerializer: KSerializer&lt;[Destination](remember-savable-navigator.md)&gt; = Parcelable.serializersModule.serializer(), contextSerializer: KSerializer&lt;[Context](remember-savable-navigator.md)&gt; = Parcelable.serializersModule.serializer(), duplicateDestinationStrategy: [NavigationStrategy.DuplicateDestination](../../../navigation-core/navigation-core/com.chrynan.navigation/-navigation-strategy/-duplicate-destination/index.md) = NavigationStrategy.DuplicateDestination.ALLOW_DUPLICATES, backwardsNavigationStrategy: [NavigationStrategy.BackwardsNavigation](../../../navigation-core/navigation-core/com.chrynan.navigation/-navigation-strategy/-backwards-navigation/index.md) = NavigationStrategy.BackwardsNavigation.IN_CONTEXT, destinationRetentionStrategy: [NavigationStrategy.DestinationRetention](../../../navigation-core/navigation-core/com.chrynan.navigation/-navigation-strategy/-destination-retention/index.md) = NavigationStrategy.DestinationRetention.RETAIN): [Navigator](../../../navigation-core/navigation-core/com.chrynan.navigation/-navigator/index.md)&lt;[Destination](remember-savable-navigator.md), [Context](remember-savable-navigator.md)&gt;

Creates, remembers and saves a [Navigator](../../../navigation-core/navigation-core/com.chrynan.navigation/-navigator/index.md) with a [SingleNavigationContext](../../../navigation-core/navigation-core/com.chrynan.navigation/-single-navigation-context/index.md). A [Navigator](../../../navigation-core/navigation-core/com.chrynan.navigation/-navigator/index.md) can be used to navigate between different UI content in an application. This differs from the [rememberNavigator](remember-navigator.md) function in that it allows restoring the [Navigator](../../../navigation-core/navigation-core/com.chrynan.navigation/-navigator/index.md) state between configuration changes via the rememberSavable function and using the provided KSerializers.

Example usage:

```kotlin
val navigator = rememberNavigator(initialDestination = "Greeting")
```

#### Return

A remembered [Navigator](../../../navigation-core/navigation-core/com.chrynan.navigation/-navigator/index.md) instance constructed using the provided values.

#### Parameters

common

| | |
|---|---|
| initialContext | The initial [NavigationContext](../../../navigation-core/navigation-core/com.chrynan.navigation/-navigation-context/index.md) value to start at for this [Navigator](../../../navigation-core/navigation-core/com.chrynan.navigation/-navigator/index.md). |
| parcelable | The Parcelable instance that is used to store and retrieve the [Navigator](../../../navigation-core/navigation-core/com.chrynan.navigation/-navigator/index.md) instance between configuration changes. |
| destinationSerializer | The KSerializer for the [Destination](remember-savable-navigator.md) type. |
| contextSerializer | The KSerializer for the [Context](remember-savable-navigator.md) type. |
| duplicateDestinationStrategy | The [NavigationStrategy.DuplicateDestination](../../../navigation-core/navigation-core/com.chrynan.navigation/-navigation-strategy/-duplicate-destination/index.md) strategy for handling of duplicate destination content within a [NavigationContext](../../../navigation-core/navigation-core/com.chrynan.navigation/-navigation-context/index.md) stack. Read the documentation on [NavigationStrategy.DuplicateDestination](../../../navigation-core/navigation-core/com.chrynan.navigation/-navigation-strategy/-duplicate-destination/index.md) for more information about the supported operations. Defaults to [NavigationStrategy.DuplicateDestination.ALLOW_DUPLICATES](../../../navigation-core/navigation-core/com.chrynan.navigation/-navigation-strategy/-duplicate-destination/-a-l-l-o-w_-d-u-p-l-i-c-a-t-e-s/index.md). |
| backwardsNavigationStrategy | The [NavigationStrategy.BackwardsNavigation](../../../navigation-core/navigation-core/com.chrynan.navigation/-navigation-strategy/-backwards-navigation/index.md) strategy of supported back navigation (across contexts or just destinations within the current context). Read the documentation on [NavigationStrategy.BackwardsNavigation](../../../navigation-core/navigation-core/com.chrynan.navigation/-navigation-strategy/-backwards-navigation/index.md) for more information about the operations that are supported. Defaults to [NavigationStrategy.BackwardsNavigation.IN_CONTEXT](../../../navigation-core/navigation-core/com.chrynan.navigation/-navigation-strategy/-backwards-navigation/-i-n_-c-o-n-t-e-x-t/index.md). |
| destinationRetentionStrategy | The [NavigationStrategy.DestinationRetention](../../../navigation-core/navigation-core/com.chrynan.navigation/-navigation-strategy/-destination-retention/index.md) strategy for handling of destination stacks within a [NavigationContext](../../../navigation-core/navigation-core/com.chrynan.navigation/-navigation-context/index.md) when navigating between different [NavigationContext](../../../navigation-core/navigation-core/com.chrynan.navigation/-navigation-context/index.md)s. Read the documentation on [NavigationStrategy.DestinationRetention](../../../navigation-core/navigation-core/com.chrynan.navigation/-navigation-strategy/-destination-retention/index.md) for more information about the supported operations. Defaults to [NavigationStrategy.DestinationRetention.RETAIN](../../../navigation-core/navigation-core/com.chrynan.navigation/-navigation-strategy/-destination-retention/-r-e-t-a-i-n/index.md). |

#### See also

| | |
|---|---|
| [rememberNavigator](remember-navigator.md) | For a version of this function that supports multiple [NavigationContext](../../../navigation-core/navigation-core/com.chrynan.navigation/-navigation-context/index.md)s. |
| [rememberSavableNavigator](remember-savable-navigator.md) | For a version of this function that saves the navigator across configuration changes. |
| [NavigationContainer](-navigation-container.md) | To display the [Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html) content for the current navigation context and keys. |
| [Navigator](../../../navigation-core/navigation-core/com.chrynan.navigation/-navigator/index.md) | For constructor functions that can be invoked outside [Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html) functions. |
