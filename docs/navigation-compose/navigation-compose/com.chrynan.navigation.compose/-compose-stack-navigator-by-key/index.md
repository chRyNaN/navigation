//[navigation-compose](../../../index.md)/[com.chrynan.navigation.compose](../index.md)/[ComposeStackNavigatorByKey](index.md)

# ComposeStackNavigatorByKey

[common]\
@[ExperimentalNavigationApi](../-experimental-navigation-api/index.md)

interface [ComposeStackNavigatorByKey](index.md)&lt;[T](index.md)&gt; : [ComposeStackNavigator](../-compose-stack-navigator/index.md)&lt;[T](index.md)&gt; , [ComposeNavigatorByKey](../-compose-navigator-by-key/index.md)&lt;[T](index.md)&gt;

## Types

| Name | Summary |
|---|---|
| [Companion](-companion/index.md) | [common]<br>object [Companion](-companion/index.md) |

## Functions

| Name | Summary |
|---|---|
| [canGoBack](../-compose-stack-navigator/can-go-back.md) | [common]<br>abstract fun [canGoBack](../-compose-stack-navigator/can-go-back.md)(): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [goBack](../-compose-stack-navigator/go-back.md) | [common]<br>abstract fun [goBack](../-compose-stack-navigator/go-back.md)(): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [goTo](../-compose-navigator-by-key/go-to.md) | [common]<br>abstract fun [goTo](../-compose-navigator-by-key/go-to.md)(key: [T](index.md), strategy: [NavStackDuplicateContentStrategy](../../../../navigation-core/com.chrynan.navigation/-nav-stack-duplicate-content-strategy/index.md)) |

## Properties

| Name | Summary |
|---|---|
| [currentKey](../-compose-navigator/current-key.md) | [common]<br>abstract val [currentKey](../-compose-navigator/current-key.md): [T](index.md) |
| [initialKey](../-compose-navigator/initial-key.md) | [common]<br>abstract val [initialKey](../-compose-navigator/initial-key.md): [T](index.md) |
| [isInitialized](../-compose-navigator/is-initialized.md) | [common]<br>abstract val [isInitialized](../-compose-navigator/is-initialized.md): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [keyChanges](../-compose-navigator/key-changes.md) | [common]<br>abstract val [keyChanges](../-compose-navigator/key-changes.md): Flow&lt;[T](index.md)&gt; |

## Inheritors

| Name |
|---|
| [ComposeNavigationIntentStackNavigatorByKey](../-compose-navigation-intent-stack-navigator-by-key/index.md) |
| [BaseComposeNavigatorByKeyViewModel](../-base-compose-navigator-by-key-view-model/index.md) |
