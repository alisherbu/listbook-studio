package kaa.alisherbu.listbook.core.shared.coroutine

import kotlinx.coroutines.CoroutineDispatcher

interface AppDispatchers {

    val main: CoroutineDispatcher

    val io: CoroutineDispatcher

    val default: CoroutineDispatcher
}
