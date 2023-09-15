package com.example.foodorderingapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.foodorderingapp.databinding.BuyagainitemBinding

class buyagainadapter(private val buyagainfoodname:ArrayList<String>,
                      private val buyagainfoodprice:ArrayList<String>,
                      private val foodimage:ArrayList<Int>) :
    RecyclerView.Adapter<buyagainadapter.mycustoomviewholder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): mycustoomviewholder {
        return mycustoomviewholder(BuyagainitemBinding.inflate(LayoutInflater.from(parent.context),parent,false))

    }

    override fun getItemCount(): Int =buyagainfoodname.size


    override fun onBindViewHolder(holder: mycustoomviewholder, position: Int) {
     holder.bind(buyagainfoodname[position],buyagainfoodprice[position],foodimage[position])
    }
  inner  class mycustoomviewholder(val binding: BuyagainitemBinding):RecyclerView.ViewHolder(binding.root) {
      fun bind(foodname: String, foodprice: String, image: Int) {
    binding.apply {
buyagainfoodname.text=foodname
        buyagainfoodprice.text=foodprice
        buyagainfoodimage.setImageResource(image )
    }
      }

  }
}