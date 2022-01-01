//[navigation-core](../../../index.md)/[com.chrynan.navigation](../index.md)/[NavigationHandler](index.md)

# NavigationHandler

[common]\
fun interface [NavigationHandler](index.md)&lt;[I](index.md) : [NavigationIntent](../-navigation-intent/index.md), [S](index.md) : [NavigationScope](../-navigation-scope/index.md)&gt;

Handles the navigation from a [Navigator](../-navigator/index.md).

## Types

| Name | Summary |
|---|---|
| [Companion](-companion/index.md) | [common]<br>object [Companion](-companion/index.md) |

## Functions

| Name | Summary |
|---|---|
| [onNavigate](on-navigate.md) | [common]<br>abstract fun [S](index.md).[onNavigate](on-navigate.md)(event: [NavigationEvent](../-navigation-event/index.md)&lt;[I](index.md)&gt;)<br>Handles the actual navigation to a different part of the app defined by the provided [event](on-navigate.md) using the [S](index.md) scope. |

## Inheritors

| Name |
|---|
| [AndroidNavigationHandler](../-android-navigation-handler/index.md) |
| [NavigationEventHandler](../-navigation-event-handler/index.md) |
