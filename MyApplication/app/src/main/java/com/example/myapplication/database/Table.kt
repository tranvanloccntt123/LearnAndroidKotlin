package com.example.myapplication.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Items")
data class Table (
    @PrimaryKey val id : Int,
    @ColumnInfo(name = "value") val value : String,
    @ColumnInfo(name = "type") val type : Int
)