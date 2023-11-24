package com.vsened.bookingapp.domain.repository

import com.vsened.bookingapp.domain.model.Customer
import com.vsened.bookingapp.domain.model.Hotel
import com.vsened.bookingapp.domain.model.Order
import com.vsened.bookingapp.domain.model.Room
import com.vsened.bookingapp.domain.model.Tourist
import com.vsened.bookingapp.presentation.Resource
import kotlinx.coroutines.flow.Flow

interface Repository {
    suspend fun getHotelById(id: Int): Resource<Hotel>

    suspend fun getRooms(hotelId: Int): Flow<Resource<List<Room>>>

    suspend fun getRoomById(id: String): Resource<Room>

    suspend fun addCustomer(customer: Customer)

    suspend fun getCustomer(): Resource<Customer>

    suspend fun addTourist(tourist: Tourist)

    suspend fun getTourists(): Flow<Resource<List<Tourist>>>

    suspend fun addOrder(order: Order)
}