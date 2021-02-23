package com.ml.challengeml.model


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

/**
 * Created by Jorge on 21,febrero,2021
 */

@Parcelize
data class ProductModel (
    @SerializedName("title")
    val titulo:String,
    @SerializedName("id")
    val id:String,
    @SerializedName("site_id")
    val site_id:String,
    @SerializedName("price")
    val price:Double,
    @SerializedName("thumbnail")
    val imagenProduct:String
        ):Parcelable

