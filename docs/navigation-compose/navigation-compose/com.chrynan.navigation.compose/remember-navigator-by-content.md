//[navigation-compose](../../index.md)/[com.chrynan.navigation.compose](index.md)/[rememberNavigatorByContent](remember-navigator-by-content.md)

# rememberNavigatorByContent

[common]\

@[ExperimentalNavigationApi](-experimental-navigation-api/index.md)

@Composable

fun &lt;[Key](remember-navigator-by-content.md)&gt; [rememberNavigatorByContent](remember-navigator-by-content.md)(initialKey: [Key](remember-navigator-by-content.md), initialContent: @Composable[ComposeNavigationContentScope](-compose-navigation-content-scope/index.md)&lt;[Key](remember-navigator-by-content.md)&gt;.() -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)): [ComposeNavigatorByContentViewModel](-compose-navigator-by-content-view-model/index.md)&lt;[Nothing](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-nothing/index.html)?, [Key](remember-navigator-by-content.md)&gt;

Creates and remembers a [ComposeNavigator](-compose-navigator/index.md) that can navigate with a key and Composable content. This allows for explicitly specifying the Composable content to navigate to at the [ComposeNavigatorByContent.goTo](-compose-navigator-by-content/go-to.md) function call site. Meaning the Composable content is more flexible and doesn't need to specified upfront when creating this [ComposeNavigatorByContent](-compose-navigator-by-content/index.md).

Example usage:

val navigator = rememberNavigatorByContent("Greeting") { Text("Hello") }\
\
// The NavContainer will start by displaying the initial content, which in this case is "Hello".\
NavContainer(navigator)\
\
// The above NavContainer will display "Good-bye" after the following call:\
navigator.goTo("Farewell") { Text("Good-bye") }\
\
// Goes back to the initial content: "Hello":\
navigator.goBack()

**Note:** That it is typical to use a [ComposeNavigator](-compose-navigator/index.md) with a [NavContainer](-nav-container.md) to display the Composable content and listen to changes.

**Note:** This function differs slightly from the [rememberNavigatorByContent](remember-navigator-by-content.md) function in that it only uses a single scope of type [Nothing](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-nothing/index.html). This means that scopes cannot be changed on the returned [ComposeNavigatorByContentViewModel](-compose-navigator-by-content-view-model/index.md).

## See also

common

| | |
|---|---|
| [rememberNavigatorByContent](remember-navigator-by-content.md) |  |

[common]\

@[ExperimentalNavigationApi](-experimental-navigation-api/index.md)

@Composable

fun &lt;[Scope](remember-navigator-by-content.md), [Key](remember-navigator-by-content.md)&gt; [rememberNavigatorByContent](remember-navigator-by-content.md)(initialScope: [Scope](remember-navigator-by-content.md), initialKeysAndContent: ([Scope](remember-navigator-by-content.md)) -&gt; [Pair](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-pair/index.html)&lt;[Key](remember-navigator-by-content.md), @Composable[ComposeNavigationContentScope](-compose-navigation-content-scope/index.md)&lt;[Key](remember-navigator-by-content.md)&gt;.() -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)&gt;): [ComposeNavigatorByContentViewModel](-compose-navigator-by-content-view-model/index.md)&lt;[Scope](remember-navigator-by-content.md), [Key](remember-navigator-by-content.md)&gt;

Creates and remembers a [ComposeNavigator](-compose-navigator/index.md) that can navigate with a key and Composable content. This allows for explicitly specifying the Composable content to navigate to at the [ComposeNavigatorByContent.goTo](-compose-navigator-by-content/go-to.md) function call site. Meaning the Composable content is more flexible and doesn't need to specified upfront when creating this [ComposeNavigatorByContent](-compose-navigator-by-content/index.md).

Example usage:

val navigator = rememberNavigatorByContent(\
                    initialScope = BottomNavBarItem.HOME,\
                    initialKeysAndContent = { scope -&gt;\
                        when (scope) {\
                            is BottomNavBarItem.HOME -&gt; "Greeting" to { Text("Hello") }\
                        }\
                    }\
                )\
\
// The NavContainer will start by displaying the initial content, which in this case is "Hello".\
NavContainer(navigator)\
\
// The above NavContainer will display "Good-bye" after the following call:\
navigator.goTo("Farewell") { Text("Good-bye") }\
\
// Goes back to the initial content: "Hello":\
navigator.goBack()

**Note:** That it is typical to use a [ComposeNavigator](-compose-navigator/index.md) with a [NavContainer](-nav-container.md) to display the Composable content and listen to changes.

**Note:** That this function differs slightly from the [rememberNavigatorByContent](remember-navigator-by-content.md) function in that this function allows changing of scopes, which is useful for more complex navigation.

## See also

common

| | |
|---|---|
| [rememberNavigatorByContent](remember-navigator-by-content.md) |  |
