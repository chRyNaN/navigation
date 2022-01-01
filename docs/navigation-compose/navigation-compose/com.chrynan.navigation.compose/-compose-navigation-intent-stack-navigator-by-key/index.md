//[navigation-compose](../../../index.md)/[com.chrynan.navigation.compose](../index.md)/[ComposeNavigationIntentStackNavigatorByKey](index.md)

# ComposeNavigationIntentStackNavigatorByKey

[common]\
@[ExperimentalNavigationApi](../-experimental-navigation-api/index.md)

interface [ComposeNavigationIntentStackNavigatorByKey](index.md)&lt;[I](index.md) : [NavigationIntent](../../../../navigation-core/navigation-core/com.chrynan.navigation/-navigation-intent/index.md)&gt; : [ComposeStackNavigatorByKey](../-compose-stack-navigator-by-key/index.md)&lt;[I](index.md)&gt; , [NavigationEventHandler](../../../../navigation-core/navigation-core/com.chrynan.navigation/-navigation-event-handler/index.md)&lt;[I](index.md), [ComposeNavigationIntentScope](../-compose-navigation-intent-scope/index.md)&lt;[I](index.md)&gt;&gt; , [NavigationEventNavigator](../../../../navigation-core/navigation-core/com.chrynan.navigation/-navigation-event-navigator/index.md)&lt;[I](index.md)&gt;

## Functions

| Name | Summary |
|---|---|
| [canGoBack](../-compose-stack-navigator/can-go-back.md) | [common]<br>abstract fun [canGoBack](../-compose-stack-navigator/can-go-back.md)(): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [goBack](../-compose-stack-navigator/go-back.md) | [common]<br>abstract fun [goBack](../-compose-stack-navigator/go-back.md)(): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [goTo](index.md#1480498924%2FFunctions%2F-1093353005) | [common]<br>abstract fun [goTo](index.md#1480498924%2FFunctions%2F-1093353005)(key: [I](index.md), strategy: [NavStackDuplicateContentStrategy](../../../../navigation-core/navigation-core/com.chrynan.navigation/-nav-stack-duplicate-content-strategy/index.md)) |
| [navigate](navigate.md) | [common]<br>open override fun [navigate](navigate.md)(event: [NavigationEvent](../../../../navigation-core/navigation-core/com.chrynan.navigation/-navigation-event/index.md)&lt;[I](index.md)&gt;) |
| [onGoBack](on-go-back.md) | [common]<br>open override fun [ComposeNavigationIntentScope](../-compose-navigation-intent-scope/index.md)&lt;[I](index.md)&gt;.[onGoBack](on-go-back.md)() |
| [onGoTo](on-go-to.md) | [common]<br>open override fun [ComposeNavigationIntentScope](../-compose-navigation-intent-scope/index.md)&lt;[I](index.md)&gt;.[onGoTo](on-go-to.md)(intent: [I](index.md)) |
| [onGoUp](on-go-up.md) | [common]<br>open override fun [ComposeNavigationIntentScope](../-compose-navigation-intent-scope/index.md)&lt;[I](index.md)&gt;.[onGoUp](on-go-up.md)() |
| [onNavigate](../-compose-navigation-intent-navigator-by-key-view-model/index.md#815856985%2FFunctions%2F-1093353005) | [common]<br>open override fun [ComposeNavigationIntentScope](../-compose-navigation-intent-scope/index.md)&lt;[I](index.md)&gt;.[onNavigate](../-compose-navigation-intent-navigator-by-key-view-model/index.md#815856985%2FFunctions%2F-1093353005)(event: [NavigationEvent](../../../../navigation-core/navigation-core/com.chrynan.navigation/-navigation-event/index.md)&lt;[I](index.md)&gt;) |

## Properties

| Name | Summary |
|---|---|
| [currentKey](../-compose-navigator/current-key.md) | [common]<br>abstract val [currentKey](../-compose-navigator/current-key.md): [I](index.md) |
| [initialKey](../-compose-navigator/initial-key.md) | [common]<br>abstract val [initialKey](../-compose-navigator/initial-key.md): [I](index.md) |
| [isInitialized](../-compose-navigator/is-initialized.md) | [common]<br>abstract val [isInitialized](../-compose-navigator/is-initialized.md): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [keyChanges](../-compose-navigator/key-changes.md) | [common]<br>abstract val [keyChanges](../-compose-navigator/key-changes.md): Flow&lt;[I](index.md)&gt; |

## Inheritors

| Name |
|---|
| [ComposeNavigationIntentNavigatorByKeyViewModel](../-compose-navigation-intent-navigator-by-key-view-model/index.md) |
