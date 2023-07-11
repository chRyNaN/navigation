@file:Suppress("unused")

package com.chrynan.navigation

import kotlin.js.Date
import kotlin.time.Duration
import kotlin.time.Duration.Companion.milliseconds

// JavaScript doesn't seem to have a way to obtain the elapsed system time. So instead we just get the current Date
// instance to get the elapsed time since the epoch. This should be fine in most cases.
internal actual fun elapsedSystemTime(): Duration =
    Date().getTime().milliseconds
