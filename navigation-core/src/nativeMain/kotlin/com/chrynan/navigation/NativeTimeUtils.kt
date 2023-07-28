package com.chrynan.navigation

import kotlin.system.getTimeMillis
import kotlin.time.Duration
import kotlin.time.Duration.Companion.milliseconds

internal actual fun elapsedSystemTime(): Duration =
    getTimeMillis().milliseconds
