package com.the_b.covid_19.model

import com.google.gson.annotations.SerializedName

data class GetGlobal (
    @SerializedName("cases")
    var cases: String? = null,

    @SerializedName("deaths")
    var deaths: String? = null,

    @SerializedName("recovered")
    var recovered: String? = null
)