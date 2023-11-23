package com.vsened.bookingapp.domain.usecase

import com.vsened.bookingapp.domain.data.Customer
import com.vsened.bookingapp.domain.repository.Repository

class AddCustomerUseCase(
    private val repository: Repository
) {
    suspend operator fun invoke(customer: Customer) {
        repository.addCustomer(customer)
    }
}