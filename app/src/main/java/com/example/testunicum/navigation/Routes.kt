package com.example.testunicum.navigation

sealed class Routes(val route: String) {
    data object ListCoffeeScreen: Routes("list")
    data object ChooseCoffee: Routes("choose")
}