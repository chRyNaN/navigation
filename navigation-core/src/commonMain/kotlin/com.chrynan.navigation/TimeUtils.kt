package com.chrynan.navigation

import kotlin.time.Duration

/**
 * Retrieves the current elapsed system time since the system booted.
 */
internal expect fun elapsedSystemTime(): Duration
