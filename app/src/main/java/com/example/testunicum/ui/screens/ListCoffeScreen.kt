package com.example.testunicum.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.testunicum.ui.theme.TestUnicumTheme

@Composable
fun ListCoffeeScreen(
    viewModel: CoffeeViewModel = hiltViewModel(),
    topPadding: PaddingValues
) {
    val coffeeModel by viewModel.coffeeModel.collectAsState()
    var listData = MutableList(40) { coffeeModel }
    var model by remember {
        mutableStateOf(coffeeModel)
    }
    LaunchedEffect(key1 = coffeeModel) {
        viewModel.getCoffeeModel()
        model = coffeeModel
        listData = MutableList(40) { model }
    }

    LazyVerticalGrid(
        columns = GridCells.Fixed(5),
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .padding(topPadding)
            ,
        contentPadding = PaddingValues(8.dp),
        horizontalArrangement = Arrangement.spacedBy(10.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        items(listData) { it ->
            ItemCoffeeData(
                glasses = it.glasses,
                name = it.name!!,
                price = it.price,
                isFree = it.isFree
            )
        }
    }
}

@Preview(
    showSystemUi = true,
    device = "spec:width=1280dp,height=800dp,dpi=240, orientation=landscape"
)
@Composable
fun ListCoffeeScreenPreview() {
    TestUnicumTheme {
        ListCoffeeScreen(topPadding = PaddingValues())
    }
}