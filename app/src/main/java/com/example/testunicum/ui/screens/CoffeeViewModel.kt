package com.example.testunicum.ui.screens

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.data.CoffeeModel
import com.example.data.SharedRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CoffeeViewModel @Inject constructor(
    private val repository: SharedRepository
) : ViewModel() {

    private var _coffeeModel = MutableStateFlow<CoffeeModel>(CoffeeModel())
    val coffeeModel = _coffeeModel.asStateFlow()

    fun saveCoffeeModel(name: String, price: Int, numberGlasses: Int, isFree: Boolean) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.saveNameCoffee(name)
            repository.savePrice(price)
            repository.saveNumberGlasses(numberGlasses)
            repository.saveIsFree(isFree)
        }
    }

    init {
        getCoffeeModel()
    }

    fun getCoffeeModel() {
        viewModelScope.launch(Dispatchers.IO) {
            _coffeeModel.value = coffeeModel.value.copy(
                name = repository.getNameCoffee(),
                price = repository.getPrice(),
                glasses = repository.getNumberGlasses(),
                isFree = repository.getIsFree()
            )
        }
    }
}