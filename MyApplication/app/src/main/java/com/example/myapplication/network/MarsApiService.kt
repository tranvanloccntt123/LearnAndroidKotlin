package com.example.myapplication.network

import com.example.myapplication.json.ConvertJson
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET
private val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()

private const val BASE_URL = "https://mars.udacity.com/"

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL).build()

interface MarsApiService{
    @GET("realestate")
    fun getProperties() : Call<List<ConvertJson>>
}

object  MarsApi {
    val retrofitServices : MarsApiService by lazy {
        retrofit.create(MarsApiService::class.java)
    }
}