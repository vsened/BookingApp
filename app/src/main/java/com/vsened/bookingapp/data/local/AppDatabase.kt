package com.vsened.bookingapp.data.local

import com.vsened.bookingapp.data.local.model.CustomerEntity
import com.vsened.bookingapp.data.local.model.HotelEntity
import com.vsened.bookingapp.data.local.model.OrderEntity
import com.vsened.bookingapp.data.local.model.RoomEntity
import com.vsened.bookingapp.data.local.model.TouristEntity
import com.vsened.bookingapp.data.mappers.toRoomDto
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

/**
 * Имитация работы базы данных
 */

class AppDatabase @Inject constructor() {
    private val customers = mutableListOf<CustomerEntity>()
    private val hotel = mutableListOf<HotelEntity>()
    private val orders = mutableListOf<OrderEntity>()
    private val rooms = mutableListOf<RoomEntity>()
    private val tourists = mutableListOf<TouristEntity>()

    suspend fun addHotel(hotelEntity: HotelEntity) {
        coroutineScope {
            hotel.add(hotelEntity)
        }
    }

    suspend fun getHotelById(id: Int): HotelEntity {
        id
        return coroutineScope {
            return@coroutineScope hotel.first()
        }
    }

    suspend fun addRooms(arr: List<RoomEntity>){
        coroutineScope {
            arr.forEach { rooms.add(it) }
        }
    }

    suspend fun getRooms(): Flow<List<RoomEntity>> = flow {
        emit(rooms)
    }

    suspend fun getRoomById(name: String): RoomEntity? {
        return coroutineScope {
            return@coroutineScope rooms.find {
                it.name == name
            }
        }
    }

    suspend fun addCustomer(customer: CustomerEntity) {
         coroutineScope {
             customers.add(customer)
         }
    }

    suspend fun getCustomer(): CustomerEntity? {
        return coroutineScope {
            return@coroutineScope customers.first()
        }
    }

    suspend fun addTourist(tourist: TouristEntity) {
        coroutineScope {
            tourists.add(tourist)
        }
    }

    suspend fun addOrder(order: OrderEntity) {
        coroutineScope {
            orders.add(order)
        }
    }

    suspend fun getTourists(): Flow<List<TouristEntity>> = flow {
        emit(tourists)
    }
}