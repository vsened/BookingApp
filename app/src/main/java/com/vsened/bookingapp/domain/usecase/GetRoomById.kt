package com.vsened.bookingapp.domain.usecase

import com.vsened.bookingapp.domain.model.Room
import com.vsened.bookingapp.domain.repository.Repository
import com.vsened.bookingapp.presentation.Resource
import javax.inject.Inject

class GetRoomById @Inject constructor(
    private val repository: Repository
) {
    suspend operator fun invoke(name: String): Resource<Room> {
        return repository.getRoomById(name)
    }
}