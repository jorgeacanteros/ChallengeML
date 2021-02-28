package com.ml.challengeml.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.viewpager2.widget.ViewPager2
import com.ml.challengeml.contract.DetailProductContract
import com.ml.challengeml.databinding.FragmentDetailSearchBinding
import com.ml.challengeml.model.DetailProductModel
import com.ml.challengeml.model.PictureModel
import com.ml.challengeml.model.ProductModel
import com.ml.challengeml.presenter.DetailSearchPresenter
import kotlinx.android.synthetic.main.fragment_detail_search.*
import kotlinx.android.synthetic.main.fragment_search.*


class DetailSearchFragment : Fragment() , DetailProductContract.view{

    private lateinit var binding: FragmentDetailSearchBinding
    private  lateinit var  adapterSlider: SliderAdapter
    private var emptyList = mutableListOf<String>()
    private  lateinit var presenter: DetailSearchPresenter
    private lateinit var viewPager: ViewPager2
    private lateinit var product: ProductModel

    //var listaejemplo: List<String> = listOf("https://images.dog.ceo/breeds/hound-afghan/n02088094_1222.jpg",
                                           //  "https://images.dog.ceo/breeds/hound-afghan/n02088094_1259.jpg",
                                          //  "https://images.dog.ceo/breeds/hound-afghan/n02088094_12945.jpg")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (savedInstanceState == null) {

        }

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
      binding= FragmentDetailSearchBinding.inflate(layoutInflater)
        requireArguments().let {
            product= it.getParcelable("product")!!
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
        setdata()
    }

    private fun init() {
        viewPager = binding.sliderProductPhoto
        adapterSlider= SliderAdapter(emptyList)
        viewPager.adapter =adapterSlider
        presenter= DetailSearchPresenter(this, product)

    }

    private fun setdata(){
        val response =presenter.buscarDetalle()
       /* CoroutineScope(Dispatchers.IO).launch {
            val response =presenter.buscarDetalle()
            getActivity()?.runOnUiThread{
                if (response.isSuccessful) {


                     emptyList.clear()
                    for(item in response.body()?.pictures!!){
                        emptyList.add(item.url)
                    }
                 //   emptyList.addAll(product)
                    adapterSlider.notifyDataSetChanged()

                }
                //    else Toast.makeText(applicationContext,"error al cargar", Toast.LENGTH_LONG).show()

            }
        }*/



    }
    fun setSlider(list: List<PictureModel>){
        emptyList.clear()
        for(item in list){
            emptyList.add(item.url)
        }
        //   emptyList.addAll(product)
        adapterSlider.notifyDataSetChanged()
    }

    override fun setData(detailProductModel: DetailProductModel) {
        setSlider(detailProductModel.listImage)
        binding.detailDescription.text = detailProductModel.descripton
        binding.detailTitle.text = detailProductModel.title
        binding.detailPrice.text = detailProductModel.price.toString()

    }

}