package com.vsened.bookingapp.presentation.screens.bookingscreen

import com.vsened.bookingapp.domain.model.Hotel
import com.vsened.bookingapp.domain.model.Room
import com.vsened.bookingapp.domain.model.Tourist

data class BookingState(
    val room: Room? = null,
    val tourists: List<Tourist> = listOf(Tourist()),
    val hotel: Hotel? = null,
    val error: String = "",
    val isLoading: Boolean = false,
    val shouldRefresh: Boolean = false
)
