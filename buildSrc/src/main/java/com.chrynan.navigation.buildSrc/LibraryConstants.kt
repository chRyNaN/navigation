@file:Suppress("MemberVisibilityCanBePrivate")

package com.chrynan.navigation.buildSrc

object LibraryConstants {

    const val group = "com.chrynan.navigation"
    const val owner = "chrynan"
    const val repoName = "navigation"
    const val versionName = "0.4.0"
    const val versionCode = 6
    const val versionDescription = "Release $versionName ($versionCode)"
    const val license = "Apache-2.0"
    const val vcsUrl = "https://github.com/chRyNaN/navigation.git"

    object Android {

        const val compileSdkVersion = 31
        const val minSdkVersion = 25
        const val targetSdkVersion = 31
    }
}
