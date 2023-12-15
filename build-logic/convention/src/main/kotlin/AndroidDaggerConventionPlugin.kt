import kaa.alisherbu.listbook.implementation
import kaa.alisherbu.listbook.kapt
import kaa.alisherbu.listbook.library
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

class AndroidDaggerConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("org.jetbrains.kotlin.kapt")
            }

            dependencies {
                implementation(library("dagger-dagger"))
                kapt(library("dagger-compiler"))
            }
        }
    }
}
