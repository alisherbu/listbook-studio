package kaa.alisherbu.listbook.feature.root.store

import com.arkivanov.mvikotlin.core.store.Store

internal sealed interface Intent

internal sealed interface Label {
    object UserAlreadySigned : Label
    object UserNotSigned : Label
}

internal sealed interface Message

internal sealed interface Action {
    object CheckUserSigned : Action
}

internal interface RootStore : Store<Intent, RootState, Label>
