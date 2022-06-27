package com.example.myapplication

import android.widget.ImageView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

@BindingAdapter("imageUrl", requireAll = true)
fun bindingAdapter(imageView : ImageView, imageUrl : String){
    imageUrl?.let {
        val imgUri = imageUrl.toUri().buildUpon().scheme("https").build()
        Glide.with(imageView.context).load(imgUri).into(imageView)
    }

}