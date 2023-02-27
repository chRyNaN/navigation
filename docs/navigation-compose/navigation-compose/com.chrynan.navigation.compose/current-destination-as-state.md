//[navigation-compose](../../index.md)/[com.chrynan.navigation.compose](index.md)/[currentDestinationAsState](current-destination-as-state.md)

# currentDestinationAsState

[common]\

@[ExperimentalNavigationApi](../../../navigation-core/navigation-core/com.chrynan.navigation/-experimental-navigation-api/index.md)

@[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)

fun &lt;[Destination](current-destination-as-state.md) : [NavigationDestination](../../../navigation-core/com.chrynan.navigation/-navigation-destination/index.md)&gt; [NavigationDestinationState](../../../navigation-core/navigation-core/com.chrynan.navigation/-navigation-destination-state/index.md)&lt;[Destination](current-destination-as-state.md)&gt;.[currentDestinationAsState](current-destination-as-state.md)(initialCurrentKey: [Destination](current-destination-as-state.md)): [State](https://developer.android.com/reference/kotlin/androidx/compose/runtime/State.html)&lt;[Destination](current-destination-as-state.md)&gt;

@[ExperimentalNavigationApi](../../../navigation-core/navigation-core/com.chrynan.navigation/-experimental-navigation-api/index.md)

@[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)

fun &lt;[Destination](current-destination-as-state.md) : [NavigationDestination](../../../navigation-core/com.chrynan.navigation/-navigation-destination/index.md)&gt; [NavigationDestinationState](../../../navigation-core/navigation-core/com.chrynan.navigation/-navigation-destination-state/index.md)&lt;[Destination](current-destination-as-state.md)&gt;.[currentDestinationAsState](current-destination-as-state.md)(): [State](https://developer.android.com/reference/kotlin/androidx/compose/runtime/State.html)&lt;[Destination](current-destination-as-state.md)&gt;

Obtains the changes to the [ComposeNavigationDestinationState.currentDestination](../../../navigation-compose/com.chrynan.navigation.compose/-compose-navigation-destination-state/current-destination.md) value and returns it as a [State](https://developer.android.com/reference/kotlin/androidx/compose/runtime/State.html). This allows it to be used in a [Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html) and cause recomposition when the value changes.

If you just need to get the current key value and do not need to cause recomposition when the value changes, simply use the [ComposeNavigationDestinationState.currentDestination](../../../navigation-compose/com.chrynan.navigation.compose/-compose-navigation-destination-state/current-destination.md) property.

**Note:** Internally this function uses the [ComposeNavigationDestinationState.destinationChanges](../../../navigation-compose/com.chrynan.navigation.compose/-compose-navigation-destination-state/destination-changes.md) Flow and the [collectAsState](https://developer.android.com/reference/kotlin/androidx/compose/runtime/package-summary.html) function using the [ComposeNavigationDestinationState.currentDestination](../../../navigation-compose/com.chrynan.navigation.compose/-compose-navigation-destination-state/current-destination.md) as the initial value.

#### See also

common

| |
|---|
| [ComposeNavigationDestinationState.currentDestination](../../../navigation-compose/com.chrynan.navigation.compose/-compose-navigation-destination-state/current-destination.md) |
| [ComposeNavigationDestinationState.destinationChanges](../../../navigation-compose/com.chrynan.navigation.compose/-compose-navigation-destination-state/destination-changes.md) |
| [collectAsState](https://developer.android.com/reference/kotlin/androidx/compose/runtime/package-summary.html) |
