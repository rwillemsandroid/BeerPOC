package be.rafwillems.beerpoc.di

import android.app.Application
import be.rafwillems.beerpoc.data.RetrofitDataStore
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(WebDataModule::class))
interface AppComponent {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder
        fun build(): AppComponent
    }

    fun retrofitDataStore(): RetrofitDataStore
}

