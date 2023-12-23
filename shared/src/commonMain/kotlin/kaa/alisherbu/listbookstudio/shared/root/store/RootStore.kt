package kaa.alisherbu.listbookstudio.shared.root.store

import com.arkivanov.mvikotlin.core.store.Store

internal sealed interface Intent

internal sealed interface Label {
    data object UserAlreadySigned : Label
    data object UserNotSigned : Label
}

internal sealed interface Message

internal sealed interface Action {
    data object Init : Action
}

internal interface RootStore : Store<Intent, RootState, Label>
