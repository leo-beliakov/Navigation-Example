package extensions

import com.android.build.api.dsl.CommonExtension
import library
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

/**
 * Configures the Compose settings & dependencies for a given project extension.
 */
fun Project.configureCompose(
    extension: CommonExtension<*, *, *, *, *, *>
) = with(extension) {
    buildFeatures {
        compose = true
    }

    dependencies {
        val bom = library("androidx-compose-bom")
        add("implementation", platform(bom))
        add("implementation", library("androidx.ui"))
        add("implementation", library("androidx.ui.graphics"))
        add("implementation", library("androidx.ui.tooling.preview"))
        add("implementation", library("androidx.material3"))
        add("implementation", library("androidx.activity.compose"))
        add("implementation", library("androidx.navigation.compose"))

        // Tests
        add("androidTestImplementation", platform(bom))
    }
}