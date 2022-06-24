package com.example.myapplication.database
val ITEM_TYPE_MAIN = 0
val ITEM_TYPE_HEADER = 1
val ITEM_TYPE_FOTTER = 2
data class ItemDetail (var type:Int = ITEM_TYPE_MAIN, var id:Int = 0, var value:String = "")