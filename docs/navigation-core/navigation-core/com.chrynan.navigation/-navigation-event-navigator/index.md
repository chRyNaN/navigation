//[navigation-core](../../../index.md)/[com.chrynan.navigation](../index.md)/[NavigationEventNavigator](index.md)

# NavigationEventNavigator

[common]\
interface [NavigationEventNavigator](index.md)&lt;[NavigationValue](index.md)&gt; : [Navigator](../-navigator/index.md), [StackNavigator](../-stack-navigator/index.md)

A [Navigator](../-navigator/index.md) that navigates using [NavigationEvent](../-navigation-event/index.md)s. This is typically the base [Navigator](../-navigator/index.md) but not every UI framework can use it, such as Jetpack Compose, so it is separate from the [Navigator](../-navigator/index.md) interface.

## Functions

| Name | Summary |
|---|---|
| [canGoBack](../-stack-navigator/can-go-back.md) | [common]<br>abstract fun [canGoBack](../-stack-navigator/can-go-back.md)(): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [goBack](go-back.md) | [common]<br>open override fun [goBack](go-back.md)(): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [navigate](navigate.md) | [common]<br>abstract fun [navigate](navigate.md)(event: [NavigationEvent](../-navigation-event/index.md)&lt;[NavigationValue](index.md)&gt;)<br>Navigates to the provided [event](navigate.md). |

## Extensions

| Name | Summary |
|---|---|
| [goTo](../go-to.md) | [common]<br>fun &lt;[NavigationValue](../go-to.md)&gt; [NavigationEventNavigator](index.md)&lt;[NavigationValue](../go-to.md)&gt;.[goTo](../go-to.md)(intent: [NavigationValue](../go-to.md))<br>A convenience function for calling [NavigationEventNavigator.navigate](navigate.md) with [NavigationEvent.To](../-navigation-event/-to/index.md). |
| [goUp](../go-up.md) | [common]<br>fun &lt;[NavigationValue](../go-up.md)&gt; [NavigationEventNavigator](index.md)&lt;[NavigationValue](../go-up.md)&gt;.[goUp](../go-up.md)()<br>A convenience function for calling [NavigationEventNavigator.navigate](navigate.md) with [NavigationEvent.Up](../-navigation-event/-up/index.md). |
