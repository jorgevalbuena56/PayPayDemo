package com.demo.paypayconverter.data.repository

import com.demo.paypayconverter.domain.model.Currency
import com.demo.paypayconverter.domain.model.Rate

interface ConverterRepository {
    suspend fun getCurrencies() : List<Currency>
    suspend fun getRates(base: String) : Rate
}