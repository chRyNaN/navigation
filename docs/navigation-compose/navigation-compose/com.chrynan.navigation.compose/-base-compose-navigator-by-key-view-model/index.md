//[navigation-compose](../../../index.md)/[com.chrynan.navigation.compose](../index.md)/[BaseComposeNavigatorByKeyViewModel](index.md)

# BaseComposeNavigatorByKeyViewModel

[common]\
@[ExperimentalNavigationApi](../-experimental-navigation-api/index.md)

abstract class [BaseComposeNavigatorByKeyViewModel](index.md)&lt;[Scope](index.md), [Key](index.md), [NavigationScope](index.md) : [ComposeNavigationKeyScope](../-compose-navigation-key-scope/index.md)&lt;[Key](index.md)&gt;&gt;(initialScope: [Scope](index.md), initialKeys: ([Scope](index.md)) -&gt; [Key](index.md)) : ViewModel, [ComposeNavigator](../-compose-navigator/index.md)&lt;[Key](index.md)&gt; , [ComposeNavigatorByKey](../-compose-navigator-by-key/index.md)&lt;[Key](index.md)&gt; , [ComposeStackNavigatorByKey](../-compose-stack-navigator-by-key/index.md)&lt;[Key](index.md)&gt; , [ComposeScopedNavigator](../-compose-scoped-navigator/index.md)&lt;[Scope](index.md), [Key](index.md)&gt;

## Functions

| Name | Summary |
|---|---|
| [canGoBack](can-go-back.md) | [common]<br>open override fun [canGoBack](can-go-back.md)(): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [changeScope](change-scope.md) | [common]<br>open override fun [changeScope](change-scope.md)(to: [Scope](index.md)) |
| [goBack](go-back.md) | [common]<br>open override fun [goBack](go-back.md)(): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [goTo](go-to.md) | [common]<br>open override fun [goTo](go-to.md)(key: [Key](index.md), strategy: [NavStackDuplicateContentStrategy](../../../../navigation-core/navigation-core/com.chrynan.navigation/-nav-stack-duplicate-content-strategy/index.md)) |

## Properties

| Name | Summary |
|---|---|
| [currentKey](current-key.md) | [common]<br>open override val [currentKey](current-key.md): [Key](index.md) |
| [currentScope](current-scope.md) | [common]<br>open override val [currentScope](current-scope.md): [Scope](index.md) |
| [initialKey](initial-key.md) | [common]<br>override val [initialKey](initial-key.md): [Key](index.md) |
| [initialScope](initial-scope.md) | [common]<br>override val [initialScope](initial-scope.md): [Scope](index.md) |
| [isInitialized](is-initialized.md) | [common]<br>open override var [isInitialized](is-initialized.md): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = false |
| [keyChanges](key-changes.md) | [common]<br>open override val [keyChanges](key-changes.md): Flow&lt;[Key](index.md)&gt; |
| [scopeChanges](scope-changes.md) | [common]<br>open override val [scopeChanges](scope-changes.md): Flow&lt;[Scope](index.md)&gt; |

## Inheritors

| Name |
|---|
| [ComposeNavigationIntentNavigatorByKeyViewModel](../-compose-navigation-intent-navigator-by-key-view-model/index.md) |
| [ComposeNavigatorByKeyViewModel](../-compose-navigator-by-key-view-model/index.md) |
