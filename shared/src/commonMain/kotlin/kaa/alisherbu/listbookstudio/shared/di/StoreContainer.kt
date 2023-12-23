package kaa.alisherbu.listbookstudio.shared.di

import com.arkivanov.mvikotlin.main.store.DefaultStoreFactory
import kaa.alisherbu.listbookstudio.shared.signin.store.SignInExecutor
import kaa.alisherbu.listbookstudio.shared.signin.store.SignInReducer
import kaa.alisherbu.listbookstudio.shared.signin.store.SignInStore
import kaa.alisherbu.listbookstudio.shared.signin.store.SignInStoreImpl
import kaa.alisherbu.listbookstudio.shared.signup.store.SignupExecutor
import kaa.alisherbu.listbookstudio.shared.signup.store.SignupReducer
import kaa.alisherbu.listbookstudio.shared.signup.store.SignupStore
import kaa.alisherbu.listbookstudio.shared.signup.store.SignupStoreImpl

internal object StoreContainer {
    private val storeFactory = DefaultStoreFactory()
    fun getSignInStore(): SignInStore {
        return SignInStoreImpl(
            storeFactory = storeFactory,
            executorFactory = { SignInExecutor() },
            reducer = SignInReducer()
        )
    }

    fun getSignupStore(): SignupStore {
        return SignupStoreImpl(
            storeFactory = storeFactory,
            executorFactory = { SignupExecutor() },
            reducer = SignupReducer()
        )
    }
}