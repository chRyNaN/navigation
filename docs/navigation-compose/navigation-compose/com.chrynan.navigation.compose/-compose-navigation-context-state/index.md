//[navigation-compose](../../../index.md)/[com.chrynan.navigation.compose](../index.md)/[ComposeNavigationContextState](index.md)

# ComposeNavigationContextState

[common]\
@[ExperimentalNavigationApi](../../../../navigation-core/navigation-core/com.chrynan.navigation/-experimental-navigation-api/index.md)

interface [ComposeNavigationContextState](index.md)&lt;[Destination](index.md) : [NavigationDestination](../../../../navigation-core/com.chrynan.navigation/-navigation-destination/index.md), [Context](index.md) : [NavigationContext](../../../../navigation-core/navigation-core/com.chrynan.navigation/-navigation-context/index.md)&lt;[Destination](index.md)&gt;&gt; : [NavigationContextState](../../../../navigation-core/navigation-core/com.chrynan.navigation/-navigation-context-state/index.md)&lt;[Destination](index.md), [Context](index.md)&gt;

## Types

| Name | Summary |
|---|---|
| [Companion](-companion/index.md) | [common]<br>object [Companion](-companion/index.md) |

## Properties

| Name | Summary |
|---|---|
| [contextChanges](../-compose-navigator-state/index.md#-1880294209%2FProperties%2F-1093353005) | [common]<br>abstract val [contextChanges](../-compose-navigator-state/index.md#-1880294209%2FProperties%2F-1093353005): Flow&lt;[Context](index.md)&gt; |
| [currentContext](../-compose-navigator-state/index.md#-822285539%2FProperties%2F-1093353005) | [common]<br>abstract val [currentContext](../-compose-navigator-state/index.md#-822285539%2FProperties%2F-1093353005): [Context](index.md) |
| [initialContext](../-compose-navigator-state/index.md#-1520396056%2FProperties%2F-1093353005) | [common]<br>abstract val [initialContext](../-compose-navigator-state/index.md#-1520396056%2FProperties%2F-1093353005): [Context](index.md) |

## Inheritors

| Name |
|---|
| [ComposeNavigatorState](../-compose-navigator-state/index.md) |

## Extensions

| Name | Summary |
|---|---|
| [currentContextAsState](../current-context-as-state.md) | [common]<br>@[ExperimentalNavigationApi](../../../../navigation-core/navigation-core/com.chrynan.navigation/-experimental-navigation-api/index.md)<br>@[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)<br>fun &lt;[Destination](../current-context-as-state.md) : [NavigationDestination](../../../../navigation-core/com.chrynan.navigation/-navigation-destination/index.md), [Context](../current-context-as-state.md) : [NavigationContext](../../../../navigation-core/navigation-core/com.chrynan.navigation/-navigation-context/index.md)&lt;[Destination](../current-context-as-state.md)&gt;&gt; [NavigationContextState](../../../../navigation-core/navigation-core/com.chrynan.navigation/-navigation-context-state/index.md)&lt;[Destination](../current-context-as-state.md), [Context](../current-context-as-state.md)&gt;.[currentContextAsState](../current-context-as-state.md)(initialCurrentContext: [Context](../current-context-as-state.md)): [State](https://developer.android.com/reference/kotlin/androidx/compose/runtime/State.html)&lt;[Context](../current-context-as-state.md)&gt;<br>@[ExperimentalNavigationApi](../../../../navigation-core/navigation-core/com.chrynan.navigation/-experimental-navigation-api/index.md)<br>@[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)<br>fun &lt;[Destination](../current-context-as-state.md) : [NavigationDestination](../../../../navigation-core/com.chrynan.navigation/-navigation-destination/index.md), [Context](../current-context-as-state.md) : [NavigationContext](../../../../navigation-core/navigation-core/com.chrynan.navigation/-navigation-context/index.md)&lt;[Destination](../current-context-as-state.md)&gt;&gt; [NavigationContextState](../../../../navigation-core/navigation-core/com.chrynan.navigation/-navigation-context-state/index.md)&lt;[Destination](../current-context-as-state.md), [Context](../current-context-as-state.md)&gt;.[currentContextAsState](../current-context-as-state.md)(): [State](https://developer.android.com/reference/kotlin/androidx/compose/runtime/State.html)&lt;[Context](../current-context-as-state.md)&gt;<br>Obtains the changes to the [ComposeNavigationContextState.currentContext](../../../../navigation-compose/com.chrynan.navigation.compose/-compose-navigation-context-state/current-context.md) value and returns it as a [State](https://developer.android.com/reference/kotlin/androidx/compose/runtime/State.html). This allows it to be used in a [Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html) and cause recomposition when the value changes. |
