//[navigation-core](../../../../../index.md)/[com.chrynan.navigation](../../../index.md)/[NavigationStrategy](../../index.md)/[DuplicateDestination](../index.md)/[CLEAR_TO_ORIGINAL](index.md)

# CLEAR_TO_ORIGINAL

[common]\
[CLEAR_TO_ORIGINAL](index.md)

When a duplicate [NavigationDestination](../../../index.md#1223765350%2FClasslikes%2F-215881696) is added to a navigation [Stack](../../../../../../navigation-core/com.chrynan.navigation/-stack/index.md), all the items on top of the existing duplicate item in the stack are cleared off. For instance, consider the following stack of items (the first item being the bottom of the stack and the last item being the top of the stack): `[A, B, C, D]`. If we were to add a value of `A` to the top of the stack, it would be considered a duplicate since `A` already exists as the first item in the stack. Adding the value of `A` to this stack using a [CLEAR_TO_ORIGINAL](index.md) strategy would result in the stack looking as follows: `[A]`. All the items are popped off the stack (or &quot;cleared&quot;) until the original item. This has the result of navigating to the item still, but altering the stack so that the item is back on top.

## Properties

| Name | Summary |
|---|---|
| [name](../../-destination-retention/-c-l-e-a-r/index.md#-372974862%2FProperties%2F-215881696) | [common]<br>val [name](../../-destination-retention/-c-l-e-a-r/index.md#-372974862%2FProperties%2F-215881696): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [ordinal](../../-destination-retention/-c-l-e-a-r/index.md#-739389684%2FProperties%2F-215881696) | [common]<br>val [ordinal](../../-destination-retention/-c-l-e-a-r/index.md#-739389684%2FProperties%2F-215881696): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [serialName](../serial-name.md) | [common]<br>val [serialName](../serial-name.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
