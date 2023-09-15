package com.example.foodorderingapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.foodorderingapp.Fragment.notificationbottomfragment
import com.example.foodorderingapp.databinding.ActivityHomeactivityBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class Homeactivity : AppCompatActivity() {
    private val binding by lazy {
        ActivityHomeactivityBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        var navcontroller=findNavController(R.id.fragment)
        val bottomnav=findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        bottomnav.setupWithNavController(navcontroller)
        binding.notificationimage.setOnClickListener {
            val bottomSheetDialog=notificationbottomfragment()
            bottomSheetDialog.show(supportFragmentManager,"test")
        }
    }

}