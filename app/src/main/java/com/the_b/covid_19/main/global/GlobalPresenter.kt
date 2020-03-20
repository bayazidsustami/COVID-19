package com.the_b.covid_19.main.global

import android.util.Log
import com.the_b.covid_19.api.ApiClient
import com.the_b.covid_19.model.GetGlobal
import retrofit2.Call
import retrofit2.Response

class GlobalPresenter(private val view: GlobalView) {

    fun getData() {
        view.showLoading()

        val apiClient = ApiClient.create()
        apiClient.getData().enqueue(object : retrofit2.Callback<GetGlobal> {
            override fun onResponse(call: Call<GetGlobal>, response: Response<GetGlobal>) {
                if (response.isSuccessful){
                    view.hideLoading()
                    val data = response.body()
                    view.showData(data)
                    Log.d("tag", "responsennya $data")
                }
            }

            override fun onFailure(call: Call<GetGlobal>, t: Throwable) {
                view.hideLoading()
                view.errorLoading(t.localizedMessage)
                Log.e("tag", "errornya ${t.message}")
            }

        })

    }
}