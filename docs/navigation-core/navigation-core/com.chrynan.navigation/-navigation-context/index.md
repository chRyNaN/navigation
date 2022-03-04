//[navigation-core](../../../index.md)/[com.chrynan.navigation](../index.md)/[NavigationContext](index.md)

# NavigationContext

[common]\
interface [NavigationContext](index.md)&lt;[Key](index.md)&gt;

Represents a navigation context, or a container of a back stack of [Key](index.md)s. Navigation can take place within a [NavigationContext](index.md) typically by changing [Key](index.md) values. But an application may have multiple [NavigationContext](index.md)s that can be changed and navigated through. This allows for more complex navigation paradigms, such as retaining multiple back stacks for a bottom navigation UI component.

## Properties

| Name | Summary |
|---|---|
| [initialKey](initial-key.md) | [common]<br>abstract val [initialKey](initial-key.md): [Key](index.md)<br>The initial key value that should be displayed when first changing to this [NavigationContext](index.md) before any other navigation was performed. |
