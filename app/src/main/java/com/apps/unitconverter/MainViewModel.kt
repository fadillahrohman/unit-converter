package com.apps.unitconverter

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import net.objecthunter.exp4j.ExpressionBuilder

class MainViewModel : ViewModel() {
    private val celcius = "celcius"
    private val fahrenheit = "fahrenheit"

    private val _input = MutableLiveData<String>("0")
    val input: LiveData<String> = _input

    private val _output = MutableLiveData<String>("0")
    val output: LiveData<String> = _output

    private val _activeInputUnit = MutableLiveData(celcius)
    val activeInputUnit: LiveData<String> = _activeInputUnit

    fun setInput(value: String) {
        if (_input.value == "0") {
            _input.value = value
        } else {
            _input.value += value
        }
    }

    fun clearInput() {
        _input.value =
            if (_input.value?.length == 1) {
                "0"
            } else {
                _input.value?.dropLast(1)
            }
    }

    fun resetInputAndOutput() {
        _input.value = "0"
        _output.value = "0"
    }

    fun convertUnit() {
        val expression = _input.value
        val result =
            try {
                ExpressionBuilder(expression).build().evaluate()
            } catch (e: Exception) {
                return
            }
        val activeUnit = _activeInputUnit.value
        result.let {
            _output.value =
                when (activeUnit) {
                    celcius -> convertCelciusToFahrenheit(it).toString()
                    fahrenheit -> convertFahrenheitToCelcius(it).toString()
                    else -> "0"
                }
        }
    }

    fun switchInputUnit() {
        val activeInputUnit = _activeInputUnit
        _activeInputUnit.value = if (activeInputUnit.value == celcius) fahrenheit else celcius
    }

    private fun convertCelciusToFahrenheit(celcius: Double): Double = (celcius * 9 / 5) + 32

    private fun convertFahrenheitToCelcius(fahrenheit: Double): Double = (fahrenheit - 32) * 5 / 9
}
