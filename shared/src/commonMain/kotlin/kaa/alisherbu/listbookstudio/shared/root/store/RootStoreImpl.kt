package kaa.alisherbu.listbookstudio.shared.root.store

import com.arkivanov.mvikotlin.core.store.SimpleBootstrapper
import com.arkivanov.mvikotlin.core.store.Store
import com.arkivanov.mvikotlin.core.store.StoreFactory

internal class RootStoreImpl(
    storeFactory: StoreFactory,
    executorFactory: () -> RootExecutor,
) : RootStore,
    Store<Intent, RootState, Label> by storeFactory.create(
        name = RootStore::class.simpleName,
        executorFactory = executorFactory,
        initialState = RootState(),
        bootstrapper = SimpleBootstrapper(Action.Init),
        autoInit = false,
    )
