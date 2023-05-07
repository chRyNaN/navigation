@file:Suppress("unused")

package com.chrynan.navigation

import kotlinx.serialization.KSerializer
import kotlinx.serialization.Serializable
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

/**
 * Represents a LIFO (last in, first out) Queue [Collection].
 */
@Serializable(with = StackSerializer::class)
interface Stack<E> : Collection<E> {

    /**
     * Retrieves the top element from this [Stack] without removing it.
     *
     * @throws [NoSuchElementException] - if the list is empty.
     */
    fun peek(): E

    companion object
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
@Serializable(with = MutableStackSerializer::class)
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

    companion object
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
 * A [Collection] that is both a [List] and a [Stack].
 */
interface ListStack<E> : List<E>,
    Stack<E>

/**
 * A [Collection] that is both a [MutableList] and a [MutableStack].
 */
interface MutableListStack<E> : MutableList<E>,
    MutableStack<E>

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
internal class ReadOnlyStack<E>(elements: Collection<E>) : ListStack<E> {

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

    override fun get(index: Int): E =
        list.get(index = index)

    override fun indexOf(element: E): Int =
        list.indexOf(element = element)

    override fun subList(fromIndex: Int, toIndex: Int): List<E> =
        list.subList(fromIndex = fromIndex, toIndex = toIndex)

    override fun lastIndexOf(element: E): Int =
        list.lastIndexOf(element = element)

    override fun listIterator(): ListIterator<E> =
        list.listIterator()

    override fun listIterator(index: Int): ListIterator<E> =
        list.listIterator(index = index)

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
internal class ArrayListMutableStack<E>(elements: Collection<E>) : MutableListStack<E> {

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

    override fun get(index: Int): E =
        list.get(index = index)

    override fun indexOf(element: E): Int =
        list.indexOf(element = element)

    override fun subList(fromIndex: Int, toIndex: Int): MutableList<E> =
        list.subList(fromIndex = fromIndex, toIndex = toIndex)

    override fun lastIndexOf(element: E): Int =
        list.lastIndexOf(element = element)

    override fun listIterator(): MutableListIterator<E> =
        list.listIterator()

    override fun listIterator(index: Int): MutableListIterator<E> =
        list.listIterator(index = index)

    override fun add(index: Int, element: E) =
        list.add(index = index, element = element)

    override fun addAll(index: Int, elements: Collection<E>): Boolean =
        list.addAll(index = index, elements = elements)

    override fun set(index: Int, element: E): E =
        list.set(index = index, element = element)

    override fun removeAt(index: Int): E =
        list.removeAt(index)

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

/**
 * A [KSerializer] for a [Stack].
 */
internal class StackSerializer<E>(
    elementSerializer: KSerializer<E>
) : KSerializer<Stack<E>> {

    private val delegateSerializer = ListSerializer(elementSerializer = elementSerializer)

    override val descriptor: SerialDescriptor
        get() = delegateSerializer.descriptor

    override fun serialize(encoder: Encoder, value: Stack<E>) {
        delegateSerializer.serialize(encoder = encoder, value = value.toList())
    }

    override fun deserialize(decoder: Decoder): Stack<E> =
        delegateSerializer.deserialize(decoder = decoder).toStack()

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is StackSerializer<*>) return false

        return delegateSerializer == other.delegateSerializer
    }

    override fun hashCode(): Int {
        return delegateSerializer.hashCode()
    }

    override fun toString(): String =
        "StackSerializer(delegateSerializer=$delegateSerializer)"
}

/**
 * A [KSerializer] for a [MutableStack].
 */
internal class MutableStackSerializer<E>(
    elementSerializer: KSerializer<E>
) : KSerializer<MutableStack<E>> {

    private val delegateSerializer = ListSerializer(elementSerializer = elementSerializer)

    override val descriptor: SerialDescriptor
        get() = delegateSerializer.descriptor

    override fun serialize(encoder: Encoder, value: MutableStack<E>) {
        delegateSerializer.serialize(encoder = encoder, value = value.toList())
    }

    override fun deserialize(decoder: Decoder): MutableStack<E> =
        delegateSerializer.deserialize(decoder = decoder).toMutableStack()

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is MutableStackSerializer<*>) return false

        return delegateSerializer == other.delegateSerializer
    }

    override fun hashCode(): Int {
        return delegateSerializer.hashCode()
    }

    override fun toString(): String =
        "MutableStackSerializer(delegateSerializer=$delegateSerializer)"
}
