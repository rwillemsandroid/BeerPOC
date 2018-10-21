package be.rafwillems.beerpoc.di

import be.rafwillems.beerpoc.data.RetrofitDataStore
import be.rafwillems.beerpoc.data.RetrofitWebService
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory

@Module
class WebDataModule{

    @Provides
    fun provideWebService(): RetrofitWebService {
        val loggingInterceptor = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.HEADERS
        }

        val httpClient = OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor)
                .build()

        return Retrofit.Builder()
                .client(httpClient)
                .baseUrl("http://www.rafwillems.be/beerpoc/")
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(MoshiConverterFactory.create())
                .build()
                .create(RetrofitWebService::class.java)
    }

    @Provides
    fun provideDataStore(githubService: RetrofitWebService) = RetrofitDataStore(githubService)

}
