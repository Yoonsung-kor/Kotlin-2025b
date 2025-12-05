package com.appweek12

import android.graphics.Color
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.appweek12.databinding.ActivityMainBinding
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    // View Binding
    private lateinit var binding: ActivityMainBinding

    // Initialize ViewModel
    // by viewModels(): Automatically creates ViewModel and manages lifecycle
    private val viewModel: CounterViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Start observing state
        setupObservers()

        // Setup button listeners
        setupListeners()
    }

    /**
     * Observe StateFlow
     *
     * UI updates whenever ViewModel state changes
     */
    private fun setupObservers() {
        lifecycleScope.launch {
            // repeatOnLifecycle: Automatically follow Activity lifecycle
            // Observe only when STARTED state
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.count.collect { count ->
                    // Executes whenever count changes
                    binding.textViewCount.text = count.toString()

                    // Change color based on state
                    when {
                        count > 0 -> binding.textViewCount.setTextColor(Color.BLUE)    // Positive: Blue
                        count < 0 -> binding.textViewCount.setTextColor(Color.RED)     // Negative: Red
                        else -> binding.textViewCount.setTextColor(Color.BLACK)        // Zero: Black
                    }
                }
            }
        }
    }

    /**
     * Setup button click listeners
     *
     * Button click → Call ViewModel method → State change → UI auto-update
     */
    private fun setupListeners() {
        // +1 button
        binding.buttonPlus.setOnClickListener {
            viewModel.increment()
        }

        // -1 button
        binding.buttonMinus.setOnClickListener {
            viewModel.decrement()
        }

        // Reset button
        binding.buttonReset.setOnClickListener {
            viewModel.reset()
        }

        // +10 button
        binding.buttonPlus10.setOnClickListener {
            viewModel.incrementBy10()
        }
    }
}