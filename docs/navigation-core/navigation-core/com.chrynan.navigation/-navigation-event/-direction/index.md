//[navigation-core](../../../../index.md)/[com.chrynan.navigation](../../index.md)/[NavigationEvent](../index.md)/[Direction](index.md)

# Direction

[common]\
@Serializable

enum [Direction](index.md) : [Enum](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-enum/index.html)&lt;[NavigationEvent.Direction](index.md)&gt; 

Represents a direction for a [NavigationEvent](../index.md). A [NavigationEvent](../index.md) can either be a [FORWARDS](-f-o-r-w-a-r-d-s/index.md) direction event, meaning the change is added to a [Stack](../../../../../navigation-core/com.chrynan.navigation/-stack/index.md), or a [BACKWARDS](-b-a-c-k-w-a-r-d-s/index.md) direction event, meaning the change causes a removal from a [Stack](../../../../../navigation-core/com.chrynan.navigation/-stack/index.md).

## Entries

| | |
|---|---|
| [BACKWARDS](-b-a-c-k-w-a-r-d-s/index.md) | [common]<br>[BACKWARDS](-b-a-c-k-w-a-r-d-s/index.md)<br>The associated [NavigationEvent](../index.md) causes a removal of a previous event change from a [Stack](../../../../../navigation-core/com.chrynan.navigation/-stack/index.md). |
| [FORWARDS](-f-o-r-w-a-r-d-s/index.md) | [common]<br>[FORWARDS](-f-o-r-w-a-r-d-s/index.md)<br>The associated [NavigationEvent](../index.md) causes an addition of the change to a [Stack](../../../../../navigation-core/com.chrynan.navigation/-stack/index.md). |

## Functions

| Name | Summary |
|---|---|
| [valueOf](value-of.md) | [common]<br>fun [valueOf](value-of.md)(value: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [NavigationEvent.Direction](index.md)<br>Returns the enum constant of this type with the specified name. The string must match exactly an identifier used to declare an enum constant in this type. (Extraneous whitespace characters are not permitted.) |
| [values](values.md) | [common]<br>fun [values](values.md)(): [Array](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)&lt;[NavigationEvent.Direction](index.md)&gt;<br>Returns an array containing the constants of this enum type, in the order they're declared. |

## Properties

| Name | Summary |
|---|---|
| [name](../../-navigation-strategy/-destination-retention/-c-l-e-a-r/index.md#-372974862%2FProperties%2F-215881696) | [common]<br>val [name](../../-navigation-strategy/-destination-retention/-c-l-e-a-r/index.md#-372974862%2FProperties%2F-215881696): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [ordinal](../../-navigation-strategy/-destination-retention/-c-l-e-a-r/index.md#-739389684%2FProperties%2F-215881696) | [common]<br>val [ordinal](../../-navigation-strategy/-destination-retention/-c-l-e-a-r/index.md#-739389684%2FProperties%2F-215881696): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [serialName](serial-name.md) | [common]<br>val [serialName](serial-name.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
