//[navigation-core](../../../index.md)/[com.chrynan.navigation](../index.md)/[NavigationContext](index.md)

# NavigationContext

[common]\
interface [NavigationContext](index.md)&lt;[Destination](index.md) : [NavigationDestination](../index.md#1223765350%2FClasslikes%2F-215881696)&gt;

Represents a navigation context, or a container of a back stack of [Destination](index.md)s. Navigation can take place within a [NavigationContext](index.md) typically by changing [Destination](index.md) values. But an application may have multiple [NavigationContext](index.md)s that can be changed and navigated through. This allows for more complex navigation paradigms, such as retaining multiple back stacks for a bottom navigation UI component.

## Types

| Name | Summary |
|---|---|
| [Companion](-companion/index.md) | [common]<br>object [Companion](-companion/index.md) |

## Properties

| Name | Summary |
|---|---|
| [initialDestination](initial-destination.md) | [common]<br>abstract val [initialDestination](initial-destination.md): [Destination](index.md)<br>The initial key value that should be displayed when first changing to this [NavigationContext](index.md) before any other navigation was performed. |

## Inheritors

| Name |
|---|
| [SingleNavigationContext](../-single-navigation-context/index.md) |
