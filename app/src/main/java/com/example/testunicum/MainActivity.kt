package com.example.testunicum

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.example.testunicum.navigation.CoffeeNavGraph
import com.example.testunicum.ui.screens.ChooseScreen
import com.example.testunicum.ui.screens.CoffeeTopAppBar
import com.example.testunicum.ui.screens.CoffeeTopAppBarViewModel
import com.example.testunicum.ui.screens.CoffeeViewModel
import com.example.testunicum.ui.screens.ListCoffeeScreen
import com.example.testunicum.ui.theme.TestUnicumTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val viewModel: CoffeeViewModel by viewModels()
    private val topAppBarViewModel: CoffeeTopAppBarViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navHostController = rememberNavController()
            TestUnicumTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Scaffold(
                        topBar = { CoffeeTopAppBar(topAppBarViewModel, navHostController) },
                    ) {
                        CoffeeNavGraph(navController = navHostController, topPadding = it, viewModel = viewModel)
                    }

                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    TestUnicumTheme {
        Greeting("Android")
    }
}