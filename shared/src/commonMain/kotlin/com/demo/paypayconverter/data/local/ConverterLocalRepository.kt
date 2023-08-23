package com.demo.paypayconverter.data.local

import com.demo.paypayconverter.data.local.model.CurrencyDAO
import com.demo.paypayconverter.data.local.model.RateDAO

interface ConverterLocalRepository {
   suspend fun getCurrencies() : List<CurrencyDAO>
   suspend fun addCurrency(currency: CurrencyDAO)
   suspend fun getRates() : RateDAO?
   suspend fun refreshRate(rate: RateDAO)
}