package com.chrynan.navigation.compose

import com.chrynan.navigation.NavigationIntent
import com.chrynan.navigation.NavigationScope

@ExperimentalNavigationApi
interface ComposeNavigationScope : NavigationScope {

    companion object : ComposeNavigationScope
}

@ExperimentalNavigationApi
interface ComposeNavigationKeyScope<Context, Key> : ComposeNavigationScope {

    val navigator: ComposeNavigatorByKey<Context, Key>

    companion object
}

@ExperimentalNavigationApi
interface ComposeNavigationIntentScope<Context, Intent : NavigationIntent> : ComposeNavigationScope,
    ComposeNavigationKeyScope<Context, Intent> {

    override val navigator: ComposeNavigationIntentStackNavigatorByKey<Context, Intent>

    companion object
}

@ExperimentalNavigationApi
interface ComposeNavigationContentScope<Context, Key> : ComposeNavigationScope {

    val navigator: ComposeNavigatorByContent<Context, Key>

    companion object
}
