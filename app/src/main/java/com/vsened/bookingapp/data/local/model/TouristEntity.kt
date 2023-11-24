package com.vsened.bookingapp.data.local.model


data class TouristEntity(
    val name: String,
    val surname: String,
    val dateOfBirth: String,
    val citizenOf: String,
    val passportId: Int,
    val passportValidityPeriod: String
)