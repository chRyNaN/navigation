//[navigation-core](../../../../index.md)/[com.chrynan.navigation](../../index.md)/[NavigationStrategy](../index.md)/[BackwardsNavigation](index.md)

# BackwardsNavigation

[common]\
@Serializable

enum [BackwardsNavigation](index.md) : [Enum](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-enum/index.html)&lt;[NavigationStrategy.BackwardsNavigation](index.md)&gt; 

Represents the type of supported back navigation. An [IN_CONTEXT](-i-n_-c-o-n-t-e-x-t/index.md) value indicates that navigation to the previous [NavigationDestination](../../index.md#1223765350%2FClasslikes%2F-215881696) in the current [NavigationContext](../../-navigation-context/index.md) should occur. An [ACROSS_CONTEXTS](-a-c-r-o-s-s_-c-o-n-t-e-x-t-s/index.md) value indicates that navigation across [NavigationContext](../../-navigation-context/index.md)s is allowed, meaning that navigation can either be to the previous [NavigationDestination](../../index.md#1223765350%2FClasslikes%2F-215881696) within the current [NavigationContext](../../-navigation-context/index.md) or to the previous [NavigationContext](../../-navigation-context/index.md) depending on whether the previous [NavigationEvent](../../-navigation-event/index.md) was a [NavigationEvent.Forward.Destination](../../-navigation-event/-forward/-destination/index.md) or [NavigationEvent.Forward.Context](../../-navigation-event/-forward/-context/index.md) event.

## Entries

| | |
|---|---|
| [IN_CONTEXT](-i-n_-c-o-n-t-e-x-t/index.md) | [common]<br>[IN_CONTEXT](-i-n_-c-o-n-t-e-x-t/index.md)<br>Indicates that navigation to the previous [NavigationDestination](../../index.md#1223765350%2FClasslikes%2F-215881696) in the current [NavigationContext](../../-navigation-context/index.md) should occur |
| [ACROSS_CONTEXTS](-a-c-r-o-s-s_-c-o-n-t-e-x-t-s/index.md) | [common]<br>[ACROSS_CONTEXTS](-a-c-r-o-s-s_-c-o-n-t-e-x-t-s/index.md)<br>Indicates that navigation across [NavigationContext](../../-navigation-context/index.md)s is allowed, meaning that navigation can either be to the previous [NavigationDestination](../../index.md#1223765350%2FClasslikes%2F-215881696) within the current [NavigationContext](../../-navigation-context/index.md) or to the previous [NavigationContext](../../-navigation-context/index.md) depending on whether the previous [NavigationEvent](../../-navigation-event/index.md) was a [NavigationEvent.Forward.Destination](../../-navigation-event/-forward/-destination/index.md) or [NavigationEvent.Forward.Context](../../-navigation-event/-forward/-context/index.md) event |

## Types

| Name | Summary |
|---|---|
| [Companion](-companion/index.md) | [common]<br>object [Companion](-companion/index.md) |

## Functions

| Name | Summary |
|---|---|
| [valueOf](value-of.md) | [common]<br>fun [valueOf](value-of.md)(value: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [NavigationStrategy.BackwardsNavigation](index.md)<br>Returns the enum constant of this type with the specified name. The string must match exactly an identifier used to declare an enum constant in this type. (Extraneous whitespace characters are not permitted.) |
| [values](values.md) | [common]<br>fun [values](values.md)(): [Array](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)&lt;[NavigationStrategy.BackwardsNavigation](index.md)&gt;<br>Returns an array containing the constants of this enum type, in the order they're declared. |

## Properties

| Name | Summary |
|---|---|
| [name](../-destination-retention/-c-l-e-a-r/index.md#-372974862%2FProperties%2F-215881696) | [common]<br>val [name](../-destination-retention/-c-l-e-a-r/index.md#-372974862%2FProperties%2F-215881696): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [ordinal](../-destination-retention/-c-l-e-a-r/index.md#-739389684%2FProperties%2F-215881696) | [common]<br>val [ordinal](../-destination-retention/-c-l-e-a-r/index.md#-739389684%2FProperties%2F-215881696): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [serialName](serial-name.md) | [common]<br>val [serialName](serial-name.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
