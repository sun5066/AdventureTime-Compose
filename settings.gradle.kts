pluginManagement {
    includeBuild("build-logic")
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}
rootProject.name = "adventure_time"
include(
    ":app",
    ":core:core-network",
    ":core:core-database",
    ":core:core-data",
    ":common:common-model",
    ":common:common-ui",
    ":common:common-util",
)