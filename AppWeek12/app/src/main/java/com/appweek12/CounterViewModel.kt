package com.appweek12

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import androidx.lifecycle.ViewModel

/**
 * CounterViewModel
 *
 * Role:
 * - Manage counter state (_count)
 * - Provide state change functions (increment, decrement, reset, incrementBy10)
 * - Exist independently of Activity
 *
 * Characteristics:
 * - Inherits from ViewModel (lifecycle management)
 * - Data preserved when Activity recreated
 * - No UI logic (only business logic)
 */
class CounterViewModel : ViewModel() {

    // Private mutable state
    // Only ViewModel can modify
    private val _count = MutableStateFlow(0)

    // Public immutable state
    // Activity can only read
    val count: StateFlow<Int> = _count.asStateFlow()

    /**
     * Increment by 1
     */
    fun increment() {
        _count.value += 1
    }

    /**
     * Decrement by 1
     */
    fun decrement() {
        _count.value -= 1
    }

    /**
     * Reset to 0
     */
    fun reset() {
        _count.value = 0
    }

    /**
     * Increment by 10
     */
    fun incrementBy10() {
        _count.value = (_count.value) + 10
    }
}