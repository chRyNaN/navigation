//[navigation-core](../../../index.md)/[com.chrynan.navigation](../index.md)/[AndroidNavigationHandler](index.md)

# AndroidNavigationHandler

[android]\
fun interface [AndroidNavigationHandler](index.md)&lt;[I](index.md) : [NavigationIntent](../../../../navigation-core/navigation-core/com.chrynan.navigation/-navigation-intent/index.md)&gt; : [NavigationHandler](../../../../navigation-core/navigation-core/com.chrynan.navigation/-navigation-handler/index.md)&lt;[I](index.md), [AndroidNavigationScope](../-android-navigation-scope/index.md)&gt; 

A [NavigationHandler](../../../../navigation-core/navigation-core/com.chrynan.navigation/-navigation-handler/index.md) used on the Android platform that uses an [AndroidNavigationScope](../-android-navigation-scope/index.md).

## Functions

| Name | Summary |
|---|---|
| [onNavigate](index.md#1690214574%2FFunctions%2F2082272698) | [android]<br>abstract fun [AndroidNavigationScope](../-android-navigation-scope/index.md).[onNavigate](index.md#1690214574%2FFunctions%2F2082272698)(event: [NavigationEvent](../../../../navigation-core/navigation-core/com.chrynan.navigation/-navigation-event/index.md)&lt;[I](index.md)&gt;)<br>Handles the actual navigation to a different part of the app defined by the provided [event](index.md#1690214574%2FFunctions%2F2082272698) using the [S](../../../../navigation-core/com.chrynan.navigation/-navigation-handler/index.md) scope. |
