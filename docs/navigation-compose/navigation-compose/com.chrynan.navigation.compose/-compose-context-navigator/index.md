//[navigation-compose](../../../index.md)/[com.chrynan.navigation.compose](../index.md)/[ComposeContextNavigator](index.md)

# ComposeContextNavigator

[common]\
@[ExperimentalNavigationApi](../../../../navigation-core/navigation-core/com.chrynan.navigation/-experimental-navigation-api/index.md)

interface [ComposeContextNavigator](index.md)&lt;[Context](index.md), [Key](index.md)&gt; : [ComposeNavigator](../-compose-navigator/index.md)&lt;[Key](index.md)&gt;

## Types

| Name | Summary |
|---|---|
| [Companion](-companion/index.md) | [common]<br>object [Companion](-companion/index.md) |

## Functions

| Name | Summary |
|---|---|
| [changeContext](change-context.md) | [common]<br>abstract fun [changeContext](change-context.md)(to: [Context](index.md)) |

## Properties

| Name | Summary |
|---|---|
| [contextChanges](context-changes.md) | [common]<br>abstract val [contextChanges](context-changes.md): Flow&lt;[Context](index.md)&gt; |
| [currentContext](current-context.md) | [common]<br>abstract val [currentContext](current-context.md): [Context](index.md) |
| [currentKey](../-compose-navigator/current-key.md) | [common]<br>abstract val [currentKey](../-compose-navigator/current-key.md): [Key](index.md) |
| [initialContext](initial-context.md) | [common]<br>abstract val [initialContext](initial-context.md): [Context](index.md) |
| [initialKey](../-compose-navigator/initial-key.md) | [common]<br>abstract val [initialKey](../-compose-navigator/initial-key.md): [Key](index.md) |
| [isInitialized](../-compose-navigator/is-initialized.md) | [common]<br>abstract val [isInitialized](../-compose-navigator/is-initialized.md): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [keyChanges](../-compose-navigator/key-changes.md) | [common]<br>abstract val [keyChanges](../-compose-navigator/key-changes.md): Flow&lt;[Key](index.md)&gt; |
| [keySaver](../-compose-navigator/key-saver.md) | [common]<br>abstract val [keySaver](../-compose-navigator/key-saver.md): [Saver](../-saver/index.md)&lt;[Key](index.md), [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)&gt; |

## Inheritors

| Name |
|---|
| [ComposeNavigatorByContent](../-compose-navigator-by-content/index.md) |
| [ComposeNavigatorByKey](../-compose-navigator-by-key/index.md) |

## Extensions

| Name | Summary |
|---|---|
| [currentContextAsState](../current-context-as-state.md) | [common]<br>@[ExperimentalNavigationApi](../../../../navigation-core/navigation-core/com.chrynan.navigation/-experimental-navigation-api/index.md)<br>@Composable<br>fun &lt;[Context](../current-context-as-state.md), [Key](../current-context-as-state.md)&gt; [ComposeContextNavigator](index.md)&lt;[Context](../current-context-as-state.md), [Key](../current-context-as-state.md)&gt;.[currentContextAsState](../current-context-as-state.md)(initialCurrentContext: [Context](../current-context-as-state.md)): State&lt;[Context](../current-context-as-state.md)&gt;<br>@[ExperimentalNavigationApi](../../../../navigation-core/navigation-core/com.chrynan.navigation/-experimental-navigation-api/index.md)<br>@Composable<br>fun &lt;[Context](../current-context-as-state.md), [Key](../current-context-as-state.md)&gt; [ComposeContextNavigator](index.md)&lt;[Context](../current-context-as-state.md), [Key](../current-context-as-state.md)&gt;.[currentContextAsState](../current-context-as-state.md)(): State&lt;[Context](../current-context-as-state.md)&gt;<br>Obtains the changes to the [ComposeContextNavigator.currentContext](current-context.md) value and returns it as a State. This allows it to be used in a Composable and cause recomposition when the value changes. |
