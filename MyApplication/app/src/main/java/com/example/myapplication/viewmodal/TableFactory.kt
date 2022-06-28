package com.example.myapplication.viewmodal

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class TableFactory(val application: Application) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(TableModel::class.java)) return TableModel(application) as T
        else throw IllegalArgumentException("Unable to construct viewmodel")
    }
}