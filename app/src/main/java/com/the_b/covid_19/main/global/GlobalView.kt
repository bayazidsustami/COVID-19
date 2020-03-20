package com.the_b.covid_19.main.global

import com.the_b.covid_19.model.GetGlobal

interface GlobalView {
    fun showLoading()
    fun hideLoading()
    fun showData(data: GetGlobal?)
    fun errorLoading(message: String?)
}