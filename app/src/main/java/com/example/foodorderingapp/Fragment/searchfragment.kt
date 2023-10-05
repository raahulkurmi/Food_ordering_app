package com.example.foodorderingapp.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.foodorderingapp.R
import com.example.foodorderingapp.adapter.pouplarmenuadapter
import com.example.foodorderingapp.databinding.FragmentSearchfragmentBinding
import com.example.foodorderingapp.modelclass.popularmenuclass

class searchfragment : Fragment() {


    private val binding by lazy {
        FragmentSearchfragmentBinding.inflate(layoutInflater)
    }
    private val itemList = ArrayList<popularmenuclass>()
    private lateinit var adapter: pouplarmenuadapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
//        binding = FragmentSearchBinding.inflate(inflater, container, false)

        setupItemList()
        adapter = pouplarmenuadapter(itemList, requireActivity())
        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String): Boolean {
                if (::adapter.isInitialized) {
                    adapter.filter(newText)
                }
                return true
            }
        })



        setupRecyclerView()



        return binding.root
    }

    private fun setupItemList() {
        itemList.add(popularmenuclass(R.drawable.banner1, "Burger", "$7"))
        itemList.add(popularmenuclass(R.drawable.banner2, "Chicken burger", "$7"))
        itemList.add(popularmenuclass(R.drawable.banner3, "Steak chicken", "$7"))
        itemList.add(popularmenuclass(R.drawable.banner4, "Americano", "$7"))
        itemList.add(popularmenuclass(R.drawable.banner5, "Vodka", "$7"))
        itemList.add(popularmenuclass(R.drawable.banner7, "Whisky", "$7"))
        itemList.add(popularmenuclass(R.drawable.banner8, "Tequila", "$7"))
//        itemList.add(recyclerviewmodelclas(R.drawable.banner, "Pancake", "$7"))
//        itemList.add(recyclerviewmodelclas(R.drawable.banner1, "Herbal pancake", "$7"))
//        itemList.add(recyclerviewmodelclas(R.drawable.banner2, "Herbal pancake", "$7"))
//        itemList.add(recyclerviewmodelclas(R.drawable.banner3, "Herbal pancake", "$7"))
//        itemList.add(recyclerviewmodelclas(R.drawable.banner4, "Herbal pancake", "$7"))
    }

    private fun setupRecyclerView() {
        binding.recyclerview.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerview.adapter = adapter
        binding.recyclerview.setHasFixedSize(true)
    }
}