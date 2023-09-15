package com.example.foodorderingapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.foodorderingapp.databinding.CartrecyclerviewBinding
import com.example.foodorderingapp.modelclass.cartmodelclass

class cartadapter(
    val list: ArrayList<cartmodelclass>,
    var requireActivity: FragmentActivity
) : RecyclerView.Adapter<cartadapter.mycustoomviewholder>() {
    private val quantity = IntArray(list.size) { 1 }

    class mycustoomviewholder(val binding: CartrecyclerviewBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): mycustoomviewholder {
        return mycustoomviewholder(
            CartrecyclerviewBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: mycustoomviewholder, position: Int) {
        var quantity = quantity[position]
        holder.binding.imageView7.setImageResource(list[position].image)
        holder.binding.textView24.text = list[position].foodname
        holder.binding.textView23.text = list[position].price
        holder.binding.textView25.text = quantity.toString()
        holder.binding.button3.setOnClickListener {
            if (quantity < 10) {
                quantity++
                holder.binding.textView25.text = quantity.toString()
            }
        }
        holder.binding.button2.setOnClickListener {
            if (quantity > 1) {
                quantity--
                holder.binding.textView25.text = quantity.toString()
            }
        }
        holder.binding.imageView9.setOnClickListener {
            delete(position)
        }
    }

    private fun delete(position: Int) {
        list.removeAt(position)
        notifyItemRemoved(position)
        notifyItemRangeChanged(position, list.size)
    }
}
