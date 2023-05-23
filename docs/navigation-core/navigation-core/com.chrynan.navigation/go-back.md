//[navigation-core](../../index.md)/[com.chrynan.navigation](index.md)/[goBack](go-back.md)

# goBack

[common]\

@[ExperimentalNavigationApi](-experimental-navigation-api/index.md)

fun &lt;[Destination](go-back.md) : [NavigationDestination](index.md#1223765350%2FClasslikes%2F-215881696), [Context](go-back.md) : [NavigationContext](-navigation-context/index.md)&lt;[Destination](go-back.md)&gt;&gt; [Navigator](-navigator/index.md)&lt;[Destination](go-back.md), [Context](go-back.md)&gt;.[goBack](go-back.md)(): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)

Performs a back navigation operation, if possible, by removing the top [NavigationEvent.Forward](-navigation-event/-forward/index.md) event from the internal navigation stack. If this [Navigator](-navigator/index.md) cannot navigate back, then this function will do nothing and return `false`.

#### Return

`true` if the back navigation operation was successful, `false` otherwise.
