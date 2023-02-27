//[navigation-compose](../../index.md)/[com.chrynan.navigation.compose](index.md)/[currentContextAsState](current-context-as-state.md)

# currentContextAsState

[common]\

@[ExperimentalNavigationApi](../../../navigation-core/navigation-core/com.chrynan.navigation/-experimental-navigation-api/index.md)

@[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)

fun &lt;[Destination](current-context-as-state.md) : [NavigationDestination](../../../navigation-core/com.chrynan.navigation/-navigation-destination/index.md), [Context](current-context-as-state.md) : [NavigationContext](../../../navigation-core/navigation-core/com.chrynan.navigation/-navigation-context/index.md)&lt;[Destination](current-context-as-state.md)&gt;&gt; [NavigationContextState](../../../navigation-core/navigation-core/com.chrynan.navigation/-navigation-context-state/index.md)&lt;[Destination](current-context-as-state.md), [Context](current-context-as-state.md)&gt;.[currentContextAsState](current-context-as-state.md)(initialCurrentContext: [Context](current-context-as-state.md)): [State](https://developer.android.com/reference/kotlin/androidx/compose/runtime/State.html)&lt;[Context](current-context-as-state.md)&gt;

@[ExperimentalNavigationApi](../../../navigation-core/navigation-core/com.chrynan.navigation/-experimental-navigation-api/index.md)

@[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)

fun &lt;[Destination](current-context-as-state.md) : [NavigationDestination](../../../navigation-core/com.chrynan.navigation/-navigation-destination/index.md), [Context](current-context-as-state.md) : [NavigationContext](../../../navigation-core/navigation-core/com.chrynan.navigation/-navigation-context/index.md)&lt;[Destination](current-context-as-state.md)&gt;&gt; [NavigationContextState](../../../navigation-core/navigation-core/com.chrynan.navigation/-navigation-context-state/index.md)&lt;[Destination](current-context-as-state.md), [Context](current-context-as-state.md)&gt;.[currentContextAsState](current-context-as-state.md)(): [State](https://developer.android.com/reference/kotlin/androidx/compose/runtime/State.html)&lt;[Context](current-context-as-state.md)&gt;

Obtains the changes to the [ComposeNavigationContextState.currentContext](../../../navigation-compose/com.chrynan.navigation.compose/-compose-navigation-context-state/current-context.md) value and returns it as a [State](https://developer.android.com/reference/kotlin/androidx/compose/runtime/State.html). This allows it to be used in a [Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html) and cause recomposition when the value changes.

If you just need to get the current scope value and do not need to cause recomposition when the value changes, simply use the [ComposeNavigationContextState.currentContext](../../../navigation-compose/com.chrynan.navigation.compose/-compose-navigation-context-state/current-context.md) property.

**Note:** Internally this function uses the [ComposeNavigationContextState.contextChanges](../../../navigation-compose/com.chrynan.navigation.compose/-compose-navigation-context-state/context-changes.md) Flow and the [collectAsState](https://developer.android.com/reference/kotlin/androidx/compose/runtime/package-summary.html) function using the [ComposeNavigationContextState.currentContext](../../../navigation-compose/com.chrynan.navigation.compose/-compose-navigation-context-state/current-context.md) as the initial value.

#### See also

common

| |
|---|
| [ComposeNavigationContextState.currentContext](../../../navigation-compose/com.chrynan.navigation.compose/-compose-navigation-context-state/current-context.md) |
| [ComposeNavigationContextState.contextChanges](../../../navigation-compose/com.chrynan.navigation.compose/-compose-navigation-context-state/context-changes.md) |
| [collectAsState](https://developer.android.com/reference/kotlin/androidx/compose/runtime/package-summary.html) |
