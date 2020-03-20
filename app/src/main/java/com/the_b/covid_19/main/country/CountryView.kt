package com.the_b.covid_19.main.country

import com.the_b.covid_19.model.CountryItem

interface CountryView {
    fun showLoading()
    fun hideLoading()
    fun showListData(data: List<CountryItem>?)
    fun errorLoading(message: String)
}