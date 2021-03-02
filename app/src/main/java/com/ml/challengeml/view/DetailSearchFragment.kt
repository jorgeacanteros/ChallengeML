package com.ml.challengeml.view

import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2
import com.ml.challengeml.R
import com.ml.challengeml.contract.DetailProductContract
import com.ml.challengeml.databinding.FragmentDetailSearchBinding
import com.ml.challengeml.model.DetailProductModel
import com.ml.challengeml.model.PictureModel
import com.ml.challengeml.model.ProductModel
import com.ml.challengeml.presenter.DetailSearchPresenter

/**
 * Created by Jorge on 27,febrero,2021
 */
class DetailSearchFragment : Fragment(), DetailProductContract.view {

    private lateinit var binding: FragmentDetailSearchBinding
    private lateinit var adapterSlider: SliderAdapter
    private var emptyList = mutableListOf<String>()
    private lateinit var presenter: DetailSearchPresenter
    private lateinit var viewPager: ViewPager2
    private lateinit var product: ProductModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (savedInstanceState == null) {

        }
    }

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailSearchBinding.inflate(layoutInflater)
        requireArguments().let {
            product = it.getParcelable("product")!!
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
        searchDetail()
    }

    /**
     * inicializa los atributos
     */
    private fun init() {
        viewPager = binding.sliderProductPhoto
        adapterSlider = SliderAdapter(emptyList)
        viewPager.adapter = adapterSlider
        presenter = DetailSearchPresenter(this, product)

    }

    private fun searchDetail() {
        val response = presenter.buscarDetalle()

    }

    /**
     * Carga la lista de imagenes en el Slider
     */

    fun setSlider(list: List<PictureModel>) {
        emptyList.clear()
        for (item in list) {
            emptyList.add(item.url)
        }
        adapterSlider.notifyDataSetChanged()
    }

    /**
     * Mensaje de error general
     */
    override fun showError() {
        val builder = AlertDialog.Builder(requireContext())
        builder.setTitle("Error de Servicio")
        builder.setMessage(R.string.mjsError)
        builder.setPositiveButton(
                "Volver"
        ) { dialog, which -> findNavController().navigate(R.id.searchFragment) }
        val dialog = builder.create()
        dialog.show()
    }

    /**
     *  Carga los datos en la View
     */

    override fun setData(detailProductModel: DetailProductModel) {
        setSlider(detailProductModel.listImage)
        binding.detailDescription.text = detailProductModel.descripton
        binding.detailTitle.text = detailProductModel.title
        binding.detailPrice.text = "$ " + detailProductModel.price.toString()

    }

}