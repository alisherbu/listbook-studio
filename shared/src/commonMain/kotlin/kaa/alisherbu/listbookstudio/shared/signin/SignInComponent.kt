package kaa.alisherbu.listbookstudio.shared.signin

import com.arkivanov.decompose.value.Value
import kaa.alisherbu.listbookstudio.shared.signin.store.SignInState

interface SignInComponent {

    val state: Value<SignInState>

    fun onBackClicked()

    fun onEmailTextChanged(text: String)

    fun onPasswordTextChanged(text: String)

    fun onLogInClicked()

    sealed interface Output {
        data object Back : Output
        data object Main : Output
        class Error(val message: String) : Output
    }
}
