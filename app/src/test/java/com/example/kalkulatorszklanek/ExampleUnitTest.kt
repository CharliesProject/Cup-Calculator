package com.example.kalkulatorszklanek

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.kalkulatorszklanek.model.MainViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.test.setMain
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.MockitoAnnotations


class ExampleUnitTest {

    private lateinit var viewModel: MainViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)
        Dispatchers.setMain(Dispatchers.Unconfined)
        viewModel = MainViewModel()
    }

    @Test
    fun set_wheat_flour() {

        val inputNumber = 150.0
        val testText = " test"
        val resultCup = 1.0

        viewModel.apply {
            inputNumberOfGrams.observeForever {}
            weightOfFullCup.observeForever {}
            flourTypeText.observeForever {}
            resultInCups.observeForever {}
            flourDisplayedText.observeForever {}

            setFlour(inputNumber, testText, resultCup)
        }
        assertEquals(inputNumber, viewModel.weightOfFullCup.value)
        assertEquals(inputNumber, viewModel.inputNumberOfGrams.value)
        assertEquals(testText, viewModel.flourTypeText.value)
        assertEquals(resultCup, viewModel.resultInCups.value)

        assertEquals(
            "${inputNumber.toInt()}$testText $resultCup szkl.",
            viewModel.flourDisplayedText.value
        )
    }

    @Test
    fun set_input_number() {

        val testDoubleNumber = 150.0

        viewModel.apply {
            inputNumberOfGrams.observeForever {}
            setModelInputText(testDoubleNumber)
        }
        assertEquals(testDoubleNumber, viewModel.inputNumberOfGrams.value)
    }

    @Test
    fun calculate() {

        val inputGrams = 95.0
        val inputNumber = 150.0
        val testText = " test"
        val resultCup = 1.0
        val finalResult = 0.63

        viewModel.apply {
            resultInCups.observeForever {}

            setFlour(inputNumber, testText, resultCup)
            setModelInputText(inputGrams)
            makeCalculation()
        }
        assertEquals(finalResult, viewModel.resultInCups.value)
    }

}