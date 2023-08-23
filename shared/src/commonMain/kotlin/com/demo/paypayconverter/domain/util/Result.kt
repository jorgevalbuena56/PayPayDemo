package com.demo.paypayconverter.domain.util

import io.ktor.client.plugins.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onStart

sealed interface Result<out T> {
    data class Success<T>(val data: T) : Result<T>
    data class Error(val exception: ErrorMessage) : Result<Nothing>
    object Loading : Result<Nothing>
    object Idle : Result<Nothing>
}

fun <T> Flow<T>.asResult(): Flow<Result<T>> {
    return this
        .map<T, Result<T>> {
            Result.Success(it)
        }
        .onStart { emit(Result.Loading) }
        .catch {
            it.printStackTrace()

            emit(Result.Error((it as Exception).getRealException()))


        }
}

sealed class ErrorMessage(val message: String = "") {


    object NetworkError : ErrorMessage("Something wrong with network, please try again.")
    object UnknownError : ErrorMessage("Something went wrong, please try again.")
    object ResponseError :
        ErrorMessage("We are fixing your problem, Thank you for your patience.")

    object NoInternet : ErrorMessage("No Internet")
    object NotFound : ErrorMessage("Not Found")
    data class ExceptionMessage(val error: String) : ErrorMessage(message = error)

}

fun  Exception.getRealException(): ErrorMessage = when (this) {
    is HttpRequestTimeoutException -> {
        ErrorMessage.NetworkError
    }
    is RedirectResponseException -> {
        ErrorMessage.NetworkError
    }
    is ClientRequestException -> {
        ErrorMessage.NetworkError
    }
    is ServerResponseException -> {
        ErrorMessage.ResponseError
    }
    else -> {
        ErrorMessage.UnknownError
    }
}