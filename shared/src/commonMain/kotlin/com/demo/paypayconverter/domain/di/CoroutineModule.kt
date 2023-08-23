package com.demo.paypayconverter.domain.di

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.SupervisorJob
import org.koin.dsl.module

interface DefaultCoroutineScope : CoroutineScope
interface MainCoroutineScope : CoroutineScope

fun MainCoroutineScope(
    job: Job = SupervisorJob()
): MainCoroutineScope = object : MainCoroutineScope {
    override val coroutineContext = job + Dispatchers.Main
}

fun DefaultCoroutineScope(
    job: Job = SupervisorJob()
): DefaultCoroutineScope = object : DefaultCoroutineScope {
    override val coroutineContext = job + Dispatchers.Default
}

val coroutineModule = module {
    factory { DefaultCoroutineScope() }
    factory { MainCoroutineScope() }
}