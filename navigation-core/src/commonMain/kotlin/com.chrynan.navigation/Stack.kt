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
internal interface Stack<E> : Collection<E> {

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
internal fun <E> Stack<E>.peekOrNull(): E? =
    try {
        peek()
    } catch (_: NoSuchElementException) {
        null
    }

/**
 * Represents a mutable LIFO (last in, first out) Queue [MutableCollection]
 */
@Serializable(with = MutableStackSerializer::class)
internal interface MutableStack<E> : Stack<E>,
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
internal fun <E> MutableStack<E>.popOrNull(): E? =
    try {
        pop()
    } catch (_: NoSuchElementException) {
        null
    }

/**
 * Returns a new read-only [Stack] using the provided ordered [elements]. The first provided element is the top of the
 * resulting [Stack] and the last provided element is the bottom of the resulting [Stack].
 */
internal fun <E> stackOf(vararg elements: E): Stack<E> =
    ReadOnlyStack(elements = elements.toList())

/**
 * Returns a [MutableStack] using the provided ordered [elements]. The first provided element is the top of the
 * resulting [Stack] and the last provided element is the bottom of the resulting [Stack].
 */
internal fun <E> mutableStackOf(vararg elements: E): MutableStack<E> =
    ArrayListMutableStack(elements = elements.toList())

/**
 * Returns a [Stack] containing all the elements in this [Collection]. Note that iterator order of the elements of this
 * [Collection] matters; the first item in this collection will be the top of the resulting [Stack] and the last item
 * in this collection will be the bottom of the resulting [Stack], which matches the [Stack.iterator] order. This will
 * make a copy of this collection using [Collection.toList] to obtain the order of the items.
 *
 * Note that a copy of this [Collection] will be wrapped in the returned [Stack], so that mutations to this
 * [Collection] will not affect the resulting [Stack].
 */
internal fun <E> Collection<E>.toStack(): Stack<E> =
    ReadOnlyStack(elements = this)

/**
 * Returns a [MutableStack] containing all the elements in this [Collection]. Note that iterator order of the elements
 * of this [Collection] matters; the first item in this collection will be the top of the resulting [Stack] and the
 * last item in this collection will be the bottom of the resulting [Stack], which matches the [Stack.iterator] order.
 * This will make a copy of this collection using [Collection.toList] to obtain the order of the items.
 *
 * Note that a copy of this [Collection] will be wrapped in the returned [Stack], so that mutations to this
 * [Collection] will not affect the resulting [Stack].
 */
internal fun <E> Collection<E>.toMutableStack(): MutableStack<E> =
    ArrayListMutableStack(elements = this)

/**
 * A read-only version of a [Stack]. This takes the elements provided in the constructor and makes a copy of that
 * collection, so further mutations to that elements collection will not affect this [Stack].
 */
internal class ReadOnlyStack<E> internal constructor(elements: Collection<E>) : Stack<E> {

    override val size: Int
        get() = list.size

    private val list = elements.toList()

    override fun peek(): E =
        list.get(index = 0)

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
internal class ArrayListMutableStack<E> internal constructor(elements: Collection<E>) : MutableStack<E> {

    override val size: Int
        get() = list.size

    private val list = ArrayList(elements.toList())

    override fun pop(): E =
        list.removeFirst()

    override fun push(element: E) =
        list.add(index = 0, element = element)

    override fun peek(): E =
        list.get(index = 0)

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

/**
 * A [KSerializer] for a [Stack].
 */
internal class StackSerializer<E> internal constructor(
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

    override fun hashCode(): Int =
        delegateSerializer.hashCode()

    override fun toString(): String =
        "StackSerializer(delegateSerializer=$delegateSerializer)"
}

/**
 * A [KSerializer] for a [MutableStack].
 */
internal class MutableStackSerializer<E> internal constructor(
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

    override fun hashCode(): Int =
        delegateSerializer.hashCode()

    override fun toString(): String =
        "MutableStackSerializer(delegateSerializer=$delegateSerializer)"
}
