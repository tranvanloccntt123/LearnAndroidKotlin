package com.example.myapplication.untils

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.adapter.ListListener
import com.example.myapplication.database.ItemDetail
import com.example.myapplication.databinding.FragmentDetailBinding
import com.example.myapplication.databinding.ItemDetailBinding

class ItemViewHolder (val binding: ItemDetailBinding) : RecyclerView.ViewHolder(binding.root){
    private var type:Int = 0
    companion object{
        fun from(parent: ViewGroup) : ItemViewHolder{
            var binding = ItemDetailBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            return ItemViewHolder(binding)
        }
    }
    public fun bind(item: ItemDetail, listListener: ListListener){
        binding.item = item
        binding.clickListener = listListener
    }
}

class ItemHeaderViewHolder(view: View) : RecyclerView.ViewHolder(view){
    private var title: TextView
    init {
        title = view.findViewById(R.id.textView)
    }
}