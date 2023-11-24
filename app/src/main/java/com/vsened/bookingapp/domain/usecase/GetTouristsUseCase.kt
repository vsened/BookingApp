package com.vsened.bookingapp.domain.usecase

import com.vsened.bookingapp.domain.model.Tourist
import com.vsened.bookingapp.domain.repository.Repository
import com.vsened.bookingapp.presentation.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetTouristsUseCase @Inject constructor(
    private val repository: Repository
) {
    suspend operator fun invoke(): Flow<Resource<List<Tourist>>> {
        return repository.getTourists()
    }
}