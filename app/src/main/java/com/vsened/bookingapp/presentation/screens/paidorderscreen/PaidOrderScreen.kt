package com.vsened.bookingapp.presentation.screens.paidorderscreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.vsened.bookingapp.R
import com.vsened.bookingapp.presentation.Screen
import com.vsened.bookingapp.presentation.ui.theme.ButtonBackground
import com.vsened.bookingapp.presentation.ui.theme.sanFrancisco

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PaidOrderScreen(navController: NavController) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text = "Заказ оплачен",
                        fontFamily = sanFrancisco,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Medium
                    )
                },
                navigationIcon = {
                    Icon(
                        imageVector = ImageVector.vectorResource(R.drawable.arrow_back),
                        contentDescription = "Back icon",
                        modifier = Modifier.clickable {
                            navController.navigate(Screen.BookingScreen.route)
                        }
                    )
                }
            )
        },
        bottomBar = {
            Button(
                shape = RoundedCornerShape(15.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                colors = ButtonDefaults.buttonColors(
                    contentColor = Color.White,
                    containerColor = ButtonBackground,
                    disabledContainerColor = ButtonBackground
                ),
                onClick = {
                    navController.navigate(Screen.HotelScreen.route)
                }
            ) {
                Text(
                    text = "Супер!",
                    fontFamily = sanFrancisco,
                    fontWeight = FontWeight.Medium,
                    fontSize = 16.sp,
                    modifier = Modifier.padding(8.dp)
                )
            }
        }
    ) {
        Column(
            modifier = Modifier
                .padding(it)
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                bitmap = ImageBitmap.imageResource(R.drawable.party_popper),
                contentDescription = "Success order icon",
                modifier = Modifier
                    .size(90.dp)
                    .clip(CircleShape)
                    .background(Color(0xFFF6F6F9))
                    .padding(20.dp)
            )
            Spacer(modifier = Modifier.height(20.dp))
            Text(
                text = "Ваш заказ принят в работу",
                fontFamily = sanFrancisco,
                fontWeight = FontWeight.Medium,
                fontSize = 20.sp
            )
            Spacer(modifier = Modifier.height(10.dp))
            Box {
                Text(
                    text = "Подтверждение заказа №104893 может занять некоторое время (от 1 часа до суток). Как только мы получим ответ от туроператора, вам на почту придет уведомление.",
                    color = Color(0xFF828796),
                    fontFamily = sanFrancisco,
                    fontWeight = FontWeight.Normal,
                    fontSize = 18.sp,
                    modifier = Modifier
                        .padding(start = 16.dp, end = 16.dp),
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}


//@Preview
//@Composable
//fun PaidOrderScreenPreview() {
//    PaidOrderScreen()
//}