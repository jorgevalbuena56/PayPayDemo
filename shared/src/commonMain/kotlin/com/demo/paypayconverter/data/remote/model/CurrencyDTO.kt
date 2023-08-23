package com.demo.paypayconverter.data.remote.model


import com.demo.paypayconverter.domain.model.Currency

data class CurrencyDTO(
   val data: Map<String, String>
)


fun CurrencyDTO.toDomain() : List<Currency> {
    return data.map {
        Currency(it.key, it.value)
    }
}

