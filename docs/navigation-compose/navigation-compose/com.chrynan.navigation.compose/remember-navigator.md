//[navigation-compose](../../index.md)/[com.chrynan.navigation.compose](index.md)/[rememberNavigator](remember-navigator.md)

# rememberNavigator

[common]\

@[ExperimentalNavigationApi](../../../navigation-core/navigation-core/com.chrynan.navigation/-experimental-navigation-api/index.md)

@[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)

fun &lt;[Destination](remember-navigator.md) : [NavigationDestination](../../../navigation-core/com.chrynan.navigation/-navigation-destination/index.md)&gt; [rememberNavigator](remember-navigator.md)(initialDestination: [Destination](remember-navigator.md)): [Navigator](../../../navigation-core/navigation-core/com.chrynan.navigation/-navigator/index.md)&lt;[Destination](remember-navigator.md), [SingleNavigationContext](../../../navigation-core/navigation-core/com.chrynan.navigation/-single-navigation-context/index.md)&lt;[Destination](remember-navigator.md)&gt;&gt;

Creates and remembers a [Navigator](../../../navigation-core/navigation-core/com.chrynan.navigation/-navigator/index.md). A [Navigator](../../../navigation-core/navigation-core/com.chrynan.navigation/-navigator/index.md) can be used to navigate between different UI content in an application.

Example usage:

```kotlin
val navigator = rememberNavigator(initialDestination = "Greeting")

// The NavContainer will start by displaying the initial content, which in this case is "Hello"
NavContainer(navigator) { _, key ->
    when (key) {
        "Greeting" -> Text("Hello")
        "Farewell" -> Text("Good-bye")
        else -> Text("Unexpected Key: $key")
    }
}

// The above NavContainer will display "Good Bye" after the following call:
navigator.goTo("Farewell")

// Goes back to the initial content: "Hello":
navigator.goBack()
```

**Note:** Use the [NavContainer](-nav-container.md) to display the [Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html) content for the current navigation context and keys.

**Note:** This function differs slightly from the [rememberNavigator](remember-navigator.md) function in that it only uses a single scope of type [Nothing](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-nothing/index.html). This means that scopes cannot be changed on the returned [ComposeNavigatorImpl](../../../navigation-compose/com.chrynan.navigation.compose/-compose-navigator-impl/index.md).

#### See also

common

| |
|---|
| [rememberNavigator](remember-navigator.md) |

[common]\

@[ExperimentalNavigationApi](../../../navigation-core/navigation-core/com.chrynan.navigation/-experimental-navigation-api/index.md)

@[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)

fun &lt;[Destination](remember-navigator.md) : [NavigationDestination](../../../navigation-core/com.chrynan.navigation/-navigation-destination/index.md), [Context](remember-navigator.md) : [NavigationContext](../../../navigation-core/navigation-core/com.chrynan.navigation/-navigation-context/index.md)&lt;[Destination](remember-navigator.md)&gt;&gt; [rememberNavigator](remember-navigator.md)(initialContext: [Context](remember-navigator.md)): [Navigator](../../../navigation-core/navigation-core/com.chrynan.navigation/-navigator/index.md)&lt;[Destination](remember-navigator.md), [Context](remember-navigator.md)&gt;

Creates and remembers a [Navigator](../../../navigation-core/navigation-core/com.chrynan.navigation/-navigator/index.md). A [Navigator](../../../navigation-core/navigation-core/com.chrynan.navigation/-navigator/index.md) can be used to navigate between different UI content in an application.

Example usage:

```kotlin
val navigator = rememberNavigator(initialContext = BottomNavBarItem.HELLO)

// The NavContainer will start by displaying the initial content, which in this case is "Hello"
NavContainer(navigator) { context, key ->
        when (key) {
            "Greeting" -> Text("Hello")
            "Farewell" -> Text("Good-bye")
            else -> Text("Unexpected Key: $key")
        }
    }

// The above NavContainer will display "Good Bye" after the following call:
navigator.goTo("Farewell")

// Goes back to the initial content: "Hello":
navigator.goBack()

// Changes the scope to BottomNavBarItem.GOODBYE and displays its initial key, which in this case is "Farewell"
navigator.changeContext(BottomNavBarItem.GOODBYE)
```

**Note:** Use the [NavContainer](-nav-container.md) to display the [Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html) content for the current navigation context and keys.

**Note:** That this function differs slightly from the [rememberNavigator](remember-navigator.md) function in that this function allows changing of scopes, which is useful for more complex navigation.

#### See also

common

| |
|---|
| [rememberNavigator](remember-navigator.md) |
