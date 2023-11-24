package com.vsened.bookingapp.domain.usecase

import com.vsened.bookingapp.domain.model.Customer
import com.vsened.bookingapp.domain.repository.Repository
import javax.inject.Inject

class AddCustomerUseCase @Inject constructor(
    private val repository: Repository
) {
    suspend operator fun invoke(customer: Customer) {
        repository.addCustomer(customer)
    }
}