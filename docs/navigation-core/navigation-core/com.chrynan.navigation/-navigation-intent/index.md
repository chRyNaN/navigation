//[navigation-core](../../../index.md)/[com.chrynan.navigation](../index.md)/[NavigationIntent](index.md)

# NavigationIntent

[common]\
interface [NavigationIntent](index.md)

Represents an intent to move to a different screen in the application. This is similar to an Intent from the MVI design pattern, but for navigation purposes.

For example:

sealed class HomeScreenIntent : NavigationIntent {\
\
    object Feed : HomeScreenIntent()\
}

## Types

| Name | Summary |
|---|---|
| [Companion](-companion/index.md) | [common]<br>object [Companion](-companion/index.md) |
