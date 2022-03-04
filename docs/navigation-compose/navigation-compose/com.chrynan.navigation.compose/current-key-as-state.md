//[navigation-compose](../../index.md)/[com.chrynan.navigation.compose](index.md)/[currentKeyAsState](current-key-as-state.md)

# currentKeyAsState

[common]\

@[ExperimentalNavigationApi](../../../navigation-core/navigation-core/com.chrynan.navigation/-experimental-navigation-api/index.md)

@Composable

fun &lt;[Key](current-key-as-state.md)&gt; [ComposeNavigator](-compose-navigator/index.md)&lt;[Key](current-key-as-state.md)&gt;.[currentKeyAsState](current-key-as-state.md)(initialCurrentKey: [Key](current-key-as-state.md)): State&lt;[Key](current-key-as-state.md)&gt;

@[ExperimentalNavigationApi](../../../navigation-core/navigation-core/com.chrynan.navigation/-experimental-navigation-api/index.md)

@Composable

fun &lt;[Key](current-key-as-state.md)&gt; [ComposeNavigator](-compose-navigator/index.md)&lt;[Key](current-key-as-state.md)&gt;.[currentKeyAsState](current-key-as-state.md)(): State&lt;[Key](current-key-as-state.md)&gt;

Obtains the changes to the [ComposeNavigator.currentKey](-compose-navigator/current-key.md) value and returns it as a State. This allows it to be used in a Composable and cause recomposition when the value changes.

If you just need to get the current key value and do not need to cause recomposition when the value changes, simply use the [ComposeNavigator.currentKey](-compose-navigator/current-key.md) property.

**Note:** Internally this function uses the [ComposeNavigator.keyChanges](-compose-navigator/key-changes.md) Flow and the collectAsState function using the [ComposeNavigator.currentKey](-compose-navigator/current-key.md) as the initial value.

## See also

common

| | |
|---|---|
| [com.chrynan.navigation.compose.ComposeNavigator](-compose-navigator/key-changes.md) |  |
| collectAsState |  |
