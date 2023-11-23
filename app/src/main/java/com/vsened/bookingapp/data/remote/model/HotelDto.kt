package com.vsened.bookingapp.data.remote.model

data class HotelDto(
    val name: String,
    val rating: String,
    val address: String,
    val minPrice: Int,
    val tags: List<String>,
    val description: String,
    val conveniences: String,
    val include: String,
    val notInclude: String,
    val nutrition: String,
    val fuelSurcharge: Int,
    val serviceSurcharge: Int
)
