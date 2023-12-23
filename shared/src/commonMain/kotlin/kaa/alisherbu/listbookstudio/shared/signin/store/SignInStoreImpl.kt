package kaa.alisherbu.listbookstudio.shared.signin.store

import com.arkivanov.mvikotlin.core.store.Store
import com.arkivanov.mvikotlin.core.store.StoreFactory

internal class SignInStoreImpl(
    storeFactory: StoreFactory,
    reducer: SignInReducer
) : SignInStore,
    Store<Intent, SignInState, Label> by storeFactory.create(
        name = SignInStore::class.simpleName,
        initialState = SignInState(),
        executorFactory = { SignInExecutor() },
        reducer = reducer,
    )
