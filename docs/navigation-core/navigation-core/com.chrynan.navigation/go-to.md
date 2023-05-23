//[navigation-core](../../index.md)/[com.chrynan.navigation](index.md)/[goTo](go-to.md)

# goTo

[common]\

@[ExperimentalNavigationApi](-experimental-navigation-api/index.md)

fun &lt;[Destination](go-to.md) : [NavigationDestination](index.md#1223765350%2FClasslikes%2F-215881696), [Context](go-to.md) : [NavigationContext](-navigation-context/index.md)&lt;[Destination](go-to.md)&gt;&gt; [Navigator](-navigator/index.md)&lt;[Destination](go-to.md), [Context](go-to.md)&gt;.[goTo](go-to.md)(destination: [Destination](go-to.md)): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)

Navigates to the provided [destination](go-to.md) in the current [NavigationContext](-navigation-context/index.md). Depending on the provided [NavigationStrategy.DuplicateDestination](-navigation-strategy/-duplicate-destination/index.md) when creating this [Navigator](-navigator/index.md), and the current [Context](go-to.md) stack, this will either clear the current [Context](go-to.md) stack to the last value that equals the provided [destination](go-to.md), or add the provided [destination](go-to.md) to the top of the current [Context](go-to.md) stack.

#### Return

`true` if the navigation operation was successful, `false` otherwise.

#### Parameters

common

| | |
|---|---|
| destination | The [NavigationDestination](index.md#1223765350%2FClasslikes%2F-215881696) that is to be navigated to and added to the current [Context](go-to.md) stack. |
