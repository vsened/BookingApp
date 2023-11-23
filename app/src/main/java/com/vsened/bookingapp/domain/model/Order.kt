package com.vsened.bookingapp.domain.model

data class Order(
    val customer: Customer,
    val hotel: Hotel,
    val room: Room,
    val price: Int,
    val startPoint: String,
    val endPoint: String,
    val period: String,
    val tourists: List<Tourist>
)
