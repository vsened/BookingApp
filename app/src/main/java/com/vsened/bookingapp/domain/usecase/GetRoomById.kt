package com.vsened.bookingapp.domain.usecase

import com.vsened.bookingapp.domain.model.Room
import com.vsened.bookingapp.domain.repository.Repository

class GetRoomById(
    private val repository: Repository
) {
    suspend operator fun invoke(roomId: Int): Room {
        return repository.getRoomById(roomId)
    }
}