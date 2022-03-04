//[navigation-compose](../../../index.md)/[com.chrynan.navigation.compose](../index.md)/[BaseComposeNavigatorByKeyViewModel](index.md)

# BaseComposeNavigatorByKeyViewModel

[common]\
@[ExperimentalNavigationApi](../../../../navigation-core/navigation-core/com.chrynan.navigation/-experimental-navigation-api/index.md)

abstract class [BaseComposeNavigatorByKeyViewModel](index.md)&lt;[Context](index.md), [Key](index.md), [NavigationScope](index.md) : [ComposeNavigationKeyScope](../-compose-navigation-key-scope/index.md)&lt;[Context](index.md), [Key](index.md)&gt;&gt;(initialContext: [Context](index.md), keySaver: [Saver](../-saver/index.md)&lt;[Key](index.md), [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)&gt;, initialKeys: ([Context](index.md)) -&gt; [Key](index.md)) : ViewModel, [ComposeNavigatorByKey](../-compose-navigator-by-key/index.md)&lt;[Context](index.md), [Key](index.md)&gt;

## Functions

| Name | Summary |
|---|---|
| [canGoBack](can-go-back.md) | [common]<br>open override fun [canGoBack](can-go-back.md)(): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [changeContext](change-context.md) | [common]<br>open override fun [changeContext](change-context.md)(to: [Context](index.md)) |
| [goBack](go-back.md) | [common]<br>open override fun [goBack](go-back.md)(): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [goTo](go-to.md) | [common]<br>open override fun [goTo](go-to.md)(key: [Key](index.md), strategy: [StackDuplicateContentStrategy](../../../../navigation-core/navigation-core/com.chrynan.navigation/-stack-duplicate-content-strategy/index.md)) |

## Properties

| Name | Summary |
|---|---|
| [contextChanges](context-changes.md) | [common]<br>open override val [contextChanges](context-changes.md): Flow&lt;[Context](index.md)&gt; |
| [currentContext](current-context.md) | [common]<br>open override val [currentContext](current-context.md): [Context](index.md) |
| [currentKey](current-key.md) | [common]<br>open override val [currentKey](current-key.md): [Key](index.md) |
| [initialContext](initial-context.md) | [common]<br>override val [initialContext](initial-context.md): [Context](index.md) |
| [initialKey](initial-key.md) | [common]<br>override val [initialKey](initial-key.md): [Key](index.md) |
| [isInitialized](is-initialized.md) | [common]<br>open override var [isInitialized](is-initialized.md): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = false |
| [keyChanges](key-changes.md) | [common]<br>open override val [keyChanges](key-changes.md): Flow&lt;[Key](index.md)&gt; |
| [keySaver](key-saver.md) | [common]<br>override val [keySaver](key-saver.md): [Saver](../-saver/index.md)&lt;[Key](index.md), [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)&gt; |

## Inheritors

| Name |
|---|
| [ComposeNavigationIntentNavigatorByKeyViewModel](../-compose-navigation-intent-navigator-by-key-view-model/index.md) |
| [ComposeNavigatorByKeyViewModel](../-compose-navigator-by-key-view-model/index.md) |
