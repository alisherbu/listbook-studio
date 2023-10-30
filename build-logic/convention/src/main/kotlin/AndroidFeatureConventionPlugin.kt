import kaa.alisherbu.listbook.debugImplementation
import kaa.alisherbu.listbook.implementation
import kaa.alisherbu.listbook.library
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

class AndroidFeatureConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            pluginManager.apply {
                apply("listbook.android.library")
                apply("listbook.android.library.compose")
                apply("listbook.android.dagger")
                apply("kotlin-parcelize")
            }

            dependencies {
                implementation(library("arkivanov-mvikotlin-mvikotlin"))
                implementation(library("arkivanov-mvikotlin-coroutines"))
                implementation(library("arkivanov-decompose-decompose"))
                implementation(library("arkivanov-decompose-extensionsComposeJetpack"))
                implementation(library("androidx-compose-foundation"))
                implementation(library("androidx-compose-material3"))
                implementation(library("androidx-compose-material"))
                implementation(library("androidx-compose-constraintLayout"))
                implementation(library("androidx-compose-toolingPreview"))
                implementation(library("compose-coil"))
                implementation(library("timber"))
                debugImplementation(library("androidx-compose-tooling"))
            }
        }
    }
}