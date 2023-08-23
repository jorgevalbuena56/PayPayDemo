package com.demo.paypayconverter.util

import com.demo.paypayconverter.data.TestConverterRepository
import com.demo.paypayconverter.data.repository.ConverterRepository
import kotlinx.coroutines.runBlocking
import kotlin.test.Test
import kotlin.test.assertTrue

class ConverterRepositoryTest {
    private val repository : ConverterRepository = TestConverterRepository()

    @Test
    fun testGetCurrencies() = runBlocking {
        val data = repository.getCurrencies()

        assertTrue(data.isNotEmpty(), "The currencies list is empty")
        assertTrue(data.size == 22, "The currencies list is missing some currencies")
        assertTrue(data[0].code == "AED", "The currency code does not match")
        assertTrue(data[0].name == "United Arab Emirates Dirham", "The currency name     does not match")
    }
}