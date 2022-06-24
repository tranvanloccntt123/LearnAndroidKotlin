package com.example.myapplication.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.database.ITEM_TYPE_FOTTER
import com.example.myapplication.database.ITEM_TYPE_HEADER
import com.example.myapplication.database.ITEM_TYPE_MAIN
import com.example.myapplication.database.ItemDetail
import com.example.myapplication.databinding.ItemDetailBinding
import com.example.myapplication.untils.ItemHeaderViewHolder
import com.example.myapplication.untils.ItemViewHolder

class ListAdapter(val clickListenter : ListListener) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    var data = listOf<ItemDetail>()
    override fun getItemCount(): Int {
        return data.size
    }

    override fun getItemViewType(position: Int): Int {
        return when(data[position].type){
            ITEM_TYPE_HEADER -> ITEM_TYPE_HEADER
            ITEM_TYPE_FOTTER -> ITEM_TYPE_FOTTER
            else -> ITEM_TYPE_MAIN
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder){
            is ItemViewHolder -> holder.bind(data[position], clickListenter)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when(viewType){
            ITEM_TYPE_HEADER -> {
                var layoutInflater = LayoutInflater.from(parent.context)
                var view = layoutInflater.inflate(R.layout.list_header, parent, false) as View
                return ItemHeaderViewHolder(view)
            }
            else -> {
                ItemViewHolder.from(parent)
            }
        }
    }

    fun pushData(item : ItemDetail){
        data += item
        Log.i("Push data", data.size.toString())
    }
}

class ListListener(val clickListener: (id: Int) -> Unit){
    fun onClick(id: Int) = clickListener(id)
}