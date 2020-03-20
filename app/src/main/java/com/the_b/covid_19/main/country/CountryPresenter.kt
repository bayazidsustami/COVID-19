package com.the_b.covid_19.main.country

import android.util.Log
import com.the_b.covid_19.api.ApiClient
import com.the_b.covid_19.model.CountryItem
import retrofit2.Call
import retrofit2.Response

class CountryPresenter(private val view: CountryView) {

    fun getCountryList(){
        view.showLoading()

        val apiClient = ApiClient.create()
        apiClient.getCountryData().enqueue(object : retrofit2.Callback<List<CountryItem>>{
            override fun onFailure(call: Call<List<CountryItem>>, t: Throwable) {
                view.hideLoading()
                view.errorLoading(t.localizedMessage)
            }

            override fun onResponse(call: Call<List<CountryItem>>, response: Response<List<CountryItem>>) {
                view.hideLoading()
                view.showListData(response.body())
                Log.d("tag", "responsennya ${response.body()}")
            }
        })
    }
}