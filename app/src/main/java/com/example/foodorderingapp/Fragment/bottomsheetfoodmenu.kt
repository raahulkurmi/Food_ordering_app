package com.example.foodorderingapp.Fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.foodorderingapp.R

import com.example.foodorderingapp.adapter.pouplarmenuadapter
import com.example.foodorderingapp.databinding.FragmentBottomsheetfoodmenuBinding
//import com.example.foodorderingapp.modelclass.Recyclerviewmodelclas
import com.example.foodorderingapp.modelclass.popularmenuclass
import com.google.android.material.bottomsheet.BottomSheetDialogFragment


class bottomsheetfoodmenu : BottomSheetDialogFragment() {
   private val binding by lazy {
       FragmentBottomsheetfoodmenuBinding.inflate(layoutInflater)
   }

    val itemlist = ArrayList<popularmenuclass>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       itemlist.add(popularmenuclass(R.drawable.banner1,"Burger","$7"))
        itemlist.add(popularmenuclass(R.drawable.banner2,"chilly Burger","$7"))
        itemlist.add(popularmenuclass(R.drawable.banner3,"salad","$7"))
        itemlist.add(popularmenuclass(R.drawable.banner4,"coffee","$7"))
        itemlist.add(popularmenuclass(R.drawable.banner5,"beer","$7"))
        itemlist.add(popularmenuclass(R.drawable.banner6,"jar beer","$7"))
        itemlist.add(popularmenuclass(R.drawable.banner7,"vodka","$7"))
        itemlist.add(popularmenuclass(R.drawable.banner8,"burger with beer","$7"))



//        list.add(Recyclerviewmodelclas(R.drawable.banner2,"Chicken burger","$7"))
//       list.add(Recyclerviewmodelclas(R.drawable.banner3,"Steak chicken","$7"))
//        list.add(Recyclerviewmodelclas(R.drawable.banner4,"Americano","$7"))
//        list.add(Recyclerviewmodelclas(R.drawable.banner5,"Vodka","$7"))
//        list.add(Recyclerviewmodelclas(R.drawable.banner7,"Whisky","$7"))
//        list.add(Recyclerviewmodelclas(R.drawable.banner8,"tequila","$7"))
//        list.add(Recyclerviewmodelclas(R.drawable.banner,"pancake","$7"))
//        list.add(Recyclerviewmodelclas(R.drawable.banner1,"Herbal pancake","$7"))
//        list.add(Recyclerviewmodelclas(R.drawable.banner2,"Herbal pancake","$7"))
//        list.add(Recyclerviewmodelclas(R.drawable.banner3,"Herbal pancake","$7"))
//        list.add(Recyclerviewmodelclas(R.drawable.banner4,"Herbal pancake","$7"))

        binding.recyclerview.layoutManager=LinearLayoutManager(requireContext())
        val adaptor=pouplarmenuadapter(itemlist,requireActivity())
        binding.recyclerview.adapter=adaptor
        binding.recyclerview.setHasFixedSize(true)
        return binding.root
    }



}