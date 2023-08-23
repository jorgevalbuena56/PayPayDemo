package com.demo.paypayconverter.android

import android.app.Application
import com.demo.paypayconverter.domain.di.initKoin
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

class PayPayConverterApp : Application() {

    override fun onCreate() {
        super.onCreate()

        initKoin(enableNetworkLogs = BuildConfig.DEBUG, appDeclaration = {
            androidContext(this@PayPayConverterApp)
            modules(
                listOf(module {
                    /**
                     * android specific modules
                     */
                })
            )
        })
    }
}