package com.the_b.covid_19.api

import com.the_b.covid_19.model.CountryItem
import com.the_b.covid_19.model.GetGlobal
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("all")
    fun getData(): Call<GetGlobal>

    @GET("countries")
    fun getCountryData(): Call<List<CountryItem>>
}