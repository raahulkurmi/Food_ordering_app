package com.example.foodorderingapp.Fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.foodorderingapp.R
import com.example.foodorderingapp.adapter.cartadapter
import com.example.foodorderingapp.databinding.FragmentCartBinding
import com.example.foodorderingapp.modelclass.cartmodelclass
import com.example.foodorderingapp.payoutactivity

class cartFragment : Fragment() {
   private val binding by lazy {
       FragmentCartBinding.inflate(layoutInflater)
   }

    private val list =ArrayList<cartmodelclass>()
//    private val cartAdapter = cartadapter(list, requireActivity())
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
list.add(cartmodelclass(R.drawable.banner1,"burger","6"))


        binding.recyclerview.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerview.adapter = cartadapter(list,requireActivity())



        binding.recyclerview.layoutManager=LinearLayoutManager(requireContext())
        binding.recyclerview.adapter=cartadapter(list,requireActivity())
        binding.recyclerview.hasFixedSize()
        binding.cartproceedd.setOnClickListener {
            startActivity(Intent(requireContext(),payoutactivity::class.java))

        }



        return binding.root
    }
//    fun updateCartItems(newList: ArrayList<cartmodelclass>) {
//       list.clear()
//        list.addAll(newList)
//        cartAdapter.notifyDataSetChanged()
//    }


}