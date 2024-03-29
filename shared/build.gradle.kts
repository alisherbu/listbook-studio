@file:Suppress("DSL_SCOPE_VIOLATION", "OPT_IN_USAGE")

plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.parcelize)
    alias(libs.plugins.kotlin.serialization)
}

kotlin {
    targetHierarchy.default()
    androidTarget {
        compilations.all {
            kotlinOptions {
                jvmTarget = JavaVersion.VERSION_17.toString()
            }
        }
    }
    listOf(iosX64(), iosArm64(), iosSimulatorArm64()).forEach {
        it.binaries.framework {
            baseName = "shared" // Used in app-ios-swift
            isStatic = true
            export(libs.arkivanov.decompose.decompose)
            export(libs.arkivanov.essenty.lifecycle)
        }
    }
    sourceSets {
        val commonMain by getting {
            dependencies {
                api(libs.arkivanov.decompose.decompose)
                api(libs.arkivanov.essenty.lifecycle)
                implementation(libs.arkivanov.mvikotlin.main)
                implementation(libs.arkivanov.mvikotlin.mvikotlin)
                implementation(libs.arkivanov.mvikotlin.logging)
                implementation(libs.arkivanov.mvikotlin.coroutines)
                implementation(libs.arkivanov.mvikotlin.rx)
                implementation(libs.coroutines.core)
                implementation(libs.firebase.auth)
            }
        }
        val androidMain by getting {
            dependencies {

            }
        }
        val iosMain by getting {
            dependencies {

            }
        }

    }
}

android {
    namespace = "kaa.alisherbu.listbookstudio.shared"
    compileSdk = 34

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    buildFeatures {
        buildConfig = true
    }
}