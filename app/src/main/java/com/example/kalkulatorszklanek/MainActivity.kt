package com.example.kalkulatorszklanek

import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.example.kalkulatorszklanek.databinding.ActivityMainBinding
import com.example.kalkulatorszklanek.model.MainViewModel
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val mainViewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initialState()

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.apply {
            viewModel = mainViewModel
            activityMain = this@MainActivity
            calculateBtn.setOnClickListener { checkInputTextIsNull() }
            exitBtn.setOnClickListener { exitApp() }
        }

        val flourTextObserver = Observer<String> { newFlour ->
            binding.resultText.text = newFlour
        }
        mainViewModel.flourDisplayedText.observe(this, flourTextObserver)

    }

    private fun initialState() {
        val flourText = getString(R.string.default_wheat)
        mainViewModel.modelInitialState(flourText)
    }

    private fun checkInputTextIsNull() {

        if (binding.enterQuantity.text?.isBlank() == true) {
            displaySnackBar()
        } else {
            setInput()
            mainCalculation()
        }
    }

    private fun displaySnackBar() {
        val contextView = findViewById<View>(R.id.calculate_btn)
        Snackbar.make(contextView, R.string.snack_bar_text, Snackbar.LENGTH_LONG)
            .show()
    }

    private fun setInput() {
        val setInputNumberOfGrams = binding.enterQuantity.text.toString().toDouble()
        mainViewModel.setModelInputText(setInputNumberOfGrams)
    }

    private fun mainCalculation() {
        mainViewModel.makeCalculation()
    }

    private fun exitApp() {
        finish()
    }

}