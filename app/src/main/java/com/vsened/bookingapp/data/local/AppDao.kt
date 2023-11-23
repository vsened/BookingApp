package com.vsened.bookingapp.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.vsened.bookingapp.data.local.model.CustomerEntity
import com.vsened.bookingapp.data.local.model.HotelEntity
import com.vsened.bookingapp.data.local.model.OrderEntity
import com.vsened.bookingapp.data.local.model.RoomEntity
import com.vsened.bookingapp.data.local.model.TouristEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface AppDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertHotel(
        hotel: HotelEntity
    )

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertRooms(
        rooms: List<RoomEntity>
    )

    @Query("SELECT * FROM hotelentity LIMIT 1")
    fun getHotelById(): Flow<HotelEntity>

    @Query("SELECT * FROM roomentity")
    fun getRooms(): Flow<List<RoomEntity>>

    @Query("SELECT * FROM roomentity WHERE id = :id")
    fun getRoomById(id: Int): Flow<RoomEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCustomer(
        customer: CustomerEntity
    )

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTourist(
        tourist: TouristEntity
    )

    @Query("SELECT * FROM touristentity WHERE id = :id")
    fun getTouristById(id: Int): Flow<TouristEntity>


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertOrder(
        order: OrderEntity
    )
}