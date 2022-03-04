//[navigation-compose](../../../index.md)/[com.chrynan.navigation.compose](../index.md)/[ComposeNavigator](index.md)

# ComposeNavigator

[common]\
@[ExperimentalNavigationApi](../../../../navigation-core/navigation-core/com.chrynan.navigation/-experimental-navigation-api/index.md)

interface [ComposeNavigator](index.md)&lt;[Key](index.md)&gt; : [Navigator](../../../../navigation-core/navigation-core/com.chrynan.navigation/-navigator/index.md)

## Types

| Name | Summary |
|---|---|
| [Companion](-companion/index.md) | [common]<br>object [Companion](-companion/index.md) |

## Properties

| Name | Summary |
|---|---|
| [currentKey](current-key.md) | [common]<br>abstract val [currentKey](current-key.md): [Key](index.md) |
| [initialKey](initial-key.md) | [common]<br>abstract val [initialKey](initial-key.md): [Key](index.md) |
| [isInitialized](is-initialized.md) | [common]<br>abstract val [isInitialized](is-initialized.md): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [keyChanges](key-changes.md) | [common]<br>abstract val [keyChanges](key-changes.md): Flow&lt;[Key](index.md)&gt; |
| [keySaver](key-saver.md) | [common]<br>abstract val [keySaver](key-saver.md): [Saver](../-saver/index.md)&lt;[Key](index.md), [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)&gt; |

## Inheritors

| Name |
|---|
| [ComposeContextNavigator](../-compose-context-navigator/index.md) |
| [ComposeNavigatorByContent](../-compose-navigator-by-content/index.md) |
| [ComposeNavigatorByKey](../-compose-navigator-by-key/index.md) |

## Extensions

| Name | Summary |
|---|---|
| [currentKeyAsState](../current-key-as-state.md) | [common]<br>@[ExperimentalNavigationApi](../../../../navigation-core/navigation-core/com.chrynan.navigation/-experimental-navigation-api/index.md)<br>@Composable<br>fun &lt;[Key](../current-key-as-state.md)&gt; [ComposeNavigator](index.md)&lt;[Key](../current-key-as-state.md)&gt;.[currentKeyAsState](../current-key-as-state.md)(initialCurrentKey: [Key](../current-key-as-state.md)): State&lt;[Key](../current-key-as-state.md)&gt;<br>@[ExperimentalNavigationApi](../../../../navigation-core/navigation-core/com.chrynan.navigation/-experimental-navigation-api/index.md)<br>@Composable<br>fun &lt;[Key](../current-key-as-state.md)&gt; [ComposeNavigator](index.md)&lt;[Key](../current-key-as-state.md)&gt;.[currentKeyAsState](../current-key-as-state.md)(): State&lt;[Key](../current-key-as-state.md)&gt;<br>Obtains the changes to the [ComposeNavigator.currentKey](current-key.md) value and returns it as a State. This allows it to be used in a Composable and cause recomposition when the value changes. |
