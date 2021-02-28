package com.ml.challengeml.model

import com.google.gson.annotations.SerializedName

/**
 * Created by Jorge on 27,febrero,2021
 */
data class PictureModel(@SerializedName("id")
                        val id:String,
                        @SerializedName("url")
                        val url:String,
                        @SerializedName("size")
                        val size:String)
