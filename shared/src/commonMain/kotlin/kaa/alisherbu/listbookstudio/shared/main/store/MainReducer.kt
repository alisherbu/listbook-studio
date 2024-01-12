package kaa.alisherbu.listbookstudio.shared.main.store

import com.arkivanov.mvikotlin.core.store.Reducer

internal class MainReducer : Reducer<MainState, Message> {
    override fun MainState.reduce(msg: Message): MainState {
        return when (msg) {
            is Message.PlayOrPause -> {
                copy(isPlaying = msg.isPlaying)
            }
        }
    }
}
