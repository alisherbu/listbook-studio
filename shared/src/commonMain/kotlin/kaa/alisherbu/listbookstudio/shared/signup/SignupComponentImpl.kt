package kaa.alisherbu.listbookstudio.shared.signup

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.slot.activate
import com.arkivanov.decompose.value.Value
import com.arkivanov.essenty.lifecycle.doOnDestroy
import com.arkivanov.mvikotlin.core.instancekeeper.getStore
import com.arkivanov.mvikotlin.extensions.coroutines.labels
import kaa.alisherbu.listbookstudio.shared.di.AppContainer
import kaa.alisherbu.listbookstudio.shared.di.StoreContainer
import kaa.alisherbu.listbookstudio.shared.signup.SignupComponent.Output
import kaa.alisherbu.listbookstudio.shared.signup.store.Intent
import kaa.alisherbu.listbookstudio.shared.signup.store.Label
import kaa.alisherbu.listbookstudio.shared.signup.store.SignupState
import kaa.alisherbu.listbookstudio.shared.utils.states
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.cancel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

class SignupComponentImpl constructor(
    componentContext: ComponentContext,
    private val output: (Output) -> Unit
) : SignupComponent, ComponentContext by componentContext {
    private val dispatchers = AppContainer.getAppDispatchers()
    private val mainScope = CoroutineScope(dispatchers.main)
    private val store = instanceKeeper.getStore(StoreContainer::getSignupStore)
    override val state: Value<SignupState> = store.states

    init {
        store.labels
            .onEach(::handleLabel)
            .launchIn(mainScope)
        lifecycle.doOnDestroy(mainScope::cancel)
    }

    private fun handleLabel(label: Label) {
        when (label) {
            Label.AccountSuccessfullyCreated -> {

            }

            is Label.ErrorOccurred -> {
                output(Output.Error(label.message))
            }
        }
    }

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
