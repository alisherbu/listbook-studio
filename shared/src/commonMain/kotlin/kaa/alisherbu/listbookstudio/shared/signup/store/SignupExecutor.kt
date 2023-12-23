package kaa.alisherbu.listbookstudio.shared.signup.store

import com.arkivanov.mvikotlin.extensions.coroutines.CoroutineExecutor
import dev.gitlive.firebase.auth.FirebaseAuth
import kotlinx.coroutines.launch

internal class SignupExecutor(
    private val firebaseAuth: FirebaseAuth
) : CoroutineExecutor<Intent, Unit, SignupState, Message, Label>() {
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

            Intent.CreateAccountClicked -> scope.launch {
                createAccount(state.email, state.password)
            }
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

    private suspend fun createAccount(email: String, password: String) {
        try {
            val user = firebaseAuth.createUserWithEmailAndPassword(email, password).user
            if (user != null) publish(Label.AccountSuccessfullyCreated)
            else publish(Label.ErrorOccurred("Something went wrong"))
        } catch (e: Exception) {
            publish(Label.ErrorOccurred(e.message.toString()))
        }
    }
}
