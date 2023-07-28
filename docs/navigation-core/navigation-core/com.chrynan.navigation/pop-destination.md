//[navigation-core](../../index.md)/[com.chrynan.navigation](index.md)/[popDestination](pop-destination.md)

# popDestination

[common]\

@[ExperimentalNavigationApi](-experimental-navigation-api/index.md)

fun &lt;[Destination](pop-destination.md) : [NavigationDestination](index.md#1223765350%2FClasslikes%2F-215881696), [Context](pop-destination.md) : [NavigationContext](-navigation-context/index.md)&lt;[Destination](pop-destination.md)&gt;&gt; [Navigator](-navigator/index.md)&lt;[Destination](pop-destination.md), [Context](pop-destination.md)&gt;.[popDestination](pop-destination.md)(): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)

Performs a back navigation operation, if possible, by removing the top [NavigationDestination](index.md#1223765350%2FClasslikes%2F-215881696) within the current [NavigationContext](-navigation-context/index.md). If this [Navigator](-navigator/index.md) cannot navigate to a previous [NavigationDestination](index.md#1223765350%2FClasslikes%2F-215881696), then this function will do nothing and return `false`.

#### Return

`true` if the back navigation operation was successful, `false` otherwise.
