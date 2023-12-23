package kaa.alisherbu.listbookstudio.shared.signup

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.value.Value
import com.arkivanov.mvikotlin.core.instancekeeper.getStore
import kaa.alisherbu.listbookstudio.shared.di.StoreContainer
import kaa.alisherbu.listbookstudio.shared.signup.SignupComponent.Output
import kaa.alisherbu.listbookstudio.shared.signup.store.Intent
import kaa.alisherbu.listbookstudio.shared.signup.store.SignupState
import kaa.alisherbu.listbookstudio.shared.utils.states

class SignupComponentImpl constructor(
    componentContext: ComponentContext,
    private val output: (Output) -> Unit
) : SignupComponent, ComponentContext by componentContext {
    private val store = instanceKeeper.getStore(StoreContainer::getSignupStore)
    override val state: Value<SignupState> = store.states

    override fun onNameTextChanged(text: String) {
        store.accept(Intent.NameTextChanged(text))
    }

    override fun onSurnameTextChanged(text: String) {
        store.accept(Intent.SurnameTextChanged(text))
    }

    override fun onEmailTextChanged(text: String) {
        store.accept(Intent.EmailTextChanged(text))
    }

    override fun onPasswordTextChanged(text: String) {
        store.accept(Intent.PasswordTextChanged(text))
    }

    override fun onBackClicked() {
        output(Output.Back)
    }

    override fun onCreateAccountClicked() {
        store.accept(Intent.CreateAccountClicked)
    }

}
