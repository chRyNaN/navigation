//[navigation-compose](../../../index.md)/[com.chrynan.navigation.compose](../index.md)/[ComposeNavigationIntentScope](index.md)

# ComposeNavigationIntentScope

[common]\
@[ExperimentalNavigationApi](../../../../navigation-core/navigation-core/com.chrynan.navigation/-experimental-navigation-api/index.md)

interface [ComposeNavigationIntentScope](index.md)&lt;[Context](index.md), [Intent](index.md) : [NavigationIntent](../../../../navigation-core/navigation-core/com.chrynan.navigation/-navigation-intent/index.md)&gt; : [ComposeNavigationScope](../-compose-navigation-scope/index.md), [ComposeNavigationKeyScope](../-compose-navigation-key-scope/index.md)&lt;[Context](index.md), [Intent](index.md)&gt;

## Types

| Name | Summary |
|---|---|
| [Companion](-companion/index.md) | [common]<br>object [Companion](-companion/index.md) |

## Properties

| Name | Summary |
|---|---|
| [navigator](navigator.md) | [common]<br>abstract override val [navigator](navigator.md): [ComposeNavigationIntentStackNavigatorByKey](../-compose-navigation-intent-stack-navigator-by-key/index.md)&lt;[Context](index.md), [Intent](index.md)&gt; |
