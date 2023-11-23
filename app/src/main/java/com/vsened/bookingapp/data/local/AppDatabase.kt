package com.vsened.bookingapp.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.vsened.bookingapp.data.local.model.CustomerEntity
import com.vsened.bookingapp.data.local.model.HotelEntity
import com.vsened.bookingapp.data.local.model.OrderEntity
import com.vsened.bookingapp.data.local.model.RoomEntity
import com.vsened.bookingapp.data.local.model.TouristEntity

@Database(
    entities = [
        CustomerEntity::class,
        HotelEntity::class,
        OrderEntity::class,
        RoomEntity::class,
        TouristEntity::class
    ],
    version = 1
)
abstract class AppDatabase : RoomDatabase() {

}