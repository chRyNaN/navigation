//[navigation-compose](../../index.md)/[com.chrynan.navigation.compose](index.md)/[NavigationContainer](-navigation-container.md)

# NavigationContainer

[common]\

@[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)

@[ExperimentalNavigationApi](../../../navigation-core/navigation-core/com.chrynan.navigation/-experimental-navigation-api/index.md)

fun &lt;[Destination](-navigation-container.md) : [NavigationDestination](../../../navigation-core/com.chrynan.navigation/-navigation-destination/index.md), [Context](-navigation-container.md) : [NavigationContext](../../../navigation-core/navigation-core/com.chrynan.navigation/-navigation-context/index.md)&lt;[Destination](-navigation-container.md)&gt;&gt; [NavigationContainer](-navigation-container.md)(navigator: [Navigator](../../../navigation-core/navigation-core/com.chrynan.navigation/-navigator/index.md)&lt;[Destination](-navigation-container.md), [Context](-navigation-container.md)&gt;, modifier: [Modifier](https://developer.android.com/reference/kotlin/androidx/compose/ui/Modifier.html) = Modifier, content: @[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)[BoxScope](https://developer.android.com/reference/kotlin/androidx/compose/foundation/layout/BoxScope.html).(destinationAndContext: [DestinationAndContext](../../../navigation-core/navigation-core/com.chrynan.navigation/-destination-and-context/index.md)&lt;[Destination](-navigation-container.md), [Context](-navigation-container.md)&gt;) -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html))

A [Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html) that listens to navigation context and destination changes from the provided [navigator](-navigation-container.md) and calls the provided [content](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html) function with the latest values.

Example usage:

```kotlin
NavContainer(
    navigator = navigator,
    modifier = modifier
) { (context, destination) ->
    Text("context = $context; destination = $destination")
}
```
