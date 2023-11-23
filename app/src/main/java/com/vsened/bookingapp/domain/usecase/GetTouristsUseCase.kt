package com.vsened.bookingapp.domain.usecase

import com.vsened.bookingapp.domain.model.Tourist
import com.vsened.bookingapp.domain.repository.Repository
import kotlinx.coroutines.flow.Flow

class GetTouristsUseCase (
    private val repository: Repository
) {
    suspend operator fun invoke(): Flow<List<Tourist>> {
        return repository.getTourists()
    }
}