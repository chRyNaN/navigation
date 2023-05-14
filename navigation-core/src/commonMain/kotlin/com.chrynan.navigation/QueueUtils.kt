@file:Suppress("unused")

package com.chrynan.navigation

/**
 * Represents the order for queue like operations on existing Kotlin collections. For instance, a queue "pop" function
 * may remove the first or last item from a list depending on the [QueueOrder] specified.
 */
internal enum class QueueOrder {

    /**
     * Represents a "Last In First Out" Queue order. This is typically known as a "Stack".
     */
    LIFO,

    /**
     * Represents a "First In First Out" Queue order.
     */
    FIFO
}

/**
 * Retrieves the item that would be the first removed from this queue [List] without removing it. If the provided
 * [order] is [QueueOrder.LIFO], then the [List.last] item is returned, otherwise, the [order] is [QueueOrder.FIFO] and
 * the [List.first] item is returned. The [order] value defaults to [QueueOrder.LIFO].
 *
 * Note that while this function respects the provided [order] for this retrieval operation, there can be no guarantee
 * that the items were added to this [List] using the same provided [order].
 *
 * @throws [NoSuchElementException] - if the list is empty.
 */
internal fun <E> List<E>.peek(order: QueueOrder = QueueOrder.LIFO): E =
    when (order) {
        QueueOrder.LIFO -> this.last()
        QueueOrder.FIFO -> this.first()
    }

/**
 * Retrieves the item that would be the first removed from this queue [List] without removing it, or `null` if this
 * [List] is empty. If the provided [order] is [QueueOrder.LIFO], then the [List.last] item is returned, otherwise, the
 * [order] is [QueueOrder.FIFO] and the [List.first] item is returned. The [order] value defaults to [QueueOrder.LIFO].
 *
 * Note that while this function respects the provided [order] for this retrieval operation, there can be no guarantee
 * that the items were added to this [List] using the same provided [order].
 */
internal fun <E> List<E>.peekOrNull(order: QueueOrder = QueueOrder.LIFO): E? =
    try {
        this.peek(order = order)
    } catch (_: NoSuchElementException) {
        null
    }

/**
 * Removes the item that would be the first removed from this queue [List]. If the provided [order] is
 * [QueueOrder.LIFO], then the [List.last] item is removed, otherwise, the [order] is [QueueOrder.FIFO] and the
 * [List.first] item is removed. The [order] value defaults to [QueueOrder.LIFO].
 *
 * Note that while this function respects the provided [order] for this removal operation, there can be no guarantee
 * that the items were added to this [MutableList] using the same provided [order].
 *
 * @throws [NoSuchElementException] - if the list is empty.
 */
internal fun <E> MutableList<E>.pop(order: QueueOrder = QueueOrder.LIFO): E =
    when (order) {
        QueueOrder.LIFO -> this.removeLast()
        QueueOrder.FIFO -> this.removeFirst()
    }

/**
 * Removes the item that would be the first removed from this queue [List], or returns `null` if this [List] is empty.
 * If the provided [order] is [QueueOrder.LIFO], then the [List.last] item is removed, otherwise, the [order] is
 * [QueueOrder.FIFO] and the [List.first] item is removed. The [order] value defaults to [QueueOrder.LIFO].
 *
 * Note that while this function respects the provided [order] for this removal operation, there can be no guarantee
 * that the items were added to this [MutableList] using the same provided [order].
 */
internal fun <E> MutableList<E>.popOrNull(order: QueueOrder = QueueOrder.LIFO): E? =
    try {
        this.pop(order = order)
    } catch (_: NoSuchElementException) {
        null
    }

/**
 * Adds the provided [element] to the end of this queue [MutableList].
 *
 * Note that while this function always adds the items to the end of the list (which works for both [QueueOrder.LIFO]
 * and [QueueOrder.FIFO] queues), the retrieval of the items cannot be guaranteed to match any specific [QueueOrder].
 */
internal fun <E> MutableList<E>.push(element: E) {
    this.add(element = element)
}
