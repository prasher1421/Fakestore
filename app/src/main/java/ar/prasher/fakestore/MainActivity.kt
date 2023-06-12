package ar.prasher.fakestore

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import ar.prasher.fakestore.viewmodels.MainViewModel
import ar.prasher.fakestore.viewmodels.MainViewModelFactory
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    lateinit var mainViewModel: MainViewModel

    @Inject
    lateinit var mainViewModelFactory: MainViewModelFactory

    private val products : TextView
        get() = findViewById(R.id.products)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //application component field injection
        (application as FakerApplication).applicationComponent
            .startInjecting(this)

        val map = (application as FakerApplication)
            .applicationComponent
            .getMap()

        mainViewModel = ViewModelProvider(
            this,
            mainViewModelFactory
        )[MainViewModel::class.java]


        mainViewModel.productsLiveData.observe(this, Observer {
            products.text = it.joinToString { x -> x.title + "\n\n"} //appends title
        })

    }
}