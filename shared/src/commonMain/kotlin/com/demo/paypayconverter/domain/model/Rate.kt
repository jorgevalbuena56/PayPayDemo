package com.demo.paypayconverter.domain.model

import com.demo.paypayconverter.data.local.model.LatestRates
import com.demo.paypayconverter.data.local.model.RateDAO
import io.realm.kotlin.ext.toRealmList

data class Rate(
    val base: String,
    val values: Map<String, Double>,
)

fun Rate.toDao(time: Long) = RateDAO().also {
    it.base = base
    it.lastTime = time
    it.rates = this.values.map { rt ->
        LatestRates().apply {
            code = rt.key
            rate = rt.value
        }
    }.toRealmList()
}