//[navigation-core](../../index.md)/[com.chrynan.navigation](index.md)/[goTo](go-to.md)

# goTo

[common]\
fun &lt;[Destination](go-to.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html), [Context](go-to.md) : [NavigationContext](-navigation-context/index.md)&lt;[Destination](go-to.md)&gt;&gt; [Navigator](-navigator/index.md)&lt;[Destination](go-to.md), [Context](go-to.md)&gt;.[goTo](go-to.md)(destination: [Destination](go-to.md))

Goes to the provided [destination](go-to.md) using the provided stack duplicate content strategy. Depending on the current [Context](go-to.md) stack, this will either clear the current [Context](go-to.md) stack to the last value that equals the provided [destination](go-to.md), or add the provided [destination](go-to.md) to the top of the current [Context](go-to.md) stack.

#### Parameters

common

| | |
|---|---|
| destination | The [NavigationDestination](index.md#1223765350%2FClasslikes%2F-215881696) that is to be navigated to and added to the current [Context](go-to.md) stack. |
