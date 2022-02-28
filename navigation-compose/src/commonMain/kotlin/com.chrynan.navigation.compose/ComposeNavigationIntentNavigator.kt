package com.chrynan.navigation.compose

import androidx.compose.runtime.Composable
import com.chrynan.navigation.*

@ExperimentalNavigationApi
interface ComposeNavigationIntentStackNavigatorByKey<Context, Intent : NavigationIntent> :
    ComposeNavigatorByKey<Context, Intent>,
    NavigationEventHandler<Intent, ComposeNavigationIntentScope<Context, Intent>>,
    NavigationEventNavigator<Intent> {

    val scope: ComposeNavigationIntentScope<Context, Intent>

    override fun ComposeNavigationIntentScope<Context, Intent>.onGoBack() {
        goBack()
    }

    override fun ComposeNavigationIntentScope<Context, Intent>.onGoUp() = onGoBack()

    override fun ComposeNavigationIntentScope<Context, Intent>.onGoTo(value: Intent) = goTo(key = value)

    override fun navigate(event: NavigationEvent<Intent>) {
        scope.onNavigate(value = event)
    }
}

@ExperimentalNavigationApi
class ComposeNavigationIntentNavigatorByKeyViewModel<Context, Intent : NavigationIntent> internal constructor(
    initialScope: Context,
    initialKeys: (Context) -> Intent,
    keySaver: Saver<Intent, Any>,
    override val content: @Composable ComposeNavigationIntentScope<Context, Intent>.(key: Intent) -> Unit
) : BaseComposeNavigatorByKeyViewModel<Context, Intent, ComposeNavigationIntentScope<Context, Intent>>(
    initialContext = initialScope,
    initialKeys = initialKeys,
    keySaver = keySaver
), ComposeNavigationIntentStackNavigatorByKey<Context, Intent> {

    override val scope = object : ComposeNavigationIntentScope<Context, Intent> {

        override val navigator: ComposeNavigationIntentNavigatorByKeyViewModel<Context, Intent>
            get() = this@ComposeNavigationIntentNavigatorByKeyViewModel
    }

    override fun goBack(): Boolean = super<BaseComposeNavigatorByKeyViewModel>.goBack()
}
