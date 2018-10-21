package be.rafwillems.beerpoc.ui.brewerylist

import be.rafwillems.beerpoc.di.AppComponent
import be.rafwillems.beerpoc.di.PerScreen
import be.rafwillems.beerpoc.ui.login.LoginModule
import be.rafwillems.beerpoc.ui.login.LoginPresenter
import dagger.Component

@PerScreen
@Component(
        modules = arrayOf(BreweryModule::class),
        dependencies = arrayOf(AppComponent::class)
)
interface BreweryComponent {
    fun presenter(): BreweryPresenter
}
