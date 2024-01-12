package kaa.alisherbu.listbookstudio.shared.main.store

import com.arkivanov.mvikotlin.extensions.coroutines.CoroutineExecutor

internal class MainExecutor : CoroutineExecutor<Intent, Action, MainState, Message, Label>() {

    override fun executeAction(action: Action, getState: () -> MainState) {
        when (action) {
            Action.Init -> init()
        }
    }

    private fun init() {

    }
}
