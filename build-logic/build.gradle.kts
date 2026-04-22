plugins {
    `kotlin-dsl`
}

repositories {
    google()
    mavenCentral()
}

dependencies {
    implementation("com.android.tools.build:gradle:8.7.3")
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:2.0.10")
    implementation("com.google.dagger:hilt-android-gradle-plugin:2.51.1")
    implementation("org.jetbrains.kotlin.plugin.compose:org.jetbrains.kotlin.plugin.compose.gradle.plugin:2.0.10")
}

gradlePlugin {
    plugins {
        register("androidLibrary") {
            id = "myproject.android.library"
            implementationClass = "AndroidLibraryConventionPlugin"
        }
        register("androidCompose") {
            id = "myproject.android.compose"
            implementationClass = "AndroidComposeConventionPlugin"
        }
        register("androidHilt") {
            id = "myproject.android.hilt"
            implementationClass = "AndroidHiltConventionPlugin"
        }
    }
}