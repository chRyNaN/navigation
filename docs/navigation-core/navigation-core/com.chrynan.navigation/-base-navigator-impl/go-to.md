//[navigation-core](../../../index.md)/[com.chrynan.navigation](../index.md)/[BaseNavigatorImpl](index.md)/[goTo](go-to.md)

# goTo

[common]\
override fun [goTo](go-to.md)(destination: [Destination](index.md), strategy: [StackDuplicateContentStrategy](../-stack-duplicate-content-strategy/index.md))

Goes to the provided [destination](go-to.md) using the provided stack duplicate content [strategy](go-to.md). Depending on the provided [strategy](go-to.md) and the current [Context](index.md) stack, this will either clear the current [Context](index.md) stack to the last value that equals the provided [destination](go-to.md), or add the provided [destination](go-to.md) to the top of the current [Context](index.md) stack.

#### Parameters

common

| | |
|---|---|
| destination | The [NavigationDestination](../index.md#1223765350%2FClasslikes%2F-215881696) that is to be navigated to and added to the current [Context](index.md) stack. |
| strategy | The [StackDuplicateContentStrategy](../-stack-duplicate-content-strategy/index.md) defining what to do when there are duplicate [Destination](index.md) values within the current [Context](index.md) stack. |
