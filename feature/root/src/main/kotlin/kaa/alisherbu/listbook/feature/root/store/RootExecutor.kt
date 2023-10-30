package kaa.alisherbu.listbook.feature.root.store

import com.arkivanov.mvikotlin.extensions.coroutines.CoroutineExecutor
import kaa.alisherbu.listbook.feature.root.domain.usecase.CheckUserSignedUseCase
import javax.inject.Inject

internal class RootExecutor @Inject constructor(
    private val checkUserSigned: CheckUserSignedUseCase,
) : CoroutineExecutor<Intent, Action, RootState, Message, Label>() {
    override fun executeAction(action: Action, getState: () -> RootState) {
        when (action) {
            Action.CheckUserSigned -> {
                if (checkUserSigned()) {
                    publish(Label.UserAlreadySigned)
                } else {
                    publish(Label.UserNotSigned)
                }
            }
        }
    }
}
