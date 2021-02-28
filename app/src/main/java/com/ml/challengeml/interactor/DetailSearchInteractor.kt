package com.ml.challengeml.interactor

import com.ml.challengeml.model.DescriptionProductResponse
import com.ml.challengeml.model.DetaidProductResponse
import com.ml.challengeml.model.SearchResponse
import retrofit2.Response

/**
 * Created by Jorge on 27,febrero,2021
 */
interface DetailSearchInteractor {
    suspend fun DetailSearchProduct(id: String): Response<DetaidProductResponse>

    suspend fun DescriptionProduct(id: String): Response<DescriptionProductResponse>
}