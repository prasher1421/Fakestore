package ar.prasher.fakestore

import android.app.Application
import ar.prasher.fakestore.di.ApplicationComponent
import ar.prasher.fakestore.di.DaggerApplicationComponent
import dagger.Component

class FakerApplication : Application(){

    lateinit var applicationComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()

        applicationComponent = DaggerApplicationComponent
            .builder()
            .build()

    }
}