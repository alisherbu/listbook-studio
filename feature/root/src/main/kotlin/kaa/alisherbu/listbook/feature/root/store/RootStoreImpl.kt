package kaa.alisherbu.listbook.feature.root.store

import com.arkivanov.mvikotlin.core.store.SimpleBootstrapper
import com.arkivanov.mvikotlin.core.store.Store
import com.arkivanov.mvikotlin.core.store.StoreFactory
import javax.inject.Inject
import javax.inject.Provider

internal class RootStoreImpl @Inject constructor(
    storeFactory: StoreFactory,
    executorProvider: Provider<RootExecutor>,
) : RootStore,
    Store<Intent, RootState, Label> by storeFactory.create(
        name = RootStore::class.simpleName,
        executorFactory = executorProvider::get,
        initialState = RootState(),
        bootstrapper = SimpleBootstrapper(Action.CheckUserSigned),
        autoInit = false,
    )
