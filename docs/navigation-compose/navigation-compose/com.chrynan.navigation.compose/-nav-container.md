//[navigation-compose](../../index.md)/[com.chrynan.navigation.compose](index.md)/[NavContainer](-nav-container.md)

# NavContainer

[common]\

@Composable

@[ExperimentalNavigationApi](-experimental-navigation-api/index.md)

fun &lt;[Scope](-nav-container.md), [Key](-nav-container.md)&gt; [NavContainer](-nav-container.md)(navigator: [ComposeNavigatorByContentViewModel](-compose-navigator-by-content-view-model/index.md)&lt;[Scope](-nav-container.md), [Key](-nav-container.md)&gt;)

Displays the content from a [navigator](-nav-container.md) in this Composable UI Container.

When the [navigator](-nav-container.md) changes its content, even outside this [NavContainer](-nav-container.md), it will be reflected within this UI container.

Example usage:

val navigator = rememberNavigatorByContent("Greeting") { Text("Hello") }\
\
// The NavContainer will start by displaying the initial content, which in this case is "Hello".\
NavContainer(navigator)\
\
// The above NavContainer will display "Good-bye" after the following call:\
navigator.goTo("Farewell") { Text("Good-bye") }

## See also

common

| | |
|---|---|
| [rememberNavigatorByContent](remember-navigator-by-content.md) |  |

[common]\

@Composable

@[ExperimentalNavigationApi](-experimental-navigation-api/index.md)

fun &lt;[Scope](-nav-container.md), [Key](-nav-container.md)&gt; [NavContainer](-nav-container.md)(navigator: [ComposeNavigatorByKeyViewModel](-compose-navigator-by-key-view-model/index.md)&lt;[Scope](-nav-container.md), [Key](-nav-container.md)&gt;)

Displays the content from a [navigator](-nav-container.md) in this Composable UI Container.

When the [navigator](-nav-container.md) changes its content, even outside this [NavContainer](-nav-container.md), it will be reflected within this UI container.

Example usage:

val navigator = rememberNavigatorByKey("Greeting") { key -&gt;\
    when(key) {\
        "Greeting" -&gt; Text("Hello")\
        "Farewell" -&gt; Text("Good-bye")\
        else -&gt; Text("Unexpected Key: $key")\
    }\
}\
\
// The NavContainer will start by displaying the initial content, which in this case is "Hello"\
NavContainer(navigator)\
\
// The above NavContainer will display "Good Bye" after the following call:\
navigator.goTo("Farewell")

## See also

common

| | |
|---|---|
| [rememberNavigatorByKey](remember-navigator-by-key.md) |  |

[common]\

@Composable

@[ExperimentalNavigationApi](-experimental-navigation-api/index.md)

fun &lt;[Scope](-nav-container.md), [Intent](-nav-container.md) : [NavigationIntent](../../../navigation-core/navigation-core/com.chrynan.navigation/-navigation-intent/index.md)&gt; [NavContainer](-nav-container.md)(navigator: [ComposeNavigationIntentNavigatorByKeyViewModel](-compose-navigation-intent-navigator-by-key-view-model/index.md)&lt;[Scope](-nav-container.md), [Intent](-nav-container.md)&gt;)

Displays the content from a [navigator](-nav-container.md) in this Composable UI Container.

When the [navigator](-nav-container.md) changes its content, even outside this [NavContainer](-nav-container.md), it will be reflected within this UI container.

Example usage:

val navigator = rememberNavigatorByKey(HomeNavigationIntent.Greeting) { navigationIntent -&gt;\
    when(navigationIntent) {\
        HomeNavigationIntent.Greeting -&gt; Text("Hello")\
        HomeNavigationIntent.Farewell -&gt; Text("Good-bye")\
    }\
}\
\
// The NavContainer will start by displaying the initial content, which in this case is "Hello"\
NavContainer(navigator)\
\
// The above NavContainer will display "Good Bye" after the following call:\
navigator.goTo(HomeNavigationIntent.Farewell)

## See also

common

| | |
|---|---|
| [rememberNavigatorByIntent](remember-navigator-by-intent.md) |  |
