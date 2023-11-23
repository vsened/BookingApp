package com.vsened.bookingapp.domain.data

data class Order(
    val id: Int,
    val customer: Customer,
    val hotel: Hotel,
    val room: Room,
    val price: Int,
    val startPoint: String,
    val endPoint: String,
    val period: String
)
