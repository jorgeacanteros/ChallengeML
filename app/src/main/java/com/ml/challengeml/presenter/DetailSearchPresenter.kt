package com.ml.challengeml.presenter

import android.app.Activity
import android.content.Context
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import com.google.android.material.internal.ContextUtils.getActivity
import com.ml.challengeml.contract.DetailProductContract
import com.ml.challengeml.interactor.BuscadorInteractor
import com.ml.challengeml.model.*
import com.ml.challengeml.services.DetailSearchService
import com.ml.challengeml.services.SearchProductService
import com.ml.challengeml.view.DetailSearchFragment
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response
import java.lang.reflect.Array.get
import kotlin.coroutines.CoroutineContext

/**
 * Created by Jorge on 27,febrero,2021
 */
class DetailSearchPresenter(fragment: DetailSearchFragment, productModel:ProductModel): DetailProductContract.presenter {

    private var view=fragment
    private var product: ProductModel = productModel
    private  lateinit var productDetail : DetailProductModel
    private var interactor: DetailSearchService = DetailSearchService()

    override  fun buscarDetalle()  {
        CoroutineScope(Dispatchers.IO).launch {
            val response: Response<DetaidProductResponse>? = interactor?.DetailSearchProduct(product.id)
            Log.e("informacion", response.toString())
            createProductDetail(response?.body(),buscarDescription())
            view.activity?.runOnUiThread {
                view.setData(productDetail)
            }
        }



    }

    private fun createProductDetail(productDetailResponse: DetaidProductResponse?, description: String) {
        productDetail = DetailProductModel(productDetailResponse?.title!!,description,productDetailResponse.pictures,productDetailResponse.price)



    }

    override suspend fun buscarDescription(): String {

        val response: Response<DescriptionProductResponse>? =interactor?.DescriptionProduct(product.id)

        Log.e("informacion",response.toString())
        return response!!.body()?.plain_text!!

    }



}