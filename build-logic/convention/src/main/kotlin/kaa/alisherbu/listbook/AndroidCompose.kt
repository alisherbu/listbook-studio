@file:Suppress("UnstableApiUsage")

package kaa.alisherbu.listbook

import org.gradle.api.Project
import com.android.build.api.dsl.CommonExtension
import org.gradle.kotlin.dsl.dependencies

internal fun Project.configureAndroidCompose(
    commonExtension: CommonExtension<*, *, *, *, *>,
) {
    commonExtension.apply {
        buildFeatures {
            compose = true
        }
        composeOptions {
            kotlinCompilerExtensionVersion = "1.5.3"
        }
        dependencies {
            val bom = library("androidx-compose-bom")
            implementation(platform(bom))
        }
    }
}