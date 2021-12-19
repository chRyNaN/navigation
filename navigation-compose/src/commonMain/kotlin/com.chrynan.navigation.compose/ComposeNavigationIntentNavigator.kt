package com.chrynan.navigation.compose

import androidx.compose.runtime.Composable
import com.chrynan.navigation.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.filterNotNull

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
class ComposeNavigationIntentNavigatorByKeyViewModel<I : NavigationIntent> internal constructor(
    override val initialKey: I,
    override val content: @Composable ComposeNavigationIntentScope<I>.(key: I) -> Unit
) : BaseComposeNavigatorByKeyViewModel<I, ComposeNavigationIntentScope<I>>(),
    ComposeNavigationIntentStackNavigatorByKey<I> {

    override val keyChanges: Flow<I>
        get() = mutableKeyFlow.filterNotNull()

    override val currentKey: I?
        get() = mutableKeyFlow.value

    override val isInitialized: Boolean = true

    private val mutableKeyFlow = MutableStateFlow<I?>(value = initialKey)

    private val keyStack = mutableListOf<I>()

    override fun goTo(key: I, strategy: NavStackDuplicateContentStrategy) {
        if (keyStack.contains(key) && strategy == NavStackDuplicateContentStrategy.CLEAR_STACK) {
            // Go Back to the content with the provided key using the updated content
            var lastKey = keyStack.lastOrNull()

            while (lastKey != null && lastKey != key) {
                keyStack.removeLast()
                lastKey = keyStack.lastOrNull()
            }

            // Replace the content with the updated content
            mutableKeyFlow.value = key
        } else {
            // Go to the provided content
            addToStack(key = key)
        }
    }

    override fun goBack(): Boolean {
        val wentBack = canGoBack()

        if (wentBack) {
            removeLastFromStack()
        }

        return wentBack
    }

    override fun canGoBack(): Boolean = keyStack.isNotEmpty()

    private fun addToStack(key: I) {
        keyStack.add(key)
        mutableKeyFlow.value = key
    }

    private fun removeLastFromStack() {
        keyStack.removeLast()
        mutableKeyFlow.value = keyStack.lastOrNull()
    }
}
