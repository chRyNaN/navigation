@file:Suppress("unused")

package com.chrynan.navigation

/**
 * Represents a LIFO (last in, first out) Queue [Collection].
 */
interface Stack<E> : Collection<E> {

    /**
     * Retrieves the top element from this [Stack] without removing it.
     *
     * @throws [NoSuchElementException] - if the list is empty.
     */
    fun peek(): E
}

/**
 * Retrieves the top element from this [Stack] without removing it, or `null` if this [Stack] is empty.
 */
fun <E> Stack<E>.peekOrNull(): E? =
    try {
        peek()
    } catch (_: NoSuchElementException) {
        null
    }

/**
 * Represents a mutable LIFO (last in, first out) Queue [MutableCollection]
 */
interface MutableStack<E> : Stack<E>,
    MutableCollection<E> {

    /**
     * Removes and returns the top element from this [Stack].
     *
     * @throws [NoSuchElementException] - if the list is empty.
     */
    fun pop(): E

    /**
     * Adds the provided [element] to the end of this queue [MutableList].
     */
    fun push(element: E)
}

/**
 * Removes and returns the top element from this [Stack], or `null` if this [Stack] is empty.
 */
fun <E> MutableStack<E>.popOrNull(): E? =
    try {
        pop()
    } catch (_: NoSuchElementException) {
        null
    }

/**
 * Returns a new read-only [Stack] using the provided ordered [elements]. The first provided element is the bottom of
 * the resulting [Stack] and the last provided element is the top of the provided [Stack].
 */
fun <E> stackOf(vararg elements: E): Stack<E> =
    ReadOnlyStack(elements = elements.toList())

/**
 * Returns a [MutableStack] using the provided ordered [elements]. The first provided element is the bottom of the
 * resulting [Stack] and the last provided element is the top of the provided [Stack].
 */
fun <E> mutableStackOf(vararg elements: E): MutableStack<E> =
    ArrayListMutableStack(elements = elements.toList())

/**
 * Returns a [Stack] containing all the elements in this [Collection]. Note that iterator order of the elements of this
 * [Collection] matters; the first item in this collection will be the bottom of the resulting [Stack] and the last
 * item in this collection will be the top of the resulting [Stack]. This will make a copy of this collection using
 * [Collection.toList] to obtain the order of the items.
 *
 * Note that a copy of this [Collection] will be wrapped in the returned [Stack], so that mutations to this
 * [Collection] will not affect the resulting [Stack].
 */
fun <E> Collection<E>.toStack(): Stack<E> =
    ReadOnlyStack(elements = this)

/**
 * Returns a [MutableStack] containing all the elements in this [Collection]. Note that iterator order of the elements
 * of this [Collection] matters; the first item in this collection will be the bottom of the resulting [Stack] and the
 * last item in this collection will be the top of the resulting [Stack]. This will make a copy of this collection
 * using [Collection.toList] to obtain the order of the items.
 *
 * Note that a copy of this [Collection] will be wrapped in the returned [Stack], so that mutations to this
 * [Collection] will not affect the resulting [Stack].
 */
fun <E> Collection<E>.toMutableStack(): MutableStack<E> =
    ArrayListMutableStack(elements = this)

/**
 * A read-only version of a [Stack]. This takes the elements provided in the constructor and makes a copy of that
 * collection, so further mutations to that elements collection will not affect this [Stack].
 */
internal class ReadOnlyStack<E>(elements: Collection<E>) : Stack<E> {

    override val size: Int
        get() = list.size

    private val list = elements.toList()

    override fun peek(): E =
        list.peek(order = QueueOrder.LIFO)

    override fun isEmpty(): Boolean =
        list.isEmpty()

    override fun iterator(): Iterator<E> =
        list.iterator()

    override fun containsAll(elements: Collection<E>): Boolean =
        this.list.containsAll(elements)

    override fun contains(element: E): Boolean =
        list.contains(element)

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Stack<*>) return false

        return toList() == other.toList()
    }

    override fun hashCode(): Int =
        list.hashCode()

    override fun toString(): String =
        "ReadOnlyStack(size=$size, elements=[${list.joinToString(separator = ",")}])"
}

/**
 * A mutable version of a [Stack] that is backed by an [ArrayList]. This takes the elements provided in the constructor
 * and makes a copy of that collection, so further mutations to that elements collection will not affect this [Stack].
 */
internal class ArrayListMutableStack<E>(elements: Collection<E>) : MutableStack<E> {

    override val size: Int
        get() = list.size

    private val list = ArrayList(elements.toList())

    override fun pop(): E =
        list.pop(order = QueueOrder.LIFO)

    override fun push(element: E) =
        list.push(element)

    override fun peek(): E =
        list.peek(order = QueueOrder.LIFO)

    override fun isEmpty(): Boolean =
        list.isEmpty()

    override fun iterator(): MutableIterator<E> =
        list.iterator()

    override fun clear() =
        list.clear()

    override fun retainAll(elements: Collection<E>): Boolean =
        list.retainAll(elements)

    override fun removeAll(elements: Collection<E>): Boolean =
        list.removeAll(elements)

    override fun remove(element: E): Boolean =
        list.remove(element)

    override fun addAll(elements: Collection<E>): Boolean =
        list.addAll(elements)

    override fun add(element: E): Boolean =
        list.add(element)

    override fun containsAll(elements: Collection<E>): Boolean =
        list.containsAll(elements)

    override fun contains(element: E): Boolean =
        list.contains(element)

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Stack<*>) return false

        return toList() == other.toList()
    }

    override fun hashCode(): Int =
        list.hashCode()

    override fun toString(): String =
        "ArrayListMutableStack(size=$size, elements=[${list.joinToString(separator = ",")}])"
}
