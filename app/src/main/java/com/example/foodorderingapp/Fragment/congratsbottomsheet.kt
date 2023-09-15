package com.example.foodorderingapp.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.foodorderingapp.R
import com.example.foodorderingapp.databinding.FragmentCongratsbottomsheetBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment


class congratsbottomsheet : BottomSheetDialogFragment(){
    private val binding by lazy {
        FragmentCongratsbottomsheetBinding.inflate(layoutInflater)
    }




    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding.gobackhome.setOnClickListener {
            dismiss()
        }

        return binding.root
    }


}