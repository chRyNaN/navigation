//[navigation-core](../../../index.md)/[com.chrynan.navigation](../index.md)/[Navigator](index.md)/[dispatch](dispatch.md)

# dispatch

[common]\
abstract fun [dispatch](dispatch.md)(event: [NavigationEvent](../-navigation-event/index.md)&lt;[Destination](index.md), [Context](index.md)&gt;): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)

Dispatches the provided navigation [event](dispatch.md) which mutates the underlying state values if the navigation event can be performed.

!Note The creation of [NavigationEvent](../-navigation-event/index.md)s is handled internally within this library's components, therefore, instead of invoking this function explicitly, use the [popDestination](../pop-destination.md), [push](../push.md), and [push](../push.md) functions.

#### Return

`true` if the navigation event was handled, or `false` if the event could not be handled (ex: a back navigation event was provided but there are no destinations to go back to). If `false` is returned, the underlying state values were not mutated.

#### Parameters

common

| | |
|---|---|
| event | The [NavigationEvent](../-navigation-event/index.md) that represents the navigation action to be performed. |
