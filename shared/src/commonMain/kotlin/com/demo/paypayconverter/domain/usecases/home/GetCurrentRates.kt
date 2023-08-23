package com.demo.paypayconverter.domain.usecases.home

import com.demo.paypayconverter.data.repository.ConverterRepository
import kotlinx.coroutines.flow.flow

class GetCurrentRates(
    private val repository: ConverterRepository,
) {
    operator fun invoke(base: String) = flow {
        emit(repository.getRates(base))
    }
}