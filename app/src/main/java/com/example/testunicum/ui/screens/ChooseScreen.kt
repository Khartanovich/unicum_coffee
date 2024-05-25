package com.example.testunicum.ui.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.testunicum.ui.theme.TestUnicumTheme
import com.example.testunicum.R
import com.example.testunicum.navigation.Routes
import com.example.testunicum.ui.theme.SwitchColorCheckedOne
import com.example.testunicum.ui.theme.TextColor
import com.example.testunicum.ui.theme.TextFieldContainerColor

private const val FIRST_GLASSES = 1
private const val SECOND_GLASSES = 2

@Composable
fun ChooseScreen(
    viewModel: CoffeeViewModel = hiltViewModel(),
    topPadding: PaddingValues,
    navController: NavHostController
) {

    val coffeeModel by viewModel.coffeeModel.collectAsState()

    var isCheckedFirstGlasses by remember {
        if (coffeeModel.glasses == FIRST_GLASSES) {
            mutableStateOf(true)
        } else {
            mutableStateOf(false)
        }
    }
    var isCheckedSecondGlasses by remember {
        if (isCheckedFirstGlasses) {
            mutableStateOf(false)
        } else {
            mutableStateOf(true)
        }
    }

    var nameCoffee by remember { mutableStateOf(coffeeModel.name) }
    var priceCoffee by remember { mutableStateOf(coffeeModel.price.toString()) }
    var isFreeCoffee by remember { mutableStateOf(coffeeModel.isFree) }
    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .padding(topPadding)
            .fillMaxSize()
            .background(Color.Black)
            .verticalScroll(scrollState),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.End
    ) {


        Row(
            modifier = Modifier
                .fillMaxWidth(0.7f),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                modifier = Modifier
                    .weight(2f, false),
                verticalArrangement = Arrangement.Top
            ) {

                Text(
                    text = stringResource(R.string.name),
                    fontSize = 16.sp,
                    color = TextColor
                )

                TextField(
                    value = nameCoffee!!, onValueChange = { nameCoffee = it },
                    colors = TextFieldDefaults.colors(
                        focusedTextColor = colorResource(id = R.color.text_field_color),
                        unfocusedTextColor = colorResource(id = R.color.text_field_color),
                        disabledTextColor = Color.Transparent,
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent,
                        disabledIndicatorColor = Color.Transparent,
                        focusedContainerColor = colorResource(id = R.color.text_field_container_color),
                        unfocusedContainerColor = colorResource(id = R.color.text_field_container_color),
                    ),
                    modifier = Modifier.fillMaxWidth(),
                    textStyle = TextStyle(fontSize = 20.sp),
                    singleLine = true
                )

                Text(
                    text = stringResource(R.string.price),
                    fontSize = 16.sp,
                    color = TextColor,
                    modifier = Modifier.padding(top = 32.dp),
                    lineHeight = 20.sp
                )

                TextField(
                    value = priceCoffee, onValueChange = { priceCoffee = it },
                    colors = TextFieldDefaults.colors(
                        focusedTextColor = colorResource(id = R.color.text_field_color),
                        unfocusedTextColor = colorResource(id = R.color.text_field_color),
                        disabledTextColor = Color.Transparent,
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent,
                        disabledIndicatorColor = Color.Transparent,
                        focusedContainerColor = colorResource(id = R.color.text_field_container_color),
                        unfocusedContainerColor = colorResource(id = R.color.text_field_container_color),
                    ),
                    modifier = Modifier
                        .background(
                            color = TextFieldContainerColor,
                            shape = MaterialTheme.shapes.small
                        )
                        .fillMaxWidth(),
                    textStyle = TextStyle(fontSize = 20.sp),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    trailingIcon = { Text(text = stringResource(R.string.rub)) },
                    singleLine = true
                )

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 12.dp)
                        .border(
                            border = BorderStroke(2.dp, SolidColor(TextFieldContainerColor)),
                            shape = RoundedCornerShape(6.dp)
                        ),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically,

                    ) {

                    Text(
                        text = stringResource(R.string.buying_free),
                        fontSize = 14.sp,
                        color = TextColor,
                        modifier = Modifier.padding(start = 24.dp)
                    )

                    Switch(
                        checked = isFreeCoffee, onCheckedChange = { isFreeCoffee = it },
                        modifier = Modifier.padding(end = 12.dp),
                        colors = SwitchDefaults.colors(
                            checkedTrackColor = SwitchColorCheckedOne
                        )
                    )

                }

                Button(
                    onClick = {
                        val name = nameCoffee.toString()
                        val price = priceCoffee.toInt()
                        val numberCoffee =
                            if (isCheckedFirstGlasses) FIRST_GLASSES else SECOND_GLASSES
                        val isFree = isFreeCoffee
                        viewModel.saveCoffeeModel(name, price, numberCoffee, isFree)
                        navController.navigate(Routes.ListCoffeeScreen.route)
                    },
                    modifier = Modifier
                        .align(Alignment.Start)
                        .padding(top = 64.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = colorResource(id = R.color.button_color)
                    ),
                    shape = RoundedCornerShape(12.dp)
                )
                {
                    Text(text = stringResource(R.string.save))

                }
            }

            Box(
                modifier = Modifier
                    .paint(
                        painter = painterResource(id = R.drawable.cream_cappuccino),
                        contentScale = ContentScale.FillWidth
                    )
                    .clickable {
                        isCheckedFirstGlasses = !isCheckedFirstGlasses
                        isCheckedSecondGlasses = !isCheckedSecondGlasses
                    },
                contentAlignment = Alignment.BottomCenter,
            ) {

                if (isCheckedFirstGlasses) {
                    Image(
                        painter = painterResource(id = R.drawable.is_cheked_glasses),
                        contentDescription = "",
                        modifier = Modifier
                            .padding()
                            .size(32.dp)
                    )
                }
            }

            Box(
                modifier = Modifier
                    .paint(
                        painter = painterResource(id = R.drawable.frame_1816),
                        contentScale = ContentScale.FillWidth
                    )
                    .clickable {
                        isCheckedFirstGlasses = !isCheckedFirstGlasses
                        isCheckedSecondGlasses = !isCheckedSecondGlasses
                    },
                contentAlignment = Alignment.BottomCenter,
            ) {

                if (isCheckedSecondGlasses) {
                    Image(
                        painter = painterResource(id = R.drawable.is_cheked_glasses),
                        contentDescription = "",
                        modifier = Modifier
                            .padding()
                            .size(32.dp)
                    )
                }
            }
        }


    }
}

@Preview(
    showSystemUi = true,
    device = "spec:width=1280dp,height=800dp,dpi=240, orientation=landscape"
)
@Composable
fun ChooseScreenPreview() {
    TestUnicumTheme {
//        ChooseScreen(topPadding = PaddingValues())
    }
}
