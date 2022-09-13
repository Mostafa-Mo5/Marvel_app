package com.mostafa.marvelapp.data.service

import com.mostafa.marvelapp.utilies.Constants
import com.mostafa.marvelapp.utilies.toMD5
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class WepRequest {
    val timestamp = System.currentTimeMillis().toString()
//    val hash = "$timestamp${BuildConfig.KEY}".toMD5()


    private val myClient = OkHttpClient.Builder().addInterceptor(HttpLoggingInterceptor()).build()
    private val retrofit = Retrofit.Builder()

        .baseUrl(Constants.BASE_URL)
        .client(myClient)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
        .build()


    val apiService: MarvelApiService = retrofit.create(MarvelApiService::class.java)
}