package kaa.alisherbu.listbookstudio.shared.signup.store

import com.arkivanov.mvikotlin.core.store.Store
import com.arkivanov.mvikotlin.core.store.StoreFactory

internal class SignupStoreImpl constructor(
    storeFactory: StoreFactory,
    reducer: SignupReducer,
) : SignupStore,
    Store<Intent, SignupState, Label> by storeFactory.create(
        name = SignupStore::class.simpleName,
        executorFactory = { SignupExecutor() },
        reducer = reducer,
        initialState = SignupState(),
    )
