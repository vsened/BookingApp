package com.vsened.bookingapp.domain.data

data class Tourist(
    val name: String,
    val surname: String,
    val dateOfBirth: String,
    val citizenOf: String,
    val passportId: Int,
    val passportValidityPeriod: String
)