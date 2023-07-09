package com.example.foodorderingapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.core.content.res.ResourcesCompat
import com.example.foodorderingapp.databinding.ActivityLoginBinding
import com.example.foodorderingapp.databinding.ActivityMain2Binding
import www.sanju.motiontoast.MotionToast
import www.sanju.motiontoast.MotionToastStyle

class MainActivity2 : AppCompatActivity() {
    private val binding by lazy {
        ActivityMain2Binding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

binding.button.setOnClickListener {
    login()


}














    }

    private fun login(){
        startActivity(Intent(this,LoginActivity::class.java))
        finish()
    }

    override fun onBackPressed() {
        val alertdialog=AlertDialog.Builder(this)
        alertdialog.setMessage("Are you sure want to quit ?")
        alertdialog.setTitle("Alert !")
        alertdialog.setCancelable(true)
        alertdialog.setPositiveButton("Yes"){
                dialog, which -> finish()
        }
        alertdialog.setNegativeButton("No") {
            // If user click no then dialog box is canceled.
                dialog, which -> dialog.cancel()
        }
        alertdialog.create()
        // Show the Alert Dialog box
        alertdialog.show()

    }
}