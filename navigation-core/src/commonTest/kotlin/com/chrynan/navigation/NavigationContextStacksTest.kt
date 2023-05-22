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
        assertEquals(expected = TestDestination.CHANNEL_DETAILS, actual = stack.first())
        assertEquals(expected = TestDestination.FAVORITES, actual = stack.last())
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
        assertEquals(expected = TestDestination.ITEM_DETAILS, actual = stack.first())
        assertEquals(expected = TestDestination.HOME, actual = stack.last())
    }

    @Test
    fun pushAllAddsItemsToTopOfStack() {
        val stacks = NavigationContextStacks<TestDestination, TestContext>(initialContext = TestContext.Home)

        stacks.pushAll(
            context = TestContext.Home,
            destinations = stackOf(TestDestination.ITEM_DETAILS, TestDestination.FAVORITES)
        )

        val stack = stacks[TestContext.Home].toMutableStack()

        assertEquals(expected = 3, actual = stack.size)
        assertEquals(expected = TestDestination.FAVORITES, actual = stack.pop())
        assertEquals(expected = TestDestination.ITEM_DETAILS, actual = stack.pop())
        assertEquals(expected = TestDestination.HOME, actual = stack.peek())
    }

    @Test
    fun clearResetsStackToInitialState() {
        val stacks = NavigationContextStacks<TestDestination, TestContext>(initialContext = TestContext.Home)

        stacks.push(context = TestContext.Home, destination = TestDestination.ITEM_DETAILS)
        stacks.push(context = TestContext.Home, destination = TestDestination.CHANNEL_DETAILS)

        stacks.push(context = TestContext.Favorites, destination = TestDestination.SETTINGS)

        val homeStack = stacks[TestContext.Home]
        val favoriteStack = stacks[TestContext.Favorites]

        assertEquals(expected = 3, actual = homeStack.size)
        assertEquals(expected = TestDestination.CHANNEL_DETAILS, actual = homeStack.peek())
        assertEquals(expected = 2, actual = favoriteStack.size)
        assertEquals(expected = TestDestination.SETTINGS, actual = favoriteStack.peek())

        stacks.clear(context = TestContext.Home)

        val updatedHomeStack = stacks[TestContext.Home]
        val updatedFavoriteStack = stacks[TestContext.Favorites]

        assertEquals(expected = 1, actual = updatedHomeStack.size)
        assertEquals(expected = TestDestination.HOME, actual = updatedHomeStack.peek())
        assertEquals(expected = 2, actual = updatedFavoriteStack.size)
        assertEquals(expected = TestDestination.SETTINGS, actual = updatedFavoriteStack.peek())
    }

    @Test
    fun clearAllResetsStacksToInitialState() {
        val stacks = NavigationContextStacks<TestDestination, TestContext>(initialContext = TestContext.Home)

        stacks.push(context = TestContext.Home, destination = TestDestination.ITEM_DETAILS)

        stacks.push(context = TestContext.Favorites, destination = TestDestination.CHANNEL_DETAILS)

        stacks.clearAll()

        val homeStack = stacks[TestContext.Home]
        val favoritesStack = stacks[TestContext.Favorites]

        assertEquals(expected = 1, actual = homeStack.size)
        assertEquals(expected = TestDestination.HOME, actual = homeStack.peek())

        assertEquals(expected = 1, actual = favoritesStack.size)
        assertEquals(expected = TestDestination.FAVORITES, actual = favoritesStack.peek())
    }

    @Test
    fun pushDroppingPopsTheStackToTheItem() {
        val stacks = NavigationContextStacks<TestDestination, TestContext>(initialContext = TestContext.Home)

        stacks.push(context = TestContext.Home, destination = TestDestination.ITEM_DETAILS)
        stacks.push(context = TestContext.Home, destination = TestDestination.FAVORITES)
        stacks.push(context = TestContext.Home, destination = TestDestination.SETTINGS)
        stacks.push(context = TestContext.Home, destination = TestDestination.CHANNEL_DETAILS)

        val initialStack = stacks[TestContext.Home]

        assertEquals(expected = 5, actual = initialStack.size)
        assertEquals(expected = TestDestination.CHANNEL_DETAILS, actual = initialStack.peek())

        stacks.pushDropping(context = TestContext.Home, TestDestination.FAVORITES)

        val updatedStack = stacks[TestContext.Home]

        assertEquals(expected = true, actual = TestDestination.FAVORITES == TestDestination.FAVORITES)
        assertEquals(expected = 3, actual = updatedStack.size)
        assertEquals(expected = TestDestination.FAVORITES, actual = updatedStack.peek())
    }

    @Test
    fun popToPreviousDestinationForContextRemovesItemOnTopOfStackAndReturnsTheNewTopOfStack() {
        val stacks = NavigationContextStacks<TestDestination, TestContext>(initialContext = TestContext.Home)

        stacks.push(context = TestContext.Home, destination = TestDestination.SETTINGS)

        assertEquals(expected = 2, actual = stacks[TestContext.Home].size)
        assertEquals(expected = TestDestination.SETTINGS, actual = stacks[TestContext.Home].peek())

        val previous = stacks.popToPreviousDestinationForContext(context = TestContext.Home)

        assertEquals(expected = 1, actual = stacks[TestContext.Home].size)
        assertEquals(expected = TestDestination.HOME, actual = stacks[TestContext.Home].peek())
        assertEquals(expected = TestDestination.HOME, actual = previous)
    }

    @Test
    fun popToPreviousDestinationForContextReturnsNullForStackThatCannotBePopped() {
        val stacks = NavigationContextStacks<TestDestination, TestContext>(initialContext = TestContext.Home)

        assertEquals(expected = 1, actual = stacks[TestContext.Home].size)
        assertEquals(expected = TestDestination.HOME, actual = stacks[TestContext.Home].peek())

        val previous = stacks.popToPreviousDestinationForContext(context = TestContext.Home)

        assertEquals(expected = 1, actual = stacks[TestContext.Home].size)
        assertEquals(expected = TestDestination.HOME, actual = stacks[TestContext.Home].peek())
        assertEquals(expected = null, actual = previous)
    }

    @Test
    fun toMapReturnsExpectedMap() {
        val stacks = NavigationContextStacks<TestDestination, TestContext>(initialContext = TestContext.Home)

        stacks.push(context = TestContext.Home, destination = TestDestination.SETTINGS)
        stacks.push(context = TestContext.Home, destination = TestDestination.CHANNEL_DETAILS)

        stacks.push(context = TestContext.Favorites, destination = TestDestination.ITEM_DETAILS)

        assertEquals(expected = 3, actual = stacks[TestContext.Home].size)
        assertEquals(expected = 2, actual = stacks[TestContext.Favorites].size)
        assertEquals(expected = TestDestination.CHANNEL_DETAILS, actual = stacks[TestContext.Home].peek())
        assertEquals(expected = TestDestination.ITEM_DETAILS, actual = stacks[TestContext.Favorites].peek())

        val map = stacks.toMap()

        assertEquals(expected = 2, actual = map.size)

        val homeStack = map[TestContext.Home]
        val favoriteStack = map[TestContext.Favorites]

        assertEquals(expected = 3, actual = homeStack?.size)
        assertEquals(expected = 2, actual = favoriteStack?.size)
        assertEquals(expected = TestDestination.CHANNEL_DETAILS, actual = homeStack?.peek())
        assertEquals(expected = TestDestination.ITEM_DETAILS, actual = favoriteStack?.peek())
    }
}
