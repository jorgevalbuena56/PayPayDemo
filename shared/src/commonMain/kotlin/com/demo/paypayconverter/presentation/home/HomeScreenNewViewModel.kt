package com.demo.paypayconverter.presentation.home

import com.demo.paypayconverter.data.repository.ConverterRepository
import com.demo.paypayconverter.domain.util.CurrencyConverterExceptions
import com.demo.paypayconverter.domain.util.CurrencyFormatter
import com.demo.paypayconverter.presentation.MviViewModel
import com.demo.paypayconverter.presentation.model.RateDisplay
import com.rickclephas.kmm.viewmodel.stateIn
import com.rickclephas.kmp.nativecoroutines.NativeCoroutinesState
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.flow
import kotlin.time.DurationUnit
import kotlin.time.toDuration

class HomeScreenNewViewModel(
    private val repository: ConverterRepository,
    private val currencyFormatter: CurrencyFormatter
) : MviViewModel<HomeScreenState, HomeScreenIntent, HomeScreenAction>(
    initialState = HomeScreenState.initial
) {

    private val ratesPoller = flow {
        while (true) {
            emit(repository.getRates(state.value.base))
            delay(30.toDuration(DurationUnit.MINUTES))
        }
    }

    @NativeCoroutinesState
    val homeState: StateFlow<HomeScreenState> =
        combine(
            ratesPoller,
            state
        ) { currentRates, currentState  ->

            val currencyList = currentState.currencies.ifEmpty {
                repository.getCurrencies()
            }
            val rates = currentRates.values.filterKeys {
                it != currentState.base
            }.map {
                RateDisplay(
                    code = it.key,
                    rate = it.value,
                    amount = currencyFormatter.formatCurrency(currentState.amount * it.value, it.key)
                )
            }

            HomeScreenState.initial.copy(
                loadState = LoadState.LOADED,
                errorMessage = "",
                base = currentState.base,
                amount = currentState.amount,
                currencies =  currencyList,
                currentRates = rates)

        }.catch { error ->
            if (error is CurrencyConverterExceptions) {
                emit(HomeScreenState.initial.copy(loadState = LoadState.ERROR, errorMessage = error.exception.message ?: "Error"))
            } else {
                emit(HomeScreenState.initial.copy(loadState = LoadState.ERROR, errorMessage = error.message ?: "Error"))
            }
        }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(), HomeScreenState.initial)


    override suspend fun executeIntent(intent: HomeScreenIntent) {
        when (intent) {
            is HomeScreenIntent.BaseCurrencyUpdated -> {
                handle(HomeScreenAction.UpdateBaseCurrency(base = intent.base))
            }
            is HomeScreenIntent.InputAmountUpdated -> {
                handle(HomeScreenAction.CalculateRate(amount = intent.amount))
            }
        }
    }

    override fun reduce(state: HomeScreenState, action: HomeScreenAction): HomeScreenState {
        return when (action) {
            is HomeScreenAction.CalculateRate -> {
                state.copy(amount = action.amount)
            }
            HomeScreenAction.Loading -> {
                state.copy(loadState = LoadState.LOADING)
            }
            is HomeScreenAction.UpdateBaseCurrency -> {
                state.copy(base = action.base)
            }
        }
    }

    fun amountFormatted() : String {
        return currencyFormatter.formatCurrency(state.value.amount, state.value.base)
    }
}