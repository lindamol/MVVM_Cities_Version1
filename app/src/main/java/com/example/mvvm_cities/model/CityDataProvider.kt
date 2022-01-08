package com.example.mvvm_cities.model

import com.example.mvvm_cities.R

class CityDataProvider {
    private  val cities = arrayListOf<City>()
    init {
        cities.add(City("Toronto", R.drawable.toronto,20000556))
        cities.add(City("Sydney", R.drawable.sydney,2034235056))
        cities.add(City("Zurich", R.drawable.zurich,467000056))
        cities.add(City("Paris", R.drawable.paris2,67_00_0056))
    }
    fun getCities() = cities
}