package com.demo.paypayconverter.data.remote.model

import com.demo.paypayconverter.domain.model.Rate
import kotlinx.serialization.Serializable

@Serializable
data class RateDTO(
   val timestamp: Long,
   val base: String,
   val rates: Map<String, Double>
)


fun RateDTO.toDomain() = Rate(base = base, values = rates)

