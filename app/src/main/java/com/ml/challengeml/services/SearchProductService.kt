package com.ml.challengeml.services


import android.util.Log
import com.ml.challengeml.interactor.BuscadorInteractor
import com.ml.challengeml.model.SearchResponse
import com.ml.challengeml.webServices.RetrofitClient
import retrofit2.Response

/**
 * Created by Jorge on 21,febrero,2021
 */
class SearchProductService() : BuscadorInteractor {

     override suspend fun searchProduct(product: String): Response<SearchResponse> {
        val response: Response<SearchResponse> = RetrofitClient.webservice.getProductByName(product)

         Log.e("informacion",response.toString())
        return response
    }


}