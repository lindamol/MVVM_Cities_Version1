package com.example.mvvm_cities.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.core.content.res.ResourcesCompat
import androidx.lifecycle.Observer
import com.example.mvvm_cities.R
import com.example.mvvm_cities.databinding.ActivityMainBinding
import com.example.mvvm_cities.viewmodel.CityViewModel
import java.util.zip.Inflater

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private  val model:CityViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        //setContentView(R.layout.activity_main)
        setContentView(binding.root)
    }

    override fun onResume() {
        super.onResume()
        //connect to my Viewmodel and observe
        model.getCityData().observe(this, Observer { city->
            binding.cityImage.setImageDrawable(
                ResourcesCompat.getDrawable(resources,city.imagecity,applicationContext.theme)
            )
            binding.citynameTextView.text = city.cityname
            binding.cityPopulationTextView.text = city.population.toString()
        })
    }
}