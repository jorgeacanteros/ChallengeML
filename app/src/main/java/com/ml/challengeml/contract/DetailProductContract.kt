package com.ml.challengeml.contract

import com.ml.challengeml.model.*
import retrofit2.Response

/**
 * Created by Jorge on 27,febrero,2021
 */
interface DetailProductContract {
    interface presenter{
         fun buscarDetalle()
        suspend fun buscarDescription(): String
    }
    interface view{
        fun showError()
        fun setData(detailProductModel: DetailProductModel)

    }
}