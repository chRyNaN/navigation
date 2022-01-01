package com.chrynan.navigation.compose

import androidx.compose.runtime.Composable
import com.chrynan.presentation.ViewModel
import com.chrynan.navigation.NavStackDuplicateContentStrategy
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.filterNotNull

@ExperimentalNavigationApi
abstract class BaseComposeNavigatorByContentViewModel<Scope, Key> : ViewModel(),
    ComposeNavigator<Key>,
    ComposeNavigatorByContent<Key>,
    ComposeStackNavigatorByContent<Key>,
    ComposeScopedNavigator<Scope, Key> {

    @Composable
    internal abstract fun ComposeNavigationContentScope<Key>.content(key: Key)
}

@ExperimentalNavigationApi
class ComposeNavigatorByContentViewModel<Scope, Key> internal constructor(
    override val initialScope: Scope,
    private val initialKeysAndContent: (Scope) -> Pair<Key, @Composable ComposeNavigationContentScope<Key>.() -> Unit>
) : BaseComposeNavigatorByContentViewModel<Scope, Key>() {

    override val keyChanges: Flow<Key>
        get() = mutableKeyFlow.filterNotNull()

    override val initialKey: Key
        get() = initialKeysAndContent(initialScope).first

    private val initialContent: @Composable ComposeNavigationContentScope<Key>.() -> Unit
        get() = initialKeysAndContent(initialScope).second

    override val currentKey: Key
        get() = mutableKeyFlow.value

    override var isInitialized: Boolean = false
        private set

    override val currentScope: Scope
        get() = mutableScopeFlow.value

    override val scopeChanges: Flow<Scope>
        get() = mutableScopeFlow.filterNotNull()

    private val mutableKeyFlow = MutableStateFlow(value = initialKey)
    private val mutableScopeFlow = MutableStateFlow(value = initialScope)

    private val contents = mutableMapOf<Key, (@Composable ComposeNavigationContentScope<Key>.() -> Unit)>(
        initialKey to initialContent
    )

    private val scopedKeyStack = mutableMapOf(initialScope to mutableListOf(initialKey))

    @Composable
    override fun goTo(
        key: Key,
        strategy: NavStackDuplicateContentStrategy,
        content: @Composable ComposeNavigationContentScope<Key>.() -> Unit
    ) {
        val currentScope = this.currentScope
        val currentKeyStack = scopedKeyStack[currentScope] ?: mutableListOf()

        // If we are already displaying this key on the current scoped stack, then return.
        if (key == currentKeyStack.lastOrNull()) return

        if (strategy == NavStackDuplicateContentStrategy.CLEAR_STACK && contents.containsKey(key)) {
            // Go Back to the content with the provided key using the updated content
            var lastKey = currentKeyStack.lastOrNull()

            while (lastKey != null && lastKey != key) {
                currentKeyStack.removeLast()

                if (!currentKeyStack.contains(lastKey)) {
                    contents.remove(lastKey)
                }

                lastKey = currentKeyStack.lastOrNull()
            }

            // Replace the content with the updated content
            contents[key] = content
            scopedKeyStack[currentScope] = currentKeyStack
            mutableKeyFlow.value = key
        } else {
            // Go to the provided content
            contents[key] = content
            currentKeyStack.add(key)
            scopedKeyStack[currentScope] = currentKeyStack
            mutableKeyFlow.value = key
        }
    }

    @Composable
    override fun goBack(): Boolean {
        val wentBack = canGoBack()

        if (wentBack) {
            val currentScope = this.currentScope
            val currentKeyStack = scopedKeyStack[currentScope] ?: mutableListOf()

            val removedKey = currentKeyStack.removeLast()

            if (!currentKeyStack.contains(removedKey)) {
                contents.remove(removedKey)
            }

            scopedKeyStack[currentScope] = currentKeyStack
            mutableKeyFlow.value = currentKeyStack.last()
        }

        return wentBack
    }

    override fun canGoBack(): Boolean {
        val currentKeyStack = scopedKeyStack[currentScope] ?: mutableListOf()

        return currentKeyStack.size > 1
    }

    @Composable
    override fun ComposeNavigationContentScope<Key>.content(key: Key) {
        contents[key]?.invoke(this)

        isInitialized = true
    }

    override fun changeScope(to: Scope) {
        if (to == currentScope) return

        val keyStack = scopedKeyStack[to]

        if (keyStack.isNullOrEmpty()) {
            val key = initialKeysAndContent(to).first
            val content = initialKeysAndContent(to).second
            contents[key] = content
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
