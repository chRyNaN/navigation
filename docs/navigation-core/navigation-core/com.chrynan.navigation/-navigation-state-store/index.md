//[navigation-core](../../../index.md)/[com.chrynan.navigation](../index.md)/[NavigationStateStore](index.md)

# NavigationStateStore

[common]\
@Serializable(with = [NavigationStateStoreSerializer::class](../../../../navigation-core/com.chrynan.navigation/-navigation-state-store-serializer/index.md))

interface [NavigationStateStore](index.md)&lt;[Destination](index.md) : [NavigationDestination](../index.md#1223765350%2FClasslikes%2F-215881696), [Context](index.md) : [NavigationContext](../-navigation-context/index.md)&lt;[Destination](index.md)&gt;&gt;

Represents a store of navigation state information that is useful for a [Navigator](../-navigator/index.md).

## Types

| Name | Summary |
|---|---|
| [Companion](-companion/index.md) | [common]<br>object [Companion](-companion/index.md) |

## Properties

| Name | Summary |
|---|---|
| [context](context.md) | [common]<br>abstract val [context](context.md): [NavigationState](../-navigation-state/index.md)&lt;[Context](index.md)&gt;<br>A [NavigationState](../-navigation-state/index.md) of [NavigationContext](../-navigation-context/index.md)s. |
| [destination](destination.md) | [common]<br>abstract val [destination](destination.md): [NavigationState](../-navigation-state/index.md)&lt;[Destination](index.md)&gt;<br>A [NavigationState](../-navigation-state/index.md) of [NavigationDestination](../index.md#1223765350%2FClasslikes%2F-215881696)s. |
| [event](event.md) | [common]<br>abstract val [event](event.md): [NavigationState](../-navigation-state/index.md)&lt;[NavigationEvent](../-navigation-event/index.md)&lt;[Destination](index.md), [Context](index.md)&gt;?&gt;<br>A [NavigationState](../-navigation-state/index.md) of [NavigationEvent](../-navigation-event/index.md)s. |
