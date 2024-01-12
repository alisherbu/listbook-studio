package kaa.alisherbu.listbookstudio.shared.main.store

import com.arkivanov.mvikotlin.core.store.Store

internal sealed interface Intent {
    data object OpenPlayer : Intent
    data object PlayOrPause : Intent
}

internal sealed interface Label

internal sealed interface Action {
    data object Init : Action
}

internal sealed interface Message {
    class PlayOrPause(val isPlaying: Boolean) : Message
}

internal interface MainStore : Store<Intent, MainState, Label>
