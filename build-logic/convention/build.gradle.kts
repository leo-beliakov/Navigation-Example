import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

// Applying the Kotlin DSL plugin to use Kotlin in Gradle build scripts.
plugins {
    `kotlin-dsl`
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}
tasks.withType<KotlinCompile>().configureEach {
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_17.toString()
    }
}

// Adding dependencies on various plugin,
dependencies {
    implementation(libs.android.gradle)
    implementation(libs.kotlin.serialization)
    implementation(libs.kotlin.gradle)
    implementation(libs.compose.gradle)
}

// Defining custom Gradle plugins for use in various project modules.
gradlePlugin {
    plugins {
        register("androidApplication") {
            id = "leoapps.android.application"
            implementationClass = "AndroidApplicationPlugin"
        }
        register("androidLibrary") {
            id = "leoapps.android.library"
            implementationClass = "AndroidLibraryPlugin"
        }
        register("androidFeature") {
            id = "leoapps.android.feature"
            implementationClass = "AndroidFeaturePlugin"
        }
        register("composeLibrary") {
            id = "leoapps.compose.library"
            implementationClass = "AndroidLibraryComposePlugin"
        }
        register("hilt") {
            id = "leoapps.hilt"
            implementationClass = "HiltPlugin"
        }
    }
}