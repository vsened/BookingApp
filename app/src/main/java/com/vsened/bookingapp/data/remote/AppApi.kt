package com.vsened.bookingapp.data.remote

import com.vsened.bookingapp.R
import com.vsened.bookingapp.data.remote.model.HotelDto
import com.vsened.bookingapp.data.remote.model.OrderDto
import com.vsened.bookingapp.data.remote.model.RoomDto
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import javax.inject.Inject

/**
*   Имитация работы с API
**/

class AppApi @Inject constructor(

) {
    suspend fun getHotelById(hotelId: Int): HotelDto = coroutineScope {
        hotelId
            return@coroutineScope HotelDto(
                name = "Steigenberger Makadi",
                rating = "5 Превосходно",
                address = "Madinat Makadi, Safaga Road, Makadi Bay, Египет",
                minPrice = 134637,
                tags = listOf(
                    "3-я линия",
                    "Платный Wi-Fi в фойе",
                    "30 км от аэропорта",
                    "1 км от пляжа"
                ),
                description = "Отель VIP-класса с собственными гольф полями. Высокий уровнь " +
                        "сервиса. Рекомендуем для респектабельного отдыха. Отель принимает " +
                        "гостей от 18 лет!",
                conveniences = "Самое необходимое",
                include = "Самое необходимое",
                notInclude = "Самое необходимое",
                nutrition = "",
                fuelSurcharge = 9300,
                serviceSurcharge = 2136,
                images = listOf(
                    R.drawable.hotel_0,
                    R.drawable.hotel_1,
                    R.drawable.hotel_2,
                    R.drawable.hotel_3,
                    R.drawable.hotel_4,
                )
            )
    }

    suspend fun getRooms(): List<RoomDto> = coroutineScope {
            return@coroutineScope listOf(
                RoomDto(
                    name = "",
                    tags = listOf(""),
                    description = "",
                    price = 0,
                    period = "",
                    images = listOf(0)
                ),
                RoomDto(
                    name = "",
                    tags = listOf(""),
                    description = "",
                    price = 0,
                    period = "",
                    images = listOf(0)
                ),
                RoomDto(
                    name = "",
                    tags = listOf(""),
                    description = "",
                    price = 0,
                    period = "",
                    images = listOf(0)
                ),
                RoomDto(
                    name = "",
                    tags = listOf(""),
                    description = "",
                    price = 0,
                    period = "",
                    images = listOf(0)
                ),
                RoomDto(
                    name = "",
                    tags = listOf(""),
                    description = "",
                    price = 0,
                    period = "",
                    images = listOf(0)
                ),
                RoomDto(
                    name = "",
                    tags = listOf(""),
                    description = "",
                    price = 0,
                    period = "",
                    images = listOf(0)
                ),
                RoomDto(
                    name = "",
                    tags = listOf(""),
                    description = "",
                    price = 0,
                    period = "",
                    images = listOf(0)
                ),
                RoomDto(
                    name = "",
                    tags = listOf(""),
                    description = "",
                    price = 0,
                    period = "",
                    images = listOf(0)
                ),
                RoomDto(
                    name = "",
                    tags = listOf(""),
                    description = "",
                    price = 0,
                    period = "",
                    images = listOf(0)
                ),
                RoomDto(
                    name = "",
                    tags = listOf(""),
                    description = "",
                    price = 0,
                    period = "",
                    images = listOf(0)
                )
            )
        }

    suspend fun addOrder(orderDto: OrderDto) = coroutineScope {
        orderDto.customer
        delay(300)
    }

}