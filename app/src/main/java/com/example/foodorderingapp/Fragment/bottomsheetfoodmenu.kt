package com.example.foodorderingapp.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.foodorderingapp.R
import com.example.foodorderingapp.adapter.menuadapterrecycler
import com.example.foodorderingapp.databinding.FragmentBottomsheetfoodmenuBinding
import com.example.foodorderingapp.modelclass.Recyclerviewmodelclas
import com.google.android.material.bottomsheet.BottomSheetDialogFragment


class bottomsheetfoodmenu : BottomSheetDialogFragment() {
   private val binding by lazy {
       FragmentBottomsheetfoodmenuBinding.inflate(layoutInflater)
   }

    val itemlist = ArrayList<Recyclerviewmodelclas>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        itemlist.add(Recyclerviewmodelclas(R.drawable.banner1,"Burger","$7"))
        itemlist.add(Recyclerviewmodelclas(R.drawable.banner2,"Chicken burger","$7"))
        itemlist.add(Recyclerviewmodelclas(R.drawable.banner3,"Steak chicken","$7"))
        itemlist.add(Recyclerviewmodelclas(R.drawable.banner4,"Americano","$7"))
        itemlist.add(Recyclerviewmodelclas(R.drawable.banner5,"Vodka","$7"))
        itemlist.add(Recyclerviewmodelclas(R.drawable.banner7,"Whisky","$7"))
        itemlist.add(Recyclerviewmodelclas(R.drawable.banner8,"tequila","$7"))
        itemlist.add(Recyclerviewmodelclas(R.drawable.banner,"pancake","$7"))
        itemlist.add(Recyclerviewmodelclas(R.drawable.banner1,"Herbal pancake","$7"))
        itemlist.add(Recyclerviewmodelclas(R.drawable.banner2,"Herbal pancake","$7"))
        itemlist.add(Recyclerviewmodelclas(R.drawable.banner3,"Herbal pancake","$7"))
        itemlist.add(Recyclerviewmodelclas(R.drawable.banner4,"Herbal pancake","$7"))

        binding.recyclerview.layoutManager= LinearLayoutManager(requireContext())
        val adaptor= menuadapterrecycler(itemlist)
        binding.recyclerview.adapter=adaptor
        binding.recyclerview.setHasFixedSize(true)

        return binding.root
    }



}