package kaa.alisherbu.listbookstudio.shared.signin

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.value.MutableValue
import kaa.alisherbu.listbookstudio.shared.signin.SignInComponent.Output
import kaa.alisherbu.listbookstudio.shared.signin.store.SignInState

class SignInComponentImpl constructor(
    componentContext: ComponentContext,
    private val output: (Output) -> Unit,
) : SignInComponent, ComponentContext by componentContext {
    override val state: MutableValue<SignInState> = MutableValue(SignInState())

    override fun onBackClicked() {
        output(Output.Back)
    }

    override fun onEmailTextChanged(text: String) {
        /* no-op */
    }

    override fun onPasswordTextChanged(text: String) {
        /* no-op */
    }

    override fun onLogInClicked() {
        /* no-op */
    }

}
