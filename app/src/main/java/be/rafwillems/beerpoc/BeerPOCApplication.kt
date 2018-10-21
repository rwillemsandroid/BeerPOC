package be.rafwillems.beerpoc

import android.app.Application
import be.rafwillems.beerpoc.di.AppComponent
import be.rafwillems.beerpoc.di.DaggerAppComponent
import timber.log.Timber

class BeerPOCApplication : Application() {
    companion object {
        lateinit var component: AppComponent
            private set
    }

    override fun onCreate() {
        super.onCreate()

        component = DaggerAppComponent.builder()
                .application(this)
                .build()

        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }
}
