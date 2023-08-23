package com.demo.paypayconverter.domain.di

import com.demo.paypayconverter.platformModule
import org.koin.core.context.startKoin
import org.koin.dsl.KoinAppDeclaration

fun initKoin(
    enableNetworkLogs: Boolean = false,
    appDeclaration: KoinAppDeclaration = {}
) =
    startKoin {
        appDeclaration()
        modules(
            getHttpClientModule(enableNetworkLogs = enableNetworkLogs),
            platformModule(),
            coroutineModule,
            realmModule,
            converterModule
        )
    }

// called by iOS etc
fun initKoin(enableNetworkLogs: Boolean = false) = initKoin(enableNetworkLogs = enableNetworkLogs) {}