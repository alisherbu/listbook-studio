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

allprojects {
    apply(plugin = rootProject.libs.plugins.detekt.get().pluginId)

    detekt {
        parallel = true
        config.setFrom("$rootDir/config/detekt/detekt.yml")
        baseline = file("$rootDir/config/detekt/baseline.xml")
        ignoredBuildTypes = listOf("release")
    }

    tasks.withType<Detekt>().configureEach {
        include("**/*.kt", "**/*.kts")
        reports {
            xml.required.set(false)
            html.required.set(false)
            txt.required.set(false)
            sarif.required.set(false)
            md.required.set(false)
        }
    }

    tasks.register<Detekt>("detektFormat") {
        autoCorrect = true
        parallel = true
        ignoreFailures = true
        config.setFrom("$rootDir/config/detekt/detekt.yml")
        include("**/*.kt", "**/*.kts")
        setSource(file(projectDir))
    }

    dependencies {
        detektPlugins(rootProject.libs.detekt.formatting)
        detektPlugins(rootProject.libs.detekt.compose)
    }
}

tasks.register("clean").configure {
    delete("build")
}

tasks.register<Copy>("copyGitHooks") {
    description = "Copies the git hooks from /config/hooks to the .git folder."
    group = "git hooks"
    from("$rootDir/config/hooks/pre-commit")
    into("$rootDir/.git/hooks/")
}

tasks.register<Exec>("installGitHooks") {
    description = "Installs git hooks from /config/hooks."
    group = "git hooks"
    workingDir = rootDir
    commandLine = listOf("chmod")
    args("-R", "+x", ".git/hooks/")
    dependsOn("copyGitHooks")
    doLast {
        logger.info("Git hook installed successfully.")
    }
}

tasks.register<Delete>("deleteGitHooks") {
    description = "Delete the pre-commit git hooks."
    group = "git hooks"
    delete(fileTree(".git/hooks/"))
}

afterEvaluate {
    tasks.getByPath(":app:assembleDebug")
        .dependsOn(":installGitHooks")
        .dependsOn(":detektFormat")
}
