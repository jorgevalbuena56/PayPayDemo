package com.demo.paypayconverter.presentation

import com.rickclephas.kmm.viewmodel.KMMViewModel
import com.rickclephas.kmm.viewmodel.MutableStateFlow
import com.rickclephas.kmm.viewmodel.coroutineScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

/**
 * Marker class for the view state
 */
interface MviState

/**
 * Marker class for View Intents
 */
interface MviIntent

/**
 * Marker class for the reducer actions
 */
interface MviAction

private const val FLOW_BUFFER_CAPACITY = 64

abstract class MviViewModel<S : MviState, I : MviIntent, A : MviAction>(
    initialState: S
) : KMMViewModel() {

    private val stateFlow = MutableStateFlow(viewModelScope, initialState)
    val state: StateFlow<S> = stateFlow.asStateFlow()

    private val intentFlow = MutableSharedFlow<I>(extraBufferCapacity = FLOW_BUFFER_CAPACITY)
    private val reduceFlow = MutableSharedFlow<A>(extraBufferCapacity = FLOW_BUFFER_CAPACITY)

    init {
        intentFlow
            .onEach { intent ->
                executeIntent(intent)
            }
            .launchIn(viewModelScope.coroutineScope)
        reduceFlow
            .onEach { action ->
                stateFlow.value = reduce(stateFlow.value, action)
            }
            .launchIn(viewModelScope.coroutineScope)
    }

    fun onIntent(intent: I) {
        intentFlow.tryEmit(intent)
    }

    protected fun handle(action: A) {
        reduceFlow.tryEmit(action)
    }

    protected abstract suspend fun executeIntent(intent: I)

    protected abstract fun reduce(state: S, action: A): S
}