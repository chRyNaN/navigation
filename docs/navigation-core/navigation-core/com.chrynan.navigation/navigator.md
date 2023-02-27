//[navigation-core](../../index.md)/[com.chrynan.navigation](index.md)/[navigator](navigator.md)

# navigator

[android]\
fun &lt;[Destination](navigator.md) : [NavigationDestination](../../../navigation-core/com.chrynan.navigation/-navigation-destination/index.md), [Context](navigator.md) : [NavigationContext](../../../navigation-core/navigation-core/com.chrynan.navigation/-navigation-context/index.md)&lt;[Destination](navigator.md)&gt;&gt; [navigator](navigator.md)(initialContext: [Context](navigator.md)): [Navigator](../../../navigation-core/navigation-core/com.chrynan.navigation/-navigator/index.md)&lt;[Destination](navigator.md), [Context](navigator.md)&gt;

Creates a [Navigator](../../../navigation-core/navigation-core/com.chrynan.navigation/-navigator/index.md) using the provided [initialContext](navigator.md).

Example usage:

```kotlin
val navigator = navigator(initialContext = AppContext.Home)

navigator.goTo(destination)
```

[android]\
fun &lt;[Destination](navigator.md) : [NavigationDestination](../../../navigation-core/com.chrynan.navigation/-navigation-destination/index.md)&gt; [navigator](navigator.md)(initialDestination: [Destination](navigator.md)): [Navigator](../../../navigation-core/navigation-core/com.chrynan.navigation/-navigator/index.md)&lt;[Destination](navigator.md), [SingleNavigationContext](../../../navigation-core/navigation-core/com.chrynan.navigation/-single-navigation-context/index.md)&lt;[Destination](navigator.md)&gt;&gt;

Creates a [Navigator](../../../navigation-core/navigation-core/com.chrynan.navigation/-navigator/index.md) with a [SingleNavigationContext](../../../navigation-core/navigation-core/com.chrynan.navigation/-single-navigation-context/index.md) using the provided [initialDestination](navigator.md).

Example usage:

```kotlin
val navigator = navigator(initialDestination = destination)

navigator.goTo(otherDestination)
```
