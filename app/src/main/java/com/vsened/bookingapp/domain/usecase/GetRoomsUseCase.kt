package com.vsened.bookingapp.domain.usecase

import com.vsened.bookingapp.domain.model.Room
import com.vsened.bookingapp.domain.repository.Repository
import kotlinx.coroutines.flow.Flow

class GetRoomsUseCase(
    private val repository: Repository
) {
    suspend operator fun invoke(hotelId: Int): Flow<List<Room>> {
        return repository.getRooms(hotelId)
    }
}