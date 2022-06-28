package com.example.myapplication.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Table::class], version = 1, exportSchema = false)
abstract class LocalDatabase : RoomDatabase() {
    abstract fun tableDao() : TableDao

    companion object{
        @Volatile
        private var INSTANCE: LocalDatabase ? = null
        fun getDatabase(context: Context) : LocalDatabase{
            if(INSTANCE == null)
                INSTANCE = Room.databaseBuilder(context.applicationContext, LocalDatabase::class.java, "Database").build()
            return INSTANCE!!
        }
    }
}