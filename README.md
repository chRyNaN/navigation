# navigation

Kotlin multi-platform application navigation library. Supports Jetpack Compose. <br/>
<img alt="GitHub tag (latest by date)" src="https://img.shields.io/github/v/tag/chRyNaN/navigation">

```kotlin
val navigator = rememberNavigatorByKey("Greeting") { key ->
    when (key) {
        "Greeting" -> Text("Hello")
        "Farewell" -> Text("Good-bye")
        else -> Text("Unexpected Key: $key")
    }
}

navigator.goTo("Farewell")
```

### Usage

Navigation is handled differently for each platform and UI framework. This library provides some common navigation
components that serve as a recommended structure, but each platform and UI framework is independently responsible for
handling navigation and choosing whether to conform to the provided components.

#### Jetpack Compose

There are three different `ComposeNavigators` that can handle navigation in Jetpack Compose. Which one to use depends on
the application needs and personal preference.

##### Navigate by content

This approach allows for specifying the `@Composable` content on demand, rather than up-front.

```kotlin
val navigator = rememberNavigatorByContent("Greeting") { Text("Hello") }

// The NavContainer will start by displaying the initial content, which in this case is "Hello".
NavContainer(navigator)

// The above NavContainer will display "Good-bye" after the following call:
navigator.goTo("Farewell") { Text("Good-bye") }

// Goes back to the initial content: "Hello":
navigator.goBack()
```

##### Navigate by key

This approach allows for specifying the `@Composable` content for each key up-front. Then navigation can be done by
simply providing a key.

```kotlin
val navigator = rememberNavigatorByKey("Greeting") { key ->
    when (key) {
        "Greeting" -> Text("Hello")
        "Farewell" -> Text("Good-bye")
        else -> Text("Unexpected Key: $key")
    }
}

// The NavContainer will start by displaying the initial content, which in this case is "Hello"
NavContainer(navigator)

// The above NavContainer will display "Good Bye" after the following call:
navigator.goTo("Farewell")

// Goes back to the initial content: "Hello":
navigator.goBack()
```

##### Navigate by NavigationIntent

This approach is similar to the key approach, but the key is a `NavigationIntent` and the returned `ComposeNavigator`
implements the `NavigationEventNavigator` interface from the `core` module.

```kotlin
val navigator = rememberNavigatorByIntent(HomeNavigationIntent.Greeting) { navigationIntent ->
    when (navigationIntent) {
        HomeNavigationIntent.Greeting -> Text("Hello")
        HomeNavigationIntent.Farewell -> Text("Good-bye")
    }
}

// The NavContainer will start by displaying the initial content, which in this case is "Hello"
NavContainer(navigator)

// The above NavContainer will display "Good Bye" after the following call:
navigator.goTo(HomeNavigationIntent.Farewell)

// Goes back to the initial content: "Hello":
navigator.goBack()
```

#### Android

To create a `Navigator` use one the provided `navigator()` functions. For instance:

```kotlin
val navigator = navigator<NavigationIntent>(activity = activity, onGoTo = { navigationIntent ->
    activity.startActivity(...)
})

navigator.goBack()
```

## Building the library

The library is provided through [Repsy.io](https://repsy.io/). Checkout
the [releases page](https://github.com/chRyNaN/navigation/releases) to get the latest version. <br/>
<img alt="GitHub tag (latest by date)" src="https://img.shields.io/github/v/tag/chRyNaN/navigation">

### Repository

```groovy
repositories {
    maven {
        url = uri("https://repo.repsy.io/mvn/chrynan/public")
    }
}
```

### Dependencies

#### core

```groovy
implementation("com.chrynan.navigation:navigation-core:VERSION")
```

#### compose

```groovy
implementation("com.chrynan.navigation:navigation-compose:VERSION")
```

## Documentation

More detailed documentation is available in the [docs](docs/) folder. The entry point to the documentation can be
found [here](docs/index.md).

## License

```
Copyright 2021 chRyNaN

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```
