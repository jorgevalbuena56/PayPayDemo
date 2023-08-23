package com.demo.paypayconverter

import com.demo.paypayconverter.domain.util.CurrencyFormatter
import platform.Foundation.NSNumber
import platform.Foundation.NSNumberFormatter
import platform.Foundation.NSNumberFormatterCurrencyStyle

class IOSCurrencyFormatter : CurrencyFormatter {
    private val numberFormatter = NSNumberFormatter().apply {
        numberStyle = NSNumberFormatterCurrencyStyle
    }
    override fun formatCurrency(value: Double, currencyCode: String): String {
        numberFormatter.currencyCode = currencyCode
        numberFormatter.maximumFractionDigits = 2u
        numberFormatter.minimumFractionDigits = 2u
        return numberFormatter.stringFromNumber(NSNumber(value)) ?: ""
    }
}