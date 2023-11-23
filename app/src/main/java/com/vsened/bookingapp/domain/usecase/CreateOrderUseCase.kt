package com.vsened.bookingapp.domain.usecase

import com.vsened.bookingapp.domain.model.Order
import com.vsened.bookingapp.domain.repository.Repository

class CreateOrderUseCase(
    private val repository: Repository
) {
    suspend operator fun invoke(order: Order) {
        repository.addOrder(order)
    }
}