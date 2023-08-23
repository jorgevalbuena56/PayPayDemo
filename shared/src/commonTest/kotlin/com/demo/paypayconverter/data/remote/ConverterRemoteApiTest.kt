package com.demo.paypayconverter.data.remote


import com.demo.paypayconverter.util.configureTestRouting
import io.ktor.client.request.get
import io.ktor.client.statement.bodyAsText
import io.ktor.http.HttpStatusCode
import io.ktor.server.testing.testApplication
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class ConverterRemoteApiTest {

    @Test
    fun testGetCurrenciesEndpoint() {
        testApplication {
            configureTestRouting()
            val response = client.get("/currencies.json")
            assertEquals(HttpStatusCode.OK, response.status)
            assertTrue(response.bodyAsText().contains("BTC"), "The response does not contains the BTC code")
        }
    }

    @Test
    fun testGetCRatesEndpoint() {
        testApplication {
            configureTestRouting()
            val response = client.get("/latest.json")
            assertEquals(HttpStatusCode.OK, response.status)
            assertTrue(response.bodyAsText().contains("BTC"), "The response does not contains the BTC code")
        }
    }
}