//[navigation-compose](../../../index.md)/[com.chrynan.navigation.compose](../index.md)/[ComposeNavigationDestinationState](index.md)

# ComposeNavigationDestinationState

[common]\
@[ExperimentalNavigationApi](../../../../navigation-core/navigation-core/com.chrynan.navigation/-experimental-navigation-api/index.md)

interface [ComposeNavigationDestinationState](index.md)&lt;[Destination](index.md) : [NavigationDestination](../../../../navigation-core/com.chrynan.navigation/-navigation-destination/index.md)&gt; : [NavigationDestinationState](../../../../navigation-core/navigation-core/com.chrynan.navigation/-navigation-destination-state/index.md)&lt;[Destination](index.md)&gt;

## Types

| Name | Summary |
|---|---|
| [Companion](-companion/index.md) | [common]<br>object [Companion](-companion/index.md) |

## Properties

| Name | Summary |
|---|---|
| [currentDestination](../-compose-navigator-state/index.md#1047421983%2FProperties%2F-1093353005) | [common]<br>abstract val [currentDestination](../-compose-navigator-state/index.md#1047421983%2FProperties%2F-1093353005): [Destination](index.md) |
| [destinationChanges](../-compose-navigator-state/index.md#1416376863%2FProperties%2F-1093353005) | [common]<br>abstract val [destinationChanges](../-compose-navigator-state/index.md#1416376863%2FProperties%2F-1093353005): Flow&lt;[Destination](index.md)&gt; |
| [initialDestination](../-compose-navigator-state/index.md#-1134545814%2FProperties%2F-1093353005) | [common]<br>abstract val [initialDestination](../-compose-navigator-state/index.md#-1134545814%2FProperties%2F-1093353005): [Destination](index.md) |

## Inheritors

| Name |
|---|
| [ComposeNavigatorState](../-compose-navigator-state/index.md) |

## Extensions

| Name | Summary |
|---|---|
| [currentDestinationAsState](../current-destination-as-state.md) | [common]<br>@[ExperimentalNavigationApi](../../../../navigation-core/navigation-core/com.chrynan.navigation/-experimental-navigation-api/index.md)<br>@[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)<br>fun &lt;[Destination](../current-destination-as-state.md) : [NavigationDestination](../../../../navigation-core/com.chrynan.navigation/-navigation-destination/index.md)&gt; [NavigationDestinationState](../../../../navigation-core/navigation-core/com.chrynan.navigation/-navigation-destination-state/index.md)&lt;[Destination](../current-destination-as-state.md)&gt;.[currentDestinationAsState](../current-destination-as-state.md)(initialCurrentKey: [Destination](../current-destination-as-state.md)): [State](https://developer.android.com/reference/kotlin/androidx/compose/runtime/State.html)&lt;[Destination](../current-destination-as-state.md)&gt;<br>@[ExperimentalNavigationApi](../../../../navigation-core/navigation-core/com.chrynan.navigation/-experimental-navigation-api/index.md)<br>@[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)<br>fun &lt;[Destination](../current-destination-as-state.md) : [NavigationDestination](../../../../navigation-core/com.chrynan.navigation/-navigation-destination/index.md)&gt; [NavigationDestinationState](../../../../navigation-core/navigation-core/com.chrynan.navigation/-navigation-destination-state/index.md)&lt;[Destination](../current-destination-as-state.md)&gt;.[currentDestinationAsState](../current-destination-as-state.md)(): [State](https://developer.android.com/reference/kotlin/androidx/compose/runtime/State.html)&lt;[Destination](../current-destination-as-state.md)&gt;<br>Obtains the changes to the [ComposeNavigationDestinationState.currentDestination](../../../../navigation-compose/com.chrynan.navigation.compose/-compose-navigation-destination-state/current-destination.md) value and returns it as a [State](https://developer.android.com/reference/kotlin/androidx/compose/runtime/State.html). This allows it to be used in a [Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html) and cause recomposition when the value changes. |
