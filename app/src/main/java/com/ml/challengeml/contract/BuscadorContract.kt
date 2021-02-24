package com.ml.challengeml.contract

import com.ml.challengeml.model.ProductModel
import com.ml.challengeml.model.SearchResponse
import retrofit2.Response

interface BuscadorContract {
    interface presenter{
        suspend fun buscar(product: String): Response<SearchResponse>
    }
    interface view{

    }
}