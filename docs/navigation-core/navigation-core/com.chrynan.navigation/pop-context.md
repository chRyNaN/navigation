//[navigation-core](../../index.md)/[com.chrynan.navigation](index.md)/[popContext](pop-context.md)

# popContext

[common]\

@[ExperimentalNavigationApi](-experimental-navigation-api/index.md)

fun &lt;[Destination](pop-context.md) : [NavigationDestination](index.md#1223765350%2FClasslikes%2F-215881696), [Context](pop-context.md) : [NavigationContext](-navigation-context/index.md)&lt;[Destination](pop-context.md)&gt;&gt; [Navigator](-navigator/index.md)&lt;[Destination](pop-context.md), [Context](pop-context.md)&gt;.[popContext](pop-context.md)(): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)

Performs a back navigation operation, if possible, by moving to the previous [NavigationContext](-navigation-context/index.md). If this [Navigator](-navigator/index.md) cannot navigate to a previous [NavigationContext](-navigation-context/index.md), then this function will do nothing and return `false`.

#### Return

`true` if the back navigation operation was successful, `false` otherwise.
