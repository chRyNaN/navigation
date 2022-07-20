package com.chrynan.navigation.compose

import com.chrynan.navigation.ExperimentalNavigationApi
import com.chrynan.navigation.NavigationScope

@ExperimentalNavigationApi
interface ComposeNavigationScope : NavigationScope {

    companion object : ComposeNavigationScope
}
