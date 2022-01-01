//[navigation-compose](../../../index.md)/[com.chrynan.navigation.compose](../index.md)/[ComposeNavigatorByContent](index.md)

# ComposeNavigatorByContent

[common]\
@[ExperimentalNavigationApi](../-experimental-navigation-api/index.md)

interface [ComposeNavigatorByContent](index.md)&lt;[T](index.md)&gt; : [ComposeNavigator](../-compose-navigator/index.md)&lt;[T](index.md)&gt;

## Types

| Name | Summary |
|---|---|
| [Companion](-companion/index.md) | [common]<br>object [Companion](-companion/index.md) |

## Functions

| Name | Summary |
|---|---|
| [goTo](go-to.md) | [common]<br>@Composable<br>abstract fun [goTo](go-to.md)(key: [T](index.md), strategy: [NavStackDuplicateContentStrategy](../../../../navigation-core/navigation-core/com.chrynan.navigation/-nav-stack-duplicate-content-strategy/index.md), content: @Composable[ComposeNavigationContentScope](../-compose-navigation-content-scope/index.md)&lt;[T](index.md)&gt;.() -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)) |

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
| [ComposeStackNavigatorByContent](../-compose-stack-navigator-by-content/index.md) |
| [BaseComposeNavigatorByContentViewModel](../-base-compose-navigator-by-content-view-model/index.md) |

## Extensions

| Name | Summary |
|---|---|
| [goTo](../go-to.md) | [common]<br>@[ExperimentalNavigationApi](../-experimental-navigation-api/index.md)<br>@Composable<br>fun &lt;[T](../go-to.md)&gt; [ComposeNavigatorByContent](index.md)&lt;[T](../go-to.md)&gt;.[goTo](../go-to.md)(key: [T](../go-to.md), content: @Composable[ComposeNavigationContentScope](../-compose-navigation-content-scope/index.md)&lt;[T](../go-to.md)&gt;.() -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)) |
