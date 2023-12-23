package kaa.alisherbu.listbookstudio.shared.signin.store

import com.arkivanov.mvikotlin.core.store.Store

internal sealed interface Intent {
    class EmailTextChanged(val text: String) : Intent
    class PasswordTextChanged(val text: String) : Intent

    data object LogInClicked : Intent
}

internal sealed interface Label {
    data object SuccessfullySigned : Label
    class ErrorOccurred(val message: String) : Label
}

internal sealed interface Message {
    class EmailTextChanged(val text: String) : Message
    class PasswordTextChanged(val text: String) : Message
}

internal interface SignInStore : Store<Intent, SignInState, Label>
