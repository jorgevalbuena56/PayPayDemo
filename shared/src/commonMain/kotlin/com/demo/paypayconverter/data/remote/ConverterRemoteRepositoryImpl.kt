package com.demo.paypayconverter.data.remote

import com.demo.paypayconverter.data.remote.api.ConverterRemoteApi
import com.demo.paypayconverter.data.remote.model.CurrencyDTO
import com.demo.paypayconverter.data.remote.model.RateDTO

class ConverterRemoteRepositoryImpl(
    private val converterRemoteApi: ConverterRemoteApi
) : ConverterRemoteRepository {

    override suspend fun getCurrencies(): CurrencyDTO {
        return CurrencyDTO(data = converterRemoteApi.getCurrencies())
    }

    override suspend fun getRates(base: String): RateDTO {
        return converterRemoteApi.getRates(base)
    }
}