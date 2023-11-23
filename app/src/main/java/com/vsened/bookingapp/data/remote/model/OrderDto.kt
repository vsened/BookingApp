package com.vsened.bookingapp.data.remote.model

data class OrderDto(
    val customer: CustomerDto,
    val hotel: HotelDto,
    val room: RoomDto,
    val price: Int,
    val startPoint: String,
    val endPoint: String,
    val period: String,
    val tourists: List<TouristDto>
)
