package com.apps.unitconverter

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    private val _input = MutableLiveData<String>("0")
    val input: LiveData<String> = _input

    fun setInput(value: String) {
        if (_input.value == "0") {
            _input.value = value
        } else {
            _input.value += value
        }
    }
}