package kaa.alisherbu.listbookstudio.shared.root.store

import com.arkivanov.mvikotlin.extensions.coroutines.CoroutineExecutor
import dev.gitlive.firebase.auth.FirebaseAuth

internal class RootExecutor(
    private val firebaseAuth: FirebaseAuth
) : CoroutineExecutor<Intent, Action, RootState, Message, Label>() {
    override fun executeAction(action: Action, getState: () -> RootState) {
        when (action) {
            Action.Init -> checkUserExistence()
        }
    }

    private fun checkUserExistence() {
        if (firebaseAuth.currentUser != null) {
            publish(Label.UserAlreadySigned)
        } else {
            publish(Label.UserNotSigned)
        }
    }
}
