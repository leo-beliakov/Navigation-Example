plugins {
    alias(libs.plugins.navtest.android.feature)
    alias(libs.plugins.navtest.hilt)
}

android {
    namespace = "com.leoapps.splash"
}

dependencies {
    implementation(project(":features:onboarding"))
    implementation(project(":features:auth"))
}
