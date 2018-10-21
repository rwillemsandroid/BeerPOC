package be.rafwillems.beerpoc.di

import javax.inject.Scope

/**
 * Custom Scope for each Screen
 */
@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class PerScreen
