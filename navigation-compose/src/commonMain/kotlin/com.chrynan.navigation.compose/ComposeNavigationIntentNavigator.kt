package com.chrynan.navigation.compose

import androidx.compose.runtime.Composable
import com.chrynan.navigation.*

@ExperimentalNavigationApi
interface ComposeNavigationIntentStackNavigatorByKey<I : NavigationIntent> :
    ComposeStackNavigatorByKey<I>,
    NavigationEventHandler<I, ComposeNavigationIntentScope<I>>,
    NavigationEventNavigator<I> {

    override fun ComposeNavigationIntentScope<I>.onGoBack() {
        goBack()
    }

    override fun ComposeNavigationIntentScope<I>.onGoUp() = onGoBack()

    override fun ComposeNavigationIntentScope<I>.onGoTo(intent: I) = goTo(key = intent)

    override fun navigate(event: NavigationEvent<I>) {
        val scope = object : ComposeNavigationIntentScope<I> {

            override val navigator: ComposeNavigationIntentStackNavigatorByKey<I>
                get() = this@ComposeNavigationIntentStackNavigatorByKey
        }

        scope.onNavigate(event = event)
    }
}

@ExperimentalNavigationApi
class ComposeNavigationIntentNavigatorByKeyViewModel<Scope, Intent : NavigationIntent> internal constructor(
    initialScope: Scope,
    initialKeys: (Scope) -> Intent,
    override val content: @Composable ComposeNavigationIntentScope<Intent>.(key: Intent) -> Unit
) : BaseComposeNavigatorByKeyViewModel<Scope, Intent, ComposeNavigationIntentScope<Intent>>(
    initialScope = initialScope,
    initialKeys = initialKeys
), ComposeNavigationIntentStackNavigatorByKey<Intent>
