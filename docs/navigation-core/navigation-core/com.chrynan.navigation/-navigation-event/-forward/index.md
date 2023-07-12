//[navigation-core](../../../../index.md)/[com.chrynan.navigation](../../index.md)/[NavigationEvent](../index.md)/[Forward](index.md)

# Forward

@Serializable

sealed class [Forward](index.md)&lt;[D](index.md) : [NavigationDestination](../../index.md#1223765350%2FClasslikes%2F-215881696), [C](index.md) : [NavigationContext](../../-navigation-context/index.md)&lt;[D](index.md)&gt;&gt; : [NavigationEvent](../index.md)&lt;[D](index.md), [C](index.md)&gt; 

A [NavigationEvent](../index.md) that represents a forward movement, or addition of a navigation change. These events can be reversed by a [Backward](../-backward/index.md) event. There are two forward navigation events: [Destination](-destination/index.md) representing a change in destination on the current context stack, and [Context](-context/index.md) representing a change in the context.

#### Inheritors

| |
|---|
| [Destination](-destination/index.md) |
| [Context](-context/index.md) |

## Types

| Name | Summary |
|---|---|
| [Context](-context/index.md) | [common]<br>@Serializable<br>class [Context](-context/index.md)&lt;[D](-context/index.md) : [NavigationDestination](../../index.md#1223765350%2FClasslikes%2F-215881696), [C](-context/index.md) : [NavigationContext](../../-navigation-context/index.md)&lt;[D](-context/index.md)&gt;&gt; : [NavigationEvent.Forward](index.md)&lt;[D](-context/index.md), [C](-context/index.md)&gt; <br>A [NavigationEvent](../index.md) that changes the current [NavigationContext](../../-navigation-context/index.md). |
| [Destination](-destination/index.md) | [common]<br>@Serializable<br>class [Destination](-destination/index.md)&lt;[D](-destination/index.md) : [NavigationDestination](../../index.md#1223765350%2FClasslikes%2F-215881696), [C](-destination/index.md) : [NavigationContext](../../-navigation-context/index.md)&lt;[D](-destination/index.md)&gt;&gt; : [NavigationEvent.Forward](index.md)&lt;[D](-destination/index.md), [C](-destination/index.md)&gt; <br>A [NavigationEvent](../index.md) that changes the [NavigationDestination](../../index.md#1223765350%2FClasslikes%2F-215881696) within the current [NavigationContext](../../-navigation-context/index.md). |

## Properties

| Name | Summary |
|---|---|
| [direction](direction.md) | [common]<br>open override val [direction](direction.md): [NavigationEvent.Direction](../-direction/index.md)<br>The navigation direction for this event. |
| [elapsedMilliseconds](../elapsed-milliseconds.md) | [common]<br>abstract val [elapsedMilliseconds](../elapsed-milliseconds.md): [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)<br>The amount of milliseconds that have elapsed on the system when the event occurred. |
