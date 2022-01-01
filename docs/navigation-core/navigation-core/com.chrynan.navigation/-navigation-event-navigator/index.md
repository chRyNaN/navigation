//[navigation-core](../../../index.md)/[com.chrynan.navigation](../index.md)/[NavigationEventNavigator](index.md)

# NavigationEventNavigator

[common]\
interface [NavigationEventNavigator](index.md)&lt;[I](index.md) : [NavigationIntent](../-navigation-intent/index.md)&gt; : [Navigator](../-navigator/index.md)

A [Navigator](../-navigator/index.md) that navigates using [NavigationEvent](../-navigation-event/index.md)s. This is typically the base [Navigator](../-navigator/index.md) but not every UI framework can use it, such as Jetpack Compose, so it is separate from the [Navigator](../-navigator/index.md) interface.

## Functions

| Name | Summary |
|---|---|
| [navigate](navigate.md) | [common]<br>abstract fun [navigate](navigate.md)(event: [NavigationEvent](../-navigation-event/index.md)&lt;[I](index.md)&gt;)<br>Navigates to the provided [event](navigate.md). |

## Extensions

| Name | Summary |
|---|---|
| [goBack](../go-back.md) | [common]<br>fun &lt;[I](../go-back.md) : [NavigationIntent](../-navigation-intent/index.md)&gt; [NavigationEventNavigator](index.md)&lt;[I](../go-back.md)&gt;.[goBack](../go-back.md)()<br>A convenience function for calling [NavigationEventNavigator.navigate](navigate.md) with [NavigationEvent.Back](../-navigation-event/-back/index.md). |
| [goTo](../go-to.md) | [common]<br>fun &lt;[I](../go-to.md) : [NavigationIntent](../-navigation-intent/index.md)&gt; [NavigationEventNavigator](index.md)&lt;[I](../go-to.md)&gt;.[goTo](../go-to.md)(intent: [I](../go-to.md))<br>A convenience function for calling [NavigationEventNavigator.navigate](navigate.md) with [NavigationEvent.To](../-navigation-event/-to/index.md). |
| [goUp](../go-up.md) | [common]<br>fun &lt;[I](../go-up.md) : [NavigationIntent](../-navigation-intent/index.md)&gt; [NavigationEventNavigator](index.md)&lt;[I](../go-up.md)&gt;.[goUp](../go-up.md)()<br>A convenience function for calling [NavigationEventNavigator.navigate](navigate.md) with [NavigationEvent.Up](../-navigation-event/-up/index.md). |
