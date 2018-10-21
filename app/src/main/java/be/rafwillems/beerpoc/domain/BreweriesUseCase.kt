package be.rafwillems.beerpoc.domain

import be.rafwillems.beerpoc.data.RetrofitDataStore
import be.rafwillems.beerpoc.data.model.Brewery
import be.rafwillems.beerpoc.data.model.LoginResult
import io.reactivex.Single

class BreweriesUseCase(private val retrofitDataStore: RetrofitDataStore) {

    fun breweries(): Single<List<Brewery>> {
        return retrofitDataStore.getBreweries()
    }

}
