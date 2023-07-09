package com.example.foodorderingapp

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import com.example.foodorderingapp.databinding.ActivityLocationactivityBinding

class Locationactivity : AppCompatActivity() {
    private lateinit var binding: ActivityLocationactivityBinding
    private val REQ_CODE = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLocationactivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val list: Array<String> = arrayOf(
            "Rajkot", "Ahemdabad", "Morbi", "Jamnagar", "Vadodora",
            "Diu", "Somnath", "Dwarka", "Daman", "Gandhinagar"
        )
        val arrayAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, list)
        binding.listoflocation.setAdapter(arrayAdapter)



        binding.listoflocation.setOnItemClickListener { _, _, _, _ ->
            if (checkPermission()) {
                Toast.makeText(applicationContext, "Permission Already granted", Toast.LENGTH_SHORT).show()
            } else {
                ActivityCompat.requestPermissions(
                    this@Locationactivity,
                    arrayOf(Manifest.permission.ACCESS_FINE_LOCATION),
                    REQ_CODE
                )
            }
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == REQ_CODE) {
            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED &&
                grantResults[1] == PackageManager.PERMISSION_GRANTED
            ) {
                Toast.makeText(applicationContext, "Permission granted", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(applicationContext, "Permission denied", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun checkPermission(): Boolean {
        val resultLocation = ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
        return resultLocation == PackageManager.PERMISSION_GRANTED
    }
}
