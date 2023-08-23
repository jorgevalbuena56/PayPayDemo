package com.demo.paypayconverter.data.remote.api

import com.demo.paypayconverter.data.remote.model.RateDTO
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.HttpRequestBuilder
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import io.ktor.client.request.url

class ConverterRemoteApi(
    private val baseUrl: String,
    private val apiKey: String,
    private val httpClient: HttpClient
) {
    suspend fun getCurrencies() : Map<String, String> {
        return get("/currencies.json") { }
    }

    suspend fun getRates(base: String) : RateDTO {
        return get("/latest.json") {
            if (base.isNotEmpty()) {
                url { parameters.append("base", base) }
            }
        }
    }

    private suspend inline fun <reified T> get(
        url: String,
        crossinline builder: HttpRequestBuilder.() -> Unit,
    ): T = api {
        httpClient.get("$baseUrl/$url") {
            builder()
            url { parameters.append("app_id", apiKey) }
        }.body()
    }


    suspend fun <T> api(call: suspend () -> T): T = try {
        call()
    } catch (e: Exception) {
        throw e
    }
}