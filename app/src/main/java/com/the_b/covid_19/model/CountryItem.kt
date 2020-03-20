package com.the_b.covid_19.model

import com.google.gson.annotations.SerializedName

data class CountryItem(
    @SerializedName("country")
    var country: String? = null,

    @SerializedName("cases")
    var cases: Int? = null,

    @SerializedName("todayCases")
    var todayCases: Int? = null,

    @SerializedName("deaths")
    var deaths: Int? = null,

    @SerializedName("todayDeaths")
    var todayDeaths: Int? = null,

    @SerializedName("recovered")
    var recovered: Int? = null,

    @SerializedName("active")
    var active: Int? = null,

    @SerializedName("critical")
    var critical: Int? = null,

    @SerializedName("casesPerOneMillion")
    var casePerOneMillion: Int? = null
)