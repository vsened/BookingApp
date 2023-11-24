package com.vsened.bookingapp.data.repository

import com.vsened.bookingapp.data.local.AppDatabase
import com.vsened.bookingapp.data.mappers.toCustomer
import com.vsened.bookingapp.data.mappers.toCustomerEntity
import com.vsened.bookingapp.data.mappers.toHotel
import com.vsened.bookingapp.data.mappers.toHotelEntity
import com.vsened.bookingapp.data.mappers.toOrderEntity
import com.vsened.bookingapp.data.mappers.toRoom
import com.vsened.bookingapp.data.mappers.toRoomEntity
import com.vsened.bookingapp.data.mappers.toTourist
import com.vsened.bookingapp.data.mappers.toTouristEntity
import com.vsened.bookingapp.data.remote.AppApi
import com.vsened.bookingapp.domain.model.Customer
import com.vsened.bookingapp.domain.model.Hotel
import com.vsened.bookingapp.domain.model.Order
import com.vsened.bookingapp.domain.model.Room
import com.vsened.bookingapp.domain.model.Tourist
import com.vsened.bookingapp.domain.repository.Repository
import com.vsened.bookingapp.presentation.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class RepositoryImpl @Inject constructor(
    private val appDatabase: AppDatabase,
    private val appApi: AppApi
): Repository {
    override suspend fun getHotelById(id: Int): Resource<Hotel> {
        val response = appApi.getHotelById(id)
        appDatabase.addHotel(response.toHotelEntity())
        val result = appDatabase.getHotelById(0)
        return Resource.Success(data = result.toHotel())
    }

    override suspend fun getRooms(hotelId: Int): Flow<Resource<List<Room>>> {
        return flow {
            emit(Resource.Loading())
            val response = appApi.getRooms()
            appDatabase.addRooms(response.map { it.toRoomEntity() })
            appDatabase.getRooms()
                .map { it.map { it.toRoom() } }
                .collect{
                    emit(Resource.Success(it))
                }
        }
    }

    override suspend fun getRoomById(id: String): Resource<Room> {
        val result = appDatabase.getRoomByName(id)
        return if (result != null) {
            Resource.Success(result.toRoom())
        } else {
            Resource.Error("not found")
        }
    }

    override suspend fun addCustomer(customer: Customer) {
        appDatabase.addCustomer(customer.toCustomerEntity())
    }

    override suspend fun getCustomer(): Resource<Customer> {
        val result = appDatabase.getCustomer()
        return if (result != null) {
            Resource.Success(result.toCustomer())
        } else {
            Resource.Error("not found")
        }
    }


    override suspend fun addTourist(tourist: Tourist) {
        appDatabase.addTourist(tourist.toTouristEntity())
    }

    override suspend fun getTourists(): Flow<Resource<List<Tourist>>> = flow {
        emit(Resource.Loading())
        appDatabase.getTourists()
            .map { it.map { it.toTourist() } }
            .collect{
                emit(Resource.Success(it))
            }
    }

    override suspend fun addOrder(order: Order) {
        appDatabase.addOrder(order.toOrderEntity())
    }
}