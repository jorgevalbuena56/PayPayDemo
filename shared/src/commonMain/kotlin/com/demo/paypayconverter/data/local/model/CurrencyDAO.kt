package com.demo.paypayconverter.data.local.model

import com.demo.paypayconverter.domain.model.Currency
import io.realm.kotlin.types.RealmObject
import io.realm.kotlin.types.annotations.PrimaryKey
import org.mongodb.kbson.ObjectId

open class CurrencyDAO : RealmObject {
    @PrimaryKey
    var _id: ObjectId = ObjectId()
    var code: String = ""
    var name: String = ""
}

fun CurrencyDAO.toDomain()  = Currency(code, name)
fun List<CurrencyDAO>.toDomain() = map {
    it.toDomain()
}