package ar.prasher.fakestore.di

import android.content.Context
import androidx.lifecycle.ViewModel
import ar.prasher.fakestore.MainActivity
import ar.prasher.fakestore.db.DatabaseModule
import ar.prasher.fakestore.viewmodels.ViewModelModule
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [NetworkModule::class, DatabaseModule::class,ViewModelModule::class])//can use modules to create interfaces
interface ApplicationComponent {

    //field injection
    fun startInjecting(mainActivity: MainActivity)


    fun getMap() : Map<String,ViewModel>

    //now everytime dagger needs context it will get
    //it from here
    //as we have bind the component with context in factory
    @Component.Factory
    interface Factory{
        fun create(@BindsInstance context : Context) : ApplicationComponent
    }

}