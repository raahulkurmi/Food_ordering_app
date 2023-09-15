package com.example.foodorderingapp.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.foodorderingapp.R
import com.example.foodorderingapp.adapter.buyagainadapter
import com.example.foodorderingapp.databinding.BuyagainitemBinding
import com.example.foodorderingapp.databinding.FragmentHistoryBinding


class historyFragment : Fragment() {

private val binding by lazy {
    FragmentHistoryBinding.inflate(layoutInflater)
}
    private lateinit var buyagainadapter: buyagainadapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
setuprecyclerview()
        return binding.root
    }
private fun setuprecyclerview(){
    val buyagainfoodname= arrayListOf("Food 1","Food 2","Food 3")
    val buyagainfoodprice= arrayListOf("$5","$10","$15")
    val buyagainfoodimage= arrayListOf(R.drawable.banner1,R.drawable.banner2,R.drawable.banner3)
    buyagainadapter= buyagainadapter(buyagainfoodname,buyagainfoodprice,buyagainfoodimage)
    binding.buyagainrecycler.adapter=buyagainadapter
    binding.buyagainrecycler.layoutManager=LinearLayoutManager(requireContext() )


}

}