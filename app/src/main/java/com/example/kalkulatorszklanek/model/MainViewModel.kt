package com.example.kalkulatorszklanek.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import java.util.*

class MainViewModel : ViewModel() {

    companion object {
        const val ONE_CUP = 1.0
        const val WHEAT_FLOUR_WEIGHT = 150.0
        const val RYE_FLOUR_WEIGHT = 115.0
        const val OATS_FLOUR_WEIGHT = 105.0
        const val RICE_FLOUR_WEIGHT = 150.0
        const val OAT_FLAKES_WEIGHT = 110.0
    }

    private val _flourDisplayedText = MutableLiveData<String>()
    val flourDisplayedText: LiveData<String> get() = _flourDisplayedText

    private val _flourTypeText = MutableLiveData<String>()
    val flourTypeText: LiveData<String> get() = _flourTypeText

    private val _inputNumberOfGrams = MutableLiveData<Double>()
    val inputNumberOfGrams: LiveData<Double> get() = _inputNumberOfGrams

    private val _resultInCups = MutableLiveData<Double>()
    val resultInCups: LiveData<Double> get() = _resultInCups

    private val _weightOfFullCup = MutableLiveData<Double>()
    val weightOfFullCup: LiveData<Double> get() = _weightOfFullCup

    private fun displayText() {
        viewModelScope.launch {
            _flourDisplayedText.value =
                "${_inputNumberOfGrams.value?.toInt()}${_flourTypeText.value} ${_resultInCups.value} szkl."
        }
    }

    fun setFlour(flourGrams: Double, flourType: String, flourCups: Double) {
        viewModelScope.launch {
            _weightOfFullCup.value = flourGrams
            _inputNumberOfGrams.value = _weightOfFullCup.value
            _flourTypeText.value = flourType
            _resultInCups.value = flourCups
            displayText()
        }
    }

    fun modelInitialState(modelInitialText: String) {
        viewModelScope.launch {
            _weightOfFullCup.value = WHEAT_FLOUR_WEIGHT
            _inputNumberOfGrams.value = _weightOfFullCup.value
            _flourTypeText.value = modelInitialText
            _resultInCups.value = ONE_CUP
            displayText()
        }
    }

    fun setModelInputText(modelInputText: Double) {
        viewModelScope.launch {
            _inputNumberOfGrams.value = modelInputText
        }
    }

    fun makeCalculation() {
        viewModelScope.launch {
            val result = (_inputNumberOfGrams.value)?.div(_weightOfFullCup.value!!)
            val formattedFinalResult = String.format(Locale.US, "%.2f", result).toDouble()
            _resultInCups.value = formattedFinalResult
            displayText()
        }
    }
}