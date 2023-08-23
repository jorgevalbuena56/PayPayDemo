package com.demo.paypayconverter.data.repository

import com.demo.paypayconverter.data.local.ConverterLocalRepository
import com.demo.paypayconverter.data.local.model.toDomain
import com.demo.paypayconverter.data.remote.ConverterRemoteRepository
import com.demo.paypayconverter.data.remote.model.toDomain
import com.demo.paypayconverter.domain.model.Currency
import com.demo.paypayconverter.domain.model.Rate
import com.demo.paypayconverter.domain.model.toDAO
import com.demo.paypayconverter.domain.model.toDao
import com.demo.paypayconverter.domain.util.CurrencyConverterExceptions
import com.demo.paypayconverter.getNowDate
import com.demo.paypayconverter.logDebug

class ConverterRepositoryImpl(
    private val localRepository: ConverterLocalRepository,
    private val remoteRepository: ConverterRemoteRepository
) : ConverterRepository {

    override suspend fun getCurrencies(): List<Currency> {
        val currencies = try {
            var currencyList = localRepository.getCurrencies().toDomain()

            if (currencyList.isEmpty()) {
                //get the list from server
                currencyList = remoteRepository.getCurrencies().toDomain()
                currencyList.forEach { currency ->
                    localRepository.addCurrency(currency.toDAO())
                }
            }
            currencyList
        } catch (e: Exception) {
            localRepository.getCurrencies().toDomain()
        }

        return currencies.ifEmpty {
            throw CurrencyConverterExceptions.GetCurrenciesException(Exception("Error obtaining Currency List"))
        }
    }

    override suspend fun getRates(base: String) : Rate {
        val rates = try {
            val rates = remoteRepository.getRates("").toDomain()
            logDebug("Refreshing Remote Rates = $rates")
            localRepository.refreshRate(rates.toDao(getNowDate()))
            rates
        } catch (e: Exception) {
            localRepository.getRates()?.toDomain()
        }

        return rates?.copy(values = rates.values.filterKeys {
            it != base
        }) ?: throw CurrencyConverterExceptions.GetRatesException(Exception("Error loading Rates"))
    }
}