import com.chrynan.navigation.buildSrc.LibraryConstants
import com.chrynan.navigation.buildSrc.isBuildingOnLinux
import com.chrynan.navigation.buildSrc.isBuildingOnOSX
import com.chrynan.navigation.buildSrc.isBuildingOnWindows
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("multiplatform")
    id("com.android.library")
    id("maven-publish")
    id("org.jetbrains.dokka")
    kotlin("plugin.serialization")
}

group = LibraryConstants.group
version = LibraryConstants.versionName

kotlin {
    android {
        publishAllLibraryVariants()
        publishLibraryVariantsGroupedByFlavor = true
    }

    targets {
        // Enable the default target hierarchy:
        targetHierarchy.default()

        android()

        jvm()

        js(IR) {
            browser {
                testTask {
                    useKarma {
                        useFirefox()
                    }
                }
            }
            nodejs()
        }

        if (isBuildingOnOSX()) {
            ios()
            iosSimulatorArm64()
            tvos()
            watchos()
            macosX64()
            macosArm64()
        }

        if (isBuildingOnLinux()) {
            linuxX64()
        }

        if (isBuildingOnWindows()) {
            mingwX64()
        }
    }
    sourceSets {
        all {
            languageSettings.optIn("kotlin.RequiresOptIn")
        }

        val commonMain by getting {
            dependencies {
                implementation(Kotlin.stdlib.common)

                implementation(KotlinX.coroutines.core)
                api(KotlinX.serialization.core)
            }
        }

        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
                implementation(KotlinX.coroutines.test)
            }
        }

        val nativeMain by sourceSets.getting
    }
}

android {
    compileSdk = LibraryConstants.Android.compileSdkVersion

    defaultConfig {
        minSdk = LibraryConstants.Android.minSdkVersion
        targetSdk = LibraryConstants.Android.targetSdkVersion
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

    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
    sourceSets["main"].java.srcDirs("src/androidMain/kotlin")
    sourceSets["main"].res.srcDirs("src/androidMain/res")

    sourceSets["test"].java.srcDirs("src/androidTest/kotlin")
    sourceSets["test"].res.srcDirs("src/androidTest/res")
}

tasks.withType<Jar> { duplicatesStrategy = DuplicatesStrategy.INHERIT }

// Android Specific Dependencies
dependencies {
    implementation(AndroidX.activity.ktx)
    implementation(AndroidX.fragment.ktx)
    implementation(AndroidX.core.ktx)
    implementation(AndroidX.appCompat)

    api(AndroidX.lifecycle.viewModelKtx)
}

afterEvaluate {
    publishing {
        repositories {
            maven {
                url = uri("https://repo.repsy.io/mvn/chrynan/public")

                credentials {
                    username = (project.findProperty("repsyUsername") ?: System.getenv("repsyUsername")) as? String
                    password = (project.findProperty("repsyToken") ?: System.getenv("repsyToken")) as? String
                }
            }
        }
    }
}
