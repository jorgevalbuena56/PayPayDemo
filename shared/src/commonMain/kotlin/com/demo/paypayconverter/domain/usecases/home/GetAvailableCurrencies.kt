package com.demo.paypayconverter.domain.usecases.home

import com.demo.paypayconverter.data.repository.ConverterRepository
import kotlinx.coroutines.flow.flow

class GetAvailableCurrencies(
    private val repository: ConverterRepository,
) {
    operator fun invoke() = flow {
        emit(repository.getCurrencies())
    }
}