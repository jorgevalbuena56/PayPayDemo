package com.demo.paypayconverter

import android.os.Parcelable
import android.util.Log
import com.demo.paypayconverter.domain.util.CurrencyFormatter
import com.demo.paypayconverter.presentation.home.HomeScreenNewViewModel
import io.ktor.client.engine.android.*
import kotlinx.parcelize.Parcelize
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module
import java.util.*

actual typealias CommonParcelize = Parcelize

actual typealias CommonParcelable = Parcelable

actual fun getNowDate() = Date().time

const val TAG = "ConverterShared"

actual fun logError(message: String, error: Throwable?) {
    Log.e(TAG, message, error)
}

actual fun logInfo(message: String) {
    Log.i(TAG, message)
}

actual fun logDebug(message: String) {
    Log.d(TAG, message)
}

actual fun logWarning(message: String) {
    Log.w(TAG, message)
}


actual fun platformModule() = module {
    single {
        Android.create()
    }

    singleOf(::AndroidCurrencyConverterImpl) bind CurrencyFormatter::class

    viewModel {
        HomeScreenNewViewModel(get(), get())
    }
}