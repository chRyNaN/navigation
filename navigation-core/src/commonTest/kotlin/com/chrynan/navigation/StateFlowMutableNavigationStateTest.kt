package com.chrynan.navigation

import kotlin.test.Test
import kotlin.test.assertEquals

class StateFlowMutableNavigationStateTest {

    @Test
    fun initialStateStaysTheSameAfterUpdateCall() {
        val state = StateFlowMutableNavigationState(initial = 1)

        assertEquals(expected = 1, actual = state.initial)

        state.update(2)

        assertEquals(expected = 1, actual = state.initial)
    }

    @Test
    fun currentStateChangesAfterUpdateCall() {
        val state = StateFlowMutableNavigationState(initial = 1)

        assertEquals(expected = 1, actual = state.current)

        state.update(2)

        assertEquals(expected = 2, actual = state.current)
    }

    @Test
    fun resetChangesCurrentValueBackToInitialValue() {
        val state = StateFlowMutableNavigationState(initial = 1)

        assertEquals(expected = 1, actual = state.initial)
        assertEquals(expected = 1, actual = state.current)

        state.update(2)

        assertEquals(expected = 1, actual = state.initial)
        assertEquals(expected = 2, actual = state.current)

        state.reset()

        assertEquals(expected = 1, actual = state.initial)
        assertEquals(expected = 1, actual = state.current)
    }
}
