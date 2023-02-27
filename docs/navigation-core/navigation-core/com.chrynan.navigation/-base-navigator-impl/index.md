//[navigation-core](../../../index.md)/[com.chrynan.navigation](../index.md)/[BaseNavigatorImpl](index.md)

# BaseNavigatorImpl

[common]\
abstract class [BaseNavigatorImpl](index.md)&lt;[Destination](index.md) : [NavigationDestination](../index.md#1223765350%2FClasslikes%2F-215881696), [Context](index.md) : [NavigationContext](../-navigation-context/index.md)&lt;[Destination](index.md)&gt;, [State](index.md) : [BaseNavigatorStateImpl](../-base-navigator-state-impl/index.md)&lt;[Destination](index.md), [Context](index.md)&gt;&gt;(val state: [State](index.md)) : [ViewModel](../-view-model/index.md), [Navigator](../-navigator/index.md)&lt;[Destination](index.md), [Context](index.md)&gt;

## Constructors

| | |
|---|---|
| [BaseNavigatorImpl](-base-navigator-impl.md) | [common]<br>fun &lt;[State](index.md) : [BaseNavigatorStateImpl](../-base-navigator-state-impl/index.md)&lt;[Destination](index.md), [Context](index.md)&gt;&gt; [BaseNavigatorImpl](-base-navigator-impl.md)(state: [State](index.md)) |

## Functions

| Name | Summary |
|---|---|
| [canGoBack](can-go-back.md) | [common]<br>override fun [canGoBack](can-go-back.md)(): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Determines whether the [Navigator](../-navigator/index.md) can navigate back in the stack in the current [Context](index.md). |
| [changeContext](change-context.md) | [common]<br>override fun [changeContext](change-context.md)(context: [Context](index.md))<br>Changes the current [Context](index.md) to the provided [context](change-context.md) value. The displayed [Destination](index.md) will top destination value in the stack associated with the provided [context](change-context.md), or the provided context's [NavigationContext.initialDestination](../-navigation-context/initial-destination.md) if there is currently no existing stack for the provided [context](change-context.md). |
| [equals](equals.md) | [common]<br>open operator override fun [equals](equals.md)(other: [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)?): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [goBack](go-back.md) | [common]<br>override fun [goBack](go-back.md)(): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Performs a back navigation operation by removing the top destination from the stack in the current [Context](index.md) and displaying the next destination in the list. If this [Navigator](../-navigator/index.md) cannot navigate back, then this function will do nothing. |
| [goTo](go-to.md) | [common]<br>override fun [goTo](go-to.md)(destination: [Destination](index.md), strategy: [StackDuplicateContentStrategy](../-stack-duplicate-content-strategy/index.md))<br>Goes to the provided [destination](go-to.md) using the provided stack duplicate content [strategy](go-to.md). Depending on the provided [strategy](go-to.md) and the current [Context](index.md) stack, this will either clear the current [Context](index.md) stack to the last value that equals the provided [destination](go-to.md), or add the provided [destination](go-to.md) to the top of the current [Context](index.md) stack. |
| [goUp](../-navigator/go-up.md) | [common]<br>open fun [goUp](../-navigator/go-up.md)(): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Performs an &quot;up&quot; navigation. An &quot;up&quot; navigation is similar to a &quot;back&quot; navigation but may be slightly different. For instance, on Android, the &quot;left arrow&quot; button in the toolbar component of an application, performs the &quot;up&quot; operation, which is slightly different from the phones back button which performs a &quot;back&quot; operation. |
| [hashCode](hash-code.md) | [common]<br>open override fun [hashCode](hash-code.md)(): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [navigate](../-navigator/navigate.md) | [common]<br>open fun [navigate](../-navigator/navigate.md)(event: [NavigationEvent](../-navigation-event/index.md)&lt;[Destination](index.md)&gt;)<br>Navigates to the provided [event](../-navigator/navigate.md). Currently, this default implementation delegates to the appropriate [goBack](../-navigator/go-back.md), [goUp](../-navigator/go-up.md), and [goTo](../-navigator/go-to.md) function depending on the provided [event](../-navigator/navigate.md) value. |
| [toString](to-string.md) | [common]<br>open override fun [toString](to-string.md)(): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |

## Properties

| Name | Summary |
|---|---|
| [state](state.md) | [common]<br>override val [state](state.md): [State](index.md)<br>The [NavigatorState](../-navigator-state/index.md) for this [Navigator](../-navigator/index.md) instance. This can be used to subscribe to destination or context changes, or get the current state values. |

## Extensions

| Name | Summary |
|---|---|
| [goTo](../go-to.md) | [common]<br>fun &lt;[Destination](../go-to.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html), [Context](../go-to.md) : [NavigationContext](../-navigation-context/index.md)&lt;[Destination](../go-to.md)&gt;&gt; [Navigator](../-navigator/index.md)&lt;[Destination](../go-to.md), [Context](../go-to.md)&gt;.[goTo](../go-to.md)(destination: [Destination](../go-to.md))<br>Goes to the provided [destination](../go-to.md) using the provided stack duplicate content strategy. Depending on the current [Context](../go-to.md) stack, this will either clear the current [Context](../go-to.md) stack to the last value that equals the provided [destination](../go-to.md), or add the provided [destination](../go-to.md) to the top of the current [Context](../go-to.md) stack. |
