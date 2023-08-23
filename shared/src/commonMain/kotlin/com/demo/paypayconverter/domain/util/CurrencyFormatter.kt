package com.demo.paypayconverter.domain.util

interface CurrencyFormatter {
    fun formatCurrency(value: Double, currencyCode: String): String
}