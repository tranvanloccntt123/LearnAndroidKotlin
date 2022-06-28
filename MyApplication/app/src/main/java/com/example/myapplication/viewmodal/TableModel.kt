package com.example.myapplication.viewmodal

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.MainActivity
import com.example.myapplication.database.LocalDatabase
import com.example.myapplication.database.Table
import com.example.myapplication.database.TableRepository
import kotlinx.coroutines.launch

class TableModel(application: Application) : ViewModel() {
    private val readAllData : LiveData<List<Table>>
    private val repository : TableRepository
    init {
        val tableDao = LocalDatabase.getDatabase(application).tableDao()
        repository = TableRepository(tableDao)
        readAllData = repository.readAllData
    }

    fun addTable(table : Table){
        viewModelScope.launch {
            repository.addTable(table)
        }
    }
}