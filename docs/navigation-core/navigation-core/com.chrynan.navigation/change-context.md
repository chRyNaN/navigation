//[navigation-core](../../index.md)/[com.chrynan.navigation](index.md)/[changeContext](change-context.md)

# changeContext

[common]\

@[ExperimentalNavigationApi](-experimental-navigation-api/index.md)

fun &lt;[Destination](change-context.md) : [NavigationDestination](index.md#1223765350%2FClasslikes%2F-215881696), [Context](change-context.md) : [NavigationContext](-navigation-context/index.md)&lt;[Destination](change-context.md)&gt;&gt; [Navigator](-navigator/index.md)&lt;[Destination](change-context.md), [Context](change-context.md)&gt;.[changeContext](change-context.md)(context: [Context](change-context.md)): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)

Changes the current [Context](change-context.md) to the provided [context](change-context.md) value. The displayed [Destination](change-context.md) will be the top destination value in the stack associated with the provided [context](change-context.md), or the provided context's [NavigationContext.initialDestination](-navigation-context/initial-destination.md) if there is currently no existing stack for the provided [context](change-context.md).

#### Return

`true` if the navigation operation was successful, `false` otherwise.

#### Parameters

common

| | |
|---|---|
| context | The [NavigationContext](-navigation-context/index.md) to change to. |
