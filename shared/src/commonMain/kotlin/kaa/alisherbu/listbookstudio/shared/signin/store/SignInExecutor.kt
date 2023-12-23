package kaa.alisherbu.listbookstudio.shared.signin.store

import com.arkivanov.mvikotlin.extensions.coroutines.CoroutineExecutor

internal class SignInExecutor : CoroutineExecutor<Intent, Unit, SignInState, Message, Label>() {
    override fun executeIntent(intent: Intent, getState: () -> SignInState) {
        val state = getState()
        when (intent) {
            is Intent.EmailTextChanged -> dispatch(Message.EmailTextChanged(intent.text))
            is Intent.PasswordTextChanged -> dispatch(Message.PasswordTextChanged(intent.text))
            Intent.LogInClicked -> {}
        }
    }
}
