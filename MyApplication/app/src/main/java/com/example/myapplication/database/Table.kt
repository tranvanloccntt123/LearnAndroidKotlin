package com.example.myapplication.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Items")
class Table {
    @PrimaryKey val id : Int? = null
    @ColumnInfo(name = "value") val value : String? = null
    @ColumnInfo(name = "type") val type : Int? = null
}