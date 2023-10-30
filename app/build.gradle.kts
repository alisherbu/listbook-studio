@file:Suppress("DSL_SCOPE_VIOLATION", "UnstableApiUsage")

plugins {
    alias(libs.plugins.listbook.android.application)
    alias(libs.plugins.listbook.android.application.compose)
    alias(libs.plugins.listbook.android.dagger)
    alias(libs.plugins.kotlin.parcelize)
    alias(libs.plugins.google.services)
}

android {
    namespace = "kaa.alisherbu.listbook"

    defaultConfig {
        applicationId = "kaa.alisherbu.listbookstudio"
        versionCode = libs.versions.versionCode.get().toInt()
        versionName = libs.versions.versionName.get()

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro",
            )
        }
    }
    packaging {
        resources {
            excludes += setOf("/META-INF/{AL2.0,LGPL2.1}")
        }
    }

    buildFeatures {
        buildConfig = true
    }
}

dependencies {

    implementation(libs.accompanist.systemuicontroller)
    implementation(libs.androidx.coreKtx)
    implementation(libs.androidx.lifecycle.runtimeKtx)
    implementation(libs.androidx.activity.compose)
    implementation(libs.androidx.compose.material3)
    implementation(libs.arkivanov.decompose.decompose)
    implementation(libs.arkivanov.decompose.extensionsComposeJetpack)
    implementation(libs.arkivanov.mvikotlin.mvikotlin)
    implementation(libs.arkivanov.mvikotlin.logging)
    implementation(libs.arkivanov.mvikotlin.main)
    implementation(libs.google.firebase.core)
    implementation(libs.google.firebase.auth)
    implementation(libs.google.firebase.firestore)
    implementation(libs.exoplayer)
    implementation(libs.timber)

    implementation(projects.core.shared)
    implementation(projects.feature.root)
}
