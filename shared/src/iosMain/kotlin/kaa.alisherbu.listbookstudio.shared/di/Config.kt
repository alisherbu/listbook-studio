package kaa.alisherbu.listbookstudio.shared.di

actual val buildInfo: BuildInfo = object : BuildInfo {
    override val isDebug: Boolean = Platform.isDebugBinary
}
