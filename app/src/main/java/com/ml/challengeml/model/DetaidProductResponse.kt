package com.ml.challengeml.model

import com.google.gson.annotations.SerializedName

/**
 * Created by Jorge on 27,febrero,2021
 */
data class DetaidProductResponse(
                               // @SerializedName("code")
                               //  val code:String,
                                 @SerializedName("title")
                                 val title:String,
                                 @SerializedName("pictures")
                                 val pictures:List<PictureModel>,
                                  @SerializedName("price")
                                 val price:Double

)
