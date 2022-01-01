//[navigation-compose](../../../index.md)/[com.chrynan.navigation.compose](../index.md)/[ComposeNavigatorByKey](index.md)

# ComposeNavigatorByKey

[common]\
@[ExperimentalNavigationApi](../-experimental-navigation-api/index.md)

interface [ComposeNavigatorByKey](index.md)&lt;[T](index.md)&gt; : [ComposeNavigator](../-compose-navigator/index.md)&lt;[T](index.md)&gt;

## Types

| Name | Summary |
|---|---|
| [Companion](-companion/index.md) | [common]<br>object [Companion](-companion/index.md) |

## Functions

| Name | Summary |
|---|---|
| [goTo](go-to.md) | [common]<br>abstract fun [goTo](go-to.md)(key: [T](index.md), strategy: [NavStackDuplicateContentStrategy](../../../../navigation-core/navigation-core/com.chrynan.navigation/-nav-stack-duplicate-content-strategy/index.md)) |

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
| [ComposeStackNavigatorByKey](../-compose-stack-navigator-by-key/index.md) |
| [BaseComposeNavigatorByKeyViewModel](../-base-compose-navigator-by-key-view-model/index.md) |

## Extensions

| Name | Summary |
|---|---|
| [goTo](../go-to.md) | [common]<br>@[ExperimentalNavigationApi](../-experimental-navigation-api/index.md)<br>fun &lt;[T](../go-to.md)&gt; [ComposeNavigatorByKey](index.md)&lt;[T](../go-to.md)&gt;.[goTo](../go-to.md)(key: [T](../go-to.md)) |
