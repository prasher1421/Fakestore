package ar.prasher.fakestore.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import ar.prasher.fakestore.models.Product
import ar.prasher.fakestore.repository.ProductRepository
import kotlinx.coroutines.launch

//for constructor with properties we need a factory
class MainViewModel(private val repository: ProductRepository) : ViewModel() {

    val productsLiveData : LiveData<ArrayList<Product>>
    get() =  repository.products


    init {

        viewModelScope.launch {
            repository.getProducts()
        }

    }

}