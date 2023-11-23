package com.vsened.bookingapp.data.remote

import com.vsened.bookingapp.data.remote.model.HotelDto
import com.vsened.bookingapp.data.remote.model.OrderDto
import com.vsened.bookingapp.data.remote.model.RoomDto
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay

/**
*   Имитация работы с API
**/
class HotelApi() {
    suspend fun getHotelById(hotelId: Int): HotelDto = coroutineScope {
            return@coroutineScope HotelDto(
                name = "",
                rating = "",
                address = "",
                minPrice = 0,
                tags = listOf(""),
                description = "",
                conveniences = "",
                include = "",
                notInclude = "",
                nutrition = "",
                fuelSurcharge = 0,
                serviceSurcharge = 0
            )

    }

    suspend fun getRooms(): List<RoomDto> = coroutineScope {
            return@coroutineScope listOf(
                RoomDto(
                    name = "",
                    tags = listOf(""),
                    description = "",
                    price = 0,
                    period = ""
                ),
                RoomDto(
                    name = "",
                    tags = listOf(""),
                    description = "",
                    price = 0,
                    period = ""
                ),
                RoomDto(
                    name = "",
                    tags = listOf(""),
                    description = "",
                    price = 0,
                    period = ""
                ),
                RoomDto(
                    name = "",
                    tags = listOf(""),
                    description = "",
                    price = 0,
                    period = ""
                ),
                RoomDto(
                    name = "",
                    tags = listOf(""),
                    description = "",
                    price = 0,
                    period = ""
                ),
                RoomDto(
                    name = "",
                    tags = listOf(""),
                    description = "",
                    price = 0,
                    period = ""
                ),
                RoomDto(
                    name = "",
                    tags = listOf(""),
                    description = "",
                    price = 0,
                    period = ""
                ),
                RoomDto(
                    name = "",
                    tags = listOf(""),
                    description = "",
                    price = 0,
                    period = ""
                ),
                RoomDto(
                    name = "",
                    tags = listOf(""),
                    description = "",
                    price = 0,
                    period = ""
                ),
                RoomDto(
                    name = "",
                    tags = listOf(""),
                    description = "",
                    price = 0,
                    period = ""
                )
            )
        }

    suspend fun addOrder(orderDto: OrderDto) = coroutineScope {
        delay(300)
    }

}