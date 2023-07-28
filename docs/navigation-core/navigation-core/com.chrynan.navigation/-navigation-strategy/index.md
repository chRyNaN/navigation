//[navigation-core](../../../index.md)/[com.chrynan.navigation](../index.md)/[NavigationStrategy](index.md)

# NavigationStrategy

[common]\
interface [NavigationStrategy](index.md)

A component that encapsulates the various navigation policies for a [Navigator](../-navigator/index.md).

## Types

| Name | Summary |
|---|---|
| [Companion](-companion/index.md) | [common]<br>object [Companion](-companion/index.md) |
| [DestinationRetention](-destination-retention/index.md) | [common]<br>@Serializable<br>enum [DestinationRetention](-destination-retention/index.md) : [Enum](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-enum/index.html)&lt;[NavigationStrategy.DestinationRetention](-destination-retention/index.md)&gt; <br>Represents the approach for retaining the [NavigationDestination](../index.md#1223765350%2FClasslikes%2F-215881696) data structures associated with a particular [NavigationContext](../-navigation-context/index.md), when navigating to other [NavigationContext](../-navigation-context/index.md)s. A [RETAIN](-destination-retention/-r-e-t-a-i-n/index.md) value indicates that the [NavigationDestination](../index.md#1223765350%2FClasslikes%2F-215881696) data structure associated with a [NavigationContext](../-navigation-context/index.md) should be kept when navigation to a different [NavigationContext](../-navigation-context/index.md), so that the state can be restored when navigating back. A [CLEAR](-destination-retention/-c-l-e-a-r/index.md) value indicates that the [NavigationDestination](../index.md#1223765350%2FClasslikes%2F-215881696) data structure associated with a [NavigationContext](../-navigation-context/index.md) should be cleared before navigating to a different [NavigationContext](../-navigation-context/index.md), so that the [NavigationContext.initialDestination](../-navigation-context/initial-destination.md) value will be displayed when navigating back. |
| [DuplicateDestination](-duplicate-destination/index.md) | [common]<br>@Serializable<br>enum [DuplicateDestination](-duplicate-destination/index.md) : [Enum](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-enum/index.html)&lt;[NavigationStrategy.DuplicateDestination](-duplicate-destination/index.md)&gt; <br>Represents the approach to take when adding a [NavigationDestination](../index.md#1223765350%2FClasslikes%2F-215881696) to a navigation [Stack](../../../../navigation-core/com.chrynan.navigation/-stack/index.md) and there already exists the same item in the [Stack](../../../../navigation-core/com.chrynan.navigation/-stack/index.md). |
