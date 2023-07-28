//[navigation-core](../../index.md)/[com.chrynan.navigation](index.md)/[Navigator](-navigator.md)

# Navigator

[common]\

@[ExperimentalNavigationApi](-experimental-navigation-api/index.md)

fun &lt;[Destination](-navigator.md) : [NavigationDestination](index.md#1223765350%2FClasslikes%2F-215881696), [Context](-navigator.md) : [NavigationContext](-navigation-context/index.md)&lt;[Destination](-navigator.md)&gt;&gt; [Navigator](-navigator.md)(initialContext: [Context](-navigator.md), duplicateDestinationStrategy: [NavigationStrategy.DuplicateDestination](-navigation-strategy/-duplicate-destination/index.md) = NavigationStrategy.DuplicateDestination.ALLOW_DUPLICATES, destinationRetentionStrategy: [NavigationStrategy.DestinationRetention](-navigation-strategy/-destination-retention/index.md) = NavigationStrategy.DestinationRetention.RETAIN): [Navigator](-navigator/index.md)&lt;[Destination](-navigator.md), [Context](-navigator.md)&gt;

Creates a [Navigator](-navigator/index.md) instance with the provided values.

#### Parameters

common

| | |
|---|---|
| initialContext | The initial [NavigationContext](-navigation-context/index.md) value to start at for this [Navigator](-navigator/index.md). |
| duplicateDestinationStrategy | The [NavigationStrategy.DuplicateDestination](-navigation-strategy/-duplicate-destination/index.md) strategy for handling of duplicate destination content within a [Context](-navigator.md) stack. Read the documentation on [NavigationStrategy.DuplicateDestination](-navigation-strategy/-duplicate-destination/index.md) for more information about the supported operations. Defaults to [NavigationStrategy.DuplicateDestination.ALLOW_DUPLICATES](-navigation-strategy/-duplicate-destination/-a-l-l-o-w_-d-u-p-l-i-c-a-t-e-s/index.md). |
| destinationRetentionStrategy | The [NavigationStrategy.DestinationRetention](-navigation-strategy/-destination-retention/index.md) strategy for handling of destination stacks within a [Context](-navigator.md) when navigating between different [NavigationContext](-navigation-context/index.md)s. Read the documentation on [NavigationStrategy.DestinationRetention](-navigation-strategy/-destination-retention/index.md) for more information about the supported operations. Defaults to [NavigationStrategy.DestinationRetention.RETAIN](-navigation-strategy/-destination-retention/-r-e-t-a-i-n/index.md). |

[common]\

@[ExperimentalNavigationApi](-experimental-navigation-api/index.md)

fun &lt;[Destination](-navigator.md) : [NavigationDestination](index.md#1223765350%2FClasslikes%2F-215881696)&gt; [Navigator](-navigator.md)(initialDestination: [Destination](-navigator.md), duplicateDestinationStrategy: [NavigationStrategy.DuplicateDestination](-navigation-strategy/-duplicate-destination/index.md) = NavigationStrategy.DuplicateDestination.ALLOW_DUPLICATES, destinationRetentionStrategy: [NavigationStrategy.DestinationRetention](-navigation-strategy/-destination-retention/index.md) = NavigationStrategy.DestinationRetention.RETAIN): [Navigator](-navigator/index.md)&lt;[Destination](-navigator.md), [SingleNavigationContext](-single-navigation-context/index.md)&lt;[Destination](-navigator.md)&gt;&gt;

Creates a [Navigator](-navigator/index.md) instance with the provided values using the [SingleNavigationContext](-single-navigation-context/index.md).

#### Parameters

common

| | |
|---|---|
| initialDestination | The initial [NavigationDestination](index.md#1223765350%2FClasslikes%2F-215881696) value to start at for this [Navigator](-navigator/index.md). |
| duplicateDestinationStrategy | The [NavigationStrategy.DuplicateDestination](-navigation-strategy/-duplicate-destination/index.md) strategy for handling of duplicate destination content within a [NavigationContext](-navigation-context/index.md) stack. Read the documentation on [NavigationStrategy.DuplicateDestination](-navigation-strategy/-duplicate-destination/index.md) for more information about the supported operations. Defaults to [NavigationStrategy.DuplicateDestination.ALLOW_DUPLICATES](-navigation-strategy/-duplicate-destination/-a-l-l-o-w_-d-u-p-l-i-c-a-t-e-s/index.md). |
| destinationRetentionStrategy | The [NavigationStrategy.DestinationRetention](-navigation-strategy/-destination-retention/index.md) strategy for handling of destination stacks within a [NavigationContext](-navigation-context/index.md) when navigating between different [NavigationContext](-navigation-context/index.md)s. Read the documentation on [NavigationStrategy.DestinationRetention](-navigation-strategy/-destination-retention/index.md) for more information about the supported operations. Defaults to [NavigationStrategy.DestinationRetention.RETAIN](-navigation-strategy/-destination-retention/-r-e-t-a-i-n/index.md). |
