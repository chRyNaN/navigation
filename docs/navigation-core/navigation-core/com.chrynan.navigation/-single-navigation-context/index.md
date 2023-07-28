//[navigation-core](../../../index.md)/[com.chrynan.navigation](../index.md)/[SingleNavigationContext](index.md)

# SingleNavigationContext

[common]\
@Serializable

class [SingleNavigationContext](index.md)&lt;[Destination](index.md) : [NavigationDestination](../index.md#1223765350%2FClasslikes%2F-215881696)&gt; : [NavigationContext](../-navigation-context/index.md)&lt;[Destination](index.md)&gt; 

An implementation of the [NavigationContext](../-navigation-context/index.md) interface that doesn't have multiple contexts. Typically, a [NavigationContext](../-navigation-context/index.md) will either be a sealed class or an enum representing the different contexts for navigation. This is common, for instance, for a UI with a bottom navigation bar, where each navigation item in that bottom navigation bar component would be a different context. Each context would retain its own stack of destinations in the [Navigator](../-navigator/index.md). However, sometimes it may be preferable to have only a single context for navigation, and in this case, this class can be used.

**Note:** That this class has an internal constructor and therefore can only be constructed from within this library. This is by design to prevent providing numerous instances of the [SingleNavigationContext](index.md) in the [Navigator.push](../push.md) function.

Example usage:

```kotlin
SingleNavigationContext(initialDestination = "Home")
```

## Functions

| Name | Summary |
|---|---|
| [equals](equals.md) | [common]<br>open operator override fun [equals](equals.md)(other: [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)?): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [hashCode](hash-code.md) | [common]<br>open override fun [hashCode](hash-code.md)(): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [toString](to-string.md) | [common]<br>open override fun [toString](to-string.md)(): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |

## Properties

| Name | Summary |
|---|---|
| [initialDestination](initial-destination.md) | [common]<br>open override val [initialDestination](initial-destination.md): [Destination](index.md)<br>The initial key value that should be displayed when first changing to this [NavigationContext](../-navigation-context/index.md) before any other navigation was performed. |
