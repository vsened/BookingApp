package com.vsened.bookingapp.presentation

sealed class Screen(val route: String) {
    object HotelScreen: Screen("hotel_screen")
    object RoomsScreen: Screen("rooms_screen")
    object BookingScreen: Screen("booking_screen")
    object PaidOrderScreen: Screen("paid_order_screen")
}
