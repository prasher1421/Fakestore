package ar.prasher.fakestore.di

import ar.prasher.fakestore.MainActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [NetworkModule::class])//can use modules to create interfaces
interface ApplicationComponent {

    //field injection
    fun startInjecting(mainActivity: MainActivity)

}