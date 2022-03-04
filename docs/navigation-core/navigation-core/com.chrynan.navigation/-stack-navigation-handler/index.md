//[navigation-core](../../../index.md)/[com.chrynan.navigation](../index.md)/[StackNavigationHandler](index.md)

# StackNavigationHandler

[common]\
interface [StackNavigationHandler](index.md)&lt;[NavigationValue](index.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html), [Scope](index.md) : [NavigationScope](../-navigation-scope/index.md)&gt; : [NavigationHandler](../-navigation-handler/index.md)&lt;[NavigationValue](index.md), [Scope](index.md)&gt; 

An extension on the [NavigationHandler](../-navigation-handler/index.md) that provides functions to determine back navigation capability.

## Types

| Name | Summary |
|---|---|
| [Companion](-companion/index.md) | [common]<br>object [Companion](-companion/index.md) |

## Functions

| Name | Summary |
|---|---|
| [canGoBack](can-go-back.md) | [common]<br>abstract fun [Scope](index.md).[canGoBack](can-go-back.md)(): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Determines whether a back navigation can be handled. |
| [onNavigate](../-navigation-handler/on-navigate.md) | [common]<br>abstract fun [Scope](index.md).[onNavigate](../-navigation-handler/on-navigate.md)(value: [NavigationValue](index.md))<br>Handles the actual navigation to a different part of the app defined by the provided [value](../-navigation-handler/on-navigate.md) using the [Scope](../-navigation-handler/index.md) scope. |

## Inheritors

| Name |
|---|
| [NavigationEventHandler](../-navigation-event-handler/index.md) |
