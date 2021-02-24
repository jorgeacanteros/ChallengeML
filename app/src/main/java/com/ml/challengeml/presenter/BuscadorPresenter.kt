package com.ml.challengeml.presenter

import android.util.Log
import com.ml.challengeml.contract.BuscadorContract
import com.ml.challengeml.interactor.BuscadorInteractor
import com.ml.challengeml.interactor.Callback
import com.ml.challengeml.model.ProductModel
import com.ml.challengeml.model.SearchResponse
import com.ml.challengeml.services.SearchProductService
import retrofit2.Response

class BuscadorPresenter: BuscadorContract.presenter {

    var buscadorInteractor: BuscadorInteractor? = null

    init {
        buscadorInteractor= SearchProductService()
    }

    override suspend fun buscar(product: String): Response<SearchResponse> {

        val response: Response<SearchResponse>? =buscadorInteractor?.searchProduct(product)


            Log.e("informacion",response.toString())
            return response!!






        }


    }

