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
}

@ExperimentalNavigationApi
interface ComposeNavigationIntentScope<I : NavigationIntent> : ComposeNavigationKeyScope<I> {

    override val navigator: ComposeNavigationIntentStackNavigatorByKey<I>
}

@ExperimentalNavigationApi
interface ComposeNavigationContentScope<K> : ComposeNavigationScope {

    val navigator: ComposeStackNavigatorByContent<K>
}
