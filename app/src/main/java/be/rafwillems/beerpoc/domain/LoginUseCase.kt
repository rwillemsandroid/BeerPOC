package be.rafwillems.beerpoc.domain

import be.rafwillems.beerpoc.data.RetrofitDataStore
import be.rafwillems.beerpoc.data.model.ExampleObject
import be.rafwillems.beerpoc.data.model.LoginResult
import io.reactivex.Single

class LoginUseCase(private val retrofitDataStore: RetrofitDataStore) {

    fun login(username: String): Single<LoginResult> {
        return retrofitDataStore.doLogin(username)
    }

}
