package com.chrynan.navigation

import kotlin.test.Test
import kotlin.test.assertEquals

class MutableNavigationStateStoreImplTest {

    @Test
    fun currentValuesDefaultToInitial() {
        val stateStore = mutableNavigationStateStoreOf(
            initialContext = TestContext.Home
        )

        assertEquals(expected = stateStore.context.initial, actual = TestContext.Home)
        assertEquals(expected = stateStore.context.current, actual = TestContext.Home)
        assertEquals(expected = stateStore.destination.initial, actual = TestContext.Home.initialDestination)
        assertEquals(expected = stateStore.destination.current, actual = TestContext.Home.initialDestination)
        assertEquals(expected = stateStore.event.initial, actual = null)
        assertEquals(expected = stateStore.event.current, actual = null)
    }

    @Test
    fun providingInitialAndCurrentValuesWorksCorrectly() {
        val currentEvent: NavigationEvent<TestDestination, TestContext> =
            NavigationEvent.Forward.Context(context = TestContext.Settings)

        val stateStore = mutableNavigationStateStoreOf(
            initialContext = TestContext.Home,
            currentContext = TestContext.Settings,
            initialDestination = TestContext.Home.initialDestination,
            currentDestination = TestContext.Settings.initialDestination,
            initialEvent = null,
            currentEvent = currentEvent
        )

        assertEquals(expected = stateStore.context.initial, actual = TestContext.Home)
        assertEquals(expected = stateStore.context.current, actual = TestContext.Settings)
        assertEquals(expected = stateStore.destination.initial, actual = TestContext.Home.initialDestination)
        assertEquals(expected = stateStore.destination.current, actual = TestContext.Settings.initialDestination)
        assertEquals(expected = stateStore.event.initial, actual = null)
        assertEquals(expected = stateStore.event.current, actual = currentEvent)
    }

    @Test
    fun updatingNoValuesRemainsTheSame() {
        val stateStore = mutableNavigationStateStoreOf(
            initialContext = TestContext.Home
        )

        assertEquals(expected = stateStore.context.initial, actual = TestContext.Home)
        assertEquals(expected = stateStore.context.current, actual = TestContext.Home)
        assertEquals(expected = stateStore.destination.initial, actual = TestContext.Home.initialDestination)
        assertEquals(expected = stateStore.destination.current, actual = TestContext.Home.initialDestination)
        assertEquals(expected = stateStore.event.initial, actual = null)
        assertEquals(expected = stateStore.event.current, actual = null)

        stateStore.update()

        assertEquals(expected = stateStore.context.initial, actual = TestContext.Home)
        assertEquals(expected = stateStore.context.current, actual = TestContext.Home)
        assertEquals(expected = stateStore.destination.initial, actual = TestContext.Home.initialDestination)
        assertEquals(expected = stateStore.destination.current, actual = TestContext.Home.initialDestination)
        assertEquals(expected = stateStore.event.initial, actual = null)
        assertEquals(expected = stateStore.event.current, actual = null)
    }

    @Test
    fun updatingContextChangesTheContextValue() {
        val stateStore = mutableNavigationStateStoreOf<TestDestination, TestContext>(
            initialContext = TestContext.Home
        )

        assertEquals(expected = stateStore.context.initial, actual = TestContext.Home)
        assertEquals(expected = stateStore.context.current, actual = TestContext.Home)
        assertEquals(expected = stateStore.destination.initial, actual = TestContext.Home.initialDestination)
        assertEquals(expected = stateStore.destination.current, actual = TestContext.Home.initialDestination)
        assertEquals(expected = stateStore.event.initial, actual = null)
        assertEquals(expected = stateStore.event.current, actual = null)

        stateStore.update(context = TestContext.Favorites)

        assertEquals(expected = stateStore.context.initial, actual = TestContext.Home)
        assertEquals(expected = stateStore.context.current, actual = TestContext.Favorites)
        assertEquals(expected = stateStore.destination.initial, actual = TestContext.Home.initialDestination)
        assertEquals(expected = stateStore.destination.current, actual = TestContext.Home.initialDestination)
        assertEquals(expected = stateStore.event.initial, actual = null)
        assertEquals(expected = stateStore.event.current, actual = null)
    }

    @Test
    fun updatingDestinationChangesTheDestinationValue() {
        val stateStore = mutableNavigationStateStoreOf<TestDestination, TestContext>(
            initialContext = TestContext.Home
        )

        assertEquals(expected = stateStore.context.initial, actual = TestContext.Home)
        assertEquals(expected = stateStore.context.current, actual = TestContext.Home)
        assertEquals(expected = stateStore.destination.initial, actual = TestContext.Home.initialDestination)
        assertEquals(expected = stateStore.destination.current, actual = TestContext.Home.initialDestination)
        assertEquals(expected = stateStore.event.initial, actual = null)
        assertEquals(expected = stateStore.event.current, actual = null)

        stateStore.update(destination = TestDestination.FAVORITES)

        assertEquals(expected = stateStore.context.initial, actual = TestContext.Home)
        assertEquals(expected = stateStore.context.current, actual = TestContext.Home)
        assertEquals(expected = stateStore.destination.initial, actual = TestContext.Home.initialDestination)
        assertEquals(expected = stateStore.destination.current, actual = TestDestination.FAVORITES)
        assertEquals(expected = stateStore.event.initial, actual = null)
        assertEquals(expected = stateStore.event.current, actual = null)
    }

    @Test
    fun updatingEventChangesTheEventValue() {
        val stateStore = mutableNavigationStateStoreOf<TestDestination, TestContext>(
            initialContext = TestContext.Home
        )

        assertEquals(expected = stateStore.context.initial, actual = TestContext.Home)
        assertEquals(expected = stateStore.context.current, actual = TestContext.Home)
        assertEquals(expected = stateStore.destination.initial, actual = TestContext.Home.initialDestination)
        assertEquals(expected = stateStore.destination.current, actual = TestContext.Home.initialDestination)
        assertEquals(expected = stateStore.event.initial, actual = null)
        assertEquals(expected = stateStore.event.current, actual = null)

        val currentEvent: NavigationEvent<TestDestination, TestContext> =
            NavigationEvent.Forward.Context(context = TestContext.Settings)

        stateStore.update(event = currentEvent)

        assertEquals(expected = stateStore.context.initial, actual = TestContext.Home)
        assertEquals(expected = stateStore.context.current, actual = TestContext.Home)
        assertEquals(expected = stateStore.destination.initial, actual = TestContext.Home.initialDestination)
        assertEquals(expected = stateStore.destination.current, actual = TestContext.Home.initialDestination)
        assertEquals(expected = stateStore.event.initial, actual = null)
        assertEquals(expected = stateStore.event.current, actual = currentEvent)
    }

    @Test
    fun updatingEverythingChangesEverything() {
        val stateStore = mutableNavigationStateStoreOf<TestDestination, TestContext>(
            initialContext = TestContext.Home
        )

        assertEquals(expected = stateStore.context.initial, actual = TestContext.Home)
        assertEquals(expected = stateStore.context.current, actual = TestContext.Home)
        assertEquals(expected = stateStore.destination.initial, actual = TestContext.Home.initialDestination)
        assertEquals(expected = stateStore.destination.current, actual = TestContext.Home.initialDestination)
        assertEquals(expected = stateStore.event.initial, actual = null)
        assertEquals(expected = stateStore.event.current, actual = null)

        val currentEvent: NavigationEvent<TestDestination, TestContext> =
            NavigationEvent.Forward.Context(context = TestContext.Favorites)

        stateStore.update(
            context = TestContext.Favorites,
            destination = TestDestination.FAVORITES,
            event = currentEvent
        )

        assertEquals(expected = stateStore.context.initial, actual = TestContext.Home)
        assertEquals(expected = stateStore.context.current, actual = TestContext.Favorites)
        assertEquals(expected = stateStore.destination.initial, actual = TestContext.Home.initialDestination)
        assertEquals(expected = stateStore.destination.current, actual = TestDestination.FAVORITES)
        assertEquals(expected = stateStore.event.initial, actual = null)
        assertEquals(expected = stateStore.event.current, actual = currentEvent)
    }

    @Test
    fun resetChangesEverythingBackToInitialValues() {
        val stateStore = mutableNavigationStateStoreOf<TestDestination, TestContext>(
            initialContext = TestContext.Home
        )

        assertEquals(expected = stateStore.context.initial, actual = TestContext.Home)
        assertEquals(expected = stateStore.context.current, actual = TestContext.Home)
        assertEquals(expected = stateStore.destination.initial, actual = TestContext.Home.initialDestination)
        assertEquals(expected = stateStore.destination.current, actual = TestContext.Home.initialDestination)
        assertEquals(expected = stateStore.event.initial, actual = null)
        assertEquals(expected = stateStore.event.current, actual = null)

        val currentEvent: NavigationEvent<TestDestination, TestContext> =
            NavigationEvent.Forward.Context(context = TestContext.Favorites)

        stateStore.update(
            context = TestContext.Favorites,
            destination = TestDestination.FAVORITES,
            event = currentEvent
        )

        assertEquals(expected = stateStore.context.initial, actual = TestContext.Home)
        assertEquals(expected = stateStore.context.current, actual = TestContext.Favorites)
        assertEquals(expected = stateStore.destination.initial, actual = TestContext.Home.initialDestination)
        assertEquals(expected = stateStore.destination.current, actual = TestDestination.FAVORITES)
        assertEquals(expected = stateStore.event.initial, actual = null)
        assertEquals(expected = stateStore.event.current, actual = currentEvent)

        stateStore.reset()

        assertEquals(expected = stateStore.context.initial, actual = TestContext.Home)
        assertEquals(expected = stateStore.context.current, actual = TestContext.Home)
        assertEquals(expected = stateStore.destination.initial, actual = TestContext.Home.initialDestination)
        assertEquals(expected = stateStore.destination.current, actual = TestContext.Home.initialDestination)
        assertEquals(expected = stateStore.event.initial, actual = null)
        assertEquals(expected = stateStore.event.current, actual = null)
    }
}
