package ar.prasher.fakestore.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import ar.prasher.fakestore.models.Product
import ar.prasher.fakestore.repository.ProductRepository
import kotlinx.coroutines.launch
import javax.inject.Inject

//for constructor with properties we need a factory
//we made it Injectable so that we can pass it to factory directly
class MainViewModel @Inject constructor(
    private val repository: ProductRepository
) : ViewModel() {

    val productsLiveData : LiveData<List<Product>>
    get() =  repository.products


    init {
        viewModelScope.launch {
            repository.getProducts()
        }

    }

}