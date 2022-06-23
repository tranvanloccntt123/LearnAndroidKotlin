package com.example.myapplication.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.database.ItemDetail
import com.example.myapplication.untils.ItemViewHolder

class ListAdapter : RecyclerView.Adapter<ItemViewHolder>() {
    var data = listOf<ItemDetail>()
    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = data[position]
        holder.textView.text = item.value
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.item_detail, parent, false) as View
        return ItemViewHolder(view)
    }

    fun pushData(item : ItemDetail){
        data += item
        Log.i("Push data", data.size.toString())
    }
}