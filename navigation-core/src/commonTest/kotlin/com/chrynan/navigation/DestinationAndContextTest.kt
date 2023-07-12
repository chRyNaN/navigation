package com.chrynan.navigation

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotEquals

class DestinationAndContextTest {

    @Test
    fun componentOneIsDestination() {
        val value = DestinationAndContext(
            context = TestContext.Home,
            destination = TestDestination.FAVORITES
        )

        assertEquals(expected = TestDestination.FAVORITES, actual = value.component1())
    }

    @Test
    fun componentTwoIsContext() {
        val value = DestinationAndContext(
            context = TestContext.Home,
            destination = TestDestination.FAVORITES
        )

        assertEquals(expected = TestContext.Home, actual = value.component2())
    }

    @Test
    fun copyWithUpdatedContextWorks() {
        val value = DestinationAndContext<TestDestination, TestContext>(
            context = TestContext.Home,
            destination = TestDestination.HOME
        )

        val newValue = value.copy(context = TestContext.Favorites)

        assertEquals(expected = TestContext.Favorites, actual = newValue.context)
        assertEquals(expected = TestDestination.HOME, actual = newValue.destination)
    }

    @Test
    fun copyWithUpdatedDestinationWorks() {
        val value = DestinationAndContext<TestDestination, TestContext>(
            context = TestContext.Home,
            destination = TestDestination.HOME
        )

        val newValue = value.copy(destination = TestDestination.FAVORITES)

        assertEquals(expected = TestContext.Home, actual = newValue.context)
        assertEquals(expected = TestDestination.FAVORITES, actual = newValue.destination)
    }

    @Test
    fun sameValuesAreEqual() {
        val one = DestinationAndContext<TestDestination, TestContext>(
            context = TestContext.Home,
            destination = TestDestination.HOME
        )
        val two = DestinationAndContext<TestDestination, TestContext>(
            context = TestContext.Home,
            destination = TestDestination.HOME
        )

        assertEquals(one, two)
    }

    @Test
    fun differentValuesAreNotEqual() {
        val one = DestinationAndContext<TestDestination, TestContext>(
            context = TestContext.Home,
            destination = TestDestination.HOME
        )
        val two = DestinationAndContext<TestDestination, TestContext>(
            context = TestContext.Favorites,
            destination = TestDestination.FAVORITES
        )

        assertNotEquals(one, two)
    }

    @Test
    fun differentContextValuesAreNotEqual() {
        val one = DestinationAndContext<TestDestination, TestContext>(
            context = TestContext.Home,
            destination = TestDestination.HOME
        )
        val two = DestinationAndContext<TestDestination, TestContext>(
            context = TestContext.Favorites,
            destination = TestDestination.HOME
        )

        assertNotEquals(one, two)
    }

    @Test
    fun differentDestinationValuesAreNotEqual() {
        val one = DestinationAndContext<TestDestination, TestContext>(
            context = TestContext.Home,
            destination = TestDestination.HOME
        )
        val two = DestinationAndContext<TestDestination, TestContext>(
            context = TestContext.Home,
            destination = TestDestination.SETTINGS
        )

        assertNotEquals(one, two)
    }
}
