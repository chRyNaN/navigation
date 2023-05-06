package com.chrynan.navigation

import kotlin.test.Test
import kotlin.test.assertContentEquals
import kotlin.test.assertEquals
import kotlin.test.assertNotNull

class QueueUtilsTest {

    @Test
    fun peekLifoOrderTakesTheLastItem() {
        val items = listOf(1, 2, 3)

        val item = items.peek(order = QueueOrder.LIFO)

        assertEquals(expected = 3, actual = item)
        assertEquals(expected = 3, actual = items.size)
    }

    @Test
    fun peekFifoOrderTakesTheFirstItem() {
        val items = listOf(1, 2, 3)

        val item = items.peek(order = QueueOrder.FIFO)

        assertEquals(expected = 1, actual = item)
        assertEquals(expected = 3, actual = items.size)
    }

    @Test
    fun peekDefaultOrderValueTakesTheLastItem() {
        val items = listOf(1, 2, 3)

        val item = items.peek()

        assertEquals(expected = 3, actual = item)
        assertEquals(expected = 3, actual = items.size)
    }

    @Test
    fun peekThrowsNoSuchElementExceptionOnEmptyList() {
        val items = emptyList<Int>()

        var exception: NoSuchElementException? = null

        try {
            items.peek()
        } catch (e: NoSuchElementException) {
            exception = e
        }

        assertNotNull(actual = exception)
    }

    @Test
    fun peekOrNullReturnsNullOnEmptyList() {
        val items = emptyList<Int>()

        val item = items.peekOrNull()

        assertEquals(expected = null, actual = item)
    }

    @Test
    fun popLifoOrderRemovesTheLastItem() {
        val items = mutableListOf(1, 2, 3)

        val item = items.pop(order = QueueOrder.LIFO)

        assertEquals(expected = 3, actual = item)
        assertEquals(expected = 2, actual = items.size)
    }

    @Test
    fun popFifoOrderRemovesTheFirstItem() {
        val items = mutableListOf(1, 2, 3)

        val item = items.pop(order = QueueOrder.FIFO)

        assertEquals(expected = 1, actual = item)
        assertEquals(expected = 2, actual = items.size)
    }

    @Test
    fun popDefaultOrderValueRemovesTheLastItem() {
        val items = mutableListOf(1, 2, 3)

        val item = items.pop()

        assertEquals(expected = 3, actual = item)
        assertEquals(expected = 2, actual = items.size)
    }

    @Test
    fun popThrowsNoSuchElementExceptionOnEmptyList() {
        val items = mutableListOf<Int>()

        var exception: NoSuchElementException? = null

        try {
            items.pop()
        } catch (e: NoSuchElementException) {
            exception = e
        }

        assertNotNull(actual = exception)
    }

    @Test
    fun popOrNullReturnsNullOnEmptyList() {
        val items = mutableListOf<Int>()

        val item = items.popOrNull()

        assertEquals(expected = null, actual = item)
    }

    @Test
    fun pushAddsItemToTheEndOfTheList() {
        val items = mutableListOf(0, 1, 2, 3)

        items.push(4)
        items.push(5)
        items.push(6)

        assertEquals(expected = 7, actual = items.size)
        assertContentEquals(expected = listOf(0, 1, 2, 3, 4, 5, 6), actual = items)
    }
}
