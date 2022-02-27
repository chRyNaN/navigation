@file:Suppress("unused")

package com.chrynan.navigation.compose

actual typealias Saver<Original, Saveable> = androidx.compose.runtime.saveable.Saver<Original, Saveable>

actual fun <T> autoSaver(): Saver<T, Any> = androidx.compose.runtime.saveable.autoSaver()
