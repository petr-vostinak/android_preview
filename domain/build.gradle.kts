plugins {
    id("myproject.android.library")
    id("myproject.android.hilt")
    alias(libs.plugins.dependency.analysis)
}

android {
    namespace = "cz.vostinak.domain"
}

dependencies {
    implementation(project(":data-realm"))
    implementation(project(":data-room"))
    implementation(project(":data-api"))
    implementation(project(":core-ui"))

    // Realm
    implementation(libs.library.base)

    // Testing
    testImplementation(libs.junit)
    testImplementation(libs.mockito.core)
    testImplementation(libs.mockito.inline)
    testImplementation(libs.mockito.kotlin)
    testImplementation(libs.kotlinx.coroutines.test)
}