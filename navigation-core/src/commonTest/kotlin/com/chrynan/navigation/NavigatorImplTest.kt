@file:OptIn(ExperimentalNavigationApi::class)

package com.chrynan.navigation

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertIs
import kotlin.test.assertNotNull

internal class NavigatorImplTest {

    @Test
    fun navigatorStartsAtInitialContextValue() {
        val navigator = Navigator(initialContext = TestContext.Home)

        assertEquals(expected = TestContext.Home, actual = navigator.store.context.initial)
        assertEquals(expected = TestContext.Home, actual = navigator.store.context.current)
        assertEquals(expected = TestDestination.HOME, actual = navigator.store.destination.initial)
        assertEquals(expected = TestDestination.HOME, actual = navigator.store.destination.current)
        assertEquals(expected = null, actual = navigator.store.event.initial)
        assertEquals(expected = null, actual = navigator.store.event.current)
        assertEquals(expected = false, actual = navigator.canPopContext())
    }

    @Test
    fun goToChangesDestination() {
        val navigator = Navigator(initialContext = TestContext.Home)

        navigator.push(TestDestination.ITEM_DETAILS)

        assertEquals(expected = TestContext.Home, actual = navigator.store.context.initial)
        assertEquals(expected = TestContext.Home, actual = navigator.store.context.current)
        assertEquals(expected = TestDestination.HOME, actual = navigator.store.destination.initial)
        assertEquals(expected = TestDestination.ITEM_DETAILS, actual = navigator.store.destination.current)
        assertEquals(expected = null, actual = navigator.store.event.initial)
        assertIs<NavigationEvent.Forward.Destination<TestDestination, TestContext>>(value = navigator.store.event.current)
        assertNotNull(actual = navigator.store.event.current)
        assertEquals(expected = true, actual = navigator.canPopDestination())
    }

    @Test
    fun goBackChangesDestinationBack() {
        val navigator = Navigator(initialContext = TestContext.Home)

        navigator.push(TestDestination.ITEM_DETAILS)

        assertEquals(expected = TestContext.Home, actual = navigator.store.context.initial)
        assertEquals(expected = TestContext.Home, actual = navigator.store.context.current)
        assertEquals(expected = TestDestination.HOME, actual = navigator.store.destination.initial)
        assertEquals(expected = TestDestination.ITEM_DETAILS, actual = navigator.store.destination.current)
        assertEquals(expected = null, actual = navigator.store.event.initial)
        assertIs<NavigationEvent.Forward.Destination<TestDestination, TestContext>>(value = navigator.store.event.current)
        assertNotNull(actual = navigator.store.event.current)
        assertEquals(expected = true, actual = navigator.canPopDestination())

        val result = navigator.popDestination()

        assertEquals(expected = true, actual = result)
        assertEquals(expected = TestContext.Home, actual = navigator.store.context.initial)
        assertEquals(expected = TestContext.Home, actual = navigator.store.context.current)
        assertEquals(expected = TestDestination.HOME, actual = navigator.store.destination.initial)
        assertEquals(expected = TestDestination.HOME, actual = navigator.store.destination.current)
        assertEquals(expected = null, actual = navigator.store.event.initial)
        assertIs<NavigationEvent.Backward<TestDestination, TestContext>>(value = navigator.store.event.current)
        assertNotNull(actual = navigator.store.event.current)
        assertEquals(expected = false, actual = navigator.canPopDestination())
    }

    @Test
    fun changeContextUpdatesContextValue() {
        val navigator = Navigator<TestDestination, TestContext>(initialContext = TestContext.Home)

        navigator.push(TestContext.Settings)

        assertEquals(expected = TestContext.Home, actual = navigator.store.context.initial)
        assertEquals(expected = TestContext.Settings, actual = navigator.store.context.current)
        assertEquals(expected = TestDestination.HOME, actual = navigator.store.destination.initial)
        assertEquals(expected = TestDestination.SETTINGS, actual = navigator.store.destination.current)
        assertEquals(expected = null, actual = navigator.store.event.initial)
        assertIs<NavigationEvent.Forward.Context<TestDestination, TestContext>>(value = navigator.store.event.current)
        assertNotNull(actual = navigator.store.event.current)
        assertEquals(expected = true, actual = navigator.canPopContext())
    }

    @Test
    fun canPopContextReturnsFalseForNoContextChange() {
        val navigator = Navigator<TestDestination, TestContext>(
            initialContext = TestContext.Home
        )

        assertEquals(expected = false, actual = navigator.canPopContext())
    }

    @Test
    fun canPopContextReturnsTrueForContextChange() {
        val navigator = Navigator<TestDestination, TestContext>(
            initialContext = TestContext.Home
        )

        navigator.push(TestContext.Settings)

        assertEquals(expected = true, actual = navigator.canPopContext())
    }

    @Test
    fun canPopDestinationReturnsFalseForInitialDestination() {
        val navigator = Navigator<TestDestination, TestContext>(
            initialContext = TestContext.Home
        )

        assertEquals(expected = false, actual = navigator.canPopDestination())
    }

    @Test
    fun canPopDestinationReturnsTrueForDestinationStack() {
        val navigator = Navigator<TestDestination, TestContext>(
            initialContext = TestContext.Home
        )

        navigator.push(TestDestination.ITEM_DETAILS)

        assertEquals(expected = true, actual = navigator.canPopDestination())
    }

    @Test
    fun resetRestoresTheInitialState() {
        val navigator = Navigator<TestDestination, TestContext>(
            initialContext = TestContext.Home
        )

        navigator.push(TestDestination.ITEM_DETAILS)
        navigator.push(TestContext.Favorites)

        assertEquals(expected = TestContext.Home, actual = navigator.store.context.initial)
        assertEquals(expected = TestContext.Favorites, actual = navigator.store.context.current)
        assertEquals(expected = TestDestination.HOME, actual = navigator.store.destination.initial)
        assertEquals(expected = TestDestination.FAVORITES, actual = navigator.store.destination.current)
        assertEquals(expected = null, actual = navigator.store.event.initial)
        assertIs<NavigationEvent.Forward.Context<TestDestination, TestContext>>(value = navigator.store.event.current)
        assertNotNull(actual = navigator.store.event.current)
        assertEquals(expected = true, actual = navigator.canPopContext())

        navigator.reset()

        assertEquals(expected = TestContext.Home, actual = navigator.store.context.initial)
        assertEquals(expected = TestContext.Home, actual = navigator.store.context.current)
        assertEquals(expected = TestDestination.HOME, actual = navigator.store.destination.initial)
        assertEquals(expected = TestDestination.HOME, actual = navigator.store.destination.current)
        assertEquals(expected = null, actual = navigator.store.event.initial)
        assertEquals(expected = null, actual = navigator.store.event.current)
        assertEquals(expected = false, actual = navigator.canPopContext())
    }
}
