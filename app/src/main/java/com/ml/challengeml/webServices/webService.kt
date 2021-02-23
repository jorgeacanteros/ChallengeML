package com.ml.challengeml.webServices

import com.ml.challengeml.model.SearchResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface webService {
    @GET("/sites/MLA/search?")
    suspend fun getProductByName(@Query("q")nameProduct:String): Response<SearchResponse>
}