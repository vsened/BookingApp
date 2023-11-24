package com.vsened.bookingapp.presentation.screens.roomsscreen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Warning
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.vsened.bookingapp.R
import com.vsened.bookingapp.presentation.Screen
import com.vsened.bookingapp.presentation.ui.theme.sanFrancisco
import kotlin.system.exitProcess

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RoomsScreen(
    navController: NavController,
    viewModel: RoomsViewModel = hiltViewModel()
) {
    val state = viewModel.state
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text = state.hotelName,
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

                },
                confirmButton = {
                    TextButton(
                        onClick = {
                            viewModel.getRooms()
                        }
                    ) {
                        Text("ОК")
                    }
                },
                dismissButton = {
                    TextButton(
                        onClick = {
                            navController.navigate(Screen.HotelScreen.route)
                        }
                    ) {
                        Text("Вернуться к отелю")
                    }
                }
            )
        } else {
            if (state.isLoading) {
                CircularProgressIndicator()
            } else {
                state.rooms?.let { list ->
                    LazyColumn(modifier = Modifier.padding(paddingValues)) {
                        items(list.size) {
                            list.forEach { room ->
                                RoomItem(room) {
                                    navController.navigate(Screen.BookingScreen.route+"?roomName=${room.id}")
                                }
                                Spacer(modifier = Modifier.height(10.dp))
                            }
                        }
                    }
                }
            }
        }
    }
}