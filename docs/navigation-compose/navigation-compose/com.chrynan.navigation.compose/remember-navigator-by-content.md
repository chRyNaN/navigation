//[navigation-compose](../../index.md)/[com.chrynan.navigation.compose](index.md)/[rememberNavigatorByContent](remember-navigator-by-content.md)

# rememberNavigatorByContent

[common]\

@[ExperimentalNavigationApi](../../../navigation-core/navigation-core/com.chrynan.navigation/-experimental-navigation-api/index.md)

@Composable

fun &lt;[Key](remember-navigator-by-content.md)&gt; [rememberNavigatorByContent](remember-navigator-by-content.md)(initialKey: [Key](remember-navigator-by-content.md), keySaver: [Saver](-saver/index.md)&lt;[Key](remember-navigator-by-content.md), [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)&gt; = autoSaver(), initialContent: @Composable[ComposeNavigationContentScope](-compose-navigation-content-scope/index.md)&lt;[Nothing](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-nothing/index.html)?, [Key](remember-navigator-by-content.md)&gt;.() -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)): [ComposeNavigatorByContentViewModel](-compose-navigator-by-content-view-model/index.md)&lt;[Nothing](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-nothing/index.html)?, [Key](remember-navigator-by-content.md)&gt;

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

@[ExperimentalNavigationApi](../../../navigation-core/navigation-core/com.chrynan.navigation/-experimental-navigation-api/index.md)

@Composable

fun &lt;[Context](remember-navigator-by-content.md), [Key](remember-navigator-by-content.md)&gt; [rememberNavigatorByContent](remember-navigator-by-content.md)(initialContext: [Context](remember-navigator-by-content.md), keySaver: [Saver](-saver/index.md)&lt;[Key](remember-navigator-by-content.md), [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)&gt; = autoSaver(), initialKeysAndContent: ([Context](remember-navigator-by-content.md)) -&gt; [Pair](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-pair/index.html)&lt;[Key](remember-navigator-by-content.md), @Composable[ComposeNavigationContentScope](-compose-navigation-content-scope/index.md)&lt;[Context](remember-navigator-by-content.md), [Key](remember-navigator-by-content.md)&gt;.() -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)&gt;): [ComposeNavigatorByContentViewModel](-compose-navigator-by-content-view-model/index.md)&lt;[Context](remember-navigator-by-content.md), [Key](remember-navigator-by-content.md)&gt;

@[ExperimentalNavigationApi](../../../navigation-core/navigation-core/com.chrynan.navigation/-experimental-navigation-api/index.md)

@Composable

fun &lt;[Context](remember-navigator-by-content.md) : [NavigationContext](../../../navigation-core/navigation-core/com.chrynan.navigation/-navigation-context/index.md)&lt;[Key](remember-navigator-by-content.md)&gt;, [Key](remember-navigator-by-content.md)&gt; [rememberNavigatorByContent](remember-navigator-by-content.md)(initialContext: [Context](remember-navigator-by-content.md), keySaver: [Saver](-saver/index.md)&lt;[Key](remember-navigator-by-content.md), [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)&gt; = autoSaver(), initialContent: ([Context](remember-navigator-by-content.md)) -&gt; @Composable[ComposeNavigationContentScope](-compose-navigation-content-scope/index.md)&lt;[Context](remember-navigator-by-content.md), [Key](remember-navigator-by-content.md)&gt;.() -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)): [ComposeNavigatorByContentViewModel](-compose-navigator-by-content-view-model/index.md)&lt;[Context](remember-navigator-by-content.md), [Key](remember-navigator-by-content.md)&gt;

Creates and remembers a [ComposeNavigator](-compose-navigator/index.md) that can navigate with a key and Composable content. This allows for explicitly specifying the Composable content to navigate to at the [ComposeNavigatorByContent.goTo](-compose-navigator-by-content/go-to.md) function call site. Meaning the Composable content is more flexible and doesn't need to specified upfront when creating this [ComposeNavigatorByContent](-compose-navigator-by-content/index.md).

Example usage:

val navigator = rememberNavigatorByContent(\
                    initialContext = BottomNavBarItem.HOME,\
                    initialContent = { context -&gt;\
                        when (context) {\
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
