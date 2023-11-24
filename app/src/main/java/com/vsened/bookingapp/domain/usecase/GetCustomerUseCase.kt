package com.vsened.bookingapp.domain.usecase

import com.vsened.bookingapp.domain.model.Customer
import com.vsened.bookingapp.domain.repository.Repository
import com.vsened.bookingapp.presentation.Resource
import javax.inject.Inject

class GetCustomerUseCase @Inject constructor(
    private val repository: Repository
) {
    suspend operator fun invoke(): Resource<Customer> {
        return repository.getCustomer()
    }
}