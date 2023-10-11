package com.nm.yourweather.presentation

import android.content.pm.PackageManager
import android.location.Location
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.lifecycle.ViewModelProvider
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.nm.yourweather.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var fusedLocationClient: FusedLocationProviderClient
    lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        mainViewModel = ViewModelProvider(this)[MainViewModel::class.java]
        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this)
        getLocation()
    }

    private fun getLocation() {
        if (ActivityCompat.checkSelfPermission(
                this,
                android.Manifest.permission.ACCESS_FINE_LOCATION
            )
            != PackageManager.PERMISSION_GRANTED &&
            ActivityCompat.checkSelfPermission(
                this,
                android.Manifest.permission.ACCESS_COARSE_LOCATION
            )
            != PackageManager.PERMISSION_GRANTED
        ) {
            ActivityCompat.requestPermissions(
                this,
                arrayOf(android.Manifest.permission.ACCESS_FINE_LOCATION), 100
            )

        }
        val location = fusedLocationClient.lastLocation
        location.addOnSuccessListener { location1: Location? ->

            mainViewModel.getCurrent( location1!!.latitude.toString(),location1.longitude.toString())
            mainViewModel.getCurrent.observe(this){
                Toast.makeText(this, it.body.main.feelsLike.toString(), Toast.LENGTH_SHORT).show()
            }




        }.addOnFailureListener {
            Toast.makeText(this@MainActivity, it.localizedMessage, Toast.LENGTH_SHORT)
                .show()
        }

    }
}