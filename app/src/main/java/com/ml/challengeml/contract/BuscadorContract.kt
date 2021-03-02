package com.ml.challengeml.contract

import com.ml.challengeml.model.ProductModel
import com.ml.challengeml.model.SearchResponse
import retrofit2.Response

interface BuscadorContract {
    interface presenter{
         fun buscar(product: String)
    }
    interface view{

    }
}