//[navigation-core](../../../index.md)/[com.chrynan.navigation](../index.md)/[NavigationEvent](index.md)

# NavigationEvent

@Serializable(with = [NavigationEventSerializer::class](../../../../navigation-core/com.chrynan.navigation/-navigation-event-serializer/index.md))

sealed class [NavigationEvent](index.md)&lt;[D](index.md) : [NavigationDestination](../index.md#1223765350%2FClasslikes%2F-215881696), [C](index.md) : [NavigationContext](../-navigation-context/index.md)&lt;[D](index.md)&gt;&gt;

Represents a navigation event that is sent to a [Navigator](../-navigator/index.md) to coordinate the navigation between UI components, such as &quot;screens&quot; within an application. A [NavigationEvent](index.md) can be a [NavigationEvent.Forward.Destination](-forward/-destination/index.md) representing a change in a [NavigationDestination](../index.md#1223765350%2FClasslikes%2F-215881696) in the current context, a [NavigationEvent.Forward.Context](-forward/-context/index.md) representing a change in [NavigationContext](../-navigation-context/index.md), or a [NavigationEvent.Backward](-backward/index.md) representing a back tracking of a previous [NavigationEvent](index.md).

#### See also

| |
|---|
| [Navigator.dispatch](../-navigator/dispatch.md) |

#### Inheritors

| |
|---|
| [Backward](-backward/index.md) |
| [Forward](-forward/index.md) |

## Types

| Name | Summary |
|---|---|
| [Backward](-backward/index.md) | [common]<br>@Serializable(with = [NavigationEventBackwardSerializer::class](../../../../navigation-core/com.chrynan.navigation/-navigation-event-backward-serializer/index.md))<br>sealed class [Backward](-backward/index.md)&lt;[D](-backward/index.md) : [NavigationDestination](../index.md#1223765350%2FClasslikes%2F-215881696), [C](-backward/index.md) : [NavigationContext](../-navigation-context/index.md)&lt;[D](-backward/index.md)&gt;&gt; : [NavigationEvent](index.md)&lt;[D](-backward/index.md), [C](-backward/index.md)&gt; <br>A [NavigationEvent](index.md) that represents a reversal of a previous navigation event. A [Backward](-backward/index.md) navigation event can be used to go to the previous [NavigationDestination](../index.md#1223765350%2FClasslikes%2F-215881696) within the current [NavigationContext](../-navigation-context/index.md), or going back to a previous [NavigationContext](../-navigation-context/index.md) before a change in context. |
| [Companion](-companion/index.md) | [common]<br>object [Companion](-companion/index.md) |
| [Direction](-direction/index.md) | [common]<br>@Serializable<br>enum [Direction](-direction/index.md) : [Enum](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-enum/index.html)&lt;[NavigationEvent.Direction](-direction/index.md)&gt; <br>Represents a direction for a [NavigationEvent](index.md). A [NavigationEvent](index.md) can either be a [FORWARDS](-direction/-f-o-r-w-a-r-d-s/index.md) direction event, meaning the change is added to a [Stack](../../../../navigation-core/com.chrynan.navigation/-stack/index.md), or a [BACKWARDS](-direction/-b-a-c-k-w-a-r-d-s/index.md) direction event, meaning the change causes a removal from a [Stack](../../../../navigation-core/com.chrynan.navigation/-stack/index.md). |
| [Forward](-forward/index.md) | [common]<br>@Serializable(with = [NavigationEventForwardSerializer::class](../../../../navigation-core/com.chrynan.navigation/-navigation-event-forward-serializer/index.md))<br>sealed class [Forward](-forward/index.md)&lt;[D](-forward/index.md) : [NavigationDestination](../index.md#1223765350%2FClasslikes%2F-215881696), [C](-forward/index.md) : [NavigationContext](../-navigation-context/index.md)&lt;[D](-forward/index.md)&gt;&gt; : [NavigationEvent](index.md)&lt;[D](-forward/index.md), [C](-forward/index.md)&gt; <br>A [NavigationEvent](index.md) that represents a forward movement, or addition of a navigation change. These events can be reversed by a [Backward](-backward/index.md) event. There are two forward navigation events: [Destination](-forward/-destination/index.md) representing a change in destination on the current context stack, and [Context](-forward/-context/index.md) representing a change in the context. |
| [Type](-type/index.md) | [common]<br>@Serializable<br>enum [Type](-type/index.md) : [Enum](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-enum/index.html)&lt;[NavigationEvent.Type](-type/index.md)&gt; |

## Properties

| Name | Summary |
|---|---|
| [direction](direction.md) | [common]<br>abstract val [direction](direction.md): [NavigationEvent.Direction](-direction/index.md)<br>The navigation direction for this event. |
| [elapsedMilliseconds](elapsed-milliseconds.md) | [common]<br>abstract val [elapsedMilliseconds](elapsed-milliseconds.md): [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)<br>The amount of milliseconds that have elapsed on the system when the event occurred. |
| [type](type.md) | [common]<br>abstract val [type](type.md): [NavigationEvent.Type](-type/index.md)<br>The type of [NavigationEvent](index.md) that occurred. |
