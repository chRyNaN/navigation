//[navigation-compose](../../../index.md)/[com.chrynan.navigation.compose](../index.md)/[ComposeNavigator](index.md)

# ComposeNavigator

[common]\
@[ExperimentalNavigationApi](../-experimental-navigation-api/index.md)

interface [ComposeNavigator](index.md)&lt;[T](index.md)&gt; : [Navigator](../../../../navigation-core/navigation-core/com.chrynan.navigation/-navigator/index.md)

## Types

| Name | Summary |
|---|---|
| [Companion](-companion/index.md) | [common]<br>object [Companion](-companion/index.md) |

## Properties

| Name | Summary |
|---|---|
| [currentKey](current-key.md) | [common]<br>abstract val [currentKey](current-key.md): [T](index.md) |
| [initialKey](initial-key.md) | [common]<br>abstract val [initialKey](initial-key.md): [T](index.md) |
| [isInitialized](is-initialized.md) | [common]<br>abstract val [isInitialized](is-initialized.md): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [keyChanges](key-changes.md) | [common]<br>abstract val [keyChanges](key-changes.md): Flow&lt;[T](index.md)&gt; |

## Inheritors

| Name |
|---|
| [ComposeNavigatorByContent](../-compose-navigator-by-content/index.md) |
| [ComposeNavigatorByKey](../-compose-navigator-by-key/index.md) |
| [ComposeStackNavigator](../-compose-stack-navigator/index.md) |
| [ComposeScopedNavigator](../-compose-scoped-navigator/index.md) |
| [BaseComposeNavigatorByContentViewModel](../-base-compose-navigator-by-content-view-model/index.md) |
| [BaseComposeNavigatorByKeyViewModel](../-base-compose-navigator-by-key-view-model/index.md) |

## Extensions

| Name | Summary |
|---|---|
| [currentKeyAsState](../current-key-as-state.md) | [common]<br>@[ExperimentalNavigationApi](../-experimental-navigation-api/index.md)<br>@Composable<br>fun &lt;[Key](../current-key-as-state.md)&gt; [ComposeNavigator](index.md)&lt;[Key](../current-key-as-state.md)&gt;.[currentKeyAsState](../current-key-as-state.md)(initialCurrentKey: [Key](../current-key-as-state.md)): State&lt;[Key](../current-key-as-state.md)&gt;<br>@[ExperimentalNavigationApi](../-experimental-navigation-api/index.md)<br>@Composable<br>fun &lt;[Key](../current-key-as-state.md)&gt; [ComposeNavigator](index.md)&lt;[Key](../current-key-as-state.md)&gt;.[currentKeyAsState](../current-key-as-state.md)(): State&lt;[Key](../current-key-as-state.md)&gt;<br>Obtains the changes to the [ComposeNavigator.currentKey](current-key.md) value and returns it as a State. This allows it to be used in a Composable and cause recomposition when the value changes. |
