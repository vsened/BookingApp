package com.vsened.bookingapp.presentation.screens.roomsscreen

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vsened.bookingapp.domain.usecase.GetHotelByIdUseCase
import com.vsened.bookingapp.domain.usecase.GetRoomsUseCase
import com.vsened.bookingapp.presentation.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RoomsViewModel @Inject constructor(
    private val getHotelByIdUseCase: GetHotelByIdUseCase,
    private val getRoomsUseCase: GetRoomsUseCase
): ViewModel() {
    var state by mutableStateOf(RoomsState())

    init {
        getRooms()
        getHotel()
    }
    fun getRooms() {
        viewModelScope.launch {
            getRoomsUseCase(0).collect { result ->
                state = state.copy(
                    isLoading = true
                )
                when(result) {
                    is Resource.Error -> {
                        state = state.copy(
                            error = result.message.toString(),
                            isLoading = false
                        )
                    }
                    is Resource.Loading -> {
                        state = state.copy(
                            isLoading = true
                        )
                    }
                    is Resource.Success -> {
                        Log.d("RoomsViewModel", "getRooms: ${result.data.toString()} ${System.currentTimeMillis()}")
                        result.data?.let {
                            state = state.copy(
                                rooms = it,
                                isLoading = false
                            )
                        }
                    }
                }
            }
        }
    }

    private fun getHotel() {
        viewModelScope.launch {
            when (val result = getHotelByIdUseCase(0)) {
                is Resource.Error -> {
                    state = state.copy(
                        hotelName = "Hotel"
                    )
                }
                is Resource.Loading -> {

                }
                is Resource.Success -> {
                    result.data?.let {
                        state = state.copy(
                            hotelName = result.data.name
                        )
                    }
                }
            }
        }
    }
}