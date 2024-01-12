package kaa.alisherbu.listbookstudio.shared.signup.store

import com.arkivanov.mvikotlin.core.store.Store
import com.arkivanov.mvikotlin.core.store.StoreFactory

internal class SignupStoreImpl constructor(
    storeFactory: StoreFactory,
    executorFactory: () -> SignupExecutor,
    reducer: SignupReducer,
) : SignupStore,
    Store<Intent, SignupState, Label> by storeFactory.create(
        name = SignupStore::class.simpleName,
        executorFactory = executorFactory,
        reducer = reducer,
        initialState = SignupState(),
    )
