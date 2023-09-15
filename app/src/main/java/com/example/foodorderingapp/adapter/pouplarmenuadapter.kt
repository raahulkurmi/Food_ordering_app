package com.example.foodorderingapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.foodorderingapp.databinding.PopularmenuBinding
import com.example.foodorderingapp.modelclass.popularmenuclass

class pouplarmenuadapter(
    val itemlist: ArrayList<popularmenuclass>, var requireActivity: FragmentActivity
): RecyclerView.Adapter<pouplarmenuadapter.mycustomadapter>() {
    private var filteredItemList: ArrayList<popularmenuclass> = ArrayList(itemlist)


    class mycustomadapter(val binding: PopularmenuBinding):RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): mycustomadapter {
        return mycustomadapter(PopularmenuBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun getItemCount(): Int {
        return filteredItemList.size
    }

    override fun onBindViewHolder(holder: mycustomadapter, position: Int) {
        val position1 = filteredItemList[position] // Use filteredItemList instead of itemlist
        holder.binding.imageView6.setImageResource(position1.image)
        holder.binding.textView15.text = position1.foodname
        holder.binding.textView16.text = position1.price

    }


    fun filter(query: String) {
        filteredItemList.clear()
        if (query.isEmpty()) {
            filteredItemList.addAll(itemlist)
        } else {
            val lowerCaseQuery = query.toLowerCase()
            itemlist.forEach { item ->
                if (item.foodname.toLowerCase().contains(lowerCaseQuery)) {
                    filteredItemList.add(item)
                }
            }
        }
        notifyDataSetChanged()
    }


}