package ar.prasher.fakestore.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import ar.prasher.fakestore.repository.ProductRepository
import javax.inject.Inject

class MainViewModelFactory @Inject constructor(
    private val mainViewModel: MainViewModel //instead of parameters we can directly use
    //the object provided by Dagger
) : ViewModelProvider.Factory{

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return mainViewModel as T
    }

}

// single factory for all viewModels

//class MainViewModelFactory @Inject constructor(
//    private val map : Map<String,@JvmSuppressWildcards ViewModel>
//) : ViewModelProvider.Factory{
//
//    override fun <T : ViewModel> create(modelClass: Class<T>): T {
//        return map[modelClass] as T
//    }
//}