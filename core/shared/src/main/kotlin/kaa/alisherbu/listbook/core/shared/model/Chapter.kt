package kaa.alisherbu.listbook.core.shared.model

data class Chapter(
    val id: String,
    val bookId: String,
    val audioUrl: String,
    val name: String,
    val isDownloaded: Boolean
)