package com.vsened.bookingapp.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.vsened.bookingapp.presentation.screens.bookingscreen.BookingScreen
import com.vsened.bookingapp.presentation.screens.hotelscreen.HotelScreen
import com.vsened.bookingapp.presentation.screens.paidorderscreen.PaidOrderScreen
import com.vsened.bookingapp.presentation.screens.roomsscreen.RoomsScreen
import com.vsened.bookingapp.presentation.ui.theme.BookingAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BookingAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = Screen.HotelScreen.route
                    ) {
                        composable(
                            route = Screen.HotelScreen.route
                        ) {HotelScreen(navController = navController)
                        }
                        composable(
                            route = Screen.RoomsScreen.route
                        ) {
                            RoomsScreen(navController = navController)
                        }
                        composable(
                            route = Screen.BookingScreen.route
                            + "?roomName={roomId}",
                            arguments = listOf(
                                navArgument(
                                    name = "roomId"
                                ) {
                                    type = NavType.StringType
                                    defaultValue = ""
                                }
                            )
                        ) {
                            val roomId = it.arguments?.getString("roomId") ?: ""
                            BookingScreen(navController = navController, roomId)
                        }
                        composable(
                            route = Screen.PaidOrderScreen.route
                        ) {
                            PaidOrderScreen(navController = navController)
                        }
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
    BookingAppTheme {
        Greeting("Android")
    }
}