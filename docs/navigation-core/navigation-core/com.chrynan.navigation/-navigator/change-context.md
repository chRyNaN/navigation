//[navigation-core](../../../index.md)/[com.chrynan.navigation](../index.md)/[Navigator](index.md)/[changeContext](change-context.md)

# changeContext

[common]\
abstract fun [changeContext](change-context.md)(context: [Context](index.md))

Changes the current [Context](index.md) to the provided [context](change-context.md) value. The displayed [Destination](index.md) will top destination value in the stack associated with the provided [context](change-context.md), or the provided context's [NavigationContext.initialDestination](../-navigation-context/initial-destination.md) if there is currently no existing stack for the provided [context](change-context.md).

#### Parameters

common

| | |
|---|---|
| context | The [NavigationContext](../-navigation-context/index.md) to change to. |
