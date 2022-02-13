package com.example.fidoo.DATA


import com.google.gson.annotations.SerializedName

data class Response(
    @SerializedName("data")
    val `data`: List<Data>,
    @SerializedName("meta")
    val meta: Meta
)