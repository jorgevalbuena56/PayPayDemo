package com.demo.paypayconverter.domain.util

import com.demo.paypayconverter.logWarning
import io.ktor.client.plugins.logging.Logger

class HttpLogger : Logger {
    override fun log(message: String) {
        logWarning(message)
    }
}