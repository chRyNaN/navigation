//[navigation-core](../../../../index.md)/[com.chrynan.navigation](../../index.md)/[NavigationStrategy](../index.md)/[DestinationRetention](index.md)

# DestinationRetention

[common]\
@Serializable

enum [DestinationRetention](index.md) : [Enum](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-enum/index.html)&lt;[NavigationStrategy.DestinationRetention](index.md)&gt; 

Represents the approach for retaining the [NavigationDestination](../../index.md#1223765350%2FClasslikes%2F-215881696) data structures associated with a particular [NavigationContext](../../-navigation-context/index.md), when navigating to other [NavigationContext](../../-navigation-context/index.md)s. A [RETAIN](-r-e-t-a-i-n/index.md) value indicates that the [NavigationDestination](../../index.md#1223765350%2FClasslikes%2F-215881696) data structure associated with a [NavigationContext](../../-navigation-context/index.md) should be kept when navigation to a different [NavigationContext](../../-navigation-context/index.md), so that the state can be restored when navigating back. A [CLEAR](-c-l-e-a-r/index.md) value indicates that the [NavigationDestination](../../index.md#1223765350%2FClasslikes%2F-215881696) data structure associated with a [NavigationContext](../../-navigation-context/index.md) should be cleared before navigating to a different [NavigationContext](../../-navigation-context/index.md), so that the [NavigationContext.initialDestination](../../-navigation-context/initial-destination.md) value will be displayed when navigating back.

## Entries

| | |
|---|---|
| [RETAIN](-r-e-t-a-i-n/index.md) | [common]<br>[RETAIN](-r-e-t-a-i-n/index.md)<br>Indicates that the [NavigationDestination](../../index.md#1223765350%2FClasslikes%2F-215881696) data structure associated with a [NavigationContext](../../-navigation-context/index.md) should be kept when navigation to a different [NavigationContext](../../-navigation-context/index.md), so that the state can be restored when navigating back. |
| [CLEAR](-c-l-e-a-r/index.md) | [common]<br>[CLEAR](-c-l-e-a-r/index.md)<br>Indicates that the [NavigationDestination](../../index.md#1223765350%2FClasslikes%2F-215881696) data structure associated with a [NavigationContext](../../-navigation-context/index.md) should be cleared before navigating to a different [NavigationContext](../../-navigation-context/index.md), so that the [NavigationContext.initialDestination](../../-navigation-context/initial-destination.md) value will be displayed when navigating back. |

## Types

| Name | Summary |
|---|---|
| [Companion](-companion/index.md) | [common]<br>object [Companion](-companion/index.md) |

## Functions

| Name | Summary |
|---|---|
| [valueOf](value-of.md) | [common]<br>fun [valueOf](value-of.md)(value: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [NavigationStrategy.DestinationRetention](index.md)<br>Returns the enum constant of this type with the specified name. The string must match exactly an identifier used to declare an enum constant in this type. (Extraneous whitespace characters are not permitted.) |
| [values](values.md) | [common]<br>fun [values](values.md)(): [Array](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)&lt;[NavigationStrategy.DestinationRetention](index.md)&gt;<br>Returns an array containing the constants of this enum type, in the order they're declared. |

## Properties

| Name | Summary |
|---|---|
| [name](-c-l-e-a-r/index.md#-372974862%2FProperties%2F-215881696) | [common]<br>val [name](-c-l-e-a-r/index.md#-372974862%2FProperties%2F-215881696): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [ordinal](-c-l-e-a-r/index.md#-739389684%2FProperties%2F-215881696) | [common]<br>val [ordinal](-c-l-e-a-r/index.md#-739389684%2FProperties%2F-215881696): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [serialName](serial-name.md) | [common]<br>val [serialName](serial-name.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
