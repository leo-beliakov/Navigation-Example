pluginManagement {
    includeBuild("build-logic")
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "Navigation Test"
include(":app")
include(":common:ui")
include(":common:mvi")
include(":common:navigation")
include(":features:splash")
include(":features:onboarding")
include(":features:main")
include(":features:auth")
include(":features:home")
include(":features:profile")
include(":features:chat")
