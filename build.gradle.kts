@file:Suppress("DSL_SCOPE_VIOLATION", "UnstableApiUsage")

import io.gitlab.arturbosch.detekt.Detekt

plugins {
    alias(libs.plugins.detekt)
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.android.library) apply false
    alias(libs.plugins.kotlin.android) apply false
    alias(libs.plugins.kotlin.parcelize) apply false
    alias(libs.plugins.google.services) apply false
    alias(libs.plugins.google.ksp) apply false
    alias(libs.plugins.kotlin.jvm) apply false
    alias(libs.plugins.kotlin.kapt) apply false
}

/*
Allows to run detekt for all files in the Gradle project
and all subprojects without a need to configure detekt plugin in every subproject.
 */
tasks.register("detektCheck", Detekt::class) {
    parallel = true
    setSource(file(projectDir))

    config.setFrom("$projectDir/config/detekt/detekt.yml")

    include("**/*.kt", "**/*.kts")
    exclude("**/resources/**", "**/build/**", "**/generated/**", "**/.gradle/**")
    dependencies {
        detektPlugins(libs.detekt.formatting)
        detektPlugins(libs.detekt.compose)
        detektPlugins(libs.detekt.ruleauthors)
    }
}
