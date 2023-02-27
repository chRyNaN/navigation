//[navigation-compose](../../index.md)/[com.chrynan.navigation.compose](index.md)/[NavContainer](-nav-container.md)

# NavContainer

[common]\

@[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)

@[ExperimentalNavigationApi](../../../navigation-core/navigation-core/com.chrynan.navigation/-experimental-navigation-api/index.md)

fun &lt;[Destination](-nav-container.md) : [NavigationDestination](../../../navigation-core/com.chrynan.navigation/-navigation-destination/index.md), [Context](-nav-container.md) : [NavigationContext](../../../navigation-core/navigation-core/com.chrynan.navigation/-navigation-context/index.md)&lt;[Destination](-nav-container.md)&gt;&gt; [NavContainer](-nav-container.md)(navigator: [Navigator](../../../navigation-core/navigation-core/com.chrynan.navigation/-navigator/index.md)&lt;[Destination](-nav-container.md), [Context](-nav-container.md)&gt;, content: @[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)[ComposeNavigationScope](-compose-navigation-scope/index.md).(context: [Context](-nav-container.md), destination: [Destination](-nav-container.md)) -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html))

A [Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html) that listens to navigation context and destination changes from the provided [navigator](-nav-container.md) and calls the provided [content](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html) function with the latest values.

Example usage:

```kotlin
NavContainer(navigator) { context, destination ->
    Text("context = $context; destination = $destination")
}
```

[common]\

@[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)

@[ExperimentalNavigationApi](../../../navigation-core/navigation-core/com.chrynan.navigation/-experimental-navigation-api/index.md)

fun &lt;[Destination](-nav-container.md) : [NavigationDestination](../../../navigation-core/com.chrynan.navigation/-navigation-destination/index.md), [Context](-nav-container.md) : [NavigationContext](../../../navigation-core/navigation-core/com.chrynan.navigation/-navigation-context/index.md)&lt;[Destination](-nav-container.md)&gt;&gt; [NavContainer](-nav-container.md)(navigator: [Navigator](../../../navigation-core/navigation-core/com.chrynan.navigation/-navigator/index.md)&lt;[Destination](-nav-container.md), [Context](-nav-container.md)&gt;, modifier: [Modifier](https://developer.android.com/reference/kotlin/androidx/compose/ui/Modifier.html), content: @[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)[ComposeNavigationScope](-compose-navigation-scope/index.md).(context: [Context](-nav-container.md), destination: [Destination](-nav-container.md)) -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html))

A [Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html) that listens to navigation context and destination changes from the provided [navigator](-nav-container.md) and calls the provided [content](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html) function with the latest values.

Example usage:

```kotlin
NavContainer(
    navigator = navigator,
    modifier = modifier
) { context, destination ->
    Text("context = $context; destination = $destination")
}
```
