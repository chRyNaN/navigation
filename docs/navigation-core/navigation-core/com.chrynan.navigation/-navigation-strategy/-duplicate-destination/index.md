//[navigation-core](../../../../index.md)/[com.chrynan.navigation](../../index.md)/[NavigationStrategy](../index.md)/[DuplicateDestination](index.md)

# DuplicateDestination

[common]\
@Serializable

enum [DuplicateDestination](index.md) : [Enum](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-enum/index.html)&lt;[NavigationStrategy.DuplicateDestination](index.md)&gt; 

Represents the approach to take when adding a [NavigationDestination](../../index.md#1223765350%2FClasslikes%2F-215881696) to a navigation [Stack](../../../../../navigation-core/com.chrynan.navigation/-stack/index.md) and there already exists the same item in the [Stack](../../../../../navigation-core/com.chrynan.navigation/-stack/index.md).

## Entries

| | |
|---|---|
| [CLEAR_TO_ORIGINAL](-c-l-e-a-r_-t-o_-o-r-i-g-i-n-a-l/index.md) | [common]<br>[CLEAR_TO_ORIGINAL](-c-l-e-a-r_-t-o_-o-r-i-g-i-n-a-l/index.md)<br>When a duplicate [NavigationDestination](../../index.md#1223765350%2FClasslikes%2F-215881696) is added to a navigation [Stack](../../../../../navigation-core/com.chrynan.navigation/-stack/index.md), all the items on top of the existing duplicate item in the stack are cleared off. For instance, consider the following stack of items (the first item being the bottom of the stack and the last item being the top of the stack): `[A, B, C, D]`. If we were to add a value of `A` to the top of the stack, it would be considered a duplicate since `A` already exists as the first item in the stack. Adding the value of `A` to this stack using a [CLEAR_TO_ORIGINAL](-c-l-e-a-r_-t-o_-o-r-i-g-i-n-a-l/index.md) strategy would result in the stack looking as follows: `[A]`. All the items are popped off the stack (or &quot;cleared&quot;) until the original item. This has the result of navigating to the item still, but altering the stack so that the item is back on top. |
| [ALLOW_DUPLICATES](-a-l-l-o-w_-d-u-p-l-i-c-a-t-e-s/index.md) | [common]<br>[ALLOW_DUPLICATES](-a-l-l-o-w_-d-u-p-l-i-c-a-t-e-s/index.md)<br>When a duplicate [NavigationDestination](../../index.md#1223765350%2FClasslikes%2F-215881696) is added to a navigation [Stack](../../../../../navigation-core/com.chrynan.navigation/-stack/index.md), the duplicate item is added on top of the stack. For instance, consider the following stack of items (the first item being the bottom of the stack and the last item being the top of the stack): `[A, B, C, D]`. If we were to add a value of `A` to the top of the stack, it would be considered a duplicate since `A` already exists as the first item in the stack. Adding the value of `A` to this stack using an [ALLOW_DUPLICATES](-a-l-l-o-w_-d-u-p-l-i-c-a-t-e-s/index.md) strategy would result in the stack looking as follows: `[A, B, C, D, A]`. This has the result of navigating to the item still, allowing duplicates, and without altering the rest of the stack. |

## Types

| Name | Summary |
|---|---|
| [Companion](-companion/index.md) | [common]<br>object [Companion](-companion/index.md) |

## Functions

| Name | Summary |
|---|---|
| [valueOf](value-of.md) | [common]<br>fun [valueOf](value-of.md)(value: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [NavigationStrategy.DuplicateDestination](index.md)<br>Returns the enum constant of this type with the specified name. The string must match exactly an identifier used to declare an enum constant in this type. (Extraneous whitespace characters are not permitted.) |
| [values](values.md) | [common]<br>fun [values](values.md)(): [Array](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)&lt;[NavigationStrategy.DuplicateDestination](index.md)&gt;<br>Returns an array containing the constants of this enum type, in the order they're declared. |

## Properties

| Name | Summary |
|---|---|
| [name](../-destination-retention/-c-l-e-a-r/index.md#-372974862%2FProperties%2F-215881696) | [common]<br>val [name](../-destination-retention/-c-l-e-a-r/index.md#-372974862%2FProperties%2F-215881696): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [ordinal](../-destination-retention/-c-l-e-a-r/index.md#-739389684%2FProperties%2F-215881696) | [common]<br>val [ordinal](../-destination-retention/-c-l-e-a-r/index.md#-739389684%2FProperties%2F-215881696): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [serialName](serial-name.md) | [common]<br>val [serialName](serial-name.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
