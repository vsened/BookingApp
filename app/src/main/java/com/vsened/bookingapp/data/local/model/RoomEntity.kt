package com.vsened.bookingapp.data.local.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class RoomEntity(
    val name: String,
    val tags: List<String>,
    val description: String,
    val price: Int,
    val period: String,
    @PrimaryKey val id: Int? = null
)
