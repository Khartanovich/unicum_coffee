package com.example.testunicum.ui.screens

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale
import javax.inject.Inject

@HiltViewModel
class CoffeeTopAppBarViewModel @Inject constructor() : ViewModel() {
    private var _degree = MutableStateFlow(85)
    val degree = _degree.asStateFlow()
    private var start: Boolean = true

    private var _time = MutableStateFlow("")
    val time = _time.asStateFlow()

    init {
        setNextDegree()
        setTime()
    }

    private fun setNextDegree() {
        viewModelScope.launch(Dispatchers.IO) {
            while (start) {
                delay(1000)
                _degree.value = (85..95).random()
            }
        }
    }

    private fun setTime(){
        viewModelScope.launch(Dispatchers.IO) {
            while (start) {
                _time.value = getTime()
                delay(10000)

            }
        }
    }

    private fun getTime(): String{
        val calendar = Calendar.getInstance()
        calendar.timeInMillis
        val formater = SimpleDateFormat("HH:mm", Locale.getDefault())
        return formater.format(calendar.timeInMillis)
    }

    override fun onCleared() {
        start = false
        super.onCleared()
    }
}