package com.demo.paypayconverter.domain.util

sealed class CurrencyConverterExceptions(val exception : Exception = Exception("Failure")) :
    Exception() {
    class GetCurrenciesException(exp: Exception) : CurrencyConverterExceptions(exp)
    class GetRatesException(exp: Exception) : CurrencyConverterExceptions(exp)
}