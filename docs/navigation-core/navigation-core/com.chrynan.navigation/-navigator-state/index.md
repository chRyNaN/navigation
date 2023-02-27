//[navigation-core](../../../index.md)/[com.chrynan.navigation](../index.md)/[NavigatorState](index.md)

# NavigatorState

[common]\
interface [NavigatorState](index.md)&lt;[Destination](index.md) : [NavigationDestination](../index.md#1223765350%2FClasslikes%2F-215881696), [Context](index.md) : [NavigationContext](../-navigation-context/index.md)&lt;[Destination](index.md)&gt;&gt; : [NavigationDestinationState](../-navigation-destination-state/index.md)&lt;[Destination](index.md)&gt; , [NavigationContextState](../-navigation-context-state/index.md)&lt;[Destination](index.md), [Context](index.md)&gt; 

Represents the state of a [Navigator](../-navigator/index.md), including providing the currently displayed [NavigationDestination](../index.md#1223765350%2FClasslikes%2F-215881696) and [NavigationContext](../-navigation-context/index.md) values.

## Types

| Name | Summary |
|---|---|
| [Companion](-companion/index.md) | [common]<br>object [Companion](-companion/index.md) |

## Properties

| Name | Summary |
|---|---|
| [contextChanges](../-navigation-context-state/context-changes.md) | [common]<br>abstract val [contextChanges](../-navigation-context-state/context-changes.md): Flow&lt;[Context](index.md)&gt; |
| [currentContext](../-navigation-context-state/current-context.md) | [common]<br>abstract val [currentContext](../-navigation-context-state/current-context.md): [Context](index.md) |
| [currentDestination](../-navigation-destination-state/current-destination.md) | [common]<br>abstract val [currentDestination](../-navigation-destination-state/current-destination.md): [Destination](index.md) |
| [destinationChanges](../-navigation-destination-state/destination-changes.md) | [common]<br>abstract val [destinationChanges](../-navigation-destination-state/destination-changes.md): Flow&lt;[Destination](index.md)&gt; |
| [initialContext](../-navigation-context-state/initial-context.md) | [common]<br>abstract val [initialContext](../-navigation-context-state/initial-context.md): [Context](index.md) |
| [initialDestination](../-navigation-destination-state/initial-destination.md) | [common]<br>abstract val [initialDestination](../-navigation-destination-state/initial-destination.md): [Destination](index.md) |
| [isInitialized](is-initialized.md) | [common]<br>abstract val [isInitialized](is-initialized.md): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Determines whether this component is currently initialized, typically meaning that it is ready for use. |

## Inheritors

| Name |
|---|
| [BaseNavigatorStateImpl](../-base-navigator-state-impl/index.md) |
