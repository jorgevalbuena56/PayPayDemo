package com.demo.paypayconverter.data.local

import com.demo.paypayconverter.data.local.model.CurrencyDAO
import com.demo.paypayconverter.data.local.model.RateDAO
import io.realm.kotlin.Realm
import io.realm.kotlin.UpdatePolicy
import io.realm.kotlin.ext.query

class ConverterLocalRepositoryImpl(
    private val realm: Realm
) : ConverterLocalRepository {

    override suspend fun getCurrencies(): List<CurrencyDAO> {
        return realm.query<CurrencyDAO>().find()
    }

    override suspend fun addCurrency(currency: CurrencyDAO) {
        realm.query<CurrencyDAO>("code = $0", currency.code).find().ifEmpty {
            realm.writeBlocking { this.copyToRealm(currency) }
        }
    }

    override suspend fun getRates(): RateDAO? {
        return realm.query<RateDAO>().find().firstOrNull()
    }

    override suspend fun refreshRate(rate: RateDAO) {
        realm.writeBlocking {
            this.copyToRealm(rate, updatePolicy = UpdatePolicy.ALL)
        }
    }
}