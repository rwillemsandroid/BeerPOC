package be.rafwillems.beerpoc.ui.login

import be.rafwillems.beerpoc.di.AppComponent
import be.rafwillems.beerpoc.di.PerScreen
import dagger.Component

@PerScreen
@Component(
        modules = arrayOf(LoginModule::class),
        dependencies = arrayOf(AppComponent::class)
)
interface LoginComponent {
    fun presenter(): LoginPresenter
}
