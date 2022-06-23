package com.example.myapplication.viewmodal

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import java.lang.IllegalArgumentException

class DetailFactory() : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(DetailViewModal::class.java)){
            return DetailViewModal() as T
        }
        throw IllegalArgumentException("Unknow ViewModel class")
    }
}