@file:Suppress("unused")

package com.chrynan.navigation.compose

internal sealed class ComposeNavigationEvent<Scope, Key>

internal data class ScopeEvent<Scope, Key>(val value: Scope) : ComposeNavigationEvent<Scope, Key>()

internal data class KeyEvent<Scope, Key>(val value: Key) : ComposeNavigationEvent<Scope, Key>()
