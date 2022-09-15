package com.mostafa.marvelapp.data.service

import android.util.Log
import com.mostafa.marvelapp.utilies.Constants
import com.mostafa.marvelapp.utilies.toMD5
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class WepRequest {


    private val retrofit = Retrofit.Builder()
        .baseUrl(Constants.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
        .build()

    val apiService: MarvelApiService = retrofit.create(MarvelApiService::class.java)
    fun Dd(){
        Log.i("TESTING",apiService.toString())
    }
}