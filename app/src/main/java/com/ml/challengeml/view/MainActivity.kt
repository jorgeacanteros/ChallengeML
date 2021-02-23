package com.ml.challengeml.view

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import com.ml.challengeml.contract.BuscadorContract
import com.ml.challengeml.databinding.ActivityMainBinding
import com.ml.challengeml.presenter.BuscadorPresenter
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() , SearchView.OnQueryTextListener, BuscadorContract.view {

    private lateinit var buscadorPresenter: BuscadorPresenter
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        init()
    }

    private fun init() {
        buscadorPresenter= BuscadorPresenter()
        binding.txtSearch.setOnQueryTextListener(this)
    }

    override  fun onQueryTextSubmit(query: String?): Boolean {
        Toast.makeText(this, "buscando", Toast.LENGTH_SHORT).show()
         if (!query.isNullOrEmpty()) {
             CoroutineScope(Dispatchers.IO).launch {
                 buscadorPresenter.buscar(query)
             }

           return false
        }
         else return false

    }

    override fun onQueryTextChange(newText: String?): Boolean {
        return false
    }


}