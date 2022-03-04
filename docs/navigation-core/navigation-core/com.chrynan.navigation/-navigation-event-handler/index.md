//[navigation-core](../../../index.md)/[com.chrynan.navigation](../index.md)/[NavigationEventHandler](index.md)

# NavigationEventHandler

[common]\
interface [NavigationEventHandler](index.md)&lt;[NavigationValue](index.md), [Scope](index.md) : [NavigationScope](../-navigation-scope/index.md)&gt; : [NavigationHandler](../-navigation-handler/index.md)&lt;[NavigationEvent](../-navigation-event/index.md)&lt;[NavigationValue](index.md)&gt;, [Scope](index.md)&gt; , [StackNavigationHandler](../-stack-navigation-handler/index.md)&lt;[NavigationEvent](../-navigation-event/index.md)&lt;[NavigationValue](index.md)&gt;, [Scope](index.md)&gt; 

A [NavigationHandler](../-navigation-handler/index.md) that provides distinct functions for each of the possible [NavigationEvent](../-navigation-event/index.md)s.

## Types

| Name | Summary |
|---|---|
| [Companion](-companion/index.md) | [common]<br>object [Companion](-companion/index.md) |

## Functions

| Name | Summary |
|---|---|
| [canGoBack](can-go-back.md) | [common]<br>open override fun [Scope](index.md).[canGoBack](can-go-back.md)(): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Determines whether a back navigation can be handled. |
| [onGoBack](on-go-back.md) | [common]<br>abstract fun [Scope](index.md).[onGoBack](on-go-back.md)() |
| [onGoTo](on-go-to.md) | [common]<br>abstract fun [Scope](index.md).[onGoTo](on-go-to.md)(value: [NavigationValue](index.md)) |
| [onGoUp](on-go-up.md) | [common]<br>abstract fun [Scope](index.md).[onGoUp](on-go-up.md)() |
| [onNavigate](on-navigate.md) | [common]<br>open override fun [Scope](index.md).[onNavigate](on-navigate.md)(value: [NavigationEvent](../-navigation-event/index.md)&lt;[NavigationValue](index.md)&gt;)<br>Handles the actual navigation to a different part of the app defined by the provided [value](on-navigate.md) using the [Scope](index.md) scope. |

## Inheritors

| Name |
|---|
| [AndroidNavigationHandler](../-android-navigation-handler/index.md) |
