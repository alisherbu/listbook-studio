package kaa.alisherbu.listbookstudio.shared.dialog

import com.arkivanov.decompose.ComponentContext

class MessageDialogComponentImpl(
    private val componentContext: ComponentContext,
    override val message: String,
    private val onDismissed: () -> Unit,
) : MessageDialogComponent, ComponentContext by componentContext {

    override fun onDismissClicked() {
        onDismissed()
    }
}
