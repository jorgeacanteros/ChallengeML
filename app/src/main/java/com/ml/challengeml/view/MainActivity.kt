package com.ml.challengeml.view

import android.os.Bundle
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import com.ml.challengeml.contract.BuscadorContract
import com.ml.challengeml.databinding.ActivityMainBinding
import com.ml.challengeml.model.ProductModel
import com.ml.challengeml.model.SearchResponse
import com.ml.challengeml.presenter.BuscadorPresenter
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import okhttp3.ResponseBody

class MainActivity : AppCompatActivity() , SearchView.OnQueryTextListener, BuscadorContract.view {

    private lateinit var buscadorPresenter: BuscadorPresenter
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapterSearch: SearchAdapter
    private var emptyList = mutableListOf<ProductModel>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        init()
    }

    private fun init() {
        adapterSearch= SearchAdapter(emptyList)
        buscadorPresenter= BuscadorPresenter()
        binding.txtSearch.setOnQueryTextListener(this)
        binding.recyProduct.layoutManager = LinearLayoutManager(this)
        binding.recyProduct.adapter= adapterSearch
    }

    override  fun onQueryTextSubmit(query: String?): Boolean {

        /*LLevar esta logica al presenter*/


            if (!query.isNullOrEmpty()) {
                CoroutineScope(Dispatchers.IO).launch {
                    val response =buscadorPresenter.buscar(query)
                    runOnUiThread {
                        if (response.isSuccessful) {
                            val product: List<ProductModel> = response.body()?.results ?: emptyList()
                                emptyList.clear()
                                emptyList.addAll(product)
                                adapterSearch.notifyDataSetChanged()

                        }
                        else Toast.makeText(applicationContext,"error al cargar",Toast.LENGTH_LONG).show()

                    }
                }


            }


        return false
    }

    override fun onQueryTextChange(newText: String?): Boolean {
        return false
    }


}