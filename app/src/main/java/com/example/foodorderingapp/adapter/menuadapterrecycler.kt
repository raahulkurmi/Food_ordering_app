package com.example.foodorderingapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.foodorderingapp.databinding.MennurecyclerviewBinding
import com.example.foodorderingapp.modelclass.Recyclerviewmodelclas


class menuadapterrecycler(val itemlist:ArrayList<Recyclerviewmodelclas>): RecyclerView.Adapter<menuadapterrecycler.mycustomadapter>() {
    class mycustomadapter(var binding:MennurecyclerviewBinding):RecyclerView.ViewHolder(binding.root) {


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): mycustomadapter {
        return mycustomadapter(MennurecyclerviewBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun getItemCount(): Int {
        return itemlist.size
    }

    override fun onBindViewHolder(holder: mycustomadapter, position: Int) {
        val position1=itemlist[position]
        holder.binding.imageView6.setImageResource(position1.image)
        holder.binding.textView15.text= itemlist[position].foodname
        holder.binding.textView16.text=itemlist[position].price




    }
}