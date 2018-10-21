package be.rafwillems.beerpoc.ui.login

import be.rafwillems.beerpoc.data.RetrofitDataStore
import be.rafwillems.beerpoc.di.PerScreen
import be.rafwillems.beerpoc.domain.LoginUseCase
import dagger.Module
import dagger.Provides

@Module
class LoginModule {
    @PerScreen
    @Provides
    fun provideLoginRepo(retrofitDataStore: RetrofitDataStore) = LoginUseCase(retrofitDataStore)
}
