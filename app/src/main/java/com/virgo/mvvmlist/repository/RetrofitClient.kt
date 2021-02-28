package com.virgo.mvvmlist.repository

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    const val MainServer = "https://5e510330f2c0d300147c034c.mockapi.io/"

    val retrofitClient : Retrofit.Builder by lazy {

        val okHttpClient = OkHttpClient.Builder()

        Retrofit.Builder()
            .baseUrl(MainServer)
            .client(okHttpClient.build())
            .addConverterFactory(GsonConverterFactory.create())

    }
    val apiInterface: ApiInterface by lazy {
        retrofitClient
            .build()
            .create(ApiInterface::class.java)
    }
}