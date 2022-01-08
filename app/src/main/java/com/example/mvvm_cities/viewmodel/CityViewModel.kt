package com.example.mvvm_cities.viewmodel

import android.os.Handler
import android.os.Looper
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mvvm_cities.model.City
import com.example.mvvm_cities.model.CityDataProvider

class CityViewModel: ViewModel() {
    //This allows views to subscribe to event and recieves notification whenever the value of data changes
    //Here cityData is changing hence Mutable
    private  val cityData = MutableLiveData<City>()
    private  val cities = CityDataProvider().getCities()
    private  var currentIndex = 0
    private  val delay = 2000L
    init {
        loop()
    }
    private  fun loop(){
        //To Get a callback after certain delay
        //updatecity will be called after delay(every2 sec)
        Handler(Looper.getMainLooper()).postDelayed({updateCity()},delay )

    }
    private fun updateCity(){
        currentIndex++
        currentIndex %= cities.size
        //update citydata
        cityData.value = cities[currentIndex]
        loop()
    }
}