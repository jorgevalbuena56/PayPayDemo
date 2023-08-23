package com.demo.paypayconverter

import org.koin.core.module.Module

expect fun platformModule(): Module

expect fun getNowDate() : Long
expect fun logError(message: String, error: Throwable? = null)
expect fun logInfo(message: String)
expect fun logDebug(message: String)
expect fun logWarning(message: String)

/**
 *
 * Common parcelable implementation for android
 */

@OptIn(ExperimentalMultiplatform::class)
@OptionalExpectation
@Target(AnnotationTarget.CLASS)
@Retention(AnnotationRetention.BINARY)
expect annotation class CommonParcelize()

expect interface CommonParcelable

