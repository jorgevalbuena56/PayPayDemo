package com.demo.paypayconverter

import com.demo.paypayconverter.presentation.home.HomeScreenNewViewModel
import io.ktor.client.engine.darwin.Darwin
import org.koin.core.component.KoinComponent
import org.koin.core.component.get
import org.koin.dsl.module
import platform.Foundation.NSLog
import platform.Foundation.NSTimeIntervalSince1970

actual fun getNowDate() = NSTimeIntervalSince1970.toLong()

const val TAG = "ZimiShared"

actual fun logError(message: String, error: Throwable?) {
    NSLog("\uD83D\uDD25 $TAG: $message")
}

actual fun logInfo(message: String) {
    NSLog("\uD83D\uDFE9 $TAG: $message")
}

actual fun logDebug(message: String) {
    NSLog("\uD83D\uDFE6 $TAG: $message")
}

actual fun logWarning(message: String) {
    NSLog("\uD83D\uDFE7 $TAG: $message")
}

actual fun platformModule() = module {
    single {
        Darwin.create()
    }
    single{
        HomeScreenNewViewModel(get(), IOSCurrencyFormatter())
    }
}

object ViewModels : KoinComponent {
    fun getHomeViewModel() = get<HomeScreenNewViewModel>()
}

actual interface CommonParcelable