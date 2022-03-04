//[navigation-compose](../../index.md)/[com.chrynan.navigation.compose](index.md)/[currentContextAsState](current-context-as-state.md)

# currentContextAsState

[common]\

@[ExperimentalNavigationApi](../../../navigation-core/navigation-core/com.chrynan.navigation/-experimental-navigation-api/index.md)

@Composable

fun &lt;[Context](current-context-as-state.md), [Key](current-context-as-state.md)&gt; [ComposeContextNavigator](-compose-context-navigator/index.md)&lt;[Context](current-context-as-state.md), [Key](current-context-as-state.md)&gt;.[currentContextAsState](current-context-as-state.md)(initialCurrentContext: [Context](current-context-as-state.md)): State&lt;[Context](current-context-as-state.md)&gt;

@[ExperimentalNavigationApi](../../../navigation-core/navigation-core/com.chrynan.navigation/-experimental-navigation-api/index.md)

@Composable

fun &lt;[Context](current-context-as-state.md), [Key](current-context-as-state.md)&gt; [ComposeContextNavigator](-compose-context-navigator/index.md)&lt;[Context](current-context-as-state.md), [Key](current-context-as-state.md)&gt;.[currentContextAsState](current-context-as-state.md)(): State&lt;[Context](current-context-as-state.md)&gt;

Obtains the changes to the [ComposeContextNavigator.currentContext](-compose-context-navigator/current-context.md) value and returns it as a State. This allows it to be used in a Composable and cause recomposition when the value changes.

If you just need to get the current scope value and do not need to cause recomposition when the value changes, simply use the [ComposeContextNavigator.currentContext](-compose-context-navigator/current-context.md) property.

**Note:** Internally this function uses the [ComposeContextNavigator.contextChanges](-compose-context-navigator/context-changes.md) Flow and the collectAsState function using the [ComposeContextNavigator.currentContext](-compose-context-navigator/current-context.md) as the initial value.

## See also

common

| | |
|---|---|
| [com.chrynan.navigation.compose.ComposeContextNavigator](-compose-context-navigator/context-changes.md) |  |
| collectAsState |  |
