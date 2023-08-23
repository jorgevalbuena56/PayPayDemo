package com.demo.paypayconverter.domain.model

import com.demo.paypayconverter.data.local.model.CurrencyDAO

data class Currency(
    val code: String,
    val name: String
)

fun Currency.toDAO() : CurrencyDAO {
    return CurrencyDAO().also {
        it.code = this.code
        it.name = this.name
    }
}

fun List<Currency>.toDao() = map {
    it.toDAO()
}