package com.example.foodorderingapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.foodorderingapp.Fragment.homeFragment
import com.example.foodorderingapp.databinding.ActivityDetailactivityBinding

class detailactivity : AppCompatActivity() {
    private val binding by lazy {
        ActivityDetailactivityBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        val foodimage=intent.getIntExtra("imageview",0)
        val foodname=intent.getStringExtra("textview")
        binding.detailfoodimage.setImageResource((foodimage))
        binding.textView33.text=foodname


        binding.imageButton.setOnClickListener {
            finish()
        }








    }
}