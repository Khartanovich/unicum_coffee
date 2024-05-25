package com.example.testunicum.ui.screens

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.testunicum.R
import com.example.testunicum.navigation.Routes
import com.example.testunicum.ui.theme.TextColor

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CoffeeTopAppBar(
    viewModel: CoffeeTopAppBarViewModel = hiltViewModel(),
    navController: NavHostController
) {
    val degree by viewModel.degree.collectAsState()
    val time by viewModel.time.collectAsState()

    TopAppBar(
        title = {
            Text(
                text = stringResource(R.string.runero_touch),
                color = colorResource(id = R.color.text_field_container_color)
            )
        },
        navigationIcon = {
            IconButton(onClick = {
                navController.navigate(Routes.ChooseCoffee.route) {
                    launchSingleTop = true

                    popUpTo(Routes.ListCoffeeScreen.route) {
                        inclusive = false
                        saveState = false
                    }
                }
            }) {
                Icon(painter = painterResource(id = R.drawable.union), contentDescription = "")
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color.Black,
            actionIconContentColor = colorResource(id = R.color.text_field_container_color),
            navigationIconContentColor = colorResource(id = R.color.text_field_container_color)
        ),
        actions = {
            Text(text = time, color = TextColor)
            Spacer(modifier = Modifier.width(48.dp))
            Text(text = degree.toString() + "°", color = TextColor)
        },
    )
}