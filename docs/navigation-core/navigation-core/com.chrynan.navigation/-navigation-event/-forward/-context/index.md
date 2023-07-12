//[navigation-core](../../../../../index.md)/[com.chrynan.navigation](../../../index.md)/[NavigationEvent](../../index.md)/[Forward](../index.md)/[Context](index.md)

# Context

[common]\
@Serializable

class [Context](index.md)&lt;[D](index.md) : [NavigationDestination](../../../index.md#1223765350%2FClasslikes%2F-215881696), [C](index.md) : [NavigationContext](../../../-navigation-context/index.md)&lt;[D](index.md)&gt;&gt; : [NavigationEvent.Forward](../index.md)&lt;[D](index.md), [C](index.md)&gt; 

A [NavigationEvent](../../index.md) that changes the current [NavigationContext](../../../-navigation-context/index.md).

## Functions

| Name | Summary |
|---|---|
| [equals](equals.md) | [common]<br>open operator override fun [equals](equals.md)(other: [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)?): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [hashCode](hash-code.md) | [common]<br>open override fun [hashCode](hash-code.md)(): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [toString](to-string.md) | [common]<br>open override fun [toString](to-string.md)(): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |

## Properties

| Name | Summary |
|---|---|
| [context](context.md) | [common]<br>val [context](context.md): [C](index.md)<br>The [NavigationContext](../../../-navigation-context/index.md) to go to. |
| [direction](../direction.md) | [common]<br>open override val [direction](../direction.md): [NavigationEvent.Direction](../../-direction/index.md)<br>The navigation direction for this event. |
| [elapsedMilliseconds](elapsed-milliseconds.md) | [common]<br>open override val [elapsedMilliseconds](elapsed-milliseconds.md): [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)<br>The amount of milliseconds that have elapsed on the system when the event occurred. **Note:** This is not safe to persist or use between system reboots. |
