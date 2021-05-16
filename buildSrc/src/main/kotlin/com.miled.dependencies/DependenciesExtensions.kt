import org.gradle.api.artifacts.ProjectDependency
import org.gradle.kotlin.dsl.DependencyHandlerScope
import org.gradle.kotlin.dsl.project
import org.gradle.plugin.use.PluginDependenciesSpec

// https://guides.gradle.org/migrating-build-logic-from-groovy-to-kotlin/#configurations-and-dependencies
// Private methods exist to hide the "dirty" implementation from public methods.

private fun PluginDependenciesSpec.plugin(plugin: String) = id(plugin)

fun PluginDependenciesSpec.plugins(vararg plugins: String) = plugins.forEach { plugin(it) }

private fun DependencyHandlerScope.kapt(dependency: String) = "kapt"(dependency)

fun DependencyHandlerScope.kapts(vararg dependencies: String) = dependencies.forEach { kapt(it) }

private fun DependencyHandlerScope.implementation(dependency: String) = "implementation"(dependency)

private fun DependencyHandlerScope.testImplementation(dependency: String) =
    "testImplementation"(dependency)

fun DependencyHandlerScope.implementations(vararg dependencies: String) =
    dependencies.forEach { implementation(it) }

fun DependencyHandlerScope.testImplementations(vararg dependencies: String) =
    dependencies.forEach { testImplementation(it) }

private fun DependencyHandlerScope.implementation(dependency: ProjectDependency) =
    "implementation"(dependency)

fun DependencyHandlerScope.implementationProjects(vararg dependencies: String) {
    dependencies.map { project(it) }
        .forEach { implementation(it) }
}
