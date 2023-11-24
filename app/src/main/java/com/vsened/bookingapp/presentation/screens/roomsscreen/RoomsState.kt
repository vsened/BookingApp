package com.vsened.bookingapp.presentation.screens.roomsscreen

import com.vsened.bookingapp.domain.model.Room

data class RoomsState(
    var rooms: List<Room>? = emptyList(),
    var hotelName: String = "",
    val isLoading: Boolean = false,
    val error: String = ""
)
