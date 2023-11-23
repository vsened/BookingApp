package com.vsened.bookingapp.presentation.screens.roomsscreen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.vsened.bookingapp.R
import com.vsened.bookingapp.presentation.Screen
import com.vsened.bookingapp.presentation.ui.theme.sanFrancisco

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RoomsScreen(navController: NavController) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text = "Steigenberger Makadi",
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
                            navController.navigate(Screen.HotelScreen.route)
                        }
                    )
                }
            )
        }
    ) {
        LazyColumn(modifier = Modifier.padding(it)) {
            items(10) {
                RoomItem() {
                    navController.navigate(Screen.BookingScreen.route)
                }
                Spacer(modifier = Modifier.height(10.dp))
            }
        }
    }
}