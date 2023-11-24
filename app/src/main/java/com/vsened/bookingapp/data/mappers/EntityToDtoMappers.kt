package com.vsened.bookingapp.data.mappers

import com.vsened.bookingapp.data.local.model.CustomerEntity
import com.vsened.bookingapp.data.local.model.HotelEntity
import com.vsened.bookingapp.data.local.model.OrderEntity
import com.vsened.bookingapp.data.local.model.RoomEntity
import com.vsened.bookingapp.data.local.model.TouristEntity
import com.vsened.bookingapp.data.remote.model.CustomerDto
import com.vsened.bookingapp.data.remote.model.HotelDto
import com.vsened.bookingapp.data.remote.model.OrderDto
import com.vsened.bookingapp.data.remote.model.RoomDto
import com.vsened.bookingapp.data.remote.model.TouristDto

fun CustomerEntity.toCustomerDto() = CustomerDto(
    phoneNumber = phoneNumber,
    email = email
)
fun HotelEntity.toHotelDto() = HotelDto(
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
    serviceSurcharge = serviceSurcharge,
    images = images
)

fun RoomEntity.toRoomDto() = RoomDto(
    name = name,
    tags = tags,
    description = description,
    price = price,
    period = period,
    images = images
)

fun OrderEntity.toOrderDto() = OrderDto(
    customer = customer.toCustomerDto(),
    hotel = hotel.toHotelDto(),
    room = room.toRoomDto(),
    price = price,
    startPoint = startPoint,
    endPoint = endPoint,
    period = period,
    tourists = tourists.map { it.toTouristDto() }
)

fun TouristEntity.toTouristDto() = TouristDto(
    name = name,
    surname = surname,
    dateOfBirth = dateOfBirth,
    citizenOf = citizenOf,
    passportId = passportId,
    passportValidityPeriod = passportValidityPeriod
)