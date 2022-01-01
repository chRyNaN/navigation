//[navigation-compose](../../../index.md)/[com.chrynan.navigation.compose](../index.md)/[BaseComposeNavigatorByContentViewModel](index.md)

# BaseComposeNavigatorByContentViewModel

[common]\
@[ExperimentalNavigationApi](../-experimental-navigation-api/index.md)

abstract class [BaseComposeNavigatorByContentViewModel](index.md)&lt;[Scope](index.md), [Key](index.md)&gt; : ViewModel, [ComposeNavigator](../-compose-navigator/index.md)&lt;[Key](index.md)&gt; , [ComposeNavigatorByContent](../-compose-navigator-by-content/index.md)&lt;[Key](index.md)&gt; , [ComposeStackNavigatorByContent](../-compose-stack-navigator-by-content/index.md)&lt;[Key](index.md)&gt; , [ComposeScopedNavigator](../-compose-scoped-navigator/index.md)&lt;[Scope](index.md), [Key](index.md)&gt;

## Functions

| Name | Summary |
|---|---|
| [canGoBack](../-compose-stack-navigator/can-go-back.md) | [common]<br>abstract fun [canGoBack](../-compose-stack-navigator/can-go-back.md)(): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [changeScope](../-compose-scoped-navigator/change-scope.md) | [common]<br>abstract fun [changeScope](../-compose-scoped-navigator/change-scope.md)(to: [Scope](index.md)) |
| [goBack](../-compose-stack-navigator/go-back.md) | [common]<br>abstract fun [goBack](../-compose-stack-navigator/go-back.md)(): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [goTo](../-compose-navigator-by-content/go-to.md) | [common]<br>@Composable<br>abstract fun [goTo](../-compose-navigator-by-content/go-to.md)(key: [Key](index.md), strategy: [NavStackDuplicateContentStrategy](../../../../navigation-core/navigation-core/com.chrynan.navigation/-nav-stack-duplicate-content-strategy/index.md), content: @Composable[ComposeNavigationContentScope](../-compose-navigation-content-scope/index.md)&lt;[Key](index.md)&gt;.() -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)) |

## Properties

| Name | Summary |
|---|---|
| [currentKey](../-compose-navigator/current-key.md) | [common]<br>abstract val [currentKey](../-compose-navigator/current-key.md): [Key](index.md) |
| [currentScope](../-compose-scoped-navigator/current-scope.md) | [common]<br>abstract val [currentScope](../-compose-scoped-navigator/current-scope.md): [Scope](index.md) |
| [initialKey](../-compose-navigator/initial-key.md) | [common]<br>abstract val [initialKey](../-compose-navigator/initial-key.md): [Key](index.md) |
| [initialScope](../-compose-scoped-navigator/initial-scope.md) | [common]<br>abstract val [initialScope](../-compose-scoped-navigator/initial-scope.md): [Scope](index.md) |
| [isInitialized](../-compose-navigator/is-initialized.md) | [common]<br>abstract val [isInitialized](../-compose-navigator/is-initialized.md): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [keyChanges](../-compose-navigator/key-changes.md) | [common]<br>abstract val [keyChanges](../-compose-navigator/key-changes.md): Flow&lt;[Key](index.md)&gt; |
| [scopeChanges](../-compose-scoped-navigator/scope-changes.md) | [common]<br>abstract val [scopeChanges](../-compose-scoped-navigator/scope-changes.md): Flow&lt;[Scope](index.md)&gt; |

## Inheritors

| Name |
|---|
| [ComposeNavigatorByContentViewModel](../-compose-navigator-by-content-view-model/index.md) |
