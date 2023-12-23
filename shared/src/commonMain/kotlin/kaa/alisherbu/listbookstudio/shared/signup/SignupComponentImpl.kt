package kaa.alisherbu.listbookstudio.shared.signup

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.value.MutableValue
import kaa.alisherbu.listbookstudio.shared.signup.SignupComponent.Output
import kaa.alisherbu.listbookstudio.shared.signup.store.SignupState

class SignupComponentImpl constructor(
    componentContext: ComponentContext,
    private val output: (Output) -> Unit,
) : SignupComponent, ComponentContext by componentContext {
    override val state: MutableValue<SignupState> = MutableValue(SignupState())

    override fun onNameTextChanged(text: String) {
        /* no-op */
    }

    override fun onSurnameTextChanged(text: String) {
        /* no-op */
    }

    override fun onEmailTextChanged(text: String) {
        /* no-op */
    }

    override fun onPasswordTextChanged(text: String) {
        /* no-op */
    }

    override fun onBackClicked() {
        output(Output.Back)
    }

    override fun onCreateAccountClicked() {
        /* no-op */
    }

}
