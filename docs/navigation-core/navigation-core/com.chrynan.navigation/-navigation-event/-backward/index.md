//[navigation-core](../../../../index.md)/[com.chrynan.navigation](../../index.md)/[NavigationEvent](../index.md)/[Backward](index.md)

# Backward

@Serializable(with = [NavigationEventBackwardSerializer::class](../../../../../navigation-core/com.chrynan.navigation/-navigation-event-backward-serializer/index.md))

sealed class [Backward](index.md)&lt;[D](index.md) : [NavigationDestination](../../index.md#1223765350%2FClasslikes%2F-215881696), [C](index.md) : [NavigationContext](../../-navigation-context/index.md)&lt;[D](index.md)&gt;&gt; : [NavigationEvent](../index.md)&lt;[D](index.md), [C](index.md)&gt; 

A [NavigationEvent](../index.md) that represents a reversal of a previous navigation event. A [Backward](index.md) navigation event can be used to go to the previous [NavigationDestination](../../index.md#1223765350%2FClasslikes%2F-215881696) within the current [NavigationContext](../../-navigation-context/index.md), or going back to a previous [NavigationContext](../../-navigation-context/index.md) before a change in context.

#### Inheritors

| |
|---|
| [Destination](-destination/index.md) |
| [Context](-context/index.md) |

## Types

| Name | Summary |
|---|---|
| [Context](-context/index.md) | [common]<br>class [Context](-context/index.md)&lt;[D](-context/index.md) : [NavigationDestination](../../index.md#1223765350%2FClasslikes%2F-215881696), [C](-context/index.md) : [NavigationContext](../../-navigation-context/index.md)&lt;[D](-context/index.md)&gt;&gt; : [NavigationEvent.Backward](index.md)&lt;[D](-context/index.md), [C](-context/index.md)&gt; <br>A [NavigationEvent](../index.md) that changes goes back to the previous [NavigationContext](../../-navigation-context/index.md). |
| [Destination](-destination/index.md) | [common]<br>class [Destination](-destination/index.md)&lt;[D](-destination/index.md) : [NavigationDestination](../../index.md#1223765350%2FClasslikes%2F-215881696), [C](-destination/index.md) : [NavigationContext](../../-navigation-context/index.md)&lt;[D](-destination/index.md)&gt;&gt; : [NavigationEvent.Backward](index.md)&lt;[D](-destination/index.md), [C](-destination/index.md)&gt; <br>A [NavigationEvent](../index.md) that changes goes back to the previous [NavigationDestination](../../index.md#1223765350%2FClasslikes%2F-215881696) within the current [NavigationContext](../../-navigation-context/index.md). |

## Properties

| Name | Summary |
|---|---|
| [direction](direction.md) | [common]<br>open override val [direction](direction.md): [NavigationEvent.Direction](../-direction/index.md)<br>The navigation direction for this event. |
| [elapsedMilliseconds](../elapsed-milliseconds.md) | [common]<br>abstract val [elapsedMilliseconds](../elapsed-milliseconds.md): [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)<br>The amount of milliseconds that have elapsed on the system when the event occurred. |
| [type](../type.md) | [common]<br>abstract val [type](../type.md): [NavigationEvent.Type](../-type/index.md)<br>The type of [NavigationEvent](../index.md) that occurred. |
