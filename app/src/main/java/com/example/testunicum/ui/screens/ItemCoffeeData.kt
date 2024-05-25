package com.example.testunicum.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.testunicum.R
import com.example.testunicum.ui.theme.PriceListGradientCenter
import com.example.testunicum.ui.theme.PriceListGradientEnd
import com.example.testunicum.ui.theme.PriceListGradientStart
import com.example.testunicum.ui.theme.SwitchColorCheckedOne
import com.example.testunicum.ui.theme.TestUnicumTheme
import com.example.testunicum.ui.theme.TextColor

@Composable
fun ItemCoffeeData(
    glasses: Int,
    name: String,
    price: Int,
    isFree: Boolean
) {
    val colorGradient =
        Brush.horizontalGradient(
            listOf(
                PriceListGradientStart,
                PriceListGradientCenter,
                PriceListGradientEnd
            )
        )
    Card(
        shape = RoundedCornerShape(6.dp),
        modifier = Modifier

    ) {
        Column(
            modifier = Modifier.background(colorResource(id = R.color.text_field_container_color)).fillMaxWidth(),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(
                    id = if (glasses == 1) R.drawable.cream_cappuccino else R.drawable.frame_1816
                ),
                contentDescription = "",
                modifier = Modifier

                    .size(166.dp),
            )
            Text(
                text = name,
                fontSize = 16.sp,
                color = TextColor,
            )

            Row(
                modifier = Modifier
                    .padding(top = 18.dp)
                    .fillMaxWidth()
                    .height(42.dp)
                    .background(colorGradient),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = if (isFree) Arrangement.Center else Arrangement.SpaceBetween
            ) {
                if (isFree) {
                    Text(
                        text = stringResource(R.string._0_33),
                        fontSize = 16.sp,
                        color = TextColor
                    )
                } else {
                    Text(
                        text = stringResource(R.string._0_33),
                        fontSize = 16.sp,
                        color = TextColor,
                        modifier = Modifier.padding(start = 4.dp)
                    )
                    Text(
                        text = price.toString() + " RUB",
                        fontSize = 18.sp,
                        color = SwitchColorCheckedOne,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(end = 4.dp)
                    )
                }
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun ItemCoffeeDataPreview() {
    TestUnicumTheme {
        ItemCoffeeData(glasses = 2, name = "my coffee", price = 199, isFree = false)
    }
}