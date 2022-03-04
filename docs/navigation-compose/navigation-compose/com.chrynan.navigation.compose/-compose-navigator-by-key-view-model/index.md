//[navigation-compose](../../../index.md)/[com.chrynan.navigation.compose](../index.md)/[ComposeNavigatorByKeyViewModel](index.md)

# ComposeNavigatorByKeyViewModel

[common]\
@[ExperimentalNavigationApi](../../../../navigation-core/navigation-core/com.chrynan.navigation/-experimental-navigation-api/index.md)

class [ComposeNavigatorByKeyViewModel](index.md)&lt;[Context](index.md), [Key](index.md)&gt; : [BaseComposeNavigatorByKeyViewModel](../-base-compose-navigator-by-key-view-model/index.md)&lt;[Context](index.md), [Key](index.md), [ComposeNavigationKeyScope](../-compose-navigation-key-scope/index.md)&lt;[Context](index.md), [Key](index.md)&gt;&gt;

## Functions

| Name | Summary |
|---|---|
| [canGoBack](../-base-compose-navigator-by-key-view-model/can-go-back.md) | [common]<br>open override fun [canGoBack](../-base-compose-navigator-by-key-view-model/can-go-back.md)(): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [changeContext](../-base-compose-navigator-by-key-view-model/change-context.md) | [common]<br>open override fun [changeContext](../-base-compose-navigator-by-key-view-model/change-context.md)(to: [Context](index.md)) |
| [goBack](../-base-compose-navigator-by-key-view-model/go-back.md) | [common]<br>open override fun [goBack](../-base-compose-navigator-by-key-view-model/go-back.md)(): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [goTo](../-base-compose-navigator-by-key-view-model/go-to.md) | [common]<br>open override fun [goTo](../-base-compose-navigator-by-key-view-model/go-to.md)(key: [Key](index.md), strategy: [StackDuplicateContentStrategy](../../../../navigation-core/navigation-core/com.chrynan.navigation/-stack-duplicate-content-strategy/index.md)) |

## Properties

| Name | Summary |
|---|---|
| [contextChanges](../-base-compose-navigator-by-key-view-model/context-changes.md) | [common]<br>open override val [contextChanges](../-base-compose-navigator-by-key-view-model/context-changes.md): Flow&lt;[Context](index.md)&gt; |
| [currentContext](../-base-compose-navigator-by-key-view-model/current-context.md) | [common]<br>open override val [currentContext](../-base-compose-navigator-by-key-view-model/current-context.md): [Context](index.md) |
| [currentKey](../-base-compose-navigator-by-key-view-model/current-key.md) | [common]<br>open override val [currentKey](../-base-compose-navigator-by-key-view-model/current-key.md): [Key](index.md) |
| [initialContext](../-base-compose-navigator-by-key-view-model/initial-context.md) | [common]<br>override val [initialContext](../-base-compose-navigator-by-key-view-model/initial-context.md): [Context](index.md) |
| [initialKey](../-base-compose-navigator-by-key-view-model/initial-key.md) | [common]<br>override val [initialKey](../-base-compose-navigator-by-key-view-model/initial-key.md): [Key](index.md) |
| [isInitialized](../-base-compose-navigator-by-key-view-model/is-initialized.md) | [common]<br>open override var [isInitialized](../-base-compose-navigator-by-key-view-model/is-initialized.md): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [keyChanges](../-base-compose-navigator-by-key-view-model/key-changes.md) | [common]<br>open override val [keyChanges](../-base-compose-navigator-by-key-view-model/key-changes.md): Flow&lt;[Key](index.md)&gt; |
| [keySaver](../-base-compose-navigator-by-key-view-model/key-saver.md) | [common]<br>override val [keySaver](../-base-compose-navigator-by-key-view-model/key-saver.md): [Saver](../-saver/index.md)&lt;[Key](index.md), [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)&gt; |
