pluginManagement {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
        maven { url = uri("https://maven.pkg.jetbrains.space/public/p/compose/dev") }
        maven { url = uri("https://repo.repsy.io/mvn/chrynan/public") }
    }
}

plugins {
    // See https://jmfayard.github.io/refreshVersions
    id("de.fayard.refreshVersions") version "0.51.0"

    // See build.gradle.kts file in root project folder for the rest of the plugins applied.
}

rootProject.name = "navigation"

include(":navigation-core")
include(":navigation-compose")
include(":sample-compose")
