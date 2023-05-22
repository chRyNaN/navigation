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
        assertEquals(expected = false, actual = navigator.canGoBack())
    }

    @Test
    fun goToChangesDestination() {
        val navigator = Navigator(initialContext = TestContext.Home)

        navigator.goTo(TestDestination.ITEM_DETAILS)

        assertEquals(expected = TestContext.Home, actual = navigator.store.context.initial)
        assertEquals(expected = TestContext.Home, actual = navigator.store.context.current)
        assertEquals(expected = TestDestination.HOME, actual = navigator.store.destination.initial)
        assertEquals(expected = TestDestination.ITEM_DETAILS, actual = navigator.store.destination.current)
        assertEquals(expected = null, actual = navigator.store.event.initial)
        assertIs<NavigationEvent.Forward.Destination<TestDestination, TestContext>>(value = navigator.store.event.current)
        assertNotNull(actual = navigator.store.event.current)
        assertEquals(expected = true, actual = navigator.canGoBack())
    }

    @Test
    fun goBackChangesDestinationBack() {
        val navigator = Navigator(initialContext = TestContext.Home)

        navigator.goTo(TestDestination.ITEM_DETAILS)

        assertEquals(expected = TestContext.Home, actual = navigator.store.context.initial)
        assertEquals(expected = TestContext.Home, actual = navigator.store.context.current)
        assertEquals(expected = TestDestination.HOME, actual = navigator.store.destination.initial)
        assertEquals(expected = TestDestination.ITEM_DETAILS, actual = navigator.store.destination.current)
        assertEquals(expected = null, actual = navigator.store.event.initial)
        assertIs<NavigationEvent.Forward.Destination<TestDestination, TestContext>>(value = navigator.store.event.current)
        assertNotNull(actual = navigator.store.event.current)
        assertEquals(expected = true, actual = navigator.canGoBack())

        val result = navigator.goBack()

        assertEquals(expected = true, actual = result)
        assertEquals(expected = TestContext.Home, actual = navigator.store.context.initial)
        assertEquals(expected = TestContext.Home, actual = navigator.store.context.current)
        assertEquals(expected = TestDestination.HOME, actual = navigator.store.destination.initial)
        assertEquals(expected = TestDestination.HOME, actual = navigator.store.destination.current)
        assertEquals(expected = null, actual = navigator.store.event.initial)
        assertIs<NavigationEvent.Backward<TestDestination, TestContext>>(value = navigator.store.event.current)
        assertNotNull(actual = navigator.store.event.current)
        assertEquals(expected = false, actual = navigator.canGoBack())
    }

    @Test
    fun changeContextUpdatesContextValue() {
        val navigator = Navigator<TestDestination, TestContext>(initialContext = TestContext.Home)

        navigator.changeContext(TestContext.Settings)

        assertEquals(expected = TestContext.Home, actual = navigator.store.context.initial)
        assertEquals(expected = TestContext.Settings, actual = navigator.store.context.current)
        assertEquals(expected = TestDestination.HOME, actual = navigator.store.destination.initial)
        assertEquals(expected = TestDestination.SETTINGS, actual = navigator.store.destination.current)
        assertEquals(expected = null, actual = navigator.store.event.initial)
        assertIs<NavigationEvent.Forward.Context<TestDestination, TestContext>>(value = navigator.store.event.current)
        assertNotNull(actual = navigator.store.event.current)
        assertEquals(expected = false, actual = navigator.canGoBack()) // Have to allow going back across contexts
    }

    @Test
    fun goBackChangesContextBackWithAcrossContextsStrategy() {
        val navigator = Navigator<TestDestination, TestContext>(
            initialContext = TestContext.Home,
            backwardsNavigationStrategy = NavigationStrategy.BackwardsNavigation.ACROSS_CONTEXTS
        )

        navigator.changeContext(TestContext.Settings)

        assertEquals(expected = TestContext.Home, actual = navigator.store.context.initial)
        assertEquals(expected = TestContext.Settings, actual = navigator.store.context.current)
        assertEquals(expected = TestDestination.HOME, actual = navigator.store.destination.initial)
        assertEquals(expected = TestDestination.SETTINGS, actual = navigator.store.destination.current)
        assertEquals(expected = null, actual = navigator.store.event.initial)
        assertIs<NavigationEvent.Forward.Context<TestDestination, TestContext>>(value = navigator.store.event.current)
        assertNotNull(actual = navigator.store.event.current)
        assertEquals(expected = true, actual = navigator.canGoBack())

        val result = navigator.goBack()

        assertEquals(expected = true, actual = result)
        assertEquals(expected = TestContext.Home, actual = navigator.store.context.initial)
        assertEquals(expected = TestContext.Home, actual = navigator.store.context.current)
        assertEquals(expected = TestDestination.HOME, actual = navigator.store.destination.initial)
        assertEquals(expected = TestDestination.HOME, actual = navigator.store.destination.current)
        assertEquals(expected = null, actual = navigator.store.event.initial)
        assertIs<NavigationEvent.Backward<TestDestination, TestContext>>(value = navigator.store.event.current)
        assertNotNull(actual = navigator.store.event.current)
        assertEquals(expected = false, actual = navigator.canGoBack())
    }

    @Test
    fun goBackDoesNotChangeContextBackWithInContextsStrategy() {
        val navigator = Navigator<TestDestination, TestContext>(
            initialContext = TestContext.Home,
            backwardsNavigationStrategy = NavigationStrategy.BackwardsNavigation.IN_CONTEXT
        )

        navigator.changeContext(TestContext.Settings)

        assertEquals(expected = TestContext.Home, actual = navigator.store.context.initial)
        assertEquals(expected = TestContext.Settings, actual = navigator.store.context.current)
        assertEquals(expected = TestDestination.HOME, actual = navigator.store.destination.initial)
        assertEquals(expected = TestDestination.SETTINGS, actual = navigator.store.destination.current)
        assertEquals(expected = null, actual = navigator.store.event.initial)
        assertIs<NavigationEvent.Forward.Context<TestDestination, TestContext>>(value = navigator.store.event.current)
        assertNotNull(actual = navigator.store.event.current)
        assertEquals(expected = false, actual = navigator.canGoBack())

        val result = navigator.goBack()

        assertEquals(expected = false, actual = result)
        assertEquals(expected = TestContext.Home, actual = navigator.store.context.initial)
        assertEquals(expected = TestContext.Settings, actual = navigator.store.context.current)
        assertEquals(expected = TestDestination.HOME, actual = navigator.store.destination.initial)
        assertEquals(expected = TestDestination.SETTINGS, actual = navigator.store.destination.current)
        assertEquals(expected = null, actual = navigator.store.event.initial)
        assertIs<NavigationEvent.Forward.Context<TestDestination, TestContext>>(value = navigator.store.event.current)
        assertNotNull(actual = navigator.store.event.current)
        assertEquals(expected = false, actual = navigator.canGoBack())
    }

    @Test
    fun canGoBackReturnsFalseForContextChangeWithInContextStrategy() {
        val navigator = Navigator<TestDestination, TestContext>(
            initialContext = TestContext.Home,
            backwardsNavigationStrategy = NavigationStrategy.BackwardsNavigation.IN_CONTEXT
        )

        navigator.changeContext(TestContext.Settings)

        assertEquals(expected = false, actual = navigator.canGoBack())
    }

    @Test
    fun canGoBackReturnsTrueForContextChangeWithAcrossContextStrategy() {
        val navigator = Navigator<TestDestination, TestContext>(
            initialContext = TestContext.Home,
            backwardsNavigationStrategy = NavigationStrategy.BackwardsNavigation.ACROSS_CONTEXTS
        )

        navigator.changeContext(TestContext.Settings)

        assertEquals(expected = true, actual = navigator.canGoBack())
    }

    @Test
    fun canGoBackReturnsFalseForInitialDestination() {
        val navigator = Navigator<TestDestination, TestContext>(
            initialContext = TestContext.Home,
            backwardsNavigationStrategy = NavigationStrategy.BackwardsNavigation.IN_CONTEXT
        )

        assertEquals(expected = false, actual = navigator.canGoBack())
    }

    @Test
    fun canGoBackReturnsTrueForDestinationStack() {
        val navigator = Navigator<TestDestination, TestContext>(
            initialContext = TestContext.Home,
            backwardsNavigationStrategy = NavigationStrategy.BackwardsNavigation.IN_CONTEXT
        )

        navigator.goTo(TestDestination.ITEM_DETAILS)

        assertEquals(expected = true, actual = navigator.canGoBack())
    }

    @Test
    fun resetRestoresTheInitialState() {
        val navigator = Navigator<TestDestination, TestContext>(
            initialContext = TestContext.Home,
            backwardsNavigationStrategy = NavigationStrategy.BackwardsNavigation.IN_CONTEXT
        )

        navigator.goTo(TestDestination.ITEM_DETAILS)
        navigator.changeContext(TestContext.Favorites)

        assertEquals(expected = TestContext.Home, actual = navigator.store.context.initial)
        assertEquals(expected = TestContext.Favorites, actual = navigator.store.context.current)
        assertEquals(expected = TestDestination.HOME, actual = navigator.store.destination.initial)
        assertEquals(expected = TestDestination.FAVORITES, actual = navigator.store.destination.current)
        assertEquals(expected = null, actual = navigator.store.event.initial)
        assertIs<NavigationEvent.Forward.Context<TestDestination, TestContext>>(value = navigator.store.event.current)
        assertNotNull(actual = navigator.store.event.current)
        assertEquals(expected = false, actual = navigator.canGoBack())

        navigator.reset()

        assertEquals(expected = TestContext.Home, actual = navigator.store.context.initial)
        assertEquals(expected = TestContext.Home, actual = navigator.store.context.current)
        assertEquals(expected = TestDestination.HOME, actual = navigator.store.destination.initial)
        assertEquals(expected = TestDestination.HOME, actual = navigator.store.destination.current)
        assertEquals(expected = null, actual = navigator.store.event.initial)
        assertEquals(expected = null, actual = navigator.store.event.current)
        assertEquals(expected = false, actual = navigator.canGoBack())
    }
}
