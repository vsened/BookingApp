package com.vsened.bookingapp.data.local.model


data class RoomEntity(
    val id: String,
    val name: String,
    val tags: List<String>,
    val description: String,
    val price: Int,
    val period: String,
    val images: List<Int>,
    val startPoint: String,
    val endPoint: String,
    val dates: String
)
