package com.vsened.bookingapp.domain.usecase

import com.vsened.bookingapp.domain.model.Tourist
import com.vsened.bookingapp.domain.repository.Repository

class AddTouristUseCase(
    private val repository: Repository
) {
    suspend operator fun invoke(tourist: Tourist) {
        repository.addTourist(tourist)
    }
}