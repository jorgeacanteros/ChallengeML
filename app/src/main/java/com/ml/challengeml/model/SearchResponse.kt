package com.ml.challengeml.model

import com.google.gson.annotations.SerializedName

/**
 * Created by Jorge on 21,febrero,2021
 */
data class SearchResponse(@SerializedName("site_id")
                          val site_id:String,
                          @SerializedName("query")
                          val query:String,
                          @SerializedName("paging")
                          val paging:PagingModel,
                          @SerializedName("results")
                          val results:List<ProductModel>
                       /* @SerializedName("secondary_results")val secondary_results:String,
                        @SerializedName("related_results")val related_results:String,
                          @SerializedName("sort")val sort:String,
                          @SerializedName("available_sorts")val available_sorts:String,
                          @SerializedName("filters")val filters:String,
                          @SerializedName("available_filters")val available_filters:String*/
)
