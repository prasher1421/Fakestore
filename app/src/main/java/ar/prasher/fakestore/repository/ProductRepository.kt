package ar.prasher.fakestore.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import ar.prasher.fakestore.db.FakerDB
import ar.prasher.fakestore.models.Product
import ar.prasher.fakestore.retrofit.FakerAPI
import javax.inject.Inject


class ProductRepository @Inject constructor(
    private val fakerAPI: FakerAPI, //provided by dagger
    private val fakerDB : FakerDB
){

    //unexposed mutable live data from the api
    private val _products = MutableLiveData<List<Product>>()
    //exposed live data from api
    val products : LiveData<List<Product>>
        get() = _products


    suspend fun getProducts(){
        val result = fakerAPI.getProducts()
        fakerDB.getFakerDAO().addProducts(result.body()!!)
        if (result.isSuccessful && result.body() != null){
            _products.postValue(result.body())
        }

    }

}