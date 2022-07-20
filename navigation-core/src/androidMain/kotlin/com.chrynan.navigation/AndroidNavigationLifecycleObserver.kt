package com.chrynan.navigation

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*

fun interface AndroidNavigationHandler<Destination : NavigationDestination, Context : NavigationContext<Destination>> {

    operator fun AndroidNavigationScope.invoke(context: Context, destination: Destination)
}

@OptIn(FlowPreview::class)
internal class AndroidNavigationLifecycleObserver<Destination : NavigationDestination, Context : NavigationContext<Destination>>(
    activity: Activity,
    private val navigator: Navigator<Destination, Context>,
    private val handler: AndroidNavigationHandler<Destination, Context>,
    private val coroutineScope: CoroutineScope,
    private val eventDispatcher: CoroutineDispatcher,
    private val handlerDispatcher: CoroutineDispatcher
) : DefaultLifecycleObserver {

    private var job: Job? = null

    private val navigationScope = AndroidNavigationScope(activity = activity)

    override fun onResume(owner: LifecycleOwner) {
        super.onResume(owner)

        job = navigator.state.contextChanges
            .flatMapConcat { context -> navigator.state.destinationChanges.map { destination -> context to destination } }
            .flowOn(eventDispatcher)
            .onEach { handler.apply { navigationScope(it.first, it.second) } }
            .flowOn(handlerDispatcher)
            .launchIn(coroutineScope)
    }

    override fun onPause(owner: LifecycleOwner) {
        super.onPause(owner)

        job?.cancel()
        job = null
    }
}

fun <Destination : NavigationDestination, Context : NavigationContext<Destination>> AppCompatActivity.registerNavigationHandler(
    navigator: Navigator<Destination, Context>,
    eventDispatcher: CoroutineDispatcher = Dispatchers.IO,
    handlerDispatcher: CoroutineDispatcher = Dispatchers.Main,
    handler: AndroidNavigationHandler<Destination, Context>
) {
    val observer = AndroidNavigationLifecycleObserver(
        activity = this,
        navigator = navigator,
        handler = handler,
        coroutineScope = lifecycleScope,
        eventDispatcher = eventDispatcher,
        handlerDispatcher = handlerDispatcher
    )

    lifecycle.addObserver(observer)
}
