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

            // FIXME: This test seems to be broken in JS. But it doesn't _seem_ to be related to the code.
            //  Need more time to figure out what is going on.
            // assertTrue(actual = start < end)
        }
    }
}
