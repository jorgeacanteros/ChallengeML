package com.ml.challengeml.model

/**
 * Created by Jorge on 28,febrero,2021
 */
data class DetailProductModel(  var title:String,
                                var descripton:String,
                                var listImage: List<PictureModel>,
                                var price: Double)
