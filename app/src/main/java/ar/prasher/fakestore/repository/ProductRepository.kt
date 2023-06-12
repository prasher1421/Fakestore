package ar.prasher.fakestore.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import ar.prasher.fakestore.models.Product
import ar.prasher.fakestore.retrofit.FakerAPI
import javax.inject.Inject


class ProductRepository @Inject constructor(
    private val fakerAPI: FakerAPI //provided by dagger
){

    //unexposed mutable live data from the api
    private val _products = MutableLiveData<ArrayList<Product>>()
    //exposed live data from api
    val products : LiveData<ArrayList<Product>>
        get() = _products


    suspend fun getProducts(){
        val result = fakerAPI.getProducts()

        if (result.isSuccessful && result.body() != null){
            _products.postValue(result.body())
        }

    }

}