package com.demo.paypayconverter.data.remote

import com.demo.paypayconverter.data.remote.model.CurrencyDTO
import com.demo.paypayconverter.data.remote.model.RateDTO

interface ConverterRemoteRepository {
   suspend fun getCurrencies() : CurrencyDTO
   suspend fun getRates(base: String): RateDTO
}