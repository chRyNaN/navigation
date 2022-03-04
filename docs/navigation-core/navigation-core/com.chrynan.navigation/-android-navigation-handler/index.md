//[navigation-core](../../../index.md)/[com.chrynan.navigation](../index.md)/[AndroidNavigationHandler](index.md)

# AndroidNavigationHandler

[android]\
interface [AndroidNavigationHandler](index.md)&lt;[Intent](index.md) : [NavigationIntent](../../../../navigation-core/navigation-core/com.chrynan.navigation/-navigation-intent/index.md)&gt; : [NavigationEventHandler](../../../../navigation-core/navigation-core/com.chrynan.navigation/-navigation-event-handler/index.md)&lt;[Intent](index.md), [AndroidNavigationScope](../-android-navigation-scope/index.md)&gt; 

A [NavigationHandler](../../../../navigation-core/navigation-core/com.chrynan.navigation/-navigation-handler/index.md) used on the Android platform that uses an [AndroidNavigationScope](../-android-navigation-scope/index.md).

## Functions

| Name | Summary |
|---|---|
| [canGoBack](index.md#87869025%2FFunctions%2F2082272698) | [android]<br>open override fun [AndroidNavigationScope](../-android-navigation-scope/index.md).[canGoBack](index.md#87869025%2FFunctions%2F2082272698)(): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Determines whether a back navigation can be handled. |
| [onGoBack](index.md#-738819608%2FFunctions%2F2082272698) | [android]<br>abstract fun [AndroidNavigationScope](../-android-navigation-scope/index.md).[onGoBack](index.md#-738819608%2FFunctions%2F2082272698)() |
| [onGoTo](index.md#-2028661020%2FFunctions%2F2082272698) | [android]<br>abstract fun [AndroidNavigationScope](../-android-navigation-scope/index.md).[onGoTo](index.md#-2028661020%2FFunctions%2F2082272698)(value: [Intent](index.md)) |
| [onGoUp](index.md#-1289287332%2FFunctions%2F2082272698) | [android]<br>abstract fun [AndroidNavigationScope](../-android-navigation-scope/index.md).[onGoUp](index.md#-1289287332%2FFunctions%2F2082272698)() |
| [onNavigate](index.md#765672858%2FFunctions%2F2082272698) | [android]<br>open override fun [AndroidNavigationScope](../-android-navigation-scope/index.md).[onNavigate](index.md#765672858%2FFunctions%2F2082272698)(value: [NavigationEvent](../../../../navigation-core/navigation-core/com.chrynan.navigation/-navigation-event/index.md)&lt;[Intent](index.md)&gt;)<br>Handles the actual navigation to a different part of the app defined by the provided [value](index.md#765672858%2FFunctions%2F2082272698) using the [Scope](../../../../navigation-core/com.chrynan.navigation/-navigation-event-handler/index.md) scope. |
