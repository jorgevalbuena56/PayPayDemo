package com.demo.paypayconverter.data

import com.demo.paypayconverter.data.repository.ConverterRepository
import com.demo.paypayconverter.domain.model.Currency
import com.demo.paypayconverter.domain.model.Rate

class TestConverterRepository : ConverterRepository {
    override suspend fun getCurrencies(): List<Currency> {
        return listOf(
            Currency("AED", "United Arab Emirates Dirham"),
            Currency("AFN", "Afghan Afghani"),
            Currency("ALL", "Albanian Lek"),
            Currency("AMD", "Armenian Dram"),
            Currency("ANG", "Netherlands Antillean Guilder"),
            Currency("AOA", "Angolan Kwanza"),
            Currency("ARS", "Argentine Peso"),
            Currency("AUD", "Australian Dollar"),
            Currency("AWG", "Aruban Florin"),
            Currency("AZN", "Azerbaijani Manat"),
            Currency("BAM", "Bosnia-Herzegovina Convertible Mark"),
            Currency("BBD", "Barbadian Dollar"),
            Currency("BDT", "Bangladeshi Taka"),
            Currency("BGN", "Bulgarian Lev"),
            Currency("BHD", "Bahraini Dinar"),
            Currency("BIF", "Burundian Franc"),
            Currency("BMD", "Bermudan Dollar"),
            Currency("BND", "Brunei Dollar"),
            Currency("BOB", "Bolivian Boliviano"),
            Currency("BRL", "Brazilian Real"),
            Currency("BSD", "Bahamian Dollar"),
            Currency("BTC", "Bitcoin")
        )
    }

    override suspend fun getRates(base: String): Rate {
        return Rate(
             base = base,
             values = mapOf("AED" to 3.673,
                            "AFN" to 86.655981,
                            "ALL" to 92.0,
                            "AMD" to 394.892978,
                            "ANG" to 1.802742,
                            "AOA" to 825.290067,
                            "ARS" to 272.9902,
                            "AUD" to 1.503375,
                            "AWG" to 1.8025,
                            "AZN" to 1.7,
                            "BAM" to 1.756609,
                            "BBD" to 2.0,
                            "BDT" to 108.55087,
                            "BGN" to 1.783089,
                            "BHD" to 0.377001,
                            "BIF" to 2830.176048,
                            "BMD" to 1.0,
                            "BND" to 1.324047,
                            "BOB" to 6.916496,
                            "BRL" to 4.7432,
                            "BSD" to 1.0,
                            "BTC" to 0.000034183996)
        )
    }
}