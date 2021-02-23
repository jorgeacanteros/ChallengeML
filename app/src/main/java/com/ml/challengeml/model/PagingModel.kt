package com.ml.challengeml.model

import com.google.gson.annotations.SerializedName

/**
 * Created by Jorge on 21,febrero,2021
 */
data class PagingModel(
                        @SerializedName("total")val total: Int,
                        @SerializedName("primary_results")val primary_results:Int,
                        @SerializedName("offset")val offset:Int,
                        @SerializedName("limit")val limit:Int
                       )
