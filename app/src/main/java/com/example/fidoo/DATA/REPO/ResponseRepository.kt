package com.example.fidoo.DATA.REPO

import com.example.fidoo.API.Network
import com.example.fidoo.API.Service
import com.example.fidoo.DATA.Data

class ResponseRepository {
    fun getService() = Network.getRetrofit().create(Service::class.java)
    suspend fun getResponseFromAPI(): List<Data> {
       val response = getService().getAllData().data
        return response
    }
}