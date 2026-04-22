import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

/**
 * Convention plugin pro Hilt dependency injection.
 */
class AndroidHiltConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("com.google.devtools.ksp")
                apply("dagger.hilt.android.plugin")
            }

            dependencies {
                add("implementation", "com.google.dagger:hilt-android:2.51.1")
                add("ksp", "com.google.dagger:hilt-android-compiler:2.51.1")
                add("implementation", "androidx.hilt:hilt-navigation-compose:1.2.0")
            }
        }
    }
}