package kaa.alisherbu.listbookstudio.shared.signup

import com.arkivanov.decompose.value.Value
import kaa.alisherbu.listbookstudio.shared.signup.store.SignupState

interface SignupComponent {
    val state: Value<SignupState>

    fun onNameTextChanged(text: String)

    fun onSurnameTextChanged(text: String)

    fun onEmailTextChanged(text: String)

    fun onPasswordTextChanged(text: String)

    fun onBackClicked()

    fun onCreateAccountClicked()

    sealed class Output {
        data object Back : Output()
        data object Main : Output()
        class Error(val message: String) : Output()
    }
}
