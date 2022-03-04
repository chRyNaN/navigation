//[navigation-compose](../../index.md)/[com.chrynan.navigation.compose](index.md)/[rememberNavigatorByKey](remember-navigator-by-key.md)

# rememberNavigatorByKey

[common]\

@[ExperimentalNavigationApi](../../../navigation-core/navigation-core/com.chrynan.navigation/-experimental-navigation-api/index.md)

@Composable

fun &lt;[Key](remember-navigator-by-key.md)&gt; [rememberNavigatorByKey](remember-navigator-by-key.md)(initialKey: [Key](remember-navigator-by-key.md), keySaver: [Saver](-saver/index.md)&lt;[Key](remember-navigator-by-key.md), [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)&gt; = autoSaver(), content: @Composable[ComposeNavigationKeyScope](-compose-navigation-key-scope/index.md)&lt;[Nothing](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-nothing/index.html)?, [Key](remember-navigator-by-key.md)&gt;.([Key](remember-navigator-by-key.md)) -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)): [ComposeNavigatorByKeyViewModel](-compose-navigator-by-key-view-model/index.md)&lt;[Nothing](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-nothing/index.html)?, [Key](remember-navigator-by-key.md)&gt;

Creates and remembers a [ComposeNavigator](-compose-navigator/index.md) that can navigate with a key. This allows for specifying the Composable content up front when creating this [ComposeNavigatorByKey](-compose-navigator-by-key/index.md) and simply navigating with a key from the [ComposeNavigatorByKey.goTo](-compose-navigator-by-key/go-to.md) function.

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
navigator.goTo("Farewell")\
\
// Goes back to the initial content: "Hello":\
navigator.goBack()

**Note:** That it is typical to use a [ComposeNavigator](-compose-navigator/index.md) with a [NavContainer](-nav-container.md) to display the Composable content and listen to changes.

**Note:** This function differs slightly from the [rememberNavigatorByKey](remember-navigator-by-key.md) function in that it only uses a single scope of type [Nothing](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-nothing/index.html). This means that scopes cannot be changed on the returned [ComposeNavigatorByKeyViewModel](-compose-navigator-by-key-view-model/index.md).

## See also

common

| | |
|---|---|
| [rememberNavigatorByKey](remember-navigator-by-key.md) |  |

[common]\

@[ExperimentalNavigationApi](../../../navigation-core/navigation-core/com.chrynan.navigation/-experimental-navigation-api/index.md)

@Composable

fun &lt;[Context](remember-navigator-by-key.md), [Key](remember-navigator-by-key.md)&gt; [rememberNavigatorByKey](remember-navigator-by-key.md)(initialContext: [Context](remember-navigator-by-key.md), initialKeys: ([Context](remember-navigator-by-key.md)) -&gt; [Key](remember-navigator-by-key.md), keySaver: [Saver](-saver/index.md)&lt;[Key](remember-navigator-by-key.md), [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)&gt; = autoSaver(), content: @Composable[ComposeNavigationKeyScope](-compose-navigation-key-scope/index.md)&lt;[Context](remember-navigator-by-key.md), [Key](remember-navigator-by-key.md)&gt;.([Key](remember-navigator-by-key.md)) -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)): [ComposeNavigatorByKeyViewModel](-compose-navigator-by-key-view-model/index.md)&lt;[Context](remember-navigator-by-key.md), [Key](remember-navigator-by-key.md)&gt;

Creates and remembers a [ComposeNavigator](-compose-navigator/index.md) that can navigate with a key. This allows for specifying the Composable content up front when creating this [ComposeNavigatorByKey](-compose-navigator-by-key/index.md) and simply navigating with a key from the [ComposeNavigatorByKey.goTo](-compose-navigator-by-key/go-to.md) function.

Example usage:

val navigator = rememberNavigatorByKey(\
    initialContext = BottomNavBarItem.HELLO,\
    initialKeys = { scope -&gt;\
        when(scope) {\
            BottomNavBarItem.HELLO -&gt; "Greeting"\
            BottomNavBarItem.GOODBYE -&gt; "Farewell"\
            ...\
        }\
    },\
    content = { key -&gt;\
        when(key) {\
            "Greeting" -&gt; Text("Hello")\
            "Farewell" -&gt; Text("Good-bye")\
            else -&gt; Text("Unexpected Key: $key")\
        }\
    }\
)\
\
// The NavContainer will start by displaying the initial content, which in this case is "Hello"\
NavContainer(navigator)\
\
// The above NavContainer will display "Good Bye" after the following call:\
navigator.goTo("Farewell")\
\
// Goes back to the initial content: "Hello":\
navigator.goBack()\
\
// Changes the scope to BottomNavBarItem.GOODBYE and displays its initial key, which in this case is "Farewell"\
navigator.changeContext(BottomNavBarItem.GOODBYE)

**Note:** That it is typical to use a [ComposeNavigator](-compose-navigator/index.md) with a [NavContainer](-nav-container.md) to display the Composable content and listen to changes.

**Note:** That this function differs slightly from the [rememberNavigatorByKey](remember-navigator-by-key.md) function in that this function allows changing of scopes, which is useful for more complex navigation.

## See also

common

| | |
|---|---|
| [rememberNavigatorByKey](remember-navigator-by-key.md) |  |

[common]\

@[ExperimentalNavigationApi](../../../navigation-core/navigation-core/com.chrynan.navigation/-experimental-navigation-api/index.md)

@Composable

fun &lt;[Context](remember-navigator-by-key.md) : [NavigationContext](../../../navigation-core/navigation-core/com.chrynan.navigation/-navigation-context/index.md)&lt;[Key](remember-navigator-by-key.md)&gt;, [Key](remember-navigator-by-key.md)&gt; [rememberNavigatorByKey](remember-navigator-by-key.md)(initialContext: [Context](remember-navigator-by-key.md), keySaver: [Saver](-saver/index.md)&lt;[Key](remember-navigator-by-key.md), [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)&gt; = autoSaver(), content: @Composable[ComposeNavigationKeyScope](-compose-navigation-key-scope/index.md)&lt;[Context](remember-navigator-by-key.md), [Key](remember-navigator-by-key.md)&gt;.([Key](remember-navigator-by-key.md)) -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)): [ComposeNavigatorByKeyViewModel](-compose-navigator-by-key-view-model/index.md)&lt;[Context](remember-navigator-by-key.md), [Key](remember-navigator-by-key.md)&gt;

Creates and remembers a [ComposeNavigator](-compose-navigator/index.md) that can navigate with a key. This allows for specifying the Composable content up front when creating this [ComposeNavigatorByKey](-compose-navigator-by-key/index.md) and simply navigating with a key from the [ComposeNavigatorByKey.goTo](-compose-navigator-by-key/go-to.md) function.

Example usage:

val navigator = rememberNavigatorByKey(\
    initialContext = BottomNavBarItem.HELLO,\
    content = { key -&gt;\
        when(key) {\
            "Greeting" -&gt; Text("Hello")\
            "Farewell" -&gt; Text("Good-bye")\
            else -&gt; Text("Unexpected Key: $key")\
        }\
    }\
)\
\
// The NavContainer will start by displaying the initial content, which in this case is "Hello"\
NavContainer(navigator)\
\
// The above NavContainer will display "Good Bye" after the following call:\
navigator.goTo("Farewell")\
\
// Goes back to the initial content: "Hello":\
navigator.goBack()\
\
// Changes the scope to BottomNavBarItem.GOODBYE and displays its initial key, which in this case is "Farewell"\
navigator.changeContext(BottomNavBarItem.GOODBYE)

**Note:** That it is typical to use a [ComposeNavigator](-compose-navigator/index.md) with a [NavContainer](-nav-container.md) to display the Composable content and listen to changes.

**Note:** That this function differs slightly from the [rememberNavigatorByKey](remember-navigator-by-key.md) function in that this function allows changing of scopes, which is useful for more complex navigation.

## See also

common

| | |
|---|---|
| [rememberNavigatorByKey](remember-navigator-by-key.md) |  |
