plugins {
    id("myproject.android.library")
    id("myproject.android.compose")
    alias(libs.plugins.kotlin.compose)
    alias(libs.plugins.dependency.analysis)
}

android {
    namespace = "cz.vostinak.core.ui"
}