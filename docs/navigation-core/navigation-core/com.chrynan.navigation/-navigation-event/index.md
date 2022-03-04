//[navigation-core](../../../index.md)/[com.chrynan.navigation](../index.md)/[NavigationEvent](index.md)

# NavigationEvent

[common]\
sealed class [NavigationEvent](index.md)&lt;[NavigationValue](index.md)&gt;

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
| [Back](-back/index.md) | [common]<br>class [Back](-back/index.md)&lt;[NavigationValue](-back/index.md)&gt; : [NavigationEvent](index.md)&lt;[NavigationValue](-back/index.md)&gt; |
| [Companion](-companion/index.md) | [common]<br>object [Companion](-companion/index.md) |
| [To](-to/index.md) | [common]<br>data class [To](-to/index.md)&lt;[NavigationValue](-to/index.md)&gt; : [NavigationEvent](index.md)&lt;[NavigationValue](-to/index.md)&gt; |
| [Up](-up/index.md) | [common]<br>class [Up](-up/index.md)&lt;[NavigationValue](-up/index.md)&gt; : [NavigationEvent](index.md)&lt;[NavigationValue](-up/index.md)&gt; |

## Inheritors

| Name |
|---|
| [Back](-back/index.md) |
| [Up](-up/index.md) |
| [To](-to/index.md) |
