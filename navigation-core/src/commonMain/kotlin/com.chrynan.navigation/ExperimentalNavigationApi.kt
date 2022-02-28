package com.chrynan.navigation

/**
 * Indicates that the component annotated with this annotation is experimental and could change or be removed in the
 * future.
 */
@RequiresOptIn(level = RequiresOptIn.Level.WARNING)
@Target(
    AnnotationTarget.CLASS,
    AnnotationTarget.FUNCTION,
    AnnotationTarget.FIELD,
    AnnotationTarget.PROPERTY
)
@MustBeDocumented
@Retention(AnnotationRetention.BINARY)
annotation class ExperimentalNavigationApi
