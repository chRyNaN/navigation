package com.chrynan.navigation

import kotlin.test.Test
import kotlin.test.assertContentEquals
import kotlin.test.assertEquals

class ReadOnlyStackTest {

    @Test
    fun peekReturnsTheLastItem() {
        val elements = listOf(1, 2, 3)

        val stack = ReadOnlyStack(elements)

        assertEquals(expected = 3, actual = stack.peek())
        assertEquals(expected = 3, actual = stack.size)
    }

    @Test
    fun mutatingWrappedStackElementsDoesNotEffectStack() {
        val elements = mutableListOf(1, 2, 3)

        val stack = ReadOnlyStack(elements)

        assertEquals(expected = 3, actual = stack.size)
        assertContentEquals(expected = listOf(1, 2, 3), actual = stack.toList())

        elements.removeLast()

        assertEquals(expected = 3, actual = stack.size)
        assertContentEquals(expected = listOf(1, 2, 3), actual = stack.toList())
    }

    @Test
    fun isEmptyReturnsCorrectly() {
        val emptyStack = ReadOnlyStack<Int>(emptyList())
        val nonEmptyStack = ReadOnlyStack(listOf(1))

        assertEquals(expected = true, actual = emptyStack.isEmpty())
        assertEquals(expected = 0, actual = emptyStack.size)

        assertEquals(expected = false, actual = nonEmptyStack.isEmpty())
        assertEquals(expected = 1, actual = nonEmptyStack.size)
    }

    @Test
    fun containsReturnsCorrectly() {
        val elements = listOf(1, 2, 3)

        val stack = ReadOnlyStack(elements)

        assertEquals(expected = false, actual = stack.contains(0))
        assertEquals(expected = true, actual = stack.contains(1))
        assertEquals(expected = true, actual = stack.contains(2))
        assertEquals(expected = true, actual = stack.contains(3))
        assertEquals(expected = false, actual = stack.contains(4))
    }

    @Test
    fun containsAllReturnsCorrectly() {
        val elements = listOf(0, 1, 2, 3, 4, 5, 6, 7, 8, 9)

        val stack = ReadOnlyStack(elements)

        assertEquals(expected = true, actual = stack.containsAll(listOf(0, 3, 6, 9)))
        assertEquals(expected = true, actual = stack.containsAll(listOf(0, 1, 2, 3, 4, 5, 6, 7, 8, 9)))
        assertEquals(expected = true, actual = stack.containsAll(listOf(1)))
        assertEquals(expected = false, actual = stack.containsAll(listOf(10)))
        assertEquals(expected = false, actual = stack.containsAll(listOf(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10)))
        assertEquals(expected = false, actual = stack.containsAll(listOf(0, 3, 11)))
        assertEquals(expected = true, actual = stack.containsAll(listOf()))
    }

    @Test
    fun readOnlyStackEqualsArrayListMutableStackWithSameContents() {
        val readOnlyStack = ReadOnlyStack(listOf(1, 2, 3))
        val arrayListMutableStack = ArrayListMutableStack(listOf(1, 2, 3))

        assertEquals(expected = true, actual = readOnlyStack == arrayListMutableStack)
    }
}
