package com.demo.paypayconverter.util

import io.ktor.server.application.call
import io.ktor.server.response.respondText
import io.ktor.server.routing.get
import io.ktor.server.testing.ApplicationTestBuilder

fun ApplicationTestBuilder.configureTestRouting() {
    routing {
        get("/currencies.json") {
            call.respondText("{\n" +
                    "  \"AED\": \"United Arab Emirates Dirham\",\n" +
                    "  \"AFN\": \"Afghan Afghani\",\n" +
                    "  \"ALL\": \"Albanian Lek\",\n" +
                    "  \"AMD\": \"Armenian Dram\",\n" +
                    "  \"ANG\": \"Netherlands Antillean Guilder\",\n" +
                    "  \"AOA\": \"Angolan Kwanza\",\n" +
                    "  \"ARS\": \"Argentine Peso\",\n" +
                    "  \"AUD\": \"Australian Dollar\",\n" +
                    "  \"AWG\": \"Aruban Florin\",\n" +
                    "  \"AZN\": \"Azerbaijani Manat\",\n" +
                    "  \"BAM\": \"Bosnia-Herzegovina Convertible Mark\",\n" +
                    "  \"BBD\": \"Barbadian Dollar\",\n" +
                    "  \"BDT\": \"Bangladeshi Taka\",\n" +
                    "  \"BGN\": \"Bulgarian Lev\",\n" +
                    "  \"BHD\": \"Bahraini Dinar\",\n" +
                    "  \"BIF\": \"Burundian Franc\",\n" +
                    "  \"BMD\": \"Bermudan Dollar\",\n" +
                    "  \"BND\": \"Brunei Dollar\",\n" +
                    "  \"BOB\": \"Bolivian Boliviano\",\n" +
                    "  \"BRL\": \"Brazilian Real\",\n" +
                    "  \"BSD\": \"Bahamian Dollar\",\n" +
                    "  \"BTC\": \"Bitcoin\",\n" +
                    "  \"BTN\": \"Bhutanese Ngultrum\",\n" +
                    "  \"BWP\": \"Botswanan Pula\",\n" +
                    "  \"BYN\": \"Belarusian Ruble\",\n" +
                    "  \"BZD\": \"Belize Dollar\",\n" +
                    "  \"CAD\": \"Canadian Dollar\",\n" +
                    "  \"CDF\": \"Congolese Franc\",\n" +
                    "  \"CHF\": \"Swiss Franc\",\n" +
                    "  \"CLF\": \"Chilean Unit of Account (UF)\",\n" +
                    "  \"CLP\": \"Chilean Peso\",\n" +
                    "  \"CNH\": \"Chinese Yuan (Offshore)\",\n" +
                    "  \"CNY\": \"Chinese Yuan\",\n" +
                    "  \"COP\": \"Colombian Peso\",\n" +
                    "  \"CRC\": \"Costa Rican Colón\",\n" +
                    "  \"CUC\": \"Cuban Convertible Peso\",\n" +
                    "  \"CUP\": \"Cuban Peso\",\n" +
                    "  \"CVE\": \"Cape Verdean Escudo\",\n" +
                    "  \"CZK\": \"Czech Republic Koruna\",\n" +
                    "  \"DJF\": \"Djiboutian Franc\",\n" +
                    "  \"DKK\": \"Danish Krone\",\n" +
                    "  \"DOP\": \"Dominican Peso\",\n" +
                    "  \"DZD\": \"Algerian Dinar\",\n" +
                    "  \"EGP\": \"Egyptian Pound\",\n" +
                    "  \"ERN\": \"Eritrean Nakfa\",\n" +
                    "  \"ETB\": \"Ethiopian Birr\",\n" +
                    "  \"EUR\": \"Euro\",\n" +
                    "  \"FJD\": \"Fijian Dollar\",\n" +
                    "  \"FKP\": \"Falkland Islands Pound\",\n" +
                    "  \"GBP\": \"British Pound Sterling\",\n" +
                    "  \"GEL\": \"Georgian Lari\",\n" +
                    "  \"GGP\": \"Guernsey Pound\",\n" +
                    "  \"GHS\": \"Ghanaian Cedi\",\n" +
                    "  \"GIP\": \"Gibraltar Pound\",\n" +
                    "  \"GMD\": \"Gambian Dalasi\",\n" +
                    "  \"GNF\": \"Guinean Franc\",\n" +
                    "  \"GTQ\": \"Guatemalan Quetzal\",\n" +
                    "  \"GYD\": \"Guyanaese Dollar\",\n" +
                    "  \"HKD\": \"Hong Kong Dollar\",\n" +
                    "  \"HNL\": \"Honduran Lempira\",\n" +
                    "  \"HRK\": \"Croatian Kuna\",\n" +
                    "  \"HTG\": \"Haitian Gourde\",\n" +
                    "  \"HUF\": \"Hungarian Forint\",\n" +
                    "  \"IDR\": \"Indonesian Rupiah\",\n" +
                    "  \"ILS\": \"Israeli New Sheqel\",\n" +
                    "  \"IMP\": \"Manx pound\",\n" +
                    "  \"INR\": \"Indian Rupee\",\n" +
                    "  \"IQD\": \"Iraqi Dinar\",\n" +
                    "  \"IRR\": \"Iranian Rial\",\n" +
                    "  \"ISK\": \"Icelandic Króna\",\n" +
                    "  \"JEP\": \"Jersey Pound\",\n" +
                    "  \"JMD\": \"Jamaican Dollar\",\n" +
                    "  \"JOD\": \"Jordanian Dinar\",\n" +
                    "  \"JPY\": \"Japanese Yen\",\n" +
                    "  \"KES\": \"Kenyan Shilling\",\n" +
                    "  \"KGS\": \"Kyrgystani Som\",\n" +
                    "  \"KHR\": \"Cambodian Riel\",\n" +
                    "  \"KMF\": \"Comorian Franc\",\n" +
                    "  \"KPW\": \"North Korean Won\",\n" +
                    "  \"KRW\": \"South Korean Won\",\n" +
                    "  \"KWD\": \"Kuwaiti Dinar\",\n" +
                    "  \"KYD\": \"Cayman Islands Dollar\",\n" +
                    "  \"KZT\": \"Kazakhstani Tenge\",\n" +
                    "  \"LAK\": \"Laotian Kip\",\n" +
                    "  \"LBP\": \"Lebanese Pound\",\n" +
                    "  \"LKR\": \"Sri Lankan Rupee\",\n" +
                    "  \"LRD\": \"Liberian Dollar\",\n" +
                    "  \"LSL\": \"Lesotho Loti\",\n" +
                    "  \"LYD\": \"Libyan Dinar\",\n" +
                    "  \"MAD\": \"Moroccan Dirham\",\n" +
                    "  \"MDL\": \"Moldovan Leu\",\n" +
                    "  \"MGA\": \"Malagasy Ariary\",\n" +
                    "  \"MKD\": \"Macedonian Denar\",\n" +
                    "  \"MMK\": \"Myanma Kyat\",\n" +
                    "  \"MNT\": \"Mongolian Tugrik\",\n" +
                    "  \"MOP\": \"Macanese Pataca\",\n" +
                    "  \"MRU\": \"Mauritanian Ouguiya\",\n" +
                    "  \"MUR\": \"Mauritian Rupee\",\n" +
                    "  \"MVR\": \"Maldivian Rufiyaa\",\n" +
                    "  \"MWK\": \"Malawian Kwacha\",\n" +
                    "  \"MXN\": \"Mexican Peso\",\n" +
                    "  \"MYR\": \"Malaysian Ringgit\",\n" +
                    "  \"MZN\": \"Mozambican Metical\",\n" +
                    "  \"NAD\": \"Namibian Dollar\",\n" +
                    "  \"NGN\": \"Nigerian Naira\",\n" +
                    "  \"NIO\": \"Nicaraguan Córdoba\",\n" +
                    "  \"NOK\": \"Norwegian Krone\",\n" +
                    "  \"NPR\": \"Nepalese Rupee\",\n" +
                    "  \"NZD\": \"New Zealand Dollar\",\n" +
                    "  \"OMR\": \"Omani Rial\",\n" +
                    "  \"PAB\": \"Panamanian Balboa\",\n" +
                    "  \"PEN\": \"Peruvian Nuevo Sol\",\n" +
                    "  \"PGK\": \"Papua New Guinean Kina\",\n" +
                    "  \"PHP\": \"Philippine Peso\",\n" +
                    "  \"PKR\": \"Pakistani Rupee\",\n" +
                    "  \"PLN\": \"Polish Zloty\",\n" +
                    "  \"PYG\": \"Paraguayan Guarani\",\n" +
                    "  \"QAR\": \"Qatari Rial\",\n" +
                    "  \"RON\": \"Romanian Leu\",\n" +
                    "  \"RSD\": \"Serbian Dinar\",\n" +
                    "  \"RUB\": \"Russian Ruble\",\n" +
                    "  \"RWF\": \"Rwandan Franc\",\n" +
                    "  \"SAR\": \"Saudi Riyal\",\n" +
                    "  \"SBD\": \"Solomon Islands Dollar\",\n" +
                    "  \"SCR\": \"Seychellois Rupee\",\n" +
                    "  \"SDG\": \"Sudanese Pound\",\n" +
                    "  \"SEK\": \"Swedish Krona\",\n" +
                    "  \"SGD\": \"Singapore Dollar\",\n" +
                    "  \"SHP\": \"Saint Helena Pound\",\n" +
                    "  \"SLL\": \"Sierra Leonean Leone\",\n" +
                    "  \"SOS\": \"Somali Shilling\",\n" +
                    "  \"SRD\": \"Surinamese Dollar\",\n" +
                    "  \"SSP\": \"South Sudanese Pound\",\n" +
                    "  \"STD\": \"São Tomé and Príncipe Dobra (pre-2018)\",\n" +
                    "  \"STN\": \"São Tomé and Príncipe Dobra\",\n" +
                    "  \"SVC\": \"Salvadoran Colón\",\n" +
                    "  \"SYP\": \"Syrian Pound\",\n" +
                    "  \"SZL\": \"Swazi Lilangeni\",\n" +
                    "  \"THB\": \"Thai Baht\",\n" +
                    "  \"TJS\": \"Tajikistani Somoni\",\n" +
                    "  \"TMT\": \"Turkmenistani Manat\",\n" +
                    "  \"TND\": \"Tunisian Dinar\",\n" +
                    "  \"TOP\": \"Tongan Pa'anga\",\n" +
                    "  \"TRY\": \"Turkish Lira\",\n" +
                    "  \"TTD\": \"Trinidad and Tobago Dollar\",\n" +
                    "  \"TWD\": \"New Taiwan Dollar\",\n" +
                    "  \"TZS\": \"Tanzanian Shilling\",\n" +
                    "  \"UAH\": \"Ukrainian Hryvnia\",\n" +
                    "  \"UGX\": \"Ugandan Shilling\",\n" +
                    "  \"USD\": \"United States Dollar\",\n" +
                    "  \"UYU\": \"Uruguayan Peso\",\n" +
                    "  \"UZS\": \"Uzbekistan Som\",\n" +
                    "  \"VEF\": \"Venezuelan Bolívar Fuerte (Old)\",\n" +
                    "  \"VES\": \"Venezuelan Bolívar Soberano\",\n" +
                    "  \"VND\": \"Vietnamese Dong\",\n" +
                    "  \"VUV\": \"Vanuatu Vatu\",\n" +
                    "  \"WST\": \"Samoan Tala\",\n" +
                    "  \"XAF\": \"CFA Franc BEAC\",\n" +
                    "  \"XAG\": \"Silver Ounce\",\n" +
                    "  \"XAU\": \"Gold Ounce\",\n" +
                    "  \"XCD\": \"East Caribbean Dollar\",\n" +
                    "  \"XDR\": \"Special Drawing Rights\",\n" +
                    "  \"XOF\": \"CFA Franc BCEAO\",\n" +
                    "  \"XPD\": \"Palladium Ounce\",\n" +
                    "  \"XPF\": \"CFP Franc\",\n" +
                    "  \"XPT\": \"Platinum Ounce\",\n" +
                    "  \"YER\": \"Yemeni Rial\",\n" +
                    "  \"ZAR\": \"South African Rand\",\n" +
                    "  \"ZMW\": \"Zambian Kwacha\",\n" +
                    "  \"ZWL\": \"Zimbabwean Dollar\"\n" +
                    "}")
        }
        get("/latest.json")  {
            call.respondText("{\n" +
                    "  \"disclaimer\": \"Usage subject to terms: https://openexchangerates.org/terms\",\n" +
                    "  \"license\": \"https://openexchangerates.org/license\",\n" +
                    "  \"timestamp\": 1690524000,\n" +
                    "  \"base\": \"USD\",\n" +
                    "  \"rates\": {\n" +
                    "    \"AED\": 3.6731,\n" +
                    "    \"AFN\": 86.655981,\n" +
                    "    \"ALL\": 92,\n" +
                    "    \"AMD\": 394.892978,\n" +
                    "    \"ANG\": 1.802742,\n" +
                    "    \"AOA\": 825.290067,\n" +
                    "    \"ARS\": 273.0226,\n" +
                    "    \"AUD\": 1.499212,\n" +
                    "    \"AWG\": 1.8025,\n" +
                    "    \"AZN\": 1.7,\n" +
                    "    \"BAM\": 1.756609,\n" +
                    "    \"BBD\": 2,\n" +
                    "    \"BDT\": 108.55087,\n" +
                    "    \"BGN\": 1.7803,\n" +
                    "    \"BHD\": 0.376968,\n" +
                    "    \"BIF\": 2830.176048,\n" +
                    "    \"BMD\": 1,\n" +
                    "    \"BND\": 1.324047,\n" +
                    "    \"BOB\": 6.916496,\n" +
                    "    \"BRL\": 4.7431,\n" +
                    "    \"BSD\": 1,\n" +
                    "    \"BTC\": 0.000034276561,\n" +
                    "    \"BTN\": 81.946238,\n" +
                    "    \"BWP\": 13.172682,\n" +
                    "    \"BYN\": 2.524879,\n" +
                    "    \"BZD\": 2.016256,\n" +
                    "    \"CAD\": 1.321905,\n" +
                    "    \"CDF\": 2516.530593,\n" +
                    "    \"CHF\": 0.868512,\n" +
                    "    \"CLF\": 0.030004,\n" +
                    "    \"CLP\": 830.27,\n" +
                    "    \"CNH\": 7.151918,\n" +
                    "    \"CNY\": 7.1517,\n" +
                    "    \"COP\": 3997.960548,\n" +
                    "    \"CRC\": 540.404275,\n" +
                    "    \"CUC\": 1,\n" +
                    "    \"CUP\": 25.75,\n" +
                    "    \"CVE\": 99.357353,\n" +
                    "    \"CZK\": 21.908395,\n" +
                    "    \"DJF\": 180.597786,\n" +
                    "    \"DKK\": 6.783644,\n" +
                    "    \"DOP\": 56.2,\n" +
                    "    \"DZD\": 135.556703,\n" +
                    "    \"EGP\": 30.9017,\n" +
                    "    \"ERN\": 15,\n" +
                    "    \"ETB\": 54.948923,\n" +
                    "    \"EUR\": 0.910257,\n" +
                    "    \"FJD\": 2.2183,\n" +
                    "    \"FKP\": 0.781682,\n" +
                    "    \"GBP\": 0.781682,\n" +
                    "    \"GEL\": 2.595,\n" +
                    "    \"GGP\": 0.781682,\n" +
                    "    \"GHS\": 11.4,\n" +
                    "    \"GIP\": 0.781682,\n" +
                    "    \"GMD\": 59.66,\n" +
                    "    \"GNF\": 8655,\n" +
                    "    \"GTQ\": 7.852418,\n" +
                    "    \"GYD\": 209.434774,\n" +
                    "    \"HKD\": 7.79914,\n" +
                    "    \"HNL\": 24.630732,\n" +
                    "    \"HRK\": 6.863669,\n" +
                    "    \"HTG\": 137.542036,\n" +
                    "    \"HUF\": 347.755803,\n" +
                    "    \"IDR\": 15082.479674,\n" +
                    "    \"ILS\": 3.716062,\n" +
                    "    \"IMP\": 0.781682,\n" +
                    "    \"INR\": 82.285498,\n" +
                    "    \"IQD\": 1310.237995,\n" +
                    "    \"IRR\": 42250,\n" +
                    "    \"ISK\": 132.44,\n" +
                    "    \"JEP\": 0.781682,\n" +
                    "    \"JMD\": 154.454815,\n" +
                    "    \"JOD\": 0.709,\n" +
                    "    \"JPY\": 139.14433333,\n" +
                    "    \"KES\": 142.1,\n" +
                    "    \"KGS\": 87.6,\n" +
                    "    \"KHR\": 4127,\n" +
                    "    \"KMF\": 444.625287,\n" +
                    "    \"KPW\": 900,\n" +
                    "    \"KRW\": 1277.489994,\n" +
                    "    \"KWD\": 0.307161,\n" +
                    "    \"KYD\": 0.833573,\n" +
                    "    \"KZT\": 444.728224,\n" +
                    "    \"LAK\": 19272.520339,\n" +
                    "    \"LBP\": 15181.344333,\n" +
                    "    \"LKR\": 330.598251,\n" +
                    "    \"LRD\": 185.399968,\n" +
                    "    \"LSL\": 17.753229,\n" +
                    "    \"LYD\": 4.769402,\n" +
                    "    \"MAD\": 9.7878,\n" +
                    "    \"MDL\": 17.669492,\n" +
                    "    \"MGA\": 4496.39954,\n" +
                    "    \"MKD\": 55.588882,\n" +
                    "    \"MMK\": 2100.58421,\n" +
                    "    \"MNT\": 3519,\n" +
                    "    \"MOP\": 8.037542,\n" +
                    "    \"MRU\": 34.194676,\n" +
                    "    \"MUR\": 45.806117,\n" +
                    "    \"MVR\": 15.35,\n" +
                    "    \"MWK\": 1050,\n" +
                    "    \"MXN\": 16.828875,\n" +
                    "    \"MYR\": 4.545,\n" +
                    "    \"MZN\": 63.749999,\n" +
                    "    \"NAD\": 17.65,\n" +
                    "    \"NGN\": 785.586324,\n" +
                    "    \"NIO\": 36.579862,\n" +
                    "    \"NOK\": 10.165854,\n" +
                    "    \"NPR\": 131.11673,\n" +
                    "    \"NZD\": 1.621404,\n" +
                    "    \"OMR\": 0.385073,\n" +
                    "    \"PAB\": 1,\n" +
                    "    \"PEN\": 3.600767,\n" +
                    "    \"PGK\": 3.590877,\n" +
                    "    \"PHP\": 54.808003,\n" +
                    "    \"PKR\": 286.855145,\n" +
                    "    \"PLN\": 4.025554,\n" +
                    "    \"PYG\": 7279.550873,\n" +
                    "    \"QAR\": 3.641341,\n" +
                    "    \"RON\": 4.4869,\n" +
                    "    \"RSD\": 106.677124,\n" +
                    "    \"RUB\": 90.362497,\n" +
                    "    \"RWF\": 1174.147196,\n" +
                    "    \"SAR\": 3.751023,\n" +
                    "    \"SBD\": 8.382819,\n" +
                    "    \"SCR\": 13.485336,\n" +
                    "    \"SDG\": 601.5,\n" +
                    "    \"SEK\": 10.50211,\n" +
                    "    \"SGD\": 1.330627,\n" +
                    "    \"SHP\": 0.781682,\n" +
                    "    \"SLL\": 17665,\n" +
                    "    \"SOS\": 577.676358,\n" +
                    "    \"SRD\": 38.3815,\n" +
                    "    \"SSP\": 130.26,\n" +
                    "    \"STD\": 22823.990504,\n" +
                    "    \"STN\": 22.268223,\n" +
                    "    \"SVC\": 8.750505,\n" +
                    "    \"SYP\": 2512.53,\n" +
                    "    \"SZL\": 17.749221,\n" +
                    "    \"THB\": 34.4575,\n" +
                    "    \"TJS\": 10.943286,\n" +
                    "    \"TMT\": 3.5,\n" +
                    "    \"TND\": 3.091,\n" +
                    "    \"TOP\": 2.35035,\n" +
                    "    \"TRY\": 26.959539,\n" +
                    "    \"TTD\": 6.78986,\n" +
                    "    \"TWD\": 31.423003,\n" +
                    "    \"TZS\": 2450,\n" +
                    "    \"UAH\": 36.942083,\n" +
                    "    \"UGX\": 3663.816162,\n" +
                    "    \"USD\": 1,\n" +
                    "    \"UYU\": 37.692821,\n" +
                    "    \"UZS\": 11614.255095,\n" +
                    "    \"VES\": 29.277384,\n" +
                    "    \"VND\": 23691.069797,\n" +
                    "    \"VUV\": 118.979,\n" +
                    "    \"WST\": 2.72551,\n" +
                    "    \"XAF\": 597.089402,\n" +
                    "    \"XAG\": 0.04125328,\n" +
                    "    \"XAU\": 0.00051219,\n" +
                    "    \"XCD\": 2.70255,\n" +
                    "    \"XDR\": 0.743219,\n" +
                    "    \"XOF\": 597.089402,\n" +
                    "    \"XPD\": 0.00081196,\n" +
                    "    \"XPF\": 108.622545,\n" +
                    "    \"XPT\": 0.00105966,\n" +
                    "    \"YER\": 250.300053,\n" +
                    "    \"ZAR\": 17.802971,\n" +
                    "    \"ZMW\": 18.515808,\n" +
                    "    \"ZWL\": 322\n" +
                    "  }\n" +
                    "}")
        }
    }
}