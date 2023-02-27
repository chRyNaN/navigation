import com.chrynan.navigation.buildSrc.LibraryConstants
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("com.android.application")
    kotlin("android")
    id("org.jetbrains.compose")
}

group = LibraryConstants.group
version = LibraryConstants.versionName

android {
    compileSdk = 33
    buildToolsVersion = "30.0.3"

    defaultConfig {
        applicationId = "com.chrynan.navigation.sample.compose"
        minSdk = 26
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("release") {
            proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    tasks.withType<KotlinCompile> {
        kotlinOptions {
            jvmTarget = "1.8"
            // Opt-in to experimental compose APIs
            freeCompilerArgs = listOf(
                "-Xopt-in=kotlin.RequiresOptIn"
            )
        }
    }
}

tasks.withType<Jar> { duplicatesStrategy = DuplicatesStrategy.INHERIT }

dependencies {
    implementation("androidx.core:core-ktx:1.9.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.6.1")

    implementation(compose.runtime)
    implementation(compose.ui)
    implementation(compose.material)

    implementation("androidx.compose.compiler:compiler:1.4.3")
    implementation("androidx.compose.ui:ui-tooling:1.4.0-beta02")
    implementation("androidx.activity:activity-compose:1.6.1")
    implementation("androidx.compose.material:material-icons-extended:1.4.0-beta02")

    implementation("com.chrynan.presentation:presentation-compose:0.7.1")
    implementation("com.chrynan.colors:colors-compose:0.7.2")

    implementation(project(":navigation-compose"))
}
