package com.vsened.bookingapp.data.local.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class CustomerEntity(
    val phoneNumber: String,
    val email: String,
    @PrimaryKey val id: Int? = null
)
