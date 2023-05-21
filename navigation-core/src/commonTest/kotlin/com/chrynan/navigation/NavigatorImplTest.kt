package com.chrynan.navigation

import kotlin.test.Test
import kotlin.test.assertEquals

internal class MapBasedMutableNavigationStateStoreTest {

    /*
    @Test
    fun backAcrossContextsReturnsFalseForInitialState() {
        val store = MutableNavigationStateStoreImpl<TestDestination, TestContext>(
            initialContext = TestContext.Home,
            duplicateStrategy = DuplicateDestination.ALLOW_DUPLICATES
        )

        store.assertInitialState(
            event = null,
            context = TestContext.Home,
            destination = TestDestination.HOME
        )
        store.assertCurrentState(
            event = null,
            context = TestContext.Home,
            destination = TestDestination.HOME
        )

        val event = NavigationEvent.Backward<TestDestination, TestContext>(
            kind = NavigationEvent.Backward.Kind.ACROSS_CONTEXTS
        )

        val result = store.dispatch(event = event)

        assertEquals(expected = false, actual = result)

        store.assertInitialState(
            event = null,
            context = TestContext.Home,
            destination = TestDestination.HOME
        )
        store.assertCurrentState(
            event = null,
            context = TestContext.Home,
            destination = TestDestination.HOME
        )
    }

    @Test
    fun backInContextsReturnsNullForInitialState() {
        val store = MutableNavigationStateStoreImpl<TestDestination, TestContext>(
            initialContext = TestContext.Home,
            duplicateStrategy = DuplicateDestination.ALLOW_DUPLICATES
        )

        store.assertInitialState(
            event = null,
            context = TestContext.Home,
            destination = TestDestination.HOME
        )
        store.assertCurrentState(
            event = null,
            context = TestContext.Home,
            destination = TestDestination.HOME
        )

        val event = NavigationEvent.Backward<TestDestination, TestContext>(
            kind = NavigationEvent.Backward.Kind.IN_CONTEXT
        )

        val result = store.dispatch(event = event)

        assertEquals(expected = false, actual = result)

        store.assertInitialState(
            event = null,
            context = TestContext.Home,
            destination = TestDestination.HOME
        )
        store.assertCurrentState(
            event = null,
            context = TestContext.Home,
            destination = TestDestination.HOME
        )
    }

    @Test
    fun destinationChangeWorksCorrectly() {
        val store = MutableNavigationStateStoreImpl<TestDestination, TestContext>(
            initialContext = TestContext.Home,
            duplicateStrategy = DuplicateDestination.ALLOW_DUPLICATES
        )

        store.assertInitialState(
            event = null,
            context = TestContext.Home,
            destination = TestDestination.HOME
        )
        store.assertCurrentState(
            event = null,
            context = TestContext.Home,
            destination = TestDestination.HOME
        )

        val event = NavigationEvent.Forward.Destination<TestDestination, TestContext>(
            destination = TestDestination.FAVORITES
        )

        val result = store.dispatch(event = event)

        assertEquals(expected = true, actual = result)

        store.assertInitialState(
            event = null,
            context = TestContext.Home,
            destination = TestDestination.HOME
        )
        store.assertCurrentState(
            event = event,
            context = TestContext.Home,
            destination = TestDestination.FAVORITES
        )
    }

    @Test
    fun contextChangeWorksCorrectly() {
        val store = MutableNavigationStateStoreImpl<TestDestination, TestContext>(
            initialContext = TestContext.Home,
            duplicateStrategy = DuplicateDestination.ALLOW_DUPLICATES
        )

        store.assertInitialState(
            event = null,
            context = TestContext.Home,
            destination = TestDestination.HOME
        )
        store.assertCurrentState(
            event = null,
            context = TestContext.Home,
            destination = TestDestination.HOME
        )

        val event = NavigationEvent.Forward.Context<TestDestination, TestContext>(
            context = TestContext.Settings
        )

        val result = store.dispatch(event = event)

        assertEquals(expected = true, actual = result)

        store.assertInitialState(
            event = null,
            context = TestContext.Home,
            destination = TestDestination.HOME
        )
        store.assertCurrentState(
            event = event,
            context = TestContext.Settings,
            destination = TestDestination.SETTINGS
        )
    }

    private fun <Destination : NavigationDestination, Context : NavigationContext<Destination>> NavigationStateStore<Destination, Context>.assertInitialState(
        event: NavigationEvent<Destination, Context>?,
        context: Context,
        destination: Destination
    ) {
        assertEquals(expected = event, actual = this.event.initial)
        assertEquals(expected = context, actual = this.context.initial)
        assertEquals(expected = destination, actual = this.destination.initial)
    }

    private fun <Destination : NavigationDestination, Context : NavigationContext<Destination>> NavigationStateStore<Destination, Context>.assertCurrentState(
        event: NavigationEvent<Destination, Context>?,
        context: Context,
        destination: Destination
    ) {
        assertEquals(expected = event, actual = this.event.current)
        assertEquals(expected = context, actual = this.context.current)
        assertEquals(expected = destination, actual = this.destination.current)
    }*/
}
