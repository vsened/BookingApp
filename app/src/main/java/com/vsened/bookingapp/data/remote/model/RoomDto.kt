package com.vsened.bookingapp.data.remote.model

data class RoomDto(
    val name: String,
    val tags: List<String>,
    val description: String,
    val price: Int,
    val period: String,
    val images: List<Int>
)
