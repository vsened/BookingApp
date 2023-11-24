package com.vsened.bookingapp.presentation.screens.bookingscreen

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vsened.bookingapp.domain.model.Tourist
import com.vsened.bookingapp.domain.usecase.GetHotelByIdUseCase
import com.vsened.bookingapp.domain.usecase.GetRoomById
import com.vsened.bookingapp.presentation.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BookingViewModel @Inject constructor(
    private val getRoomById: GetRoomById,
    private val getHotelByIdUseCase: GetHotelByIdUseCase
): ViewModel() {
    var state by mutableStateOf(BookingState())

    init {
        getHotel()
    }

    fun getRoom(roomId: String) {
        Log.d("BookingViewModel", "Start getRoom: $roomId")
        viewModelScope.launch {
            state = state.copy(
                isLoading = true
            )
            when (val result = getRoomById(roomId)) {
                is Resource.Error -> {
                    state = state.copy(
                        error = result.message.toString(),
                        isLoading = false
                    )
                }
                is Resource.Loading -> {

                }
                is Resource.Success -> {
                    state = state.copy(
                        room = result.data,
                        shouldRefresh = true
                    )
                    Log.d("BookingViewModel", "Success getRoom: $result")
                }
            }
        }
    }

    private fun getHotel() {
        viewModelScope.launch {
            when (val result = getHotelByIdUseCase(0)) {
                is Resource.Error -> {
                    state = state.copy(
                        hotel = null
                    )
                }
                is Resource.Loading -> {

                }
                is Resource.Success -> {
                    result.data?.let {
                        state = state.copy(
                            hotel = result.data
                        )
                    }
                }
            }
        }
    }

    fun addTourist(newTourist: Tourist) {
        val oldTourists = state.tourists.toMutableList()
        oldTourists.add(newTourist)
        state = state.copy(
            tourists = oldTourists,
            shouldRefresh = true
        )
    }

}