package com.vsened.bookingapp.data.local.model


data class OrderEntity(
    val customer: CustomerEntity,
    val hotel: HotelEntity,
    val room: RoomEntity,
    val price: Int,
    val startPoint: String,
    val endPoint: String,
    val period: String,
    val tourists: List<TouristEntity>
)
