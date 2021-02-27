package com.ml.challengeml.view

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.ml.challengeml.R
import com.ml.challengeml.contract.BuscadorContract
import com.ml.challengeml.databinding.ActivityMainBinding
import com.ml.challengeml.model.ProductModel
import com.ml.challengeml.presenter.BuscadorPresenter
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

import android.widget.LinearLayout

import androidx.appcompat.app.AppCompatActivity

import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment.findNavController
import androidx.navigation.fragment.findNavController


import com.ml.challengeml.model.SearchResponse

import kotlinx.android.synthetic.main.activity_main.view.*
import kotlinx.android.synthetic.main.fragment_search.*


import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import okhttp3.ResponseBody



class SearchFragment : Fragment(), SearchView.OnQueryTextListener, BuscadorContract.view, SearchAdapter.OnProductClickListener {

    private lateinit var buscadorPresenter: BuscadorPresenter
    private lateinit var adapterSearch: SearchAdapter
    private var emptyList = mutableListOf<ProductModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_search, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {
        adapterSearch= SearchAdapter(emptyList, this)
        buscadorPresenter= BuscadorPresenter()
        txtSearch.setOnQueryTextListener(this)
        recyProduct.layoutManager = LinearLayoutManager(requireContext())
        recyProduct.adapter= adapterSearch
    }

    override  fun onQueryTextSubmit(query: String?): Boolean {

        /*LLevar esta logica al presenter*/


        if (!query.isNullOrEmpty()) {
            CoroutineScope(Dispatchers.IO).launch {
                val response = buscadorPresenter.buscar(query)
                getActivity()?.runOnUiThread{
                    if (response.isSuccessful) {
                        val product: List<ProductModel> = response.body()?.results ?: emptyList()
                        emptyList.clear()
                        emptyList.addAll(product)
                        adapterSearch.notifyDataSetChanged()

                    }
                //    else Toast.makeText(applicationContext,"error al cargar", Toast.LENGTH_LONG).show()

                }
            }


        }


        return false
    }

    override fun onQueryTextChange(newText: String?): Boolean {
        return false
    }

    override fun onProductClick(product: ProductModel) {
        val bundle= Bundle()
        bundle.putParcelable("product",product)
        findNavController().navigate(R.id.detailSearchFragment,bundle)
    }
}