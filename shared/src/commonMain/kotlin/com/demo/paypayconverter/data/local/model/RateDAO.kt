package com.demo.paypayconverter.data.local.model

import com.demo.paypayconverter.domain.model.Rate
import io.realm.kotlin.ext.realmListOf
import io.realm.kotlin.types.EmbeddedRealmObject
import io.realm.kotlin.types.RealmList
import io.realm.kotlin.types.RealmObject


class RateDAO : RealmObject {
    var base: String = ""
    var lastTime: Long = 0
    var rates: RealmList<LatestRates> = realmListOf()
}

class LatestRates : EmbeddedRealmObject {
    var code: String = ""
    var rate: Double = 0.0
}

fun RateDAO.toDomain() = Rate(base = base, values = rates.associate { it.code to it.rate })