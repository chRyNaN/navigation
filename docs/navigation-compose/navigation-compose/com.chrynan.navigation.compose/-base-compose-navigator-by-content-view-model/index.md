//[navigation-compose](../../../index.md)/[com.chrynan.navigation.compose](../index.md)/[BaseComposeNavigatorByContentViewModel](index.md)

# BaseComposeNavigatorByContentViewModel

[common]\
@[ExperimentalNavigationApi](../../../../navigation-core/navigation-core/com.chrynan.navigation/-experimental-navigation-api/index.md)

abstract class [BaseComposeNavigatorByContentViewModel](index.md)&lt;[Context](index.md), [Key](index.md)&gt; : ViewModel, [ComposeNavigatorByContent](../-compose-navigator-by-content/index.md)&lt;[Context](index.md), [Key](index.md)&gt;

## Functions

| Name | Summary |
|---|---|
| [canGoBack](index.md#1718773359%2FFunctions%2F-1093353005) | [common]<br>abstract fun [canGoBack](index.md#1718773359%2FFunctions%2F-1093353005)(): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [changeContext](../-compose-context-navigator/change-context.md) | [common]<br>abstract fun [changeContext](../-compose-context-navigator/change-context.md)(to: [Context](index.md)) |
| [goBack](index.md#1603024541%2FFunctions%2F-1093353005) | [common]<br>abstract fun [goBack](index.md#1603024541%2FFunctions%2F-1093353005)(): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [goTo](../-compose-navigator-by-content/go-to.md) | [common]<br>@Composable<br>abstract fun [goTo](../-compose-navigator-by-content/go-to.md)(key: [Key](index.md), strategy: [StackDuplicateContentStrategy](../../../../navigation-core/navigation-core/com.chrynan.navigation/-stack-duplicate-content-strategy/index.md), content: @Composable[ComposeNavigationContentScope](../-compose-navigation-content-scope/index.md)&lt;[Context](index.md), [Key](index.md)&gt;.() -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)) |

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
| [ComposeNavigatorByContentViewModel](../-compose-navigator-by-content-view-model/index.md) |
