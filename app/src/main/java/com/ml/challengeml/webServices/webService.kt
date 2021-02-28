package com.ml.challengeml.webServices

import com.ml.challengeml.model.DescriptionProductModel
import com.ml.challengeml.model.DescriptionProductResponse
import com.ml.challengeml.model.DetaidProductResponse
import com.ml.challengeml.model.SearchResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface webService {
    @GET("/sites/MLA/search?")
    suspend fun getProductByName(@Query("q")nameProduct:String): Response<SearchResponse>

    @GET("/items/{id}")
    suspend fun getDetailProductByID(@Path("id")idProduct:String): Response<DetaidProductResponse>

    @GET("/items/{id}/description")
    suspend fun getDescriptionProductByID(@Path("id")idProduct:String): Response<DescriptionProductResponse>

}