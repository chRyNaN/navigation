package com.chrynan.navigation.compose

import com.chrynan.navigation.NavigationIntent
import com.chrynan.navigation.NavigationScope

@ExperimentalNavigationApi
interface ComposeNavigationScope : NavigationScope {

    companion object : ComposeNavigationScope
}

@ExperimentalNavigationApi
interface ComposeNavigationKeyScope<K> : ComposeNavigationScope {

    val navigator: ComposeStackNavigatorByKey<K>

    companion object
}

@ExperimentalNavigationApi
interface ComposeNavigationIntentScope<I : NavigationIntent> : ComposeNavigationKeyScope<I> {

    override val navigator: ComposeNavigationIntentStackNavigatorByKey<I>

    companion object
}

@ExperimentalNavigationApi
interface ComposeNavigationContentScope<K> : ComposeNavigationScope {

    val navigator: ComposeStackNavigatorByContent<K>

    companion object
}
