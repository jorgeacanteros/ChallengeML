package com.ml.challengeml.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ml.challengeml.R
import com.ml.challengeml.databinding.PhotoSliderBinding

import com.squareup.picasso.Picasso

/**
 * Created by Jorge on 27,febrero,2021
 */
class SliderAdapter (val listPhoto:List<String>) : RecyclerView.Adapter<SliderAdapter.sliderViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): sliderViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return sliderViewHolder(layoutInflater.inflate(R.layout.photo_slider,parent, false))
    }

    override fun onBindViewHolder(holder: sliderViewHolder, position: Int) {
        holder.bind(listPhoto[position])
    }

    override fun getItemCount(): Int = listPhoto.size

    inner class sliderViewHolder(view: View): RecyclerView.ViewHolder(view){
        val view = view
        val binding=PhotoSliderBinding.bind(view)

        fun bind(photo: String){

            Picasso.with(view.context).load(photo).into(binding.imgPhoto)



        }
    }


}