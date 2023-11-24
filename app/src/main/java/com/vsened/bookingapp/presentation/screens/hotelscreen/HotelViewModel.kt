package com.vsened.bookingapp.presentation.screens.hotelscreen

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vsened.bookingapp.domain.usecase.GetHotelByIdUseCase
import com.vsened.bookingapp.presentation.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HotelViewModel @Inject constructor(
    private val getHotelByIdUseCase: GetHotelByIdUseCase
): ViewModel() {
    var state by mutableStateOf(HotelState())

    init {
        getHotel()
    }

    fun getHotel() {
        viewModelScope.launch {
            state = state.copy(
                isLoading = true
            )
            when(val result = getHotelByIdUseCase(0)) {
                is Resource.Error -> {
                    Log.d(TAG, "getHotel: ${result.message}")
                    state = state.copy(
                        error = result.message.toString(),
                        isLoading = false
                    )
                }
                is Resource.Loading -> {

                }
                is Resource.Success -> {
                    state = state.copy(
                        hotel = result.data,
                        isLoading = false
                    )
                }
            }
        }
    }
    companion object{
        private const val TAG = "HotelViewModel"
    }

}