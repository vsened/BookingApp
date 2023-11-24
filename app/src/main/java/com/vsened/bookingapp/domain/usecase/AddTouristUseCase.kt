package com.vsened.bookingapp.domain.usecase

import com.vsened.bookingapp.domain.model.Tourist
import com.vsened.bookingapp.domain.repository.Repository
import javax.inject.Inject

class AddTouristUseCase @Inject constructor(
    private val repository: Repository
) {
    suspend operator fun invoke(tourist: Tourist) {
        repository.addTourist(tourist)
    }
}