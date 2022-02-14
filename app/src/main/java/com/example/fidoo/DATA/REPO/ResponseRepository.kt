package com.example.fidoo.DATA.REPO

import com.example.fidoo.API.Network
import com.example.fidoo.API.Service
import com.example.fidoo.DATA.Data

class ResponseRepository {
    private fun getService(): Service = Network.getRetrofit().create(Service::class.java)
    suspend fun getDataFromService(): List<Data> {
        return getService().getAllResponse().data
    }
}