//[navigation-compose](../../index.md)/[com.chrynan.navigation.compose](index.md)/[rememberNavigator](remember-navigator.md)

# rememberNavigator

[common]\

@[ExperimentalNavigationApi](../../../navigation-core/navigation-core/com.chrynan.navigation/-experimental-navigation-api/index.md)

@[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)

fun &lt;[Destination](remember-navigator.md) : [NavigationDestination](../../../navigation-core/com.chrynan.navigation/-navigation-destination/index.md)&gt; [rememberNavigator](remember-navigator.md)(initialDestination: [Destination](remember-navigator.md), duplicateDestinationStrategy: [NavigationStrategy.DuplicateDestination](../../../navigation-core/navigation-core/com.chrynan.navigation/-navigation-strategy/-duplicate-destination/index.md) = NavigationStrategy.DuplicateDestination.ALLOW_DUPLICATES, destinationRetentionStrategy: [NavigationStrategy.DestinationRetention](../../../navigation-core/navigation-core/com.chrynan.navigation/-navigation-strategy/-destination-retention/index.md) = NavigationStrategy.DestinationRetention.RETAIN): [Navigator](../../../navigation-core/navigation-core/com.chrynan.navigation/-navigator/index.md)&lt;[Destination](remember-navigator.md), [SingleNavigationContext](../../../navigation-core/navigation-core/com.chrynan.navigation/-single-navigation-context/index.md)&lt;[Destination](remember-navigator.md)&gt;&gt;

Creates and remembers a [Navigator](../../../navigation-core/navigation-core/com.chrynan.navigation/-navigator/index.md) with a [SingleNavigationContext](../../../navigation-core/navigation-core/com.chrynan.navigation/-single-navigation-context/index.md). A [Navigator](../../../navigation-core/navigation-core/com.chrynan.navigation/-navigator/index.md) can be used to navigate between different UI content in an application.

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
| duplicateDestinationStrategy | The [NavigationStrategy.DuplicateDestination](../../../navigation-core/navigation-core/com.chrynan.navigation/-navigation-strategy/-duplicate-destination/index.md) strategy for handling of duplicate destination content within a [NavigationContext](../../../navigation-core/navigation-core/com.chrynan.navigation/-navigation-context/index.md) stack. Read the documentation on [NavigationStrategy.DuplicateDestination](../../../navigation-core/navigation-core/com.chrynan.navigation/-navigation-strategy/-duplicate-destination/index.md) for more information about the supported operations. Defaults to [NavigationStrategy.DuplicateDestination.ALLOW_DUPLICATES](../../../navigation-core/navigation-core/com.chrynan.navigation/-navigation-strategy/-duplicate-destination/-a-l-l-o-w_-d-u-p-l-i-c-a-t-e-s/index.md). |
| destinationRetentionStrategy | The [NavigationStrategy.DestinationRetention](../../../navigation-core/navigation-core/com.chrynan.navigation/-navigation-strategy/-destination-retention/index.md) strategy for handling of destination stacks within a [NavigationContext](../../../navigation-core/navigation-core/com.chrynan.navigation/-navigation-context/index.md) when navigating between different [NavigationContext](../../../navigation-core/navigation-core/com.chrynan.navigation/-navigation-context/index.md)s. Read the documentation on [NavigationStrategy.DestinationRetention](../../../navigation-core/navigation-core/com.chrynan.navigation/-navigation-strategy/-destination-retention/index.md) for more information about the supported operations. Defaults to [NavigationStrategy.DestinationRetention.RETAIN](../../../navigation-core/navigation-core/com.chrynan.navigation/-navigation-strategy/-destination-retention/-r-e-t-a-i-n/index.md). |

#### See also

| | |
|---|---|
| [rememberNavigator](remember-navigator.md) | For a version of this function that supports multiple [NavigationContext](../../../navigation-core/navigation-core/com.chrynan.navigation/-navigation-context/index.md)s. |
| [rememberSavableNavigator](remember-savable-navigator.md) | For a version of this function that saves the navigator across configuration changes. |
| [NavigationContainer](-navigation-container.md) | To display the [Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html) content for the current navigation context and keys. |
| [Navigator](../../../navigation-core/navigation-core/com.chrynan.navigation/-navigator/index.md) | For constructor functions that can be invoked outside [Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html) functions. |

[common]\

@[ExperimentalNavigationApi](../../../navigation-core/navigation-core/com.chrynan.navigation/-experimental-navigation-api/index.md)

@[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)

fun &lt;[Destination](remember-navigator.md) : [NavigationDestination](../../../navigation-core/com.chrynan.navigation/-navigation-destination/index.md), [Context](remember-navigator.md) : [NavigationContext](../../../navigation-core/navigation-core/com.chrynan.navigation/-navigation-context/index.md)&lt;[Destination](remember-navigator.md)&gt;&gt; [rememberNavigator](remember-navigator.md)(initialContext: [Context](remember-navigator.md), duplicateDestinationStrategy: [NavigationStrategy.DuplicateDestination](../../../navigation-core/navigation-core/com.chrynan.navigation/-navigation-strategy/-duplicate-destination/index.md) = NavigationStrategy.DuplicateDestination.ALLOW_DUPLICATES, destinationRetentionStrategy: [NavigationStrategy.DestinationRetention](../../../navigation-core/navigation-core/com.chrynan.navigation/-navigation-strategy/-destination-retention/index.md) = NavigationStrategy.DestinationRetention.RETAIN): [Navigator](../../../navigation-core/navigation-core/com.chrynan.navigation/-navigator/index.md)&lt;[Destination](remember-navigator.md), [Context](remember-navigator.md)&gt;

Creates and remembers a [Navigator](../../../navigation-core/navigation-core/com.chrynan.navigation/-navigator/index.md) with a [SingleNavigationContext](../../../navigation-core/navigation-core/com.chrynan.navigation/-single-navigation-context/index.md). A [Navigator](../../../navigation-core/navigation-core/com.chrynan.navigation/-navigator/index.md) can be used to navigate between different UI content in an application.

Example usage:

```kotlin
val navigator = rememberNavigator(initialContext = MainContext.HOME)
```

#### Return

A remembered [Navigator](../../../navigation-core/navigation-core/com.chrynan.navigation/-navigator/index.md) instance constructed using the provided values.

#### Parameters

common

| | |
|---|---|
| initialContext | The initial [NavigationContext](../../../navigation-core/navigation-core/com.chrynan.navigation/-navigation-context/index.md) value to start at for this [Navigator](../../../navigation-core/navigation-core/com.chrynan.navigation/-navigator/index.md). |
| duplicateDestinationStrategy | The [NavigationStrategy.DuplicateDestination](../../../navigation-core/navigation-core/com.chrynan.navigation/-navigation-strategy/-duplicate-destination/index.md) strategy for handling of duplicate destination content within a [Context](remember-navigator.md) stack. Read the documentation on [NavigationStrategy.DuplicateDestination](../../../navigation-core/navigation-core/com.chrynan.navigation/-navigation-strategy/-duplicate-destination/index.md) for more information about the supported operations. Defaults to [NavigationStrategy.DuplicateDestination.ALLOW_DUPLICATES](../../../navigation-core/navigation-core/com.chrynan.navigation/-navigation-strategy/-duplicate-destination/-a-l-l-o-w_-d-u-p-l-i-c-a-t-e-s/index.md). |
| destinationRetentionStrategy | The [NavigationStrategy.DestinationRetention](../../../navigation-core/navigation-core/com.chrynan.navigation/-navigation-strategy/-destination-retention/index.md) strategy for handling of destination stacks within a [Context](remember-navigator.md) when navigating between different [NavigationContext](../../../navigation-core/navigation-core/com.chrynan.navigation/-navigation-context/index.md)s. Read the documentation on [NavigationStrategy.DestinationRetention](../../../navigation-core/navigation-core/com.chrynan.navigation/-navigation-strategy/-destination-retention/index.md) for more information about the supported operations. Defaults to [NavigationStrategy.DestinationRetention.RETAIN](../../../navigation-core/navigation-core/com.chrynan.navigation/-navigation-strategy/-destination-retention/-r-e-t-a-i-n/index.md). |

#### See also

| | |
|---|---|
| [rememberNavigator](remember-navigator.md) | For a version of this function with only a single [NavigationContext](../../../navigation-core/navigation-core/com.chrynan.navigation/-navigation-context/index.md). |
| [rememberSavableNavigator](remember-savable-navigator.md) | For a version of this function that saves the navigator across configuration changes. |
| [NavigationContainer](-navigation-container.md) | To display the [Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html) content for the current navigation context and keys. |
| [Navigator](../../../navigation-core/navigation-core/com.chrynan.navigation/-navigator/index.md) | For constructor functions that can be invoked outside [Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html) functions. |
