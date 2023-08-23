package com.demo.paypayconverter.presentation.home

import com.demo.paypayconverter.domain.model.Currency
import com.demo.paypayconverter.presentation.MviAction
import com.demo.paypayconverter.presentation.MviIntent
import com.demo.paypayconverter.presentation.MviState
import com.demo.paypayconverter.presentation.model.RateDisplay

enum class LoadState {
    IDLE,
    LOADING,
    LOADED,
    ERROR
}

data class HomeScreenState(
    val loadState: LoadState,
    val errorMessage: String,
    val base: String,
    val amount : Double,
    val currentRates: List<RateDisplay>,
    val currencies: List<Currency>
) : MviState {
    companion object {
        val initial = HomeScreenState(
            loadState = LoadState.LOADING,
            errorMessage = "",
            base = "USD",
            amount = 0.0,
            currentRates = emptyList(),
            currencies = emptyList()
        )
    }
}

sealed class HomeScreenIntent : MviIntent {
    data class BaseCurrencyUpdated(val base: String) : HomeScreenIntent()
    data class InputAmountUpdated(val amount: Double) : HomeScreenIntent()
}

sealed class HomeScreenAction : MviAction {
    data object Loading : HomeScreenAction()
    data class UpdateBaseCurrency(val base: String) : HomeScreenAction()
    data class CalculateRate(val amount: Double) : HomeScreenAction()
}
