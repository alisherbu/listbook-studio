package kaa.alisherbu.listbookstudio.shared.signup.store

import com.arkivanov.mvikotlin.extensions.coroutines.CoroutineExecutor

internal class SignupExecutor : CoroutineExecutor<Intent, Unit, SignupState, Message, Label>() {
    override fun executeIntent(intent: Intent, getState: () -> SignupState) {
        val state = getState()
        when (intent) {
            is Intent.EmailTextChanged -> {
                val isCreateAccountButtonEnabled = isNotBlank(
                    name = state.name,
                    surname = state.surname,
                    email = intent.text,
                    password = state.password,
                )
                dispatch(Message.EmailTextChanged(intent.text, isCreateAccountButtonEnabled))
            }

            is Intent.NameTextChanged -> {
                val isCreateAccountButtonEnabled = isNotBlank(
                    name = intent.text,
                    surname = state.surname,
                    email = state.email,
                    password = state.password,
                )
                dispatch(Message.NameTextChanged(intent.text, isCreateAccountButtonEnabled))
            }

            is Intent.PasswordTextChanged -> {
                val isCreateAccountButtonEnabled = isNotBlank(
                    name = state.name,
                    surname = state.surname,
                    email = state.email,
                    password = intent.text,
                )
                dispatch(Message.PasswordTextChanged(intent.text, isCreateAccountButtonEnabled))
            }

            is Intent.SurnameTextChanged -> {
                val isCreateAccountButtonEnabled = isNotBlank(
                    name = state.name,
                    surname = intent.text,
                    email = state.email,
                    password = state.password,
                )
                dispatch(Message.SurnameTextChanged(intent.text, isCreateAccountButtonEnabled))
            }

            Intent.CreateAccountClicked -> {}
        }
    }

    private fun isNotBlank(
        name: String,
        surname: String,
        email: String,
        password: String,
    ): Boolean {
        return name.isNotBlank() && surname.isNotBlank() &&
                email.isNotBlank() && password.isNotBlank()
    }
}
