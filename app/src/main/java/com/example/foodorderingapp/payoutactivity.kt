package com.example.foodorderingapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.fragment.app.FragmentManager
import com.example.foodorderingapp.Fragment.cartFragment
import com.example.foodorderingapp.Fragment.congratsbottomsheet
import com.example.foodorderingapp.databinding.ActivityPayoutactivityBinding

class payoutactivity : AppCompatActivity() {
    private val binding by lazy {
        ActivityPayoutactivityBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.payoutbutton.setOnClickListener {
            val bottomsheet=congratsbottomsheet()
            bottomsheet.show(this@payoutactivity.supportFragmentManager,"test")
        }
        binding.button4.setOnClickListener {
            finish()
        }


    }
}