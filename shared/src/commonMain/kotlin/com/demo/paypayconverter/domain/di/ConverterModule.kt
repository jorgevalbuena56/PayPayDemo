package com.demo.paypayconverter.domain.di

import com.demo.paypayconverter.data.remote.api.ConverterRemoteApi
import com.demo.paypayconverter.data.remote.ConverterRemoteRepositoryImpl
import com.demo.paypayconverter.data.local.ConverterLocalRepository
import com.demo.paypayconverter.data.local.ConverterLocalRepositoryImpl
import com.demo.paypayconverter.data.remote.ConverterRemoteRepository
import com.demo.paypayconverter.data.repository.ConverterRepository
import com.demo.paypayconverter.data.repository.ConverterRepositoryImpl
import com.demo.paypayconverter.domain.usecases.home.GetAvailableCurrencies
import com.demo.paypayconverter.domain.usecases.home.GetCurrentRates
import org.koin.core.module.dsl.singleOf
import org.koin.core.qualifier.qualifier
import org.koin.dsl.bind
import org.koin.dsl.module

val converterModule = module {
    single { ConverterRemoteApi(get(qualifier("PayPayConverterCoreURL")),
                                get(qualifier("ApiKey")),
                                get()) }

    singleOf(::ConverterRepositoryImpl) bind ConverterRepository::class
    singleOf(::ConverterRemoteRepositoryImpl) bind ConverterRemoteRepository::class
    singleOf(::ConverterLocalRepositoryImpl) bind ConverterLocalRepository::class
    singleOf(::GetAvailableCurrencies)
    singleOf(::GetCurrentRates)
}