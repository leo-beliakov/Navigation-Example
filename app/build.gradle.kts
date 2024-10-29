plugins {
    alias(libs.plugins.navtest.android.application)
    alias(libs.plugins.navtest.hilt)
}

android {
    namespace = "com.leoapps.navigationtest"

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
}

dependencies {
    implementation(project(":features:splash"))
    implementation(project(":features:onboarding"))
    implementation(project(":features:main"))
    implementation(project(":features:auth"))
    implementation(project(":features:home"))
    implementation(project(":features:chat"))
    implementation(project(":features:profile"))
    implementation(project(":common:ui"))
    implementation(project(":common:mvi"))
    implementation(project(":common:navigation"))
}