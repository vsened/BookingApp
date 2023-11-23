package com.vsened.bookingapp.domain.data

data class Room(
    val name: String,
    val tags: List<String>,
    val description: String,
    val price: Int,
    val period: String,

)
