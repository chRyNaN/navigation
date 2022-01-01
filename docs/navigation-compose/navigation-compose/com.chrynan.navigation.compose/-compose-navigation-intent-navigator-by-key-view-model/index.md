//[navigation-compose](../../../index.md)/[com.chrynan.navigation.compose](../index.md)/[ComposeNavigationIntentNavigatorByKeyViewModel](index.md)

# ComposeNavigationIntentNavigatorByKeyViewModel

[common]\
@[ExperimentalNavigationApi](../-experimental-navigation-api/index.md)

class [ComposeNavigationIntentNavigatorByKeyViewModel](index.md)&lt;[Scope](index.md), [Intent](index.md) : [NavigationIntent](../../../../navigation-core/navigation-core/com.chrynan.navigation/-navigation-intent/index.md)&gt; : [BaseComposeNavigatorByKeyViewModel](../-base-compose-navigator-by-key-view-model/index.md)&lt;[Scope](index.md), [Intent](index.md), [ComposeNavigationIntentScope](../-compose-navigation-intent-scope/index.md)&lt;[Intent](index.md)&gt;&gt; , [ComposeNavigationIntentStackNavigatorByKey](../-compose-navigation-intent-stack-navigator-by-key/index.md)&lt;[Intent](index.md)&gt;

## Functions

| Name | Summary |
|---|---|
| [canGoBack](../-base-compose-navigator-by-key-view-model/can-go-back.md) | [common]<br>open override fun [canGoBack](../-base-compose-navigator-by-key-view-model/can-go-back.md)(): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [changeScope](../-base-compose-navigator-by-key-view-model/change-scope.md) | [common]<br>open override fun [changeScope](../-base-compose-navigator-by-key-view-model/change-scope.md)(to: [Scope](index.md)) |
| [goBack](../-base-compose-navigator-by-key-view-model/go-back.md) | [common]<br>open override fun [goBack](../-base-compose-navigator-by-key-view-model/go-back.md)(): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [goTo](index.md#-1944187993%2FFunctions%2F-1093353005) | [common]<br>open override fun [goTo](index.md#-1944187993%2FFunctions%2F-1093353005)(key: [Intent](index.md), strategy: [NavStackDuplicateContentStrategy](../../../../navigation-core/navigation-core/com.chrynan.navigation/-nav-stack-duplicate-content-strategy/index.md)) |
| [navigate](../-compose-navigation-intent-stack-navigator-by-key/navigate.md) | [common]<br>open override fun [navigate](../-compose-navigation-intent-stack-navigator-by-key/navigate.md)(event: [NavigationEvent](../../../../navigation-core/navigation-core/com.chrynan.navigation/-navigation-event/index.md)&lt;[Intent](index.md)&gt;) |
| [onGoBack](../-compose-navigation-intent-stack-navigator-by-key/on-go-back.md) | [common]<br>open override fun [ComposeNavigationIntentScope](../-compose-navigation-intent-scope/index.md)&lt;[Intent](index.md)&gt;.[onGoBack](../-compose-navigation-intent-stack-navigator-by-key/on-go-back.md)() |
| [onGoTo](../-compose-navigation-intent-stack-navigator-by-key/on-go-to.md) | [common]<br>open override fun [ComposeNavigationIntentScope](../-compose-navigation-intent-scope/index.md)&lt;[Intent](index.md)&gt;.[onGoTo](../-compose-navigation-intent-stack-navigator-by-key/on-go-to.md)(intent: [Intent](index.md)) |
| [onGoUp](../-compose-navigation-intent-stack-navigator-by-key/on-go-up.md) | [common]<br>open override fun [ComposeNavigationIntentScope](../-compose-navigation-intent-scope/index.md)&lt;[Intent](index.md)&gt;.[onGoUp](../-compose-navigation-intent-stack-navigator-by-key/on-go-up.md)() |
| [onNavigate](index.md#815856985%2FFunctions%2F-1093353005) | [common]<br>open override fun [ComposeNavigationIntentScope](../-compose-navigation-intent-scope/index.md)&lt;[Intent](index.md)&gt;.[onNavigate](index.md#815856985%2FFunctions%2F-1093353005)(event: [NavigationEvent](../../../../navigation-core/navigation-core/com.chrynan.navigation/-navigation-event/index.md)&lt;[Intent](index.md)&gt;) |

## Properties

| Name | Summary |
|---|---|
| [currentKey](../-base-compose-navigator-by-key-view-model/current-key.md) | [common]<br>open override val [currentKey](../-base-compose-navigator-by-key-view-model/current-key.md): [Intent](index.md) |
| [currentScope](../-base-compose-navigator-by-key-view-model/current-scope.md) | [common]<br>open override val [currentScope](../-base-compose-navigator-by-key-view-model/current-scope.md): [Scope](index.md) |
| [initialKey](../-base-compose-navigator-by-key-view-model/initial-key.md) | [common]<br>override val [initialKey](../-base-compose-navigator-by-key-view-model/initial-key.md): [Intent](index.md) |
| [initialScope](../-base-compose-navigator-by-key-view-model/initial-scope.md) | [common]<br>override val [initialScope](../-base-compose-navigator-by-key-view-model/initial-scope.md): [Scope](index.md) |
| [isInitialized](../-base-compose-navigator-by-key-view-model/is-initialized.md) | [common]<br>open override var [isInitialized](../-base-compose-navigator-by-key-view-model/is-initialized.md): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [keyChanges](../-base-compose-navigator-by-key-view-model/key-changes.md) | [common]<br>open override val [keyChanges](../-base-compose-navigator-by-key-view-model/key-changes.md): Flow&lt;[Intent](index.md)&gt; |
| [scopeChanges](../-base-compose-navigator-by-key-view-model/scope-changes.md) | [common]<br>open override val [scopeChanges](../-base-compose-navigator-by-key-view-model/scope-changes.md): Flow&lt;[Scope](index.md)&gt; |
