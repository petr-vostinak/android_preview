plugins {
    id("myproject.android.library")
    id("myproject.android.hilt")
    alias(libs.plugins.dependency.analysis)
}

android {
    namespace = "cz.vostinak.room"
}

dependencies {
    // Room
    implementation(libs.androidx.room.runtime)
    ksp(libs.androidx.room.compiler)
}