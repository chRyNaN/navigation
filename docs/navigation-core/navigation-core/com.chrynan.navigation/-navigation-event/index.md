//[navigation-core](../../../index.md)/[com.chrynan.navigation](../index.md)/[NavigationEvent](index.md)

# NavigationEvent

[common]\
sealed class [NavigationEvent](index.md)&lt;[I](index.md) : [NavigationIntent](../-navigation-intent/index.md)&gt;

An event that is sent to a [Navigator](../-navigator/index.md) to coordinate the navigation between screens.

## See also

common

| | |
|---|---|
| Navigator.navigate |  |
| [com.chrynan.navigation.NavigationHandler](../-navigation-handler/on-navigate.md) |  |

## Types

| Name | Summary |
|---|---|
| [Back](-back/index.md) | [common]<br>class [Back](-back/index.md)&lt;[I](-back/index.md) : [NavigationIntent](../-navigation-intent/index.md)&gt; : [NavigationEvent](index.md)&lt;[I](-back/index.md)&gt; |
| [Companion](-companion/index.md) | [common]<br>object [Companion](-companion/index.md) |
| [To](-to/index.md) | [common]<br>data class [To](-to/index.md)&lt;[I](-to/index.md) : [NavigationIntent](../-navigation-intent/index.md)&gt;(intent: [I](-to/index.md)) : [NavigationEvent](index.md)&lt;[I](-to/index.md)&gt; |
| [Up](-up/index.md) | [common]<br>class [Up](-up/index.md)&lt;[I](-up/index.md) : [NavigationIntent](../-navigation-intent/index.md)&gt; : [NavigationEvent](index.md)&lt;[I](-up/index.md)&gt; |

## Inheritors

| Name |
|---|
| [NavigationEvent](-back/index.md) |
| [NavigationEvent](-up/index.md) |
| [NavigationEvent](-to/index.md) |
