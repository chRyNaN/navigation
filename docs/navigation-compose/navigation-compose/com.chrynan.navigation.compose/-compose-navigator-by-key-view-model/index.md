//[navigation-compose](../../../index.md)/[com.chrynan.navigation.compose](../index.md)/[ComposeNavigatorByKeyViewModel](index.md)

# ComposeNavigatorByKeyViewModel

[common]\
@[ExperimentalNavigationApi](../-experimental-navigation-api/index.md)

class [ComposeNavigatorByKeyViewModel](index.md)&lt;[Scope](index.md), [Key](index.md)&gt; : [BaseComposeNavigatorByKeyViewModel](../-base-compose-navigator-by-key-view-model/index.md)&lt;[Scope](index.md), [Key](index.md), [ComposeNavigationKeyScope](../-compose-navigation-key-scope/index.md)&lt;[Key](index.md)&gt;&gt;

## Functions

| Name | Summary |
|---|---|
| [canGoBack](../-base-compose-navigator-by-key-view-model/can-go-back.md) | [common]<br>open override fun [canGoBack](../-base-compose-navigator-by-key-view-model/can-go-back.md)(): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [changeScope](../-base-compose-navigator-by-key-view-model/change-scope.md) | [common]<br>open override fun [changeScope](../-base-compose-navigator-by-key-view-model/change-scope.md)(to: [Scope](index.md)) |
| [goBack](../-base-compose-navigator-by-key-view-model/go-back.md) | [common]<br>open override fun [goBack](../-base-compose-navigator-by-key-view-model/go-back.md)(): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [goTo](../-base-compose-navigator-by-key-view-model/go-to.md) | [common]<br>open override fun [goTo](../-base-compose-navigator-by-key-view-model/go-to.md)(key: [Key](index.md), strategy: [NavStackDuplicateContentStrategy](../../../../navigation-core/navigation-core/com.chrynan.navigation/-nav-stack-duplicate-content-strategy/index.md)) |

## Properties

| Name | Summary |
|---|---|
| [currentKey](../-base-compose-navigator-by-key-view-model/current-key.md) | [common]<br>open override val [currentKey](../-base-compose-navigator-by-key-view-model/current-key.md): [Key](index.md) |
| [currentScope](../-base-compose-navigator-by-key-view-model/current-scope.md) | [common]<br>open override val [currentScope](../-base-compose-navigator-by-key-view-model/current-scope.md): [Scope](index.md) |
| [initialKey](../-base-compose-navigator-by-key-view-model/initial-key.md) | [common]<br>override val [initialKey](../-base-compose-navigator-by-key-view-model/initial-key.md): [Key](index.md) |
| [initialScope](../-base-compose-navigator-by-key-view-model/initial-scope.md) | [common]<br>override val [initialScope](../-base-compose-navigator-by-key-view-model/initial-scope.md): [Scope](index.md) |
| [isInitialized](../-base-compose-navigator-by-key-view-model/is-initialized.md) | [common]<br>open override var [isInitialized](../-base-compose-navigator-by-key-view-model/is-initialized.md): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [keyChanges](../-base-compose-navigator-by-key-view-model/key-changes.md) | [common]<br>open override val [keyChanges](../-base-compose-navigator-by-key-view-model/key-changes.md): Flow&lt;[Key](index.md)&gt; |
| [scopeChanges](../-base-compose-navigator-by-key-view-model/scope-changes.md) | [common]<br>open override val [scopeChanges](../-base-compose-navigator-by-key-view-model/scope-changes.md): Flow&lt;[Scope](index.md)&gt; |
