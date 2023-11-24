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
                nutrition = "Всё включено",
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
                    id = "1",
                    name = "Стандартный с видом на бассейн или сад",
                    tags = listOf(
                        "Все включено",
                        "Кондиционер"
                    ),
                    description = "",
                    price = 186600,
                    period = "за 7 ночей с перелётом",
                    images = listOf(
                        R.drawable.room_01,
                        R.drawable.room_02,
                        R.drawable.room_03,
                        R.drawable.room_04,
                        R.drawable.room_05,
                    ),
                    startPoint = "Санкт-Петербург",
                    endPoint = "Египет, Хургада",
                    dates = "19.10.2023 - 26.10.2023"
                ),
                RoomDto(
                    id = "2",
                    name = "Улучшенный с видом на бассейн или сад",
                    tags = listOf(
                        "Все включено",
                        "Кондиционер"
                    ),
                    description = "",
                    price = 196600,
                    period = "за 6 ночей с перелётом",
                    images = listOf(
                        R.drawable.room_11,
                        R.drawable.room_12,
                        R.drawable.room_13,
                        R.drawable.room_14,
                        R.drawable.room_15,
                    ),
                    startPoint = "Москва",
                    endPoint = "Египет, Хургада",
                    dates = "19.10.2023 - 25.10.2023"
                ),
                RoomDto(
                    id = "3",
                    name = "Люкс с видом на бассейн или сад",
                    tags = listOf(
                        "Все включено",
                        "Кондиционер"
                    ),
                    description = "",
                    price = 206600,
                    period = "за 5 ночей с перелётом",
                    images = listOf(
                        R.drawable.room_21,
                        R.drawable.room_22,
                        R.drawable.room_23,
                        R.drawable.room_24,
                        R.drawable.room_25,
                    ),
                    startPoint = "Казань",
                    endPoint = "Египет, Хургада",
                    dates = "19.10.2023 - 24.10.2023"
                ),
                RoomDto(
                    id = "4",
                    name = "Стандартный с видом на сад",
                    tags = listOf(
                        "Все включено",
                        "Кондиционер"
                    ),
                    description = "",
                    price = 146600,
                    period = "за 8 ночей с перелётом",
                    images = listOf(
                        R.drawable.room_31,
                        R.drawable.room_32,
                        R.drawable.room_33,
                        R.drawable.room_34,
                        R.drawable.room_35,
                    ),
                    startPoint = "Екатеринбург",
                    endPoint = "Египет, Хургада",
                    dates = "19.10.2023 - 27.10.2023"
                ),
                RoomDto(
                    id = "5",
                    name = "Стандартный с видом на бассейн",
                    tags = listOf(
                        "Все включено",
                        "Кондиционер"
                    ),
                    description = "",
                    price = 174600,
                    period = "за 9 ночей с перелётом",
                    images = listOf(
                        R.drawable.room_41,
                        R.drawable.room_42,
                        R.drawable.room_43,
                        R.drawable.room_44,
                        R.drawable.room_45,
                    ),
                    startPoint = "Челябинск",
                    endPoint = "Египет, Хургада",
                    dates = "19.10.2023 - 28.10.2023"
                ),
                RoomDto(
                    id = "6",
                    name = "Уютный с видом на сад",
                    tags = listOf(
                        "Все включено",
                        "Кондиционер"
                    ),
                    description = "",
                    price = 196600,
                    period = "за 10 ночей с перелётом",
                    images = listOf(
                        R.drawable.room_1,
                        R.drawable.room_2,
                        R.drawable.room_3,
                        R.drawable.room_4,
                        R.drawable.room_0,
                    ),
                    startPoint = "Сочи",
                    endPoint = "Египет, Хургада",
                    dates = "19.10.2023 - 29.10.2023"
                )
            )
        }

    suspend fun addOrder(orderDto: OrderDto) = coroutineScope {
        orderDto.customer
        delay(300)
    }

}