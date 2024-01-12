package kaa.alisherbu.listbookstudio.shared.di

interface BuildInfo {
    val isDebug: Boolean
}

expect val buildInfo: BuildInfo
