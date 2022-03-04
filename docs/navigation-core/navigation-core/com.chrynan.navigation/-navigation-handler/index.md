//[navigation-core](../../../index.md)/[com.chrynan.navigation](../index.md)/[NavigationHandler](index.md)

# NavigationHandler

[common]\
fun interface [NavigationHandler](index.md)&lt;[NavigationValue](index.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html), [Scope](index.md) : [NavigationScope](../-navigation-scope/index.md)&gt;

Handles the navigation from a [Navigator](../-navigator/index.md).

## Types

| Name | Summary |
|---|---|
| [Companion](-companion/index.md) | [common]<br>object [Companion](-companion/index.md) |

## Functions

| Name | Summary |
|---|---|
| [onNavigate](on-navigate.md) | [common]<br>abstract fun [Scope](index.md).[onNavigate](on-navigate.md)(value: [NavigationValue](index.md))<br>Handles the actual navigation to a different part of the app defined by the provided [value](on-navigate.md) using the [Scope](index.md) scope. |

## Inheritors

| Name |
|---|
| [NavigationEventHandler](../-navigation-event-handler/index.md) |
| [StackNavigationHandler](../-stack-navigation-handler/index.md) |
