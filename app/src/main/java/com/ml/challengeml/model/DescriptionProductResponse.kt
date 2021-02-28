package com.ml.challengeml.model

import com.google.gson.annotations.SerializedName

/**
 * Created by Jorge on 28,febrero,2021
 */
data class DescriptionProductResponse( @SerializedName("text")
                                       val text: String,
                                       @SerializedName("plain_text")
                                       val plain_text: String)

