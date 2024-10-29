plugins {
    alias(libs.plugins.navtest.android.feature)
    alias(libs.plugins.navtest.hilt)
}

android {
    namespace = "com.leoapps.main"
}

dependencies {
    implementation(project(":features:home"))
    implementation(project(":features:chat"))
    implementation(project(":features:profile"))
}