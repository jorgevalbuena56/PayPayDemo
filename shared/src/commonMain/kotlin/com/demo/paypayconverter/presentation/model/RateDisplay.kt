package com.demo.paypayconverter.presentation.model

data class RateDisplay(
    val code: String,
    val rate: Double,
    val amount: String = ""
)