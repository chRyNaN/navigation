@file:Suppress("unused")

package com.chrynan.navigation.compose

actual interface Saver<Original, Saveable : Any>

actual fun <T> autoSaver(): Saver<T, Any> = object : Saver<T, Any> {}
