package com.chrynan.navigation

import kotlinx.coroutines.delay
import kotlinx.coroutines.test.runTest
import kotlin.test.Test
import kotlin.test.assertTrue
import kotlin.time.Duration.Companion.seconds

class TimeUtilsTest {

    @Test
    fun elapsedSystemTimeIncrementsOverTime() {
        runTest {
            val start = elapsedSystemTime()

            delay(2.seconds)

            val end = elapsedSystemTime()

            assertTrue(actual = start < end)
        }
    }
}
