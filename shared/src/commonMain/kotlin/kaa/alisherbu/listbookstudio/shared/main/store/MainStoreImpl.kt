package kaa.alisherbu.listbookstudio.shared.main.store

import com.arkivanov.mvikotlin.core.store.SimpleBootstrapper
import com.arkivanov.mvikotlin.core.store.Store
import com.arkivanov.mvikotlin.core.store.StoreFactory

internal class MainStoreImpl(
    storeFactory: StoreFactory,
    executorFactory: () -> MainExecutor,
    reducer: MainReducer,
) : MainStore,
    Store<Intent, MainState, Label> by storeFactory.create(
        name = MainStore::class.simpleName,
        initialState = MainState(),
        executorFactory = executorFactory,
        reducer = reducer,
        bootstrapper = SimpleBootstrapper(Action.Init)
    )
