package com.example.foodorderingapp.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.foodorderingapp.R
import com.example.foodorderingapp.adapter.notificationadpter
import com.example.foodorderingapp.databinding.FragmentNotificationbottomfragmentBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment


class notificationbottomfragment : BottomSheetDialogFragment() {
    private val binding by lazy {
       FragmentNotificationbottomfragmentBinding.inflate(layoutInflater)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val notification= listOf("Your order has been canceleed","Order has been taken by driver","Congrats Your order is placed")
        val notificationimage= listOf(R.drawable.sademoji,R.drawable.truck,R.drawable.placed)
        val adapter=notificationadpter(ArrayList(notification), ArrayList(  notificationimage))
        binding.notificationreclvwerviwe.layoutManager=LinearLayoutManager(requireContext())
        binding.notificationreclvwerviwe.adapter=adapter
        return binding.root
    }


    }
