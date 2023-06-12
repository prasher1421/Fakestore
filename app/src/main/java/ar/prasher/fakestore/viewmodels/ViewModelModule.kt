package ar.prasher.fakestore.viewmodels

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import dagger.multibindings.StringKey


@Module
abstract class ViewModelModule {

    @Binds //now everytime ViewModel is called it will be MainViewModel
    @StringKey("mainViewModel")
    @IntoMap //map system we will use the above key to access it
    abstract fun mainViewModel(mainViewModel: MainViewModel) : ViewModel

    //if it actually existed then there would be a collision
    //so we use multibinding
//    @Binds
//    @StringKey("mainViewModel2")
//    @IntoMap
//    abstract fun mainViewModel2(mainViewModel2: MainViewModel2) : ViewModel
}