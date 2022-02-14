package com.example.fidoo.API

import com.example.fidoo.DATA.Response
import retrofit2.http.GET

interface Service {
    @GET("public/v1/posts")
    suspend fun getAllResponse() : Response
}