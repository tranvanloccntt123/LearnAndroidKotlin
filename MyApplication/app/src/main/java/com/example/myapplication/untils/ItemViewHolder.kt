package com.example.myapplication.untils

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R

class ItemViewHolder (val view : View) : RecyclerView.ViewHolder(view){
    val textView : TextView
    init {
        textView = view.findViewById(R.id.txt_item_value)
    }
}