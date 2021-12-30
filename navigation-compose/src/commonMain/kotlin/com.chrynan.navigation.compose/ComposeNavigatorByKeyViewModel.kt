package com.chrynan.navigation.compose

import androidx.compose.runtime.Composable
import com.chrynan.presentation.ViewModel
import com.chrynan.navigation.NavStackDuplicateContentStrategy
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.filterNotNull

@ExperimentalNavigationApi
abstract class BaseComposeNavigatorByKeyViewModel<T, S : ComposeNavigationKeyScope<T>> : ViewModel(),
    ComposeNavigator<T>,
    ComposeNavigatorByKey<T>,
    ComposeStackNavigatorByKey<T> {

    internal abstract val content: @Composable S.(key: T) -> Unit
}

@ExperimentalNavigationApi
class ComposeNavigatorByKeyViewModel<T> internal constructor(
    override val initialKey: T,
    override val content: @Composable ComposeNavigationKeyScope<T>.(key: T) -> Unit
) : BaseComposeNavigatorByKeyViewModel<T, ComposeNavigationKeyScope<T>>() {

    override val keyChanges: Flow<T>
        get() = mutableKeyFlow.filterNotNull()

    override val currentKey: T
        get() = mutableKeyFlow.value

    override val isInitialized: Boolean = true

    private val mutableKeyFlow = MutableStateFlow(value = initialKey)

    private val keyStack = mutableListOf<T>()

    override fun goTo(key: T, strategy: NavStackDuplicateContentStrategy) {
        if (key == currentKey) return

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

    override fun canGoBack(): Boolean = keyStack.size > 1

    private fun addToStack(key: T) {
        keyStack.add(key)
        mutableKeyFlow.value = key
    }

    private fun removeLastFromStack() {
        keyStack.removeLast()
        mutableKeyFlow.value = keyStack.last()
    }
}
