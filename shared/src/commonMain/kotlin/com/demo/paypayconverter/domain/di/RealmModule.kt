package com.demo.paypayconverter.domain.di

import com.demo.paypayconverter.data.local.model.CurrencyDAO
import com.demo.paypayconverter.data.local.model.LatestRates
import com.demo.paypayconverter.data.local.model.RateDAO
import io.realm.kotlin.Realm
import io.realm.kotlin.RealmConfiguration
import org.koin.dsl.module

val realmModule = module {
    single {
        Realm.open(
            RealmConfiguration.Builder(schema = setOf(CurrencyDAO::class, RateDAO::class, LatestRates::class)).build()
        )
    }
}