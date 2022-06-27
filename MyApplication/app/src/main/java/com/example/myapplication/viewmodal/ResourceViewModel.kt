package com.example.myapplication.viewmodal

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bumptech.glide.Glide
import com.example.myapplication.json.ConvertJson
import com.example.myapplication.network.MarsApi
import kotlinx.coroutines.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ResourceViewModel() : ViewModel() {
    private var _response : MutableLiveData<String> = MutableLiveData<String>()
    private var _properties : MutableLiveData<String> = MutableLiveData<String>()
    val properties: LiveData<String>
        get() = _properties
    val res: LiveData<String>
        get() = _response

    init {
        _response.value = "Set the Mars API Response here!"
        _properties.value = ""
    }
    private fun getMarsRealEstateProperties(){
        runBlocking {
            coroutineScope {
                launch {
                    val getPropertiesDeferred = MarsApi.retrofitServices.getProperties()
                    try {
                        var listResult = getPropertiesDeferred.await()
                        _response.value = "Get Api Success with " + listResult?.size + " items"
                        if(listResult.size > 0){
                            _properties.value = listResult[0].imgSrcUrl
                        }

                    }catch (t: Throwable){
                        _response.value = "Failure"
                    }
                }
            }
        }
    }

    fun callApi(callback : (res : String) -> Unit){
        getMarsRealEstateProperties()
    }

    override fun onCleared() {
        super.onCleared()
        viewModelScope.cancel()
    }
}

