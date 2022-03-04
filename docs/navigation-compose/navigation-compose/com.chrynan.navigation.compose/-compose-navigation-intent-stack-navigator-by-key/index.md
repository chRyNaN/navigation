//[navigation-compose](../../../index.md)/[com.chrynan.navigation.compose](../index.md)/[ComposeNavigationIntentStackNavigatorByKey](index.md)

# ComposeNavigationIntentStackNavigatorByKey

[common]\
@[ExperimentalNavigationApi](../../../../navigation-core/navigation-core/com.chrynan.navigation/-experimental-navigation-api/index.md)

interface [ComposeNavigationIntentStackNavigatorByKey](index.md)&lt;[Context](index.md), [Intent](index.md) : [NavigationIntent](../../../../navigation-core/navigation-core/com.chrynan.navigation/-navigation-intent/index.md)&gt; : [ComposeNavigatorByKey](../-compose-navigator-by-key/index.md)&lt;[Context](index.md), [Intent](index.md)&gt; , [NavigationEventHandler](../../../../navigation-core/navigation-core/com.chrynan.navigation/-navigation-event-handler/index.md)&lt;[Intent](index.md), [ComposeNavigationIntentScope](../-compose-navigation-intent-scope/index.md)&lt;[Context](index.md), [Intent](index.md)&gt;&gt; , [NavigationEventNavigator](../../../../navigation-core/navigation-core/com.chrynan.navigation/-navigation-event-navigator/index.md)&lt;[Intent](index.md)&gt;

## Functions

| Name | Summary |
|---|---|
| [canGoBack](../-compose-navigation-intent-navigator-by-key-view-model/index.md#-2140702436%2FFunctions%2F-1093353005) | [common]<br>open override fun [ComposeNavigationIntentScope](../-compose-navigation-intent-scope/index.md)&lt;[Context](index.md), [Intent](index.md)&gt;.[canGoBack](../-compose-navigation-intent-navigator-by-key-view-model/index.md#-2140702436%2FFunctions%2F-1093353005)(): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>abstract fun [canGoBack](../-base-compose-navigator-by-content-view-model/index.md#1718773359%2FFunctions%2F-1093353005)(): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [changeContext](../-compose-context-navigator/change-context.md) | [common]<br>abstract fun [changeContext](../-compose-context-navigator/change-context.md)(to: [Context](index.md)) |
| [goBack](../-base-compose-navigator-by-content-view-model/index.md#1603024541%2FFunctions%2F-1093353005) | [common]<br>abstract fun [goBack](../-base-compose-navigator-by-content-view-model/index.md#1603024541%2FFunctions%2F-1093353005)(): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [goTo](index.md#-401010681%2FFunctions%2F-1093353005) | [common]<br>abstract fun [goTo](index.md#-401010681%2FFunctions%2F-1093353005)(key: [Intent](index.md), strategy: [StackDuplicateContentStrategy](../../../../navigation-core/navigation-core/com.chrynan.navigation/-stack-duplicate-content-strategy/index.md)) |
| [navigate](navigate.md) | [common]<br>open override fun [navigate](navigate.md)(event: [NavigationEvent](../../../../navigation-core/navigation-core/com.chrynan.navigation/-navigation-event/index.md)&lt;[Intent](index.md)&gt;) |
| [onGoBack](on-go-back.md) | [common]<br>open override fun [ComposeNavigationIntentScope](../-compose-navigation-intent-scope/index.md)&lt;[Context](index.md), [Intent](index.md)&gt;.[onGoBack](on-go-back.md)() |
| [onGoTo](on-go-to.md) | [common]<br>open override fun [ComposeNavigationIntentScope](../-compose-navigation-intent-scope/index.md)&lt;[Context](index.md), [Intent](index.md)&gt;.[onGoTo](on-go-to.md)(value: [Intent](index.md)) |
| [onGoUp](on-go-up.md) | [common]<br>open override fun [ComposeNavigationIntentScope](../-compose-navigation-intent-scope/index.md)&lt;[Context](index.md), [Intent](index.md)&gt;.[onGoUp](on-go-up.md)() |
| [onNavigate](../-compose-navigation-intent-navigator-by-key-view-model/index.md#1369063281%2FFunctions%2F-1093353005) | [common]<br>open override fun [ComposeNavigationIntentScope](../-compose-navigation-intent-scope/index.md)&lt;[Context](index.md), [Intent](index.md)&gt;.[onNavigate](../-compose-navigation-intent-navigator-by-key-view-model/index.md#1369063281%2FFunctions%2F-1093353005)(value: [NavigationEvent](../../../../navigation-core/navigation-core/com.chrynan.navigation/-navigation-event/index.md)&lt;[Intent](index.md)&gt;) |

## Properties

| Name | Summary |
|---|---|
| [contextChanges](../-compose-context-navigator/context-changes.md) | [common]<br>abstract val [contextChanges](../-compose-context-navigator/context-changes.md): Flow&lt;[Context](index.md)&gt; |
| [currentContext](../-compose-context-navigator/current-context.md) | [common]<br>abstract val [currentContext](../-compose-context-navigator/current-context.md): [Context](index.md) |
| [currentKey](../-compose-navigator/current-key.md) | [common]<br>abstract val [currentKey](../-compose-navigator/current-key.md): [Intent](index.md) |
| [initialContext](../-compose-context-navigator/initial-context.md) | [common]<br>abstract val [initialContext](../-compose-context-navigator/initial-context.md): [Context](index.md) |
| [initialKey](../-compose-navigator/initial-key.md) | [common]<br>abstract val [initialKey](../-compose-navigator/initial-key.md): [Intent](index.md) |
| [isInitialized](../-compose-navigator/is-initialized.md) | [common]<br>abstract val [isInitialized](../-compose-navigator/is-initialized.md): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [keyChanges](../-compose-navigator/key-changes.md) | [common]<br>abstract val [keyChanges](../-compose-navigator/key-changes.md): Flow&lt;[Intent](index.md)&gt; |
| [keySaver](../-compose-navigator/key-saver.md) | [common]<br>abstract val [keySaver](../-compose-navigator/key-saver.md): [Saver](../-saver/index.md)&lt;[Intent](index.md), [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)&gt; |
| [scope](scope.md) | [common]<br>abstract val [scope](scope.md): [ComposeNavigationIntentScope](../-compose-navigation-intent-scope/index.md)&lt;[Context](index.md), [Intent](index.md)&gt; |

## Inheritors

| Name |
|---|
| [ComposeNavigationIntentNavigatorByKeyViewModel](../-compose-navigation-intent-navigator-by-key-view-model/index.md) |
