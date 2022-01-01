//[navigation-compose](../../index.md)/[com.chrynan.navigation.compose](index.md)/[currentScopeAsState](current-scope-as-state.md)

# currentScopeAsState

[common]\

@[ExperimentalNavigationApi](-experimental-navigation-api/index.md)

@Composable

fun &lt;[Scope](current-scope-as-state.md), [Key](current-scope-as-state.md)&gt; [ComposeScopedNavigator](-compose-scoped-navigator/index.md)&lt;[Scope](current-scope-as-state.md), [Key](current-scope-as-state.md)&gt;.[currentScopeAsState](current-scope-as-state.md)(initialCurrentScope: [Scope](current-scope-as-state.md)): State&lt;[Scope](current-scope-as-state.md)&gt;

@[ExperimentalNavigationApi](-experimental-navigation-api/index.md)

@Composable

fun &lt;[Scope](current-scope-as-state.md), [Key](current-scope-as-state.md)&gt; [ComposeScopedNavigator](-compose-scoped-navigator/index.md)&lt;[Scope](current-scope-as-state.md), [Key](current-scope-as-state.md)&gt;.[currentScopeAsState](current-scope-as-state.md)(): State&lt;[Scope](current-scope-as-state.md)&gt;

Obtains the changes to the [ComposeScopedNavigator.currentScope](-compose-scoped-navigator/current-scope.md) value and returns it as a State. This allows it to be used in a Composable and cause recomposition when the value changes.

If you just need to get the current scope value and do not need to cause recomposition when the value changes, simply use the [ComposeScopedNavigator.currentScope](-compose-scoped-navigator/current-scope.md) property.

**Note:** Internally this function uses the [ComposeScopedNavigator.scopeChanges](-compose-scoped-navigator/scope-changes.md) Flow and the collectAsState function using the [ComposeScopedNavigator.currentScope](-compose-scoped-navigator/current-scope.md) as the initial value.

## See also

common

| | |
|---|---|
| [com.chrynan.navigation.compose.ComposeScopedNavigator](-compose-scoped-navigator/scope-changes.md) |  |
| collectAsState |  |
