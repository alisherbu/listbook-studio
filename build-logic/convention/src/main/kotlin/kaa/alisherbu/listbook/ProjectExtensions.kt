/*
 * Copyright 2023 The Android Open Source Project
 *
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 *
 *       https://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 */

package kaa.alisherbu.listbook

import org.gradle.api.Project
import org.gradle.api.artifacts.MinimalExternalModuleDependency
import org.gradle.api.artifacts.VersionCatalog
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.api.artifacts.dsl.DependencyHandler
import org.gradle.api.provider.Provider
import org.gradle.kotlin.dsl.getByType

val Project.libs
    get(): VersionCatalog = extensions.getByType<VersionCatalogsExtension>().named("libs")

fun DependencyHandler.implementation(dependencyNotation: Provider<MinimalExternalModuleDependency>) {
    add("implementation", dependencyNotation)
}

fun DependencyHandler.debugImplementation(dependencyNotation: Provider<MinimalExternalModuleDependency>) {
    add("debugImplementation", dependencyNotation)
}

fun DependencyHandler.kapt(dependencyNotation: Provider<MinimalExternalModuleDependency>) {
    add("kapt", dependencyNotation)
}

fun Project.library(alias: String): Provider<MinimalExternalModuleDependency> {
    return libs.findLibrary(alias).get()
}
