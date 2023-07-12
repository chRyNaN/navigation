@file:Suppress("unused")

package com.chrynan.navigation

import kotlin.time.Duration
import kotlin.time.Duration.Companion.milliseconds

internal actual fun elapsedSystemTime(): Duration =
    System.currentTimeMillis().milliseconds
