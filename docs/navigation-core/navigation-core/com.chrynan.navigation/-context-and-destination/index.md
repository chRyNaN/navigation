//[navigation-core](../../../index.md)/[com.chrynan.navigation](../index.md)/[ContextAndDestination](index.md)

# ContextAndDestination

[common]\
@Serializable

class [ContextAndDestination](index.md)&lt;[Context](index.md) : [NavigationContext](../-navigation-context/index.md)&lt;[Destination](index.md)&gt;, [Destination](index.md) : [NavigationDestination](../index.md#1223765350%2FClasslikes%2F-215881696)&gt;(val context: [Context](index.md), val destination: [Destination](index.md))

A wrapper class around a [NavigationContext](../-navigation-context/index.md) and an associated [NavigationDestination](../index.md#1223765350%2FClasslikes%2F-215881696).

## Constructors

| | |
|---|---|
| [ContextAndDestination](-context-and-destination.md) | [common]<br>constructor(context: [Context](index.md), destination: [Destination](index.md)) |

## Functions

| Name | Summary |
|---|---|
| [component1](component1.md) | [common]<br>operator fun [component1](component1.md)(): [Context](index.md) |
| [component2](component2.md) | [common]<br>operator fun [component2](component2.md)(): [Destination](index.md) |
| [copy](copy.md) | [common]<br>fun [copy](copy.md)(context: [Context](index.md) = this.context, destination: [Destination](index.md) = this.destination): [ContextAndDestination](index.md)&lt;[Context](index.md), [Destination](index.md)&gt;<br>Creates a copy of this [ContextAndDestination](index.md) instance, overriding the provided values. |
| [equals](equals.md) | [common]<br>open operator override fun [equals](equals.md)(other: [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)?): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [hashCode](hash-code.md) | [common]<br>open override fun [hashCode](hash-code.md)(): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [toString](to-string.md) | [common]<br>open override fun [toString](to-string.md)(): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |

## Properties

| Name | Summary |
|---|---|
| [context](context.md) | [common]<br>val [context](context.md): [Context](index.md) |
| [destination](destination.md) | [common]<br>val [destination](destination.md): [Destination](index.md) |
