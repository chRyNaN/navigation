//[navigation-compose](../../index.md)/[com.chrynan.navigation.compose](index.md)/[rememberNavigatorByIntent](remember-navigator-by-intent.md)

# rememberNavigatorByIntent

[common]\

@[ExperimentalNavigationApi](../../../navigation-core/navigation-core/com.chrynan.navigation/-experimental-navigation-api/index.md)

@Composable

fun &lt;[Intent](remember-navigator-by-intent.md) : [NavigationIntent](../../../navigation-core/navigation-core/com.chrynan.navigation/-navigation-intent/index.md)&gt; [rememberNavigatorByIntent](remember-navigator-by-intent.md)(initialIntent: [Intent](remember-navigator-by-intent.md), keySaver: [Saver](-saver/index.md)&lt;[Intent](remember-navigator-by-intent.md), [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)&gt; = autoSaver(), content: @Composable[ComposeNavigationIntentScope](-compose-navigation-intent-scope/index.md)&lt;[Nothing](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-nothing/index.html)?, [Intent](remember-navigator-by-intent.md)&gt;.([Intent](remember-navigator-by-intent.md)) -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)): [ComposeNavigationIntentNavigatorByKeyViewModel](-compose-navigation-intent-navigator-by-key-view-model/index.md)&lt;[Nothing](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-nothing/index.html)?, [Intent](remember-navigator-by-intent.md)&gt;

Creates and remembers a [ComposeNavigator](-compose-navigator/index.md) that can navigate with a [NavigationIntent](../../../navigation-core/navigation-core/com.chrynan.navigation/-navigation-intent/index.md) as a key. This allows for specifying the Composable content up front when creating this [ComposeNavigatorByKey](-compose-navigator-by-key/index.md) and simply navigating with a [NavigationIntent](../../../navigation-core/navigation-core/com.chrynan.navigation/-navigation-intent/index.md) key from the [ComposeNavigatorByKey.goTo](-compose-navigator-by-key/go-to.md) function. The returned [ComposeNavigator](-compose-navigator/index.md) implements the [Navigator](../../../navigation-core/navigation-core/com.chrynan.navigation/-navigator/index.md) interface.

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
navigator.goTo(HomeNavigationIntent.Farewell)\
\
// Goes back to the initial content: "Hello":\
navigator.goBack()

**Note:** That it is typical to use a [ComposeNavigator](-compose-navigator/index.md) with a [NavContainer](-nav-container.md) to display the Composable content and listen to changes.

**Note:** This function differs slightly from the [rememberNavigatorByIntent](remember-navigator-by-intent.md) function in that it only uses a single scope of type [Nothing](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-nothing/index.html). This means that scopes cannot be changed on the returned [ComposeNavigationIntentNavigatorByKeyViewModel](-compose-navigation-intent-navigator-by-key-view-model/index.md).

## See also

common

| | |
|---|---|
| [rememberNavigatorByIntent](remember-navigator-by-intent.md) |  |

[common]\

@[ExperimentalNavigationApi](../../../navigation-core/navigation-core/com.chrynan.navigation/-experimental-navigation-api/index.md)

@Composable

fun &lt;[Context](remember-navigator-by-intent.md), [Intent](remember-navigator-by-intent.md) : [NavigationIntent](../../../navigation-core/navigation-core/com.chrynan.navigation/-navigation-intent/index.md)&gt; [rememberNavigatorByIntent](remember-navigator-by-intent.md)(initialContext: [Context](remember-navigator-by-intent.md), initialIntents: ([Context](remember-navigator-by-intent.md)) -&gt; [Intent](remember-navigator-by-intent.md), keySaver: [Saver](-saver/index.md)&lt;[Intent](remember-navigator-by-intent.md), [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)&gt; = autoSaver(), content: @Composable[ComposeNavigationIntentScope](-compose-navigation-intent-scope/index.md)&lt;[Context](remember-navigator-by-intent.md), [Intent](remember-navigator-by-intent.md)&gt;.([Intent](remember-navigator-by-intent.md)) -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)): [ComposeNavigationIntentNavigatorByKeyViewModel](-compose-navigation-intent-navigator-by-key-view-model/index.md)&lt;[Context](remember-navigator-by-intent.md), [Intent](remember-navigator-by-intent.md)&gt;

Creates and remembers a [ComposeNavigator](-compose-navigator/index.md) that can navigate with a [NavigationIntent](../../../navigation-core/navigation-core/com.chrynan.navigation/-navigation-intent/index.md) as a key. This allows for specifying the Composable content up front when creating this [ComposeNavigatorByKey](-compose-navigator-by-key/index.md) and simply navigating with a [NavigationIntent](../../../navigation-core/navigation-core/com.chrynan.navigation/-navigation-intent/index.md) key from the [ComposeNavigatorByKey.goTo](-compose-navigator-by-key/go-to.md) function. The returned [ComposeNavigator](-compose-navigator/index.md) implements the [Navigator](../../../navigation-core/navigation-core/com.chrynan.navigation/-navigator/index.md) interface.

Example usage:

val navigator = rememberNavigatorByKey(\
    initialContext = BottomNavBarItem.HELLO,\
    initialKeys = { scope -&gt;\
        when(scope) {\
            BottomNavBarItem.HELLO -&gt; HomeNavigationIntent.Greeting\
            BottomNavBarItem.GOODBYE -&gt; HomeNavigationIntent.Farewell\
            ...\
        }\
    },\
    content = { navigationIntent -&gt;\
        when(navigationIntent) {\
            HomeNavigationIntent.Greeting -&gt; Text("Hello")\
            HomeNavigationIntent.Farewell -&gt; Text("Good-bye")\
        }\
    }\
)\
\
// The NavContainer will start by displaying the initial content, which in this case is "Hello"\
NavContainer(navigator)\
\
// The above NavContainer will display "Good Bye" after the following call:\
navigator.goTo(HomeNavigationIntent.Farewell)\
\
// Goes back to the initial content: "Hello":\
navigator.goBack()

**Note:** That it is typical to use a [ComposeNavigator](-compose-navigator/index.md) with a [NavContainer](-nav-container.md) to display the Composable content and listen to changes.

**Note:** That this function differs slightly from the [rememberNavigatorByIntent](remember-navigator-by-intent.md) function in that this function allows changing of scopes, which is useful for more complex navigation.

## See also

common

| | |
|---|---|
| [rememberNavigatorByIntent](remember-navigator-by-intent.md) |  |

[common]\

@[ExperimentalNavigationApi](../../../navigation-core/navigation-core/com.chrynan.navigation/-experimental-navigation-api/index.md)

@Composable

fun &lt;[Context](remember-navigator-by-intent.md) : [NavigationContext](../../../navigation-core/navigation-core/com.chrynan.navigation/-navigation-context/index.md)&lt;[Intent](remember-navigator-by-intent.md)&gt;, [Intent](remember-navigator-by-intent.md) : [NavigationIntent](../../../navigation-core/navigation-core/com.chrynan.navigation/-navigation-intent/index.md)&gt; [rememberNavigatorByIntent](remember-navigator-by-intent.md)(initialContext: [Context](remember-navigator-by-intent.md), keySaver: [Saver](-saver/index.md)&lt;[Intent](remember-navigator-by-intent.md), [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)&gt; = autoSaver(), content: @Composable[ComposeNavigationIntentScope](-compose-navigation-intent-scope/index.md)&lt;[Context](remember-navigator-by-intent.md), [Intent](remember-navigator-by-intent.md)&gt;.([Intent](remember-navigator-by-intent.md)) -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)): [ComposeNavigationIntentNavigatorByKeyViewModel](-compose-navigation-intent-navigator-by-key-view-model/index.md)&lt;[Context](remember-navigator-by-intent.md), [Intent](remember-navigator-by-intent.md)&gt;

Creates and remembers a [ComposeNavigator](-compose-navigator/index.md) that can navigate with a [NavigationIntent](../../../navigation-core/navigation-core/com.chrynan.navigation/-navigation-intent/index.md) as a key. This allows for specifying the Composable content up front when creating this [ComposeNavigatorByKey](-compose-navigator-by-key/index.md) and simply navigating with a [NavigationIntent](../../../navigation-core/navigation-core/com.chrynan.navigation/-navigation-intent/index.md) key from the [ComposeNavigatorByKey.goTo](-compose-navigator-by-key/go-to.md) function. The returned [ComposeNavigator](-compose-navigator/index.md) implements the [Navigator](../../../navigation-core/navigation-core/com.chrynan.navigation/-navigator/index.md) interface.

Example usage:

val navigator = rememberNavigatorByKey(\
    initialContext = BottomNavBarItem.HELLO,\
    content = { navigationIntent -&gt;\
        when(navigationIntent) {\
            HomeNavigationIntent.Greeting -&gt; Text("Hello")\
            HomeNavigationIntent.Farewell -&gt; Text("Good-bye")\
        }\
    }\
)\
\
// The NavContainer will start by displaying the initial content, which in this case is "Hello"\
NavContainer(navigator)\
\
// The above NavContainer will display "Good Bye" after the following call:\
navigator.goTo(HomeNavigationIntent.Farewell)\
\
// Goes back to the initial content: "Hello":\
navigator.goBack()

**Note:** That it is typical to use a [ComposeNavigator](-compose-navigator/index.md) with a [NavContainer](-nav-container.md) to display the Composable content and listen to changes.

**Note:** That this function differs slightly from the [rememberNavigatorByIntent](remember-navigator-by-intent.md) function in that this function allows changing of scopes, which is useful for more complex navigation.

## See also

common

| | |
|---|---|
| [rememberNavigatorByIntent](remember-navigator-by-intent.md) |  |
