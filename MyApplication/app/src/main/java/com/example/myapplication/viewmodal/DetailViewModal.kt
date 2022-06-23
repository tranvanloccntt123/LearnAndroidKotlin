package com.example.myapplication.viewmodal

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class DetailViewModal() : ViewModel() {
    var score: MutableLiveData<Int> = MutableLiveData<Int>()

    init {
        Log.i("DetailViewModal", "DetailViewModal Created")
        score.value = 0
    }

    override fun onCleared() {
        super.onCleared()
        Log.i("DetailViewModal", "DetailViewModal Destroy")
    }

    fun correct(){
        score.value = score.value?.plus(1)
    }
}