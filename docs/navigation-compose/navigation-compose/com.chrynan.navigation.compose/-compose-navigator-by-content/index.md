//[navigation-compose](../../../index.md)/[com.chrynan.navigation.compose](../index.md)/[ComposeNavigatorByContent](index.md)

# ComposeNavigatorByContent

[common]\
@[ExperimentalNavigationApi](../../../../navigation-core/navigation-core/com.chrynan.navigation/-experimental-navigation-api/index.md)

interface [ComposeNavigatorByContent](index.md)&lt;[Context](index.md), [Key](index.md)&gt; : [ComposeNavigator](../-compose-navigator/index.md)&lt;[Key](index.md)&gt; , [ComposeContextNavigator](../-compose-context-navigator/index.md)&lt;[Context](index.md), [Key](index.md)&gt; , [StackNavigator](../../../../navigation-core/navigation-core/com.chrynan.navigation/-stack-navigator/index.md)

## Types

| Name | Summary |
|---|---|
| [Companion](-companion/index.md) | [common]<br>object [Companion](-companion/index.md) |

## Functions

| Name | Summary |
|---|---|
| [canGoBack](../-base-compose-navigator-by-content-view-model/index.md#1718773359%2FFunctions%2F-1093353005) | [common]<br>abstract fun [canGoBack](../-base-compose-navigator-by-content-view-model/index.md#1718773359%2FFunctions%2F-1093353005)(): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [changeContext](../-compose-context-navigator/change-context.md) | [common]<br>abstract fun [changeContext](../-compose-context-navigator/change-context.md)(to: [Context](index.md)) |
| [goBack](../-base-compose-navigator-by-content-view-model/index.md#1603024541%2FFunctions%2F-1093353005) | [common]<br>abstract fun [goBack](../-base-compose-navigator-by-content-view-model/index.md#1603024541%2FFunctions%2F-1093353005)(): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [goTo](go-to.md) | [common]<br>@Composable<br>abstract fun [goTo](go-to.md)(key: [Key](index.md), strategy: [StackDuplicateContentStrategy](../../../../navigation-core/navigation-core/com.chrynan.navigation/-stack-duplicate-content-strategy/index.md), content: @Composable[ComposeNavigationContentScope](../-compose-navigation-content-scope/index.md)&lt;[Context](index.md), [Key](index.md)&gt;.() -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)) |

## Properties

| Name | Summary |
|---|---|
| [contextChanges](../-compose-context-navigator/context-changes.md) | [common]<br>abstract val [contextChanges](../-compose-context-navigator/context-changes.md): Flow&lt;[Context](index.md)&gt; |
| [currentContext](../-compose-context-navigator/current-context.md) | [common]<br>abstract val [currentContext](../-compose-context-navigator/current-context.md): [Context](index.md) |
| [currentKey](../-compose-navigator/current-key.md) | [common]<br>abstract val [currentKey](../-compose-navigator/current-key.md): [Key](index.md) |
| [initialContext](../-compose-context-navigator/initial-context.md) | [common]<br>abstract val [initialContext](../-compose-context-navigator/initial-context.md): [Context](index.md) |
| [initialKey](../-compose-navigator/initial-key.md) | [common]<br>abstract val [initialKey](../-compose-navigator/initial-key.md): [Key](index.md) |
| [isInitialized](../-compose-navigator/is-initialized.md) | [common]<br>abstract val [isInitialized](../-compose-navigator/is-initialized.md): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [keyChanges](../-compose-navigator/key-changes.md) | [common]<br>abstract val [keyChanges](../-compose-navigator/key-changes.md): Flow&lt;[Key](index.md)&gt; |
| [keySaver](../-compose-navigator/key-saver.md) | [common]<br>abstract val [keySaver](../-compose-navigator/key-saver.md): [Saver](../-saver/index.md)&lt;[Key](index.md), [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)&gt; |

## Inheritors

| Name |
|---|
| [BaseComposeNavigatorByContentViewModel](../-base-compose-navigator-by-content-view-model/index.md) |

## Extensions

| Name | Summary |
|---|---|
| [goTo](../go-to.md) | [common]<br>@[ExperimentalNavigationApi](../../../../navigation-core/navigation-core/com.chrynan.navigation/-experimental-navigation-api/index.md)<br>@Composable<br>fun &lt;[Context](../go-to.md), [Key](../go-to.md)&gt; [ComposeNavigatorByContent](index.md)&lt;[Context](../go-to.md), [Key](../go-to.md)&gt;.[goTo](../go-to.md)(key: [Key](../go-to.md), content: @Composable[ComposeNavigationContentScope](../-compose-navigation-content-scope/index.md)&lt;[Context](../go-to.md), [Key](../go-to.md)&gt;.() -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)) |
