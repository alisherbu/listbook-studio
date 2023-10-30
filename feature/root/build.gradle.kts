@file:Suppress("DSL_SCOPE_VIOLATION", "UnstableApiUsage")

plugins {
    alias(libs.plugins.listbook.android.feature)
    alias(libs.plugins.kotlin.parcelize)
}

android {
    namespace = "kaa.alisherbu.listbook.feature.root"
}

dependencies {
    implementation(libs.google.firebase.auth)

    implementation(projects.core.shared)
}
