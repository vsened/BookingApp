package com.vsened.bookingapp.presentation.screens.hotelscreen

import com.vsened.bookingapp.domain.model.Hotel

data class HotelScreenState(
    var hotel: Hotel? = null,
    val isLoading: Boolean = false,
    val error: String = ""
)
