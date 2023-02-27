package com.chrynan.navigation.buildSrc

import java.lang.System

fun isBuildingOnOSX(): Boolean {
    val osName = System.getProperty("os.name").toLowerCase()

    return osName.contains("mac os x") || osName.contains("darwin") || osName.contains("osx")
}
