import java.util.Properties

plugins {
    id("myproject.android.library")
    id("myproject.android.hilt")
    alias(libs.plugins.dependency.analysis)
}

android {
    namespace = "cz.vostinak.data"
}

dependencies {
    // Retrofit
    implementation(libs.retrofit)
    implementation(libs.converter.gson)

    // OkHttp
    implementation(libs.okhttp)
    implementation(libs.okhttp.logging.interceptor)
}