plugins {
    id("myproject.android.library")
    id("myproject.android.compose")
    id("myproject.android.hilt")
    alias(libs.plugins.dependency.analysis)
}

android {
    namespace = "cz.vostinak.presentation"

    buildFeatures {
        compose = true
    }
}

dependencies {
    implementation(project(":core-ui"))
    implementation(project(":domain"))

    // Compose
    implementation(libs.androidx.material.icons.extended)

    // Coil
    implementation(libs.coil.compose)

    // Unit testing
    testImplementation(libs.mockito.core)
    testImplementation(libs.mockito.inline)
    testImplementation(libs.mockito.kotlin)
    testImplementation(libs.kotlinx.coroutines.test)
    testImplementation(libs.androidx.core.testing)
    testImplementation(libs.hilt.android.testing)
}