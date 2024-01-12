package kaa.alisherbu.listbookstudio.shared.signin.store

import com.arkivanov.mvikotlin.extensions.coroutines.CoroutineExecutor
import dev.gitlive.firebase.auth.FirebaseAuth
import kotlinx.coroutines.launch

internal class SignInExecutor(
    private val firebaseAuth: FirebaseAuth
) : CoroutineExecutor<Intent, Unit, SignInState, Message, Label>() {
    override fun executeIntent(intent: Intent, getState: () -> SignInState) {
        val state = getState()
        when (intent) {
            is Intent.EmailTextChanged -> dispatch(Message.EmailTextChanged(intent.text))
            is Intent.PasswordTextChanged -> dispatch(Message.PasswordTextChanged(intent.text))
            Intent.LogInClicked -> scope.launch {
                signIn(state.email, state.password)
            }
        }
    }

    private suspend fun signIn(email: String, password: String) {
        try {
            val user = firebaseAuth.signInWithEmailAndPassword(email, password).user
            if (user != null) publish(Label.SuccessfullySigned)
            else publish(Label.ErrorOccurred("Something went wrong"))
        } catch (e: Exception) {
            publish(Label.ErrorOccurred(e.message.toString()))
        }
    }
}
