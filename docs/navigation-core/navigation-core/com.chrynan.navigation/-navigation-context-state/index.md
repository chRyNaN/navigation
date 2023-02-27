//[navigation-core](../../../index.md)/[com.chrynan.navigation](../index.md)/[NavigationContextState](index.md)

# NavigationContextState

[common]\
interface [NavigationContextState](index.md)&lt;[Destination](index.md) : [NavigationDestination](../index.md#1223765350%2FClasslikes%2F-215881696), [Context](index.md) : [NavigationContext](../-navigation-context/index.md)&lt;[Destination](index.md)&gt;&gt;

## Types

| Name | Summary |
|---|---|
| [Companion](-companion/index.md) | [common]<br>object [Companion](-companion/index.md) |

## Properties

| Name | Summary |
|---|---|
| [contextChanges](context-changes.md) | [common]<br>abstract val [contextChanges](context-changes.md): Flow&lt;[Context](index.md)&gt; |
| [currentContext](current-context.md) | [common]<br>abstract val [currentContext](current-context.md): [Context](index.md) |
| [initialContext](initial-context.md) | [common]<br>abstract val [initialContext](initial-context.md): [Context](index.md) |

## Inheritors

| Name |
|---|
| [NavigatorState](../-navigator-state/index.md) |
