package com.vsened.bookingapp.data.mappers

import com.vsened.bookingapp.data.local.model.CustomerEntity
import com.vsened.bookingapp.data.local.model.HotelEntity
import com.vsened.bookingapp.data.local.model.OrderEntity
import com.vsened.bookingapp.data.local.model.RoomEntity
import com.vsened.bookingapp.data.local.model.TouristEntity
import com.vsened.bookingapp.domain.model.Customer
import com.vsened.bookingapp.domain.model.Hotel
import com.vsened.bookingapp.domain.model.Order
import com.vsened.bookingapp.domain.model.Room
import com.vsened.bookingapp.domain.model.Tourist

fun CustomerEntity.toCustomer() = Customer(
    phoneNumber = phoneNumber,
    email = email
)
fun HotelEntity.toHotel() = Hotel(
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

fun RoomEntity.toRoom() = Room(
    id = id,
    name = name,
    tags = tags,
    description = description,
    price = price,
    period = period,
    images = images,
    startPoint = startPoint,
    endPoint = endPoint,
    dates = dates
)

fun OrderEntity.toOrder() = Order(
    customer = customer.toCustomer(),
    hotel = hotel.toHotel(),
    room = room.toRoom(),
    price = price,
    startPoint = startPoint,
    endPoint = endPoint,
    period = period,
    tourists = tourists.map { it.toTourist() }
)

fun TouristEntity.toTourist() = Tourist(
    name = name,
    surname = surname,
    dateOfBirth = dateOfBirth,
    citizenOf = citizenOf,
    passportId = passportId,
    passportValidityPeriod = passportValidityPeriod
)