plugins {
    id("myproject.android.library")
    alias(libs.plugins.realm.plugin)
    id("com.google.devtools.ksp")
    id("com.google.dagger.hilt.android")
    alias(libs.plugins.dependency.analysis)
}

android {
    namespace = "cz.vostinak.realm"
}

dependencies {
    // Hilt
    implementation(libs.hilt)
    ksp(libs.hilt.compiler)

    // Realm
    implementation(libs.library.base)
    implementation(libs.kotlinx.coroutines.core)
    // implementation("io.realm.kotlin:library-sync:1.16.0")
}