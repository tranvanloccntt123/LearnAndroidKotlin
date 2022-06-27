package com.example.myapplication.viewmodal

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myapplication.json.ConvertJson
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
        MarsApi.retrofitServices.getProperties().enqueue(object : Callback<List<ConvertJson>>{
            override fun onResponse(
                call: Call<List<ConvertJson>>,
                response: Response<List<ConvertJson>>
            ) {
                _response.value = "Get Api Success with " + response.body()?.size + " items"
            }

            override fun onFailure(call: Call<List<ConvertJson>>, t: Throwable) {
                _response.value = "Failure"
            }
        })
    }
}

private fun <T> Call<T>.enqueue(callback: Callback<String>) {

}

