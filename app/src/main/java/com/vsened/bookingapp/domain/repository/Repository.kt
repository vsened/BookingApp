package com.vsened.bookingapp.domain.repository

import com.vsened.bookingapp.domain.data.Customer
import com.vsened.bookingapp.domain.data.Hotel
import com.vsened.bookingapp.domain.data.Order
import com.vsened.bookingapp.domain.data.Room
import com.vsened.bookingapp.domain.data.Tourist
import kotlinx.coroutines.flow.Flow

interface Repository {
    suspend fun getHotelById(id: Int): Hotel

    suspend fun getRooms(hotelId: Int): Flow<List<Room>>

    suspend fun getRoomById(id: Int): Room

    suspend fun addCustomer(customer: Customer)

    suspend fun addTourist(tourist: Tourist)

    suspend fun getTourists(): Flow<List<Tourist>>

    suspend fun addOrder(order: Order)
}