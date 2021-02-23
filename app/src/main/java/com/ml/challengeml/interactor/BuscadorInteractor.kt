package com.ml.challengeml.interactor

import com.ml.challengeml.model.SearchResponse
import retrofit2.Response

/**
 * Created by Jorge on 21,febrero,2021
 */
interface BuscadorInteractor {

    suspend fun searchProduct(product: String): Response<SearchResponse>
}