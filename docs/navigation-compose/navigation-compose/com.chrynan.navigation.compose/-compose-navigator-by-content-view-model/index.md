//[navigation-compose](../../../index.md)/[com.chrynan.navigation.compose](../index.md)/[ComposeNavigatorByContentViewModel](index.md)

# ComposeNavigatorByContentViewModel

[common]\
@[ExperimentalNavigationApi](../../../../navigation-core/navigation-core/com.chrynan.navigation/-experimental-navigation-api/index.md)

class [ComposeNavigatorByContentViewModel](index.md)&lt;[Context](index.md), [Key](index.md)&gt; : [BaseComposeNavigatorByContentViewModel](../-base-compose-navigator-by-content-view-model/index.md)&lt;[Context](index.md), [Key](index.md)&gt;

## Functions

| Name | Summary |
|---|---|
| [canGoBack](can-go-back.md) | [common]<br>open override fun [canGoBack](can-go-back.md)(): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [changeContext](change-context.md) | [common]<br>open override fun [changeContext](change-context.md)(to: [Context](index.md)) |
| [goBack](go-back.md) | [common]<br>open override fun [goBack](go-back.md)(): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [goTo](go-to.md) | [common]<br>@Composable<br>open override fun [goTo](go-to.md)(key: [Key](index.md), strategy: [StackDuplicateContentStrategy](../../../../navigation-core/navigation-core/com.chrynan.navigation/-stack-duplicate-content-strategy/index.md), content: @Composable[ComposeNavigationContentScope](../-compose-navigation-content-scope/index.md)&lt;[Context](index.md), [Key](index.md)&gt;.() -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)) |

## Properties

| Name | Summary |
|---|---|
| [contextChanges](context-changes.md) | [common]<br>open override val [contextChanges](context-changes.md): Flow&lt;[Context](index.md)&gt; |
| [currentContext](current-context.md) | [common]<br>open override val [currentContext](current-context.md): [Context](index.md) |
| [currentKey](current-key.md) | [common]<br>open override val [currentKey](current-key.md): [Key](index.md) |
| [initialContext](initial-context.md) | [common]<br>open override val [initialContext](initial-context.md): [Context](index.md) |
| [initialKey](initial-key.md) | [common]<br>open override val [initialKey](initial-key.md): [Key](index.md) |
| [isInitialized](is-initialized.md) | [common]<br>open override var [isInitialized](is-initialized.md): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = false |
| [keyChanges](key-changes.md) | [common]<br>open override val [keyChanges](key-changes.md): Flow&lt;[Key](index.md)&gt; |
| [keySaver](key-saver.md) | [common]<br>open override val [keySaver](key-saver.md): [Saver](../-saver/index.md)&lt;[Key](index.md), [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)&gt; |
