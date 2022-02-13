package com.example.fidoo.API

import com.example.fidoo.DATA.Data

sealed class NetworkHelperClass {
    data class OnSuccess(val responseList: List<Data>) : NetworkHelperClass()
}