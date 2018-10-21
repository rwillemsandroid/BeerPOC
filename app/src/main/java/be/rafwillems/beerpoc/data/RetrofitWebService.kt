package be.rafwillems.beerpoc.data

import be.rafwillems.beerpoc.data.model.Brewery
import be.rafwillems.beerpoc.data.model.ExampleObject
import be.rafwillems.beerpoc.data.model.LoginResult
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface RetrofitWebService {
    @GET("example")
    fun getExampleObject(): Single<ExampleObject>

    @GET("login/{username}")
    fun doLogin(@Path("username") username: String): Single<LoginResult>

    @GET("brewery")
    fun getBreweries(): Single<List<Brewery>>
}
