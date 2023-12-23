package kaa.alisherbu.listbookstudio.shared.signin

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.value.MutableValue
import com.arkivanov.decompose.value.Value
import com.arkivanov.mvikotlin.core.instancekeeper.getStore
import kaa.alisherbu.listbookstudio.shared.di.StoreContainer
import kaa.alisherbu.listbookstudio.shared.signin.SignInComponent.Output
import kaa.alisherbu.listbookstudio.shared.signin.store.Intent
import kaa.alisherbu.listbookstudio.shared.signin.store.SignInState
import kaa.alisherbu.listbookstudio.shared.utils.states

class SignInComponentImpl constructor(
    componentContext: ComponentContext,
    private val output: (Output) -> Unit
) : SignInComponent, ComponentContext by componentContext {
    private val store = instanceKeeper.getStore(StoreContainer::getSignInStore)
    override val state: Value<SignInState> = store.states

    override fun onBackClicked() {
        output(Output.Back)
    }

    override fun onEmailTextChanged(text: String) {
        store.accept(Intent.EmailTextChanged(text))
    }

    override fun onPasswordTextChanged(text: String) {
        store.accept(Intent.PasswordTextChanged(text))
    }

    override fun onLogInClicked() {
        store.accept(Intent.LogInClicked)
    }

}
