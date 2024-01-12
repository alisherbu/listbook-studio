package kaa.alisherbu.listbookstudio.shared.dialog

interface MessageDialogComponent {
    val message: String
    fun onDismissClicked()
}