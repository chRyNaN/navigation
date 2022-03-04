//[navigation-compose](../../../index.md)/[com.chrynan.navigation.compose](../index.md)/[ComposeNavigationIntentNavigatorByKeyViewModel](index.md)

# ComposeNavigationIntentNavigatorByKeyViewModel

[common]\
@[ExperimentalNavigationApi](../../../../navigation-core/navigation-core/com.chrynan.navigation/-experimental-navigation-api/index.md)

class [ComposeNavigationIntentNavigatorByKeyViewModel](index.md)&lt;[Context](index.md), [Intent](index.md) : [NavigationIntent](../../../../navigation-core/navigation-core/com.chrynan.navigation/-navigation-intent/index.md)&gt; : [BaseComposeNavigatorByKeyViewModel](../-base-compose-navigator-by-key-view-model/index.md)&lt;[Context](index.md), [Intent](index.md), [ComposeNavigationIntentScope](../-compose-navigation-intent-scope/index.md)&lt;[Context](index.md), [Intent](index.md)&gt;&gt; , [ComposeNavigationIntentStackNavigatorByKey](../-compose-navigation-intent-stack-navigator-by-key/index.md)&lt;[Context](index.md), [Intent](index.md)&gt;

## Functions

| Name | Summary |
|---|---|
| [canGoBack](../-base-compose-navigator-by-key-view-model/can-go-back.md) | [common]<br>open override fun [canGoBack](../-base-compose-navigator-by-key-view-model/can-go-back.md)(): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>open override fun [ComposeNavigationIntentScope](../-compose-navigation-intent-scope/index.md)&lt;[Context](index.md), [Intent](index.md)&gt;.[canGoBack](index.md#-2140702436%2FFunctions%2F-1093353005)(): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [changeContext](../-base-compose-navigator-by-key-view-model/change-context.md) | [common]<br>open override fun [changeContext](../-base-compose-navigator-by-key-view-model/change-context.md)(to: [Context](index.md)) |
| [goBack](go-back.md) | [common]<br>open override fun [goBack](go-back.md)(): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [goTo](index.md#-1857530580%2FFunctions%2F-1093353005) | [common]<br>open override fun [goTo](index.md#-1857530580%2FFunctions%2F-1093353005)(key: [Intent](index.md), strategy: [StackDuplicateContentStrategy](../../../../navigation-core/navigation-core/com.chrynan.navigation/-stack-duplicate-content-strategy/index.md)) |
| [navigate](../-compose-navigation-intent-stack-navigator-by-key/navigate.md) | [common]<br>open override fun [navigate](../-compose-navigation-intent-stack-navigator-by-key/navigate.md)(event: [NavigationEvent](../../../../navigation-core/navigation-core/com.chrynan.navigation/-navigation-event/index.md)&lt;[Intent](index.md)&gt;) |
| [onGoBack](../-compose-navigation-intent-stack-navigator-by-key/on-go-back.md) | [common]<br>open override fun [ComposeNavigationIntentScope](../-compose-navigation-intent-scope/index.md)&lt;[Context](index.md), [Intent](index.md)&gt;.[onGoBack](../-compose-navigation-intent-stack-navigator-by-key/on-go-back.md)() |
| [onGoTo](../-compose-navigation-intent-stack-navigator-by-key/on-go-to.md) | [common]<br>open override fun [ComposeNavigationIntentScope](../-compose-navigation-intent-scope/index.md)&lt;[Context](index.md), [Intent](index.md)&gt;.[onGoTo](../-compose-navigation-intent-stack-navigator-by-key/on-go-to.md)(value: [Intent](index.md)) |
| [onGoUp](../-compose-navigation-intent-stack-navigator-by-key/on-go-up.md) | [common]<br>open override fun [ComposeNavigationIntentScope](../-compose-navigation-intent-scope/index.md)&lt;[Context](index.md), [Intent](index.md)&gt;.[onGoUp](../-compose-navigation-intent-stack-navigator-by-key/on-go-up.md)() |
| [onNavigate](index.md#1369063281%2FFunctions%2F-1093353005) | [common]<br>open override fun [ComposeNavigationIntentScope](../-compose-navigation-intent-scope/index.md)&lt;[Context](index.md), [Intent](index.md)&gt;.[onNavigate](index.md#1369063281%2FFunctions%2F-1093353005)(value: [NavigationEvent](../../../../navigation-core/navigation-core/com.chrynan.navigation/-navigation-event/index.md)&lt;[Intent](index.md)&gt;) |

## Properties

| Name | Summary |
|---|---|
| [contextChanges](../-base-compose-navigator-by-key-view-model/context-changes.md) | [common]<br>open override val [contextChanges](../-base-compose-navigator-by-key-view-model/context-changes.md): Flow&lt;[Context](index.md)&gt; |
| [currentContext](../-base-compose-navigator-by-key-view-model/current-context.md) | [common]<br>open override val [currentContext](../-base-compose-navigator-by-key-view-model/current-context.md): [Context](index.md) |
| [currentKey](../-base-compose-navigator-by-key-view-model/current-key.md) | [common]<br>open override val [currentKey](../-base-compose-navigator-by-key-view-model/current-key.md): [Intent](index.md) |
| [initialContext](../-base-compose-navigator-by-key-view-model/initial-context.md) | [common]<br>override val [initialContext](../-base-compose-navigator-by-key-view-model/initial-context.md): [Context](index.md) |
| [initialKey](../-base-compose-navigator-by-key-view-model/initial-key.md) | [common]<br>override val [initialKey](../-base-compose-navigator-by-key-view-model/initial-key.md): [Intent](index.md) |
| [isInitialized](../-base-compose-navigator-by-key-view-model/is-initialized.md) | [common]<br>open override var [isInitialized](../-base-compose-navigator-by-key-view-model/is-initialized.md): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [keyChanges](../-base-compose-navigator-by-key-view-model/key-changes.md) | [common]<br>open override val [keyChanges](../-base-compose-navigator-by-key-view-model/key-changes.md): Flow&lt;[Intent](index.md)&gt; |
| [keySaver](../-base-compose-navigator-by-key-view-model/key-saver.md) | [common]<br>override val [keySaver](../-base-compose-navigator-by-key-view-model/key-saver.md): [Saver](../-saver/index.md)&lt;[Intent](index.md), [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)&gt; |
| [scope](scope.md) | [common]<br>open override val [scope](scope.md): [ComposeNavigationIntentScope](../-compose-navigation-intent-scope/index.md)&lt;[Context](index.md), [Intent](index.md)&gt; |
