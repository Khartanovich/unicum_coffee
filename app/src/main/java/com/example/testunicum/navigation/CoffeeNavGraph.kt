package com.example.testunicum.navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.testunicum.ui.screens.ChooseScreen
import com.example.testunicum.ui.screens.CoffeeViewModel
import com.example.testunicum.ui.screens.ListCoffeeScreen

@Composable
fun CoffeeNavGraph(
    navController: NavHostController,
    viewModel: CoffeeViewModel = hiltViewModel(),
    topPadding: PaddingValues
    ) {
    NavHost(navController = navController, startDestination = Routes.ListCoffeeScreen.route,
        modifier = Modifier.background(Color.Black)){
        composable(Routes.ListCoffeeScreen.route){
            ListCoffeeScreen(topPadding = topPadding, viewModel = viewModel)
        }
        composable(Routes.ChooseCoffee.route){
            ChooseScreen(topPadding = topPadding, viewModel = viewModel, navController = navController)
        }
    }
}