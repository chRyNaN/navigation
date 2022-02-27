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
class ComposeNavigationIntentNavigatorByKeyViewModel<Context, Intent : NavigationIntent> internal constructor(
    initialScope: Context,
    initialKeys: (Context) -> Intent,
    keySaver: Saver<Intent, Any>,
    override val content: @Composable ComposeNavigationIntentScope<Intent>.(key: Intent) -> Unit
) : BaseComposeNavigatorByKeyViewModel<Context, Intent, ComposeNavigationIntentScope<Intent>>(
    initialContext = initialScope,
    initialKeys = initialKeys,
    keySaver = keySaver
), ComposeNavigationIntentStackNavigatorByKey<Intent>
