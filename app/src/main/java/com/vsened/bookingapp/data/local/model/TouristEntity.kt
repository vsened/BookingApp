package com.vsened.bookingapp.data.local.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class TouristEntity(
    val name: String,
    val surname: String,
    val dateOfBirth: String,
    val citizenOf: String,
    val passportId: Int,
    val passportValidityPeriod: String,
    @PrimaryKey val id: Int? = null
)