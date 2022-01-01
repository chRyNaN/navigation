//[navigation-core](../../../index.md)/[com.chrynan.navigation](../index.md)/[NavigationEventHandler](index.md)

# NavigationEventHandler

[common]\
interface [NavigationEventHandler](index.md)&lt;[I](index.md) : [NavigationIntent](../-navigation-intent/index.md), [S](index.md) : [NavigationScope](../-navigation-scope/index.md)&gt; : [NavigationHandler](../-navigation-handler/index.md)&lt;[I](index.md), [S](index.md)&gt; 

A [NavigationHandler](../-navigation-handler/index.md) that provides distinct functions for each of the possible [NavigationEvent](../-navigation-event/index.md)s.

## Types

| Name | Summary |
|---|---|
| [Companion](-companion/index.md) | [common]<br>object [Companion](-companion/index.md) |

## Functions

| Name | Summary |
|---|---|
| [onGoBack](on-go-back.md) | [common]<br>abstract fun [S](index.md).[onGoBack](on-go-back.md)() |
| [onGoTo](on-go-to.md) | [common]<br>abstract fun [S](index.md).[onGoTo](on-go-to.md)(intent: [I](index.md)) |
| [onGoUp](on-go-up.md) | [common]<br>abstract fun [S](index.md).[onGoUp](on-go-up.md)() |
| [onNavigate](on-navigate.md) | [common]<br>open override fun [S](index.md).[onNavigate](on-navigate.md)(event: [NavigationEvent](../-navigation-event/index.md)&lt;[I](index.md)&gt;)<br>Handles the actual navigation to a different part of the app defined by the provided [event](on-navigate.md) using the [S](index.md) scope. |
