//[navigation-core](../../../index.md)/[com.chrynan.navigation](../index.md)/[Navigator](index.md)

# Navigator

@[ExperimentalNavigationApi](../-experimental-navigation-api/index.md)

@Serializable(with = [NavigatorSerializer::class](../../../../navigation-core/com.chrynan.navigation/-navigator-serializer/index.md))

interface [Navigator](index.md)&lt;[Destination](index.md) : [NavigationDestination](../index.md#1223765350%2FClasslikes%2F-215881696), [Context](index.md) : [NavigationContext](../-navigation-context/index.md)&lt;[Destination](index.md)&gt;&gt;

A [Navigator](index.md) is responsible for coordinating the navigation between the different UI component groupings in an application. It is a stateful component that reacts to [NavigationEvent](../-navigation-event/index.md)s that are emitted via calls to the navigation functions ([goTo](../go-to.md), [goBack](../go-back.md), and [changeContext](../change-context.md)) and updates its stored state values which can be accessed via its state [store](store.md). It is up to the user of a [Navigator](index.md) to subscribe to the state changes of this component and update the associated UI accordingly.

##  Example usage:

```kotlin
// Create a Navigator instance.
val navigator = Navigator(initialContext = mainAppContext)

// Listen to destination changes and update the UI accordingly.
navigator.store.destination.changes
    .onEach { destination ->
        // Update the UI
    }
    .launchIn(coroutineScope)

// Perform navigation to different destinations.
navigator.goTo(destination = Destinations.HOME)
```

#### See also

| | |
|---|---|
| [Navigator](index.md) | The [Navigator](index.md) constructor function for creating an instance of this interface. |
| [goTo](../go-to.md) | For navigating to a new [NavigationDestination](../index.md#1223765350%2FClasslikes%2F-215881696) within the current [NavigationContext](../-navigation-context/index.md). |
| [goBack](../go-back.md) | For navigating backwards, either within the current [NavigationContext](../-navigation-context/index.md) or across [NavigationContext](../-navigation-context/index.md)s, depending on the [NavigationStrategy.BackwardsNavigation](../-navigation-strategy/-backwards-navigation/index.md) strategy supplied to the [Navigator](index.md) function when creating an instance of this [Navigator](index.md). |
| [changeContext](../change-context.md) | For navigating to a different [NavigationContext](../-navigation-context/index.md). |

## Types

| Name | Summary |
|---|---|
| [Companion](-companion/index.md) | [common]<br>object [Companion](-companion/index.md) |

## Functions

| Name | Summary |
|---|---|
| [canGoBack](can-go-back.md) | [common]<br>abstract fun [canGoBack](can-go-back.md)(): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Determines whether this [Navigator](index.md) can navigate back. |
| [changeContext](../change-context.md) | [common]<br>@[ExperimentalNavigationApi](../-experimental-navigation-api/index.md)<br>fun &lt;[Destination](../change-context.md) : [NavigationDestination](../index.md#1223765350%2FClasslikes%2F-215881696), [Context](../change-context.md) : [NavigationContext](../-navigation-context/index.md)&lt;[Destination](../change-context.md)&gt;&gt; [Navigator](index.md)&lt;[Destination](../change-context.md), [Context](../change-context.md)&gt;.[changeContext](../change-context.md)(context: [Context](../change-context.md)): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Changes the current [Context](../change-context.md) to the provided [context](../change-context.md) value. The displayed [Destination](../change-context.md) will be the top destination value in the stack associated with the provided [context](../change-context.md), or the provided context's [NavigationContext.initialDestination](../-navigation-context/initial-destination.md) if there is currently no existing stack for the provided [context](../change-context.md). |
| [dispatch](dispatch.md) | [common]<br>abstract fun [dispatch](dispatch.md)(event: [NavigationEvent](../-navigation-event/index.md)&lt;[Destination](index.md), [Context](index.md)&gt;): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Dispatches the provided navigation [event](dispatch.md) which mutates the underlying state values if the navigation event can be performed. The creation of [NavigationEvent](../-navigation-event/index.md)s is handled internally within this library's components, therefore, instead of invoking this function explicitly, use the [goBack](../go-back.md), [goTo](../go-to.md), and [changeContext](../change-context.md) functions. |
| [goBack](../go-back.md) | [common]<br>@[ExperimentalNavigationApi](../-experimental-navigation-api/index.md)<br>fun &lt;[Destination](../go-back.md) : [NavigationDestination](../index.md#1223765350%2FClasslikes%2F-215881696), [Context](../go-back.md) : [NavigationContext](../-navigation-context/index.md)&lt;[Destination](../go-back.md)&gt;&gt; [Navigator](index.md)&lt;[Destination](../go-back.md), [Context](../go-back.md)&gt;.[goBack](../go-back.md)(): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Performs a back navigation operation, if possible, by removing the top [NavigationEvent.Forward](../-navigation-event/-forward/index.md) event from the internal navigation stack. If this [Navigator](index.md) cannot navigate back, then this function will do nothing and return `false`. |
| [goTo](../go-to.md) | [common]<br>@[ExperimentalNavigationApi](../-experimental-navigation-api/index.md)<br>fun &lt;[Destination](../go-to.md) : [NavigationDestination](../index.md#1223765350%2FClasslikes%2F-215881696), [Context](../go-to.md) : [NavigationContext](../-navigation-context/index.md)&lt;[Destination](../go-to.md)&gt;&gt; [Navigator](index.md)&lt;[Destination](../go-to.md), [Context](../go-to.md)&gt;.[goTo](../go-to.md)(destination: [Destination](../go-to.md)): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Navigates to the provided [destination](../go-to.md) in the current [NavigationContext](../-navigation-context/index.md). Depending on the provided [NavigationStrategy.DuplicateDestination](../-navigation-strategy/-duplicate-destination/index.md) when creating this [Navigator](index.md), and the current [Context](../go-to.md) stack, this will either clear the current [Context](../go-to.md) stack to the last value that equals the provided [destination](../go-to.md), or add the provided [destination](../go-to.md) to the top of the current [Context](../go-to.md) stack. |
| [reset](reset.md) | [common]<br>abstract fun [reset](reset.md)()<br>Resets this [Navigator](index.md) back to its initial state. |

## Properties

| Name | Summary |
|---|---|
| [store](store.md) | [common]<br>abstract val [store](store.md): [NavigationStateStore](../-navigation-state-store/index.md)&lt;[Destination](index.md), [Context](index.md)&gt;<br>The [NavigationStateStore](../-navigation-state-store/index.md) containing the latest [NavigationState](../-navigation-state/index.md)s for each navigation value. This is useful to get the initial, current, or subscribe to the changes in value of the different navigation components. |
