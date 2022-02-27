package com.chrynan.navigation.compose

import androidx.compose.runtime.Composable
import com.chrynan.presentation.ViewModel
import com.chrynan.navigation.NavStackDuplicateContentStrategy
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.filterNotNull

@ExperimentalNavigationApi
abstract class BaseComposeNavigatorByKeyViewModel<Context, Key, NavigationScope : ComposeNavigationKeyScope<Key>>(
    final override val initialContext: Context,
    final override val keySaver: Saver<Key, Any>,
    private val initialKeys: (Context) -> Key
) : ViewModel(),
    ComposeNavigator<Key>,
    ComposeNavigatorByKey<Key>,
    ComposeStackNavigatorByKey<Key>,
    ComposeContextNavigator<Context, Key> {

    internal abstract val content: @Composable NavigationScope.(key: Key) -> Unit

    override val keyChanges: Flow<Key>
        get() = mutableKeyFlow.filterNotNull()

    final override val initialKey: Key
        get() = initialKeys(initialContext)

    override val currentKey: Key
        get() = mutableKeyFlow.value

    override var isInitialized: Boolean = false
        internal set

    override val currentContext: Context
        get() = mutableScopeFlow.value

    override val contextChanges: Flow<Context>
        get() = mutableScopeFlow.filterNotNull()

    private val mutableKeyFlow = MutableStateFlow(value = initialKey)
    private val mutableScopeFlow = MutableStateFlow(value = initialContext)

    private val scopedKeyStack = mutableMapOf(initialContext to mutableListOf(initialKey))

    override fun goTo(key: Key, strategy: NavStackDuplicateContentStrategy) {
        val currentScope = this.currentContext
        val currentKeyStack = scopedKeyStack[currentScope] ?: mutableListOf()

        // If we are already displaying this key on the current scoped stack, then return.
        if (key == currentKeyStack.lastOrNull()) return

        if (strategy == NavStackDuplicateContentStrategy.CLEAR_STACK && currentKeyStack.contains(key)) {
            // Go Back to the content with the provided key using the updated content
            var lastKey = currentKeyStack.lastOrNull()

            while (lastKey != null && lastKey != key) {
                currentKeyStack.removeLast()
                lastKey = currentKeyStack.lastOrNull()
            }

            // Replace the content with the updated content
            scopedKeyStack[currentScope] = currentKeyStack
            mutableKeyFlow.value = key
        } else {
            // Go to the provided content
            currentKeyStack.add(key)
            scopedKeyStack[currentScope] = currentKeyStack
            mutableKeyFlow.value = key
        }
    }

    override fun goBack(): Boolean {
        val wentBack = canGoBack()

        if (wentBack) {
            val currentScope = this.currentContext
            val currentKeyStack = scopedKeyStack[currentScope] ?: mutableListOf()
            currentKeyStack.removeLast()
            scopedKeyStack[currentScope] = currentKeyStack
            mutableKeyFlow.value = currentKeyStack.last()
        }

        return wentBack
    }

    override fun canGoBack(): Boolean {
        val currentKeyStack = scopedKeyStack[currentContext] ?: mutableListOf()

        return currentKeyStack.size > 1
    }

    override fun changeContext(to: Context) {
        if (to == currentContext) return

        val keyStack = scopedKeyStack[to]

        if (keyStack.isNullOrEmpty()) {
            val key = initialKeys(to)
            val newKeyStack = mutableListOf(key)
            scopedKeyStack[to] = newKeyStack
            mutableScopeFlow.value = to
            mutableKeyFlow.value = key
        } else {
            val key = keyStack.last()
            mutableScopeFlow.value = to
            mutableKeyFlow.value = key
        }
    }
}

@ExperimentalNavigationApi
class ComposeNavigatorByKeyViewModel<Context, Key> internal constructor(
    initialContext: Context,
    initialKeys: (Context) -> Key,
    keySaver: Saver<Key, Any>,
    override val content: @Composable ComposeNavigationKeyScope<Key>.(key: Key) -> Unit
) : BaseComposeNavigatorByKeyViewModel<Context, Key, ComposeNavigationKeyScope<Key>>(
    initialContext = initialContext,
    initialKeys = initialKeys,
    keySaver = keySaver
)
