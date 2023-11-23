package com.vsened.bookingapp.data.local.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class OrderEntity(
    val customer: CustomerEntity,
    val hotel: HotelEntity,
    val room: RoomEntity,
    val price: Int,
    val startPoint: String,
    val endPoint: String,
    val period: String,
    val tourists: List<TouristEntity>,
    @PrimaryKey val id: Int? = null
)
