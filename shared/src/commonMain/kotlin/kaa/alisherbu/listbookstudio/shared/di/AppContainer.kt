package kaa.alisherbu.listbookstudio.shared.di

import kaa.alisherbu.listbook.core.shared.coroutine.AppDispatchers
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO

internal object AppContainer {
    fun getAppDispatchers(): AppDispatchers {
        return object : AppDispatchers {
            override val main: CoroutineDispatcher
                get() = Dispatchers.Main
            override val io: CoroutineDispatcher
                get() = Dispatchers.IO
            override val default: CoroutineDispatcher
                get() = Dispatchers.Default

        }
    }
}