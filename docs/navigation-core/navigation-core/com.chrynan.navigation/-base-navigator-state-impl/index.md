//[navigation-core](../../../index.md)/[com.chrynan.navigation](../index.md)/[BaseNavigatorStateImpl](index.md)

# BaseNavigatorStateImpl

[common]\
abstract class [BaseNavigatorStateImpl](index.md)&lt;[Destination](index.md) : [NavigationDestination](../index.md#1223765350%2FClasslikes%2F-215881696), [Context](index.md) : [NavigationContext](../-navigation-context/index.md)&lt;[Destination](index.md)&gt;&gt;(val initialContext: [Context](index.md)) : [NavigatorState](../-navigator-state/index.md)&lt;[Destination](index.md), [Context](index.md)&gt;

## Constructors

| | |
|---|---|
| [BaseNavigatorStateImpl](-base-navigator-state-impl.md) | [common]<br>fun &lt;[Context](index.md) : [NavigationContext](../-navigation-context/index.md)&lt;[Destination](index.md)&gt;&gt; [BaseNavigatorStateImpl](-base-navigator-state-impl.md)(initialContext: [Context](index.md)) |

## Functions

| Name | Summary |
|---|---|
| [change](change.md) | [common]<br>fun [change](change.md)(destination: [Destination](index.md) = currentDestination, context: [Context](index.md) = currentContext) |
| [equals](equals.md) | [common]<br>open operator override fun [equals](equals.md)(other: [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)?): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [hashCode](hash-code.md) | [common]<br>open override fun [hashCode](hash-code.md)(): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [toString](to-string.md) | [common]<br>open override fun [toString](to-string.md)(): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |

## Properties

| Name | Summary |
|---|---|
| [contextChanges](context-changes.md) | [common]<br>override val [contextChanges](context-changes.md): Flow&lt;[Context](index.md)&gt; |
| [currentContext](current-context.md) | [common]<br>override val [currentContext](current-context.md): [Context](index.md) |
| [currentDestination](current-destination.md) | [common]<br>override val [currentDestination](current-destination.md): [Destination](index.md) |
| [destinationChanges](destination-changes.md) | [common]<br>override val [destinationChanges](destination-changes.md): Flow&lt;[Destination](index.md)&gt; |
| [initialContext](initial-context.md) | [common]<br>override val [initialContext](initial-context.md): [Context](index.md) |
| [initialDestination](initial-destination.md) | [common]<br>override val [initialDestination](initial-destination.md): [Destination](index.md) |
| [isInitialized](is-initialized.md) | [common]<br>override var [isInitialized](is-initialized.md): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = false<br>Determines whether this component is currently initialized, typically meaning that it is ready for use. |
