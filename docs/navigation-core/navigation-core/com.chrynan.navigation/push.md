//[navigation-core](../../index.md)/[com.chrynan.navigation](index.md)/[push](push.md)

# push

[common]\

@[ExperimentalNavigationApi](-experimental-navigation-api/index.md)

fun &lt;[Destination](push.md) : [NavigationDestination](index.md#1223765350%2FClasslikes%2F-215881696), [Context](push.md) : [NavigationContext](-navigation-context/index.md)&lt;[Destination](push.md)&gt;&gt; [Navigator](-navigator/index.md)&lt;[Destination](push.md), [Context](push.md)&gt;.[push](push.md)(destination: [Destination](push.md)): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)

Navigates to the provided [destination](push.md) in the current [NavigationContext](-navigation-context/index.md). Depending on the provided [NavigationStrategy.DuplicateDestination](-navigation-strategy/-duplicate-destination/index.md) when creating this [Navigator](-navigator/index.md), and the current [Context](push.md) stack, this will either clear the current [Context](push.md) stack to the last value that equals the provided [destination](push.md), or add the provided [destination](push.md) to the top of the current [Context](push.md) stack.

#### Return

`true` if the navigation operation was successful, `false` otherwise.

#### Parameters

common

| | |
|---|---|
| destination | The [NavigationDestination](index.md#1223765350%2FClasslikes%2F-215881696) that is to be navigated to and added to the current [Context](push.md) stack. |

[common]\

@[ExperimentalNavigationApi](-experimental-navigation-api/index.md)

fun &lt;[Destination](push.md) : [NavigationDestination](index.md#1223765350%2FClasslikes%2F-215881696), [Context](push.md) : [NavigationContext](-navigation-context/index.md)&lt;[Destination](push.md)&gt;&gt; [Navigator](-navigator/index.md)&lt;[Destination](push.md), [Context](push.md)&gt;.[push](push.md)(context: [Context](push.md)): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)

Changes the current [Context](push.md) to the provided [context](push.md) value. The displayed [Destination](push.md) will be the top destination value in the stack associated with the provided [context](push.md), or the provided context's [NavigationContext.initialDestination](-navigation-context/initial-destination.md) if there is currently no existing stack for the provided [context](push.md).

#### Return

`true` if the navigation operation was successful, `false` otherwise.

#### Parameters

common

| | |
|---|---|
| context | The [NavigationContext](-navigation-context/index.md) to change to. |
