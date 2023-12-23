package kaa.alisherbu.listbookstudio.shared.di

import com.arkivanov.mvikotlin.logging.store.LoggingStoreFactory
import com.arkivanov.mvikotlin.main.store.DefaultStoreFactory
import dev.gitlive.firebase.Firebase
import dev.gitlive.firebase.auth.auth
import kaa.alisherbu.listbookstudio.shared.signin.store.SignInExecutor
import kaa.alisherbu.listbookstudio.shared.signin.store.SignInReducer
import kaa.alisherbu.listbookstudio.shared.signin.store.SignInStore
import kaa.alisherbu.listbookstudio.shared.signin.store.SignInStoreImpl
import kaa.alisherbu.listbookstudio.shared.signup.store.SignupExecutor
import kaa.alisherbu.listbookstudio.shared.signup.store.SignupReducer
import kaa.alisherbu.listbookstudio.shared.signup.store.SignupStore
import kaa.alisherbu.listbookstudio.shared.signup.store.SignupStoreImpl

internal object StoreContainer {
    private val storeFactory = if (buildInfo.isDebug) LoggingStoreFactory(DefaultStoreFactory())
    else DefaultStoreFactory()
    private val firebaseAuth get() = Firebase.auth
    fun getSignInStore(): SignInStore {
        return SignInStoreImpl(
            storeFactory = storeFactory,
            executorFactory = { SignInExecutor(firebaseAuth) },
            reducer = SignInReducer()
        )
    }

    fun getSignupStore(): SignupStore {
        return SignupStoreImpl(
            storeFactory = storeFactory,
            executorFactory = { SignupExecutor(firebaseAuth) },
            reducer = SignupReducer()
        )
    }
}