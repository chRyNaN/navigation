//[navigation-core](../../../index.md)/[com.chrynan.navigation](../index.md)/[BaseNavigatorImpl](index.md)/[goBack](go-back.md)

# goBack

[common]\
override fun [goBack](go-back.md)(): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)

Performs a back navigation operation by removing the top destination from the stack in the current [Context](index.md) and displaying the next destination in the list. If this [Navigator](../-navigator/index.md) cannot navigate back, then this function will do nothing.

#### Return

`true` if the back navigation operation was successful, `false` otherwise.
