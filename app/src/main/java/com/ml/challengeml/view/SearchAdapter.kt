package com.ml.challengeml.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ml.challengeml.R
import com.ml.challengeml.databinding.ItemProductBinding
import com.ml.challengeml.model.ProductModel
import com.squareup.picasso.Picasso

/**
 * Created by Jorge on 23,febrero,2021
 */
class SearchAdapter(val listSeach:List<ProductModel>, private val itemClick: OnProductClickListener): RecyclerView.Adapter<SearchAdapter.SearchViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return SearchViewHolder(layoutInflater.inflate(R.layout.item_product,parent,false))
    }

    override fun onBindViewHolder(holder: SearchViewHolder, position: Int) {
        holder.bind(listSeach[position])
    }

    override fun getItemCount(): Int = listSeach.size

    inner class SearchViewHolder(view: View): RecyclerView.ViewHolder(view){
        val view = view
        val binding= ItemProductBinding.bind(view)

        fun bind(product: ProductModel){

            Picasso.with(view.context).load(product.imagenProduct).into(binding.imgItem)
            binding.itemTitle.text = product.titulo
            binding.itemPrice.text = product.price.toString()
            view.setOnClickListener{
                itemClick.onProductClick(product)
            }

        }
    }

    interface OnProductClickListener{
        fun onProductClick(product: ProductModel)
    }

}

