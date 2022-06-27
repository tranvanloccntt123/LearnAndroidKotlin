package com.example.myapplication.database

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface TableDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun addTable(table: Table)
    @Query("SELECT * from Items")
    fun readAllData() : LiveData<List<Table>>
}