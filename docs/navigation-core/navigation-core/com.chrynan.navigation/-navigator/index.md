//[navigation-core](../../../index.md)/[com.chrynan.navigation](../index.md)/[Navigator](index.md)

# Navigator

[common]\
interface [Navigator](index.md)&lt;[Destination](index.md) : [NavigationDestination](../index.md#1223765350%2FClasslikes%2F-215881696), [Context](index.md) : [NavigationContext](../-navigation-context/index.md)&lt;[Destination](index.md)&gt;&gt;

A [Navigator](index.md) is responsible for coordinating the navigation between the different UI component groupings in an application.

A [Navigator](index.md) is platform and UI framework dependent, so each implementation depends on the particular UI framework used, for example, Jetpack Compose.

## Types

| Name | Summary |
|---|---|
| [Companion](-companion/index.md) | [common]<br>object [Companion](-companion/index.md) |

## Functions

| Name | Summary |
|---|---|
| [canGoBack](can-go-back.md) | [common]<br>abstract fun [canGoBack](can-go-back.md)(): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Determines whether the [Navigator](index.md) can navigate back in the stack in the current [Context](index.md). |
| [changeContext](change-context.md) | [common]<br>abstract fun [changeContext](change-context.md)(context: [Context](index.md))<br>Changes the current [Context](index.md) to the provided [context](change-context.md) value. The displayed [Destination](index.md) will top destination value in the stack associated with the provided [context](change-context.md), or the provided context's [NavigationContext.initialDestination](../-navigation-context/initial-destination.md) if there is currently no existing stack for the provided [context](change-context.md). |
| [goBack](go-back.md) | [common]<br>abstract fun [goBack](go-back.md)(): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Performs a back navigation operation by removing the top destination from the stack in the current [Context](index.md) and displaying the next destination in the list. If this [Navigator](index.md) cannot navigate back, then this function will do nothing. |
| [goTo](go-to.md) | [common]<br>abstract fun [goTo](go-to.md)(destination: [Destination](index.md), strategy: [StackDuplicateContentStrategy](../-stack-duplicate-content-strategy/index.md))<br>Goes to the provided [destination](go-to.md) using the provided stack duplicate content [strategy](go-to.md). Depending on the provided [strategy](go-to.md) and the current [Context](index.md) stack, this will either clear the current [Context](index.md) stack to the last value that equals the provided [destination](go-to.md), or add the provided [destination](go-to.md) to the top of the current [Context](index.md) stack. |
| [goUp](go-up.md) | [common]<br>open fun [goUp](go-up.md)(): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Performs an &quot;up&quot; navigation. An &quot;up&quot; navigation is similar to a &quot;back&quot; navigation but may be slightly different. For instance, on Android, the &quot;left arrow&quot; button in the toolbar component of an application, performs the &quot;up&quot; operation, which is slightly different from the phones back button which performs a &quot;back&quot; operation. |
| [navigate](navigate.md) | [common]<br>open fun [navigate](navigate.md)(event: [NavigationEvent](../-navigation-event/index.md)&lt;[Destination](index.md)&gt;)<br>Navigates to the provided [event](navigate.md). Currently, this default implementation delegates to the appropriate [goBack](go-back.md), [goUp](go-up.md), and [goTo](go-to.md) function depending on the provided [event](navigate.md) value. |

## Properties

| Name | Summary |
|---|---|
| [state](state.md) | [common]<br>abstract val [state](state.md): [NavigatorState](../-navigator-state/index.md)&lt;[Destination](index.md), [Context](index.md)&gt;<br>The [NavigatorState](../-navigator-state/index.md) for this [Navigator](index.md) instance. This can be used to subscribe to destination or context changes, or get the current state values. |

## Inheritors

| Name |
|---|
| [BaseNavigatorImpl](../-base-navigator-impl/index.md) |

## Extensions

| Name | Summary |
|---|---|
| [goTo](../go-to.md) | [common]<br>fun &lt;[Destination](../go-to.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html), [Context](../go-to.md) : [NavigationContext](../-navigation-context/index.md)&lt;[Destination](../go-to.md)&gt;&gt; [Navigator](index.md)&lt;[Destination](../go-to.md), [Context](../go-to.md)&gt;.[goTo](../go-to.md)(destination: [Destination](../go-to.md))<br>Goes to the provided [destination](../go-to.md) using the provided stack duplicate content strategy. Depending on the current [Context](../go-to.md) stack, this will either clear the current [Context](../go-to.md) stack to the last value that equals the provided [destination](../go-to.md), or add the provided [destination](../go-to.md) to the top of the current [Context](../go-to.md) stack. |
