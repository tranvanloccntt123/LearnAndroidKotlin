package com.example.myapplication.database

import androidx.lifecycle.LiveData

class TableRepository( private val tableDao: TableDao) {
    val readAllData : LiveData<List<Table>> = tableDao.readAllData()
    fun addTable(table: Table){
        tableDao.addTable(table)
    }
}