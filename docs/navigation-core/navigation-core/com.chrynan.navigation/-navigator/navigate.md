//[navigation-core](../../../index.md)/[com.chrynan.navigation](../index.md)/[Navigator](index.md)/[navigate](navigate.md)

# navigate

[common]\
open fun [navigate](navigate.md)(event: [NavigationEvent](../-navigation-event/index.md)&lt;[Destination](index.md)&gt;)

Navigates to the provided [event](navigate.md). Currently, this default implementation delegates to the appropriate [goBack](go-back.md), [goUp](go-up.md), and [goTo](go-to.md) function depending on the provided [event](navigate.md) value.

#### Parameters

common

| | |
|---|---|
| event | The [NavigationEvent](../-navigation-event/index.md) that represents the navigation action to be performed. |
