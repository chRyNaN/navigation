//[navigation-core](../../../index.md)/[com.chrynan.navigation](../index.md)/[NavigationState](index.md)

# NavigationState

[common]\
@Serializable(with = [NavigationStateSerializer::class](../../../../navigation-core/com.chrynan.navigation/-navigation-state-serializer/index.md))

interface [NavigationState](index.md)&lt;[T](index.md)&gt;

A generic wrapper around the state of a navigation component. This provides a way to access the retained [initial](initial.md) state value, the [current](current.md) state value, and [changes](changes.md) to the state value.

Though this component can be generally useful for any type of state management, it is meant for use within the context of this navigation library (hence, the name of the component), and is exposed so that the wrapped state values can be accessed. This component is a sealed interface so that it cannot be inherited outside of this library, and creation of the component is internal. If you need something like this component externally, consider using a state management library like [cycle](https://github.com/chRyNaN/cycle).

## Types

| Name | Summary |
|---|---|
| [Companion](-companion/index.md) | [common]<br>object [Companion](-companion/index.md) |

## Properties

| Name | Summary |
|---|---|
| [changes](changes.md) | [common]<br>abstract val [changes](changes.md): Flow&lt;[T](index.md)&gt;<br>The changes in the underlying wrapped state value. This is a shareable Flow that can be subscribed to for the purposes of listening to state changes. |
| [current](current.md) | [common]<br>abstract val [current](current.md): [T](index.md)<br>The current state value. This value can change over time, so subsequent calls to access this property can return different values. Use the [changes](changes.md) property to subscribe to the changes. |
| [initial](initial.md) | [common]<br>abstract val [initial](initial.md): [T](index.md)<br>The initial state value when this component was first created. This value does not change when the wrapped state value changes, so subsequent calls to access this property will always return the same value. |
