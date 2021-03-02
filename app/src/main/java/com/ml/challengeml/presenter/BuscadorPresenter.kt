package com.ml.challengeml.presenter

import android.util.Log
import android.widget.Toast
import com.ml.challengeml.contract.BuscadorContract
import com.ml.challengeml.interactor.BuscadorInteractor
import com.ml.challengeml.interactor.Callback
import com.ml.challengeml.model.DetaidProductResponse
import com.ml.challengeml.model.ProductModel
import com.ml.challengeml.model.SearchResponse
import com.ml.challengeml.services.SearchProductService
import com.ml.challengeml.view.SearchFragment
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response

/**
 * Created by Jorge on 27,febrero,2021
 */

class BuscadorPresenter(fragment: SearchFragment) : BuscadorContract.presenter {

    private var view = fragment
    var buscadorInteractor: BuscadorInteractor? = null

    init {
        buscadorInteractor = SearchProductService()
    }

    /**
     * busca y armado de lista para mostrar en View
     */
    override fun buscar(product: String) {
        CoroutineScope(Dispatchers.IO).launch {
            val response: Response<SearchResponse>? = buscadorInteractor?.searchProduct(product)
            view.activity?.runOnUiThread {
                if (response?.isSuccessful!!) {
                    val product: List<ProductModel> = response.body()?.results ?: emptyList()
                    view.emptyList.clear()
                    view.emptyList.addAll(product)
                    view.adapterSearch.notifyDataSetChanged()

                } else Toast.makeText(view.context, "error al cargar", Toast.LENGTH_LONG).show()

            }
        }


    }


}

