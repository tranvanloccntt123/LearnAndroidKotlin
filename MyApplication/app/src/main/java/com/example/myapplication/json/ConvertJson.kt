package com.example.myapplication.json

import com.squareup.moshi.Json

data class ConvertJson(val id: String, @Json(name = "img_src") val imgSrcUrl: String, val type: String, val price: Double)