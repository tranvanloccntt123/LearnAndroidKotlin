package com.example.myapplication.viewmodal

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myapplication.network.MarsApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ResourceViewModel() : ViewModel() {
    var _response : MutableLiveData<String> = MutableLiveData<String>()
    init {
        _response.value = "Set the Mars API Response here!"
    }

    fun callApi(callback : (res : String) -> Unit){
        MarsApi.retrofitServices.getProperties().enqueue(object : Callback<String>{
            override fun onResponse(call: Call<String>, response: Response<String>) {
                if(response.isSuccessful){
                    _response.value = response.body()
                }
            }

            override fun onFailure(call: Call<String>, t: Throwable) {
                _response.value = "Fail: " + t.message
            }
        })
    }
}

