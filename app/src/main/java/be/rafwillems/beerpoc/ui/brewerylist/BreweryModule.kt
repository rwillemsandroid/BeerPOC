package be.rafwillems.beerpoc.ui.brewerylist

import be.rafwillems.beerpoc.data.RetrofitDataStore
import be.rafwillems.beerpoc.di.PerScreen
import be.rafwillems.beerpoc.domain.BreweriesUseCase
import be.rafwillems.beerpoc.domain.LoginUseCase
import dagger.Module
import dagger.Provides

@Module
class BreweryModule {
    @PerScreen
    @Provides
    fun provideBreweryRepo(retrofitDataStore: RetrofitDataStore) = BreweriesUseCase(retrofitDataStore)
}
