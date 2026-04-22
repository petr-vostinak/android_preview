import com.android.build.gradle.LibraryExtension
import org.gradle.api.JavaVersion
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.getByType
import java.util.Properties

/**
 * Convention plugin pro všechny Android library moduly.
 * Nastavuje compileSdk, minSdk, compileOptions a společné dependencies.
 */
class AndroidLibraryConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            val libs = extensions.getByType<VersionCatalogsExtension>().named("libs")

            with(pluginManager) {
                apply(libs.findPlugin("android.library").get().get().pluginId)
                apply(libs.findPlugin("kotlin.android").get().get().pluginId)
            }

            extensions.configure<LibraryExtension> {
                compileSdk = 36

                defaultConfig {
                    minSdk = 24
                    testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
                }

                compileOptions {
                    sourceCompatibility = JavaVersion.VERSION_11
                    targetCompatibility = JavaVersion.VERSION_11
                }

                kotlinOptions {
                    jvmTarget = "11"
                }

                buildFeatures { buildConfig = true }
                val keystoreFile = project.rootProject.file("local.properties")
                val properties = Properties()
                properties.load(keystoreFile.inputStream())
                val apiKey = properties.getProperty("API_KEY") ?: ""

                buildTypes {
                    debug {
                        isMinifyEnabled = false
                        buildConfigField(
                            type = "String",
                            name = "API_KEY",
                            value = "\"$apiKey\""
                        )
                    }

                    release {
                        isMinifyEnabled = true
                        buildConfigField(
                            type = "String",
                            name = "API_KEY",
                            value = "\"$apiKey\""
                        )
                        proguardFiles(
                            getDefaultProguardFile("proguard-android-optimize.txt"),
                            "proguard-rules.pro"
                        )
                    }
                }
            }

            dependencies {
                add("implementation", libs.findLibrary("androidx.core.ktx").get())
                add("testImplementation", libs.findLibrary("junit").get())
                add("androidTestImplementation", libs.findLibrary("androidx.junit").get())
                add("androidTestImplementation", libs.findLibrary("androidx.espresso.core").get())
            }
        }
    }
}

fun LibraryExtension.kotlinOptions(block: org.jetbrains.kotlin.gradle.dsl.KotlinJvmOptions.() -> Unit) {
    (this as org.gradle.api.plugins.ExtensionAware)
        .extensions
        .configure("kotlinOptions", block)
}