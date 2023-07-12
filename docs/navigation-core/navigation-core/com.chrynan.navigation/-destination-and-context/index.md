//[navigation-core](../../../index.md)/[com.chrynan.navigation](../index.md)/[DestinationAndContext](index.md)

# DestinationAndContext

[common]\
@Serializable

class [DestinationAndContext](index.md)&lt;[Destination](index.md) : [NavigationDestination](../index.md#1223765350%2FClasslikes%2F-215881696), [Context](index.md) : [NavigationContext](../-navigation-context/index.md)&lt;[Destination](index.md)&gt;&gt;(val destination: [Destination](index.md), val context: [Context](index.md))

A wrapper class around a [NavigationDestination](../index.md#1223765350%2FClasslikes%2F-215881696) and an associated [NavigationContext](../-navigation-context/index.md).

## Constructors

| | |
|---|---|
| [DestinationAndContext](-destination-and-context.md) | [common]<br>constructor(destination: [Destination](index.md), context: [Context](index.md)) |

## Functions

| Name | Summary |
|---|---|
| [component1](component1.md) | [common]<br>operator fun [component1](component1.md)(): [Destination](index.md) |
| [component2](component2.md) | [common]<br>operator fun [component2](component2.md)(): [Context](index.md) |
| [copy](copy.md) | [common]<br>fun [copy](copy.md)(destination: [Destination](index.md) = this.destination, context: [Context](index.md) = this.context): [DestinationAndContext](index.md)&lt;[Destination](index.md), [Context](index.md)&gt;<br>Creates a copy of this [DestinationAndContext](index.md) instance, overriding the provided values. |
| [equals](equals.md) | [common]<br>open operator override fun [equals](equals.md)(other: [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)?): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [hashCode](hash-code.md) | [common]<br>open override fun [hashCode](hash-code.md)(): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [toString](to-string.md) | [common]<br>open override fun [toString](to-string.md)(): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |

## Properties

| Name | Summary |
|---|---|
| [context](context.md) | [common]<br>val [context](context.md): [Context](index.md) |
| [destination](destination.md) | [common]<br>val [destination](destination.md): [Destination](index.md) |
