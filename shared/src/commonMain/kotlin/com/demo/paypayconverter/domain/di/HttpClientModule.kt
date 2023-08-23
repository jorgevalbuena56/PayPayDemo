package com.demo.paypayconverter.domain.di

import com.demo.paypayconverter.domain.util.HttpLogger
import io.ktor.client.HttpClient
import io.ktor.client.plugins.DefaultRequest
import io.ktor.client.plugins.HttpTimeout
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logging
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import org.koin.core.module.Module
import org.koin.core.qualifier.named
import org.koin.dsl.module

fun getHttpClientModule(enableNetworkLogs: Boolean): Module {
    return module {
        single(named("PayPayConverterCoreURL")) {
            "https://openexchangerates.org/api/"
        }
        single(named("ApiKey")) {
            "49cbca1322144e14a0a0f4227113ee98"
        }
        single {
            createHttpClient(enableNetworkLogs = enableNetworkLogs)
        }
    }
}

fun createHttpClient(enableNetworkLogs: Boolean) = HttpClient {

    expectSuccess = true

    install(ContentNegotiation) {
        json(createJson())
    }
    install(HttpTimeout) {
        connectTimeoutMillis = 15000
    }
    install(DefaultRequest) {
        headers.append("Content-Type", "application/json")
    }

    if (enableNetworkLogs) {
        install(Logging) {
            logger = HttpLogger()
            level = LogLevel.ALL
        }
    }
}

fun createJson() = Json { isLenient = true; ignoreUnknownKeys = true; prettyPrint = true }