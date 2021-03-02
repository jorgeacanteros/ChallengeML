package com.ml.challengeml.services

import android.util.Log
import com.ml.challengeml.interactor.DetailSearchInteractor
import com.ml.challengeml.model.DescriptionProductResponse
import com.ml.challengeml.model.DetaidProductResponse
import com.ml.challengeml.model.SearchResponse
import com.ml.challengeml.webServices.RetrofitClient
import retrofit2.Response

/**
 * Created by Jorge on 27,febrero,2021
 */
class DetailSearchService : DetailSearchInteractor{

    /**
     * busca la información del producto por el id
     * @param id identificador del producto seleccionado
     */
    override suspend fun DetailSearchProduct(id: String): Response<DetaidProductResponse> {
        val response: Response<DetaidProductResponse> = RetrofitClient.webservice.getDetailProductByID(id)
        Log.e("informacion",response.toString())
        return response
    }

    /**
     * busca la descripción del producto por el id
     * @param id identificador del producto seleccionado
     */
    override suspend fun DescriptionProduct(id: String): Response<DescriptionProductResponse> {
        val response: Response<DescriptionProductResponse> = RetrofitClient.webservice.getDescriptionProductByID(id)
        Log.e("informacion",response.toString())
        return response
    }

}