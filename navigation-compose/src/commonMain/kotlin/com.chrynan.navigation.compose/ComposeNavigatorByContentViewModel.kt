package com.chrynan.navigation.compose

import androidx.compose.runtime.Composable
import com.chrynan.presentation.ViewModel
import com.chrynan.navigation.StackDuplicateContentStrategy
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.filterNotNull

@ExperimentalNavigationApi
abstract class BaseComposeNavigatorByContentViewModel<Context, Key> : ViewModel(),
    ComposeNavigatorByContent<Context, Key> {

    @Composable
    internal abstract fun ComposeNavigationContentScope<Context, Key>.content(key: Key)
}

@ExperimentalNavigationApi
class ComposeNavigatorByContentViewModel<Context, Key> internal constructor(
    override val initialContext: Context,
    override val keySaver: Saver<Key, Any>,
    private val initialKeysAndContent: (Context) -> Pair<Key, @Composable ComposeNavigationContentScope<Context, Key>.() -> Unit>
) : BaseComposeNavigatorByContentViewModel<Context, Key>() {

    override val keyChanges: Flow<Key>
        get() = mutableKeyFlow.filterNotNull()

    override val initialKey: Key
        get() = initialKeysAndContent(initialContext).first

    private val initialContent: @Composable ComposeNavigationContentScope<Context, Key>.() -> Unit
        get() = initialKeysAndContent(initialContext).second

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

    private val contents = mutableMapOf<Key, (@Composable ComposeNavigationContentScope<Context, Key>.() -> Unit)>(
        initialKey to initialContent
    )

    private val scopedKeyStack = mutableMapOf(initialContext to mutableListOf(initialKey))

    @Composable
    override fun goTo(
        key: Key,
        strategy: StackDuplicateContentStrategy,
        content: @Composable ComposeNavigationContentScope<Context, Key>.() -> Unit
    ) {
        val currentScope = this.currentContext
        val currentKeyStack = scopedKeyStack[currentScope] ?: mutableListOf()

        // If we are already displaying this key on the current scoped stack, then return.
        if (key == currentKeyStack.lastOrNull()) return

        if (strategy == StackDuplicateContentStrategy.CLEAR_STACK && contents.containsKey(key)) {
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

    override fun goBack(): Boolean {
        val wentBack = canGoBack()

        if (wentBack) {
            val currentScope = this.currentContext
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
        val currentKeyStack = scopedKeyStack[currentContext] ?: mutableListOf()

        return currentKeyStack.size > 1
    }

    @Composable
    override fun ComposeNavigationContentScope<Context, Key>.content(key: Key) {
        contents[key]?.invoke(this)
    }

    override fun changeContext(to: Context) {
        if (to == currentContext) return

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
