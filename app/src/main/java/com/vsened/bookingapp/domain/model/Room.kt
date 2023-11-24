package com.vsened.bookingapp.domain.model

data class Room(
    val name: String,
    val tags: List<String>,
    val description: String,
    val price: Int,
    val period: String,
    val images: List<Int>
)
