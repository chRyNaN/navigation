//[navigation-core](../../../../index.md)/[com.chrynan.navigation](../../index.md)/[NavigationEvent](../index.md)/[Backward](index.md)

# Backward

[common]\
@Serializable

class [Backward](index.md)&lt;[D](index.md) : [NavigationDestination](../../index.md#1223765350%2FClasslikes%2F-215881696), [C](index.md) : [NavigationContext](../../-navigation-context/index.md)&lt;[D](index.md)&gt;&gt; : [NavigationEvent](../index.md)&lt;[D](index.md), [C](index.md)&gt; 

A [NavigationEvent](../index.md) that represents a reversal of a previous navigation event. A [Backward](index.md) navigation event can be used to go to the previous [NavigationDestination](../../index.md#1223765350%2FClasslikes%2F-215881696) within the current [NavigationContext](../../-navigation-context/index.md), or going back to a previous [NavigationContext](../../-navigation-context/index.md) before a change in context. The type of back navigation that is supported is defined by the provided kind property.

## Functions

| Name | Summary |
|---|---|
| [equals](equals.md) | [common]<br>open operator override fun [equals](equals.md)(other: [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)?): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [hashCode](hash-code.md) | [common]<br>open override fun [hashCode](hash-code.md)(): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [toString](to-string.md) | [common]<br>open override fun [toString](to-string.md)(): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |

## Properties

| Name | Summary |
|---|---|
| [direction](direction.md) | [common]<br>open override val [direction](direction.md): [NavigationEvent.Direction](../-direction/index.md)<br>The navigation direction for this event. |
| [instant](instant.md) | [common]<br>open override val [instant](instant.md): Instant<br>The Instant that the event occurred. |
