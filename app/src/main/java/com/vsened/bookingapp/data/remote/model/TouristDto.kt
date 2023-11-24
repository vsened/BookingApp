package com.vsened.bookingapp.data.remote.model

data class TouristDto(
    val name: String,
    val surname: String,
    val dateOfBirth: String,
    val citizenOf: String,
    val passportId: Int,
    val passportValidityPeriod: String
)