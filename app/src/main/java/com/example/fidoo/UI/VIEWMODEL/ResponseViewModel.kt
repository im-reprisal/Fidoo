package com.example.fidoo.UI.VIEWMODEL

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.fidoo.DATA.REPO.ResponseRepository
import com.example.fidoo.API.NetworkHelperClass
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ResponseViewModel: ViewModel() {
    private val responseRepository = ResponseRepository()
    private val mutableLiveData = MutableLiveData<NetworkHelperClass>()
    val liveData: LiveData<NetworkHelperClass> = mutableLiveData
    fun callAPi() {
        CoroutineScope(Dispatchers.IO).launch {
            val response = responseRepository.getResponseFromAPI()
            mutableLiveData.postValue(NetworkHelperClass.OnSuccess(response))
        }
    }
}