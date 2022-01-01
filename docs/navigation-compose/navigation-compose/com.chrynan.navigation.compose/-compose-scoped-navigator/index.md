//[navigation-compose](../../../index.md)/[com.chrynan.navigation.compose](../index.md)/[ComposeScopedNavigator](index.md)

# ComposeScopedNavigator

[common]\
@[ExperimentalNavigationApi](../-experimental-navigation-api/index.md)

interface [ComposeScopedNavigator](index.md)&lt;[Scope](index.md), [Key](index.md)&gt; : [ComposeNavigator](../-compose-navigator/index.md)&lt;[Key](index.md)&gt;

## Types

| Name | Summary |
|---|---|
| [Companion](-companion/index.md) | [common]<br>object [Companion](-companion/index.md) |

## Functions

| Name | Summary |
|---|---|
| [changeScope](change-scope.md) | [common]<br>abstract fun [changeScope](change-scope.md)(to: [Scope](index.md)) |

## Properties

| Name | Summary |
|---|---|
| [currentKey](../-compose-navigator/current-key.md) | [common]<br>abstract val [currentKey](../-compose-navigator/current-key.md): [Key](index.md) |
| [currentScope](current-scope.md) | [common]<br>abstract val [currentScope](current-scope.md): [Scope](index.md) |
| [initialKey](../-compose-navigator/initial-key.md) | [common]<br>abstract val [initialKey](../-compose-navigator/initial-key.md): [Key](index.md) |
| [initialScope](initial-scope.md) | [common]<br>abstract val [initialScope](initial-scope.md): [Scope](index.md) |
| [isInitialized](../-compose-navigator/is-initialized.md) | [common]<br>abstract val [isInitialized](../-compose-navigator/is-initialized.md): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [keyChanges](../-compose-navigator/key-changes.md) | [common]<br>abstract val [keyChanges](../-compose-navigator/key-changes.md): Flow&lt;[Key](index.md)&gt; |
| [scopeChanges](scope-changes.md) | [common]<br>abstract val [scopeChanges](scope-changes.md): Flow&lt;[Scope](index.md)&gt; |

## Inheritors

| Name |
|---|
| [BaseComposeNavigatorByContentViewModel](../-base-compose-navigator-by-content-view-model/index.md) |
| [BaseComposeNavigatorByKeyViewModel](../-base-compose-navigator-by-key-view-model/index.md) |

## Extensions

| Name | Summary |
|---|---|
| [currentScopeAsState](../current-scope-as-state.md) | [common]<br>@[ExperimentalNavigationApi](../-experimental-navigation-api/index.md)<br>@Composable<br>fun &lt;[Scope](../current-scope-as-state.md), [Key](../current-scope-as-state.md)&gt; [ComposeScopedNavigator](index.md)&lt;[Scope](../current-scope-as-state.md), [Key](../current-scope-as-state.md)&gt;.[currentScopeAsState](../current-scope-as-state.md)(initialCurrentScope: [Scope](../current-scope-as-state.md)): State&lt;[Scope](../current-scope-as-state.md)&gt;<br>@[ExperimentalNavigationApi](../-experimental-navigation-api/index.md)<br>@Composable<br>fun &lt;[Scope](../current-scope-as-state.md), [Key](../current-scope-as-state.md)&gt; [ComposeScopedNavigator](index.md)&lt;[Scope](../current-scope-as-state.md), [Key](../current-scope-as-state.md)&gt;.[currentScopeAsState](../current-scope-as-state.md)(): State&lt;[Scope](../current-scope-as-state.md)&gt;<br>Obtains the changes to the [ComposeScopedNavigator.currentScope](current-scope.md) value and returns it as a State. This allows it to be used in a Composable and cause recomposition when the value changes. |
