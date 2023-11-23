package com.vsened.bookingapp.data.mappers

import com.vsened.bookingapp.data.local.model.HotelEntity
import com.vsened.bookingapp.data.remote.model.HotelDto
import com.vsened.bookingapp.data.remote.model.RoomDto


fun HotelDto.toHotelEntity(): HotelEntity {
    return HotelEntity(
        name = name,
        rating = rating,
        address = address,
        minPrice = minPrice,
        tags = tags,
        description = description,
        conveniences = conveniences,
        include = include,
        notInclude = notInclude,
        nutrition = nutrition,
        fuelSurcharge = fuelSurcharge,
        serviceSurcharge = serviceSurcharge
    )
}

fun RoomDto.toRoomEntity() = RoomDto(
    name = name,
    tags = tags,
    description = description,
    price = price,
    period = period,
)