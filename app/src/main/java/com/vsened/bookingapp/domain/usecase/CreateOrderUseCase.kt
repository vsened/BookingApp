package com.vsened.bookingapp.domain.usecase

import com.vsened.bookingapp.domain.model.Order
import com.vsened.bookingapp.domain.repository.Repository
import javax.inject.Inject

class CreateOrderUseCase @Inject constructor(
    private val repository: Repository
) {
    suspend operator fun invoke(order: Order) {
        repository.addOrder(order)
    }
}