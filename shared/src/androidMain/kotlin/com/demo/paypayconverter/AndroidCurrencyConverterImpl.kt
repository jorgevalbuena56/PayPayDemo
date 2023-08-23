package com.demo.paypayconverter

import com.demo.paypayconverter.domain.util.CurrencyFormatter
import java.text.NumberFormat
import java.util.Currency
import java.util.Locale

class AndroidCurrencyConverterImpl : CurrencyFormatter {
    private val locale = Locale.getDefault()

    override fun formatCurrency(value: Double, currencyCode: String): String {
        val formatter = NumberFormat.getCurrencyInstance(locale)
        formatter.currency = Currency.getInstance(currencyCode)
        formatter.maximumFractionDigits = 2
        formatter.minimumFractionDigits = 2
        return formatter.format(value)
    }
}
