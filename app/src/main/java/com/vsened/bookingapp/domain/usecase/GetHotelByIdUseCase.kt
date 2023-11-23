package com.vsened.bookingapp.domain.usecase

import com.vsened.bookingapp.domain.model.Hotel
import com.vsened.bookingapp.domain.repository.Repository

class GetHotelByIdUseCase(
    private val repository: Repository
) {
    suspend operator fun invoke(id: Int): Hotel {
        return repository.getHotelById(id)
    }
}