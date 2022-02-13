package com.example.fidoo.DATA


import com.google.gson.annotations.SerializedName

data class Links(
    @SerializedName("current")
    val current: String,
    @SerializedName("next")
    val next: String,
    @SerializedName("previous")
    val previous: Any
)