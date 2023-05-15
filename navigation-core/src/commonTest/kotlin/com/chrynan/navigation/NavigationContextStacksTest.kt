package com.chrynan.navigation

import kotlin.test.Test
import kotlin.test.assertEquals

internal class NavigationContextStacksTest {

    @Test
    fun initialContextIsReturnedCorrectly() {
        val stacks = NavigationContextStacks<TestDestination, TestContext>(initialContext = TestContext.Home)

        val stack = stacks[TestContext.Home]

        assertEquals(expected = 1, actual = stack.size)
        assertEquals(expected = TestDestination.HOME, actual = stack.peek())
    }

    @Test
    fun getDefaultsToStackOfInitialDestination() {
        val stacks = NavigationContextStacks<TestDestination, TestContext>(initialContext = TestContext.Home)

        val stack = stacks[TestContext.Favorites]

        assertEquals(expected = 1, actual = stack.size)
        assertEquals(expected = TestDestination.FAVORITES, actual = stack.peek())
    }

    @Test
    fun peekDefaultsToInitialDestination() {
        val stacks = NavigationContextStacks<TestDestination, TestContext>(initialContext = TestContext.Home)

        val destination = stacks.peek(context = TestContext.Favorites)

        assertEquals(expected = TestDestination.FAVORITES, actual = destination)
    }

    @Test
    fun peekReturnsCorrectValue() {
        val stacks = NavigationContextStacks<TestDestination, TestContext>(initialContext = TestContext.Home)

        val destination = stacks.peek(context = TestContext.Home)

        assertEquals(expected = TestDestination.HOME, actual = destination)
    }

    @Test
    fun popReturnsNullForNonExistingContext() {
        val stacks = NavigationContextStacks<TestDestination, TestContext>(initialContext = TestContext.Home)

        val destination = stacks.pop(context = TestContext.Favorites)

        assertEquals(expected = null, actual = destination)
    }

    @Test
    fun popReturnsNullForStackWithInitialDestination() {
        val stacks = NavigationContextStacks<TestDestination, TestContext>(initialContext = TestContext.Home)

        val destination = stacks.pop(context = TestContext.Home)

        assertEquals(expected = null, actual = destination)
    }

    @Test
    fun popRemoveAndReturnsDestinationCorrectly() {
        val stacks = NavigationContextStacks<TestDestination, TestContext>(initialContext = TestContext.Home)

        stacks.push(context = TestContext.Home, destination = TestDestination.ITEM_DETAILS)

        assertEquals(expected = TestDestination.ITEM_DETAILS, actual = stacks.peek(context = TestContext.Home))

        val destination = stacks.pop(context = TestContext.Home)

        assertEquals(expected = TestDestination.ITEM_DETAILS, actual = destination)
        assertEquals(expected = TestDestination.HOME, actual = stacks.peek(context = TestContext.Home))
    }

    @Test
    fun pushFirstTimeContextResultsInInitialDestinationAndNewDestination() {
        val stacks = NavigationContextStacks<TestDestination, TestContext>(initialContext = TestContext.Home)

        stacks.push(context = TestContext.Favorites, destination = TestDestination.CHANNEL_DETAILS)

        val stack = stacks[TestContext.Favorites]

        assertEquals(expected = 2, actual = stack.size)
        assertEquals(expected = TestDestination.CHANNEL_DETAILS, actual = stack.peek())
        assertEquals(expected = TestDestination.FAVORITES, actual = stack.first())
    }

    @Test
    fun pushInitialDestinationResultsInDuplicates() {
        val stacks = NavigationContextStacks<TestDestination, TestContext>(initialContext = TestContext.Home)

        stacks.push(context = TestContext.Home, destination = TestDestination.HOME)

        val stack = stacks[TestContext.Home]

        assertEquals(expected = 2, actual = stack.size)
        assertEquals(expected = TestDestination.HOME, actual = stack.peek())
        assertEquals(expected = TestDestination.HOME, actual = stack.first())
    }

    @Test
    fun pushAddsItemToTopOfStack() {
        val stacks = NavigationContextStacks<TestDestination, TestContext>(initialContext = TestContext.Home)

        stacks.push(context = TestContext.Home, destination = TestDestination.ITEM_DETAILS)

        val stack = stacks[TestContext.Home]

        assertEquals(expected = 2, actual = stack.size)
        assertEquals(expected = TestDestination.ITEM_DETAILS, actual = stack.peek())
        assertEquals(expected = TestDestination.HOME, actual = stack.first())
    }

    @Test
    fun pushAllAddsItemsToTopOfStack(){
        val stacks = NavigationContextStacks<TestDestination, TestContext>(initialContext = TestContext.Home)

        stacks.pushAll(context = TestContext.Home, destinations = stackOf(TestDestination.ITEM_DETAILS, TestDestination.FAVORITES))

        val stack = stacks[TestContext.Home].toMutableStack()

        assertEquals(expected = 3, actual = stack.size)
        assertEquals(expected = TestDestination.FAVORITES, actual = stack.pop())
        assertEquals(expected = TestDestination.ITEM_DETAILS, actual = stack.pop())
        assertEquals(expected = TestDestination.HOME, actual = stack.peek())
    }

    @Test
    fun clearResetsStacksToInitialState() {
        val stacks = NavigationContextStacks<TestDestination, TestContext>(initialContext = TestContext.Home)

        stacks.push(context = TestContext.Home, destination = TestDestination.ITEM_DETAILS)

        stacks.push(context = TestContext.Favorites, destination = TestDestination.CHANNEL_DETAILS)

        stacks.clear()

        val homeStack = stacks[TestContext.Home]
        val favoritesStack = stacks[TestContext.Favorites]

        assertEquals(expected = 1, actual = homeStack.size)
        assertEquals(expected = TestDestination.HOME, actual = homeStack.peek())

        assertEquals(expected = 1, actual = favoritesStack.size)
        assertEquals(expected = TestDestination.FAVORITES, actual = favoritesStack.peek())
    }
}
