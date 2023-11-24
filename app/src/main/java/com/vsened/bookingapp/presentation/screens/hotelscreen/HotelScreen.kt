package com.vsened.bookingapp.presentation.screens.hotelscreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Warning
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.vsened.bookingapp.R
import com.vsened.bookingapp.presentation.Screen
import com.vsened.bookingapp.presentation.screens.utils.ImageSlider
import com.vsened.bookingapp.presentation.screens.utils.UserRating
import com.vsened.bookingapp.presentation.ui.theme.ButtonBackground
import com.vsened.bookingapp.presentation.ui.theme.sanFrancisco
import kotlin.system.exitProcess

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HotelScreen(
    navController: NavController,
    viewModel: HotelViewModel = hiltViewModel()
) {
    val state = viewModel.state

    Scaffold(
        modifier = Modifier
            .fillMaxSize(),
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
                    navController.navigate(Screen.RoomsScreen.route)
                }
            ) {
                Text(
                    modifier = Modifier.padding(10.dp),
                    text = "К выбору номера",
                    fontFamily = sanFrancisco,
                    fontWeight = FontWeight.Medium,
                    fontSize = 16.sp
                )
            }
        }
    ) { paddingValues ->
        if (state.error.isNotBlank()) {
            AlertDialog(
                icon = {
                    Icon(imageVector = Icons.Outlined.Warning, contentDescription = "Warning Icon")
                },
                title = {
                    Text(text = "Что-то пошло не так!")
                },
                text = {
                    Text(text = "Попробуйте перезапустить приложение")
                },
                onDismissRequest = {
                    viewModel.getHotel()
                },
                confirmButton = {
                    TextButton(
                        onClick = {
                            viewModel.getHotel()
                        }
                    ) {
                        Text("ОК")
                    }
                },
                dismissButton = {
                    TextButton(
                        onClick = {
                            exitProcess(0)
                        }
                    ) {
                        Text("Отмена")
                    }
                }
            )
        } else {
            if (state.isLoading) {
                CircularProgressIndicator()
            } else {
                state.hotel?.let { hotel ->
                    LazyColumn(
                        modifier = Modifier.padding(paddingValues)
                    ) {
                        item {
                            Card(
                                modifier = Modifier
                                    .fillMaxWidth(),
                                shape = RoundedCornerShape(bottomStart = 12.dp, bottomEnd = 12.dp),
                                colors = CardDefaults.cardColors(
                                    containerColor = Color.White,
                                )
                            ) {
                                Text(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(top = 15.dp),
                                    text = "Отель",
                                    fontFamily = sanFrancisco,
                                    fontSize = 18.sp,
                                    fontWeight = FontWeight.Medium,
                                    textAlign = TextAlign.Center,
                                )
                                Spacer(modifier = Modifier.height(10.dp))
                                ImageSlider(hotel.images)
                                Spacer(Modifier.height(10.dp))
                                UserRating(hotel.rating)
                                Spacer(Modifier.height(3.dp))
                                Text(
                                    modifier = Modifier.padding(start = 16.dp, end = 16.dp),
                                    text = hotel.name,
                                    fontFamily = sanFrancisco,
                                    fontSize = 22.sp,
                                    fontWeight = FontWeight.Medium
                                )
                                Spacer(Modifier.height(3.dp))
                                Text(
                                    modifier = Modifier.padding(start = 16.dp, end = 16.dp),
                                    text = hotel.address,
                                    fontFamily = sanFrancisco,
                                    color = Color(0xFF0D72FF)
                                )
                                Spacer(Modifier.height(10.dp))
                                Row(
                                    modifier = Modifier.padding(start = 16.dp, end = 16.dp),
                                    horizontalArrangement = Arrangement.Start,
                                    verticalAlignment = Alignment.Bottom
                                ) {
                                    Text(
                                        text = "от ${hotel.minPrice / 1000} ${hotel.minPrice % 1000} ₽",
                                        fontFamily = sanFrancisco,
                                        fontWeight = FontWeight.Medium,
                                        fontSize = 30.sp
                                    )
                                    Spacer(modifier = Modifier.width(5.dp))
                                    Text(
                                        text = "за тур с перелётом",
                                        fontFamily = sanFrancisco,
                                        fontSize = 16.sp,
                                        color = Color(0xFF828796),
                                        modifier = Modifier.padding(bottom = 4.dp)
                                    )
                                }
                                Spacer(modifier = Modifier.height(15.dp))
                            }
                            Spacer(modifier = Modifier.height(7.dp))
                        }
                        item {
                            HotelCard(hotel)
                            Spacer(modifier = Modifier.height(10.dp))
                        }
                    }
                }
            }
        }
    }
}


//@Composable
//@Preview
//fun HotelScreenPreview() {
//    HotelScreen()
//}