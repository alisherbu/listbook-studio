package kaa.alisherbu.listbookstudio.shared.di

import kaa.alisherbu.listbookstudio.shared.BuildConfig


actual val buildInfo: BuildInfo = object : BuildInfo {
    override val isDebug: Boolean = BuildConfig.DEBUG
}