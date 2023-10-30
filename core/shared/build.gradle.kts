@file:Suppress("DSL_SCOPE_VIOLATION", "UnstableApiUsage")

plugins {
    alias(libs.plugins.listbook.android.library)
    alias(libs.plugins.listbook.android.library.compose)
    alias(libs.plugins.kotlin.parcelize)
}

android {
    namespace = "kaa.alisherbu.listbook.core.shared"
}

dependencies {
    implementation(libs.androidx.compose.material3)
    implementation(libs.exoplayer)
    implementation(libs.timber)
}
