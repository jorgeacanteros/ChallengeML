package com.ml.challengeml.webServices

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by Jorge on 21,febrero,2021
 */
object RetrofitClient {

    val webservice by lazy {
        Retrofit.Builder()
            .baseUrl("https://api.mercadolibre.com")
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .build().create(webService::class.java)
    }
}