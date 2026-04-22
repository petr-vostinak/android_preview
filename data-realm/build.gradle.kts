plugins {
    id("myproject.android.library")
    id("myproject.android.hilt")
    alias(libs.plugins.realm.plugin)
    alias(libs.plugins.dependency.analysis)
}

android {
    namespace = "cz.vostinak.realm"
}

dependencies {
    // Realm
    implementation(libs.library.base)
    implementation(libs.kotlinx.coroutines.core)
    // implementation("io.realm.kotlin:library-sync:1.16.0")
}