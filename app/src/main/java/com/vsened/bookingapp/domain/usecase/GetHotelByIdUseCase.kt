package com.vsened.bookingapp.domain.usecase

import com.vsened.bookingapp.domain.model.Hotel
import com.vsened.bookingapp.domain.repository.Repository
import com.vsened.bookingapp.presentation.Resource
import javax.inject.Inject

class GetHotelByIdUseCase @Inject constructor(
    private val repository: Repository
) {
    suspend operator fun invoke(id: Int): Resource<Hotel> {
        return repository.getHotelById(id)
    }
}