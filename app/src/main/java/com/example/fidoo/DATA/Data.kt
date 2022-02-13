package com.example.fidoo.DATA


import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("body")
    val body: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("title")
    val title: String,
    @SerializedName("user_id")
    val userId: Int
)