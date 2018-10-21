package be.rafwillems.beerpoc.data

import be.rafwillems.beerpoc.data.model.ExampleObject
import be.rafwillems.beerpoc.data.model.LoginResult
import io.reactivex.Single

class RetrofitDataStore(private val retrofitWebService: RetrofitWebService) {
    fun loadTest(): Single<ExampleObject> = retrofitWebService.getExampleObject()
    fun doLogin(username: String): Single<LoginResult> = retrofitWebService.doLogin(username)

}
