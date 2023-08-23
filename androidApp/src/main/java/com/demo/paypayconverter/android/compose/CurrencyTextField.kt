package com.demo.paypayconverter.android.compose

import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun CurrencyTextField(
    value: String,
    onValueChange: (Double) -> Unit,
    modifier: Modifier = Modifier
) {
        val keyboardController = LocalSoftwareKeyboardController.current

        BasicTextField(
            value = value,
            onValueChange = { input ->
                if (input.length < 16) {
                    // Remove any non-digit characters and validate the input
                    val digitsOnly = input.filter { it.isDigit() }

                    // Calculate the double value from the sanitized input
                    val newValue = if (digitsOnly.isNotEmpty()) {
                        digitsOnly.toDouble() / 100.0 // Divide by 100 to convert back to Double
                    } else {
                        0.0
                    }
                    onValueChange(newValue)
                }

            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Done
            ),
            keyboardActions = KeyboardActions(
                onDone = {
                    keyboardController?.hide()
                }
            ),
            textStyle = TextStyle(fontSize = 18.sp),
            modifier = modifier
        )
}