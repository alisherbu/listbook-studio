@file:Suppress("DSL_SCOPE_VIOLATION", "UnstableApiUsage")


plugins {
    alias(libs.plugins.android.application) apply false
}

tasks.register("clean").configure {
    delete("build")
}

