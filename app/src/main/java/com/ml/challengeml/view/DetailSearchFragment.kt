package com.ml.challengeml.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewpager2.widget.ViewPager2
import com.ml.challengeml.R
import com.ml.challengeml.databinding.FragmentDetailSearchBinding
import com.ml.challengeml.model.ProductModel
import com.ml.challengeml.presenter.BuscadorPresenter
import com.ml.challengeml.presenter.DetailSearchPresenter
import kotlinx.android.synthetic.main.fragment_detail_search.*
import kotlinx.android.synthetic.main.fragment_search.*


class DetailSearchFragment : Fragment() {

    private lateinit var binding: FragmentDetailSearchBinding
    private  lateinit var  adapterSlider: SliderAdapter
    private var emptyList = mutableListOf<String>()
    private  lateinit var presenter: DetailSearchPresenter
    private lateinit var viewPager: ViewPager2
    private lateinit var product: ProductModel

    var listaejemplo: List<String> = listOf("https://images.dog.ceo/breeds/hound-afghan/n02088094_1222.jpg",
                                             "https://images.dog.ceo/breeds/hound-afghan/n02088094_1259.jpg",
                                            "https://images.dog.ceo/breeds/hound-afghan/n02088094_12945.jpg")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requireArguments().let {
            product= it.getParcelable<ProductModel>("ProductModel")!!
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
      binding= FragmentDetailSearchBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
        setdata()
    }

    private fun init() {
        viewPager = binding.sliderProductPhoto
        adapterSlider= SliderAdapter(listaejemplo)
        viewPager.adapter =adapterSlider
        presenter= DetailSearchPresenter()

    }

    private fun setdata(){

    }

}