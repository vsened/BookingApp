package com.vsened.bookingapp.domain.usecase

import com.vsened.bookingapp.domain.model.Room
import com.vsened.bookingapp.domain.repository.Repository
import com.vsened.bookingapp.presentation.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetRoomsUseCase @Inject constructor(
    private val repository: Repository
) {
    suspend operator fun invoke(hotelId: Int): Flow<Resource<List<Room>>> {
        return repository.getRooms(hotelId)
    }
}