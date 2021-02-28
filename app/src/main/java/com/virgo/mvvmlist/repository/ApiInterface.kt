package com.virgo.mvvmlist.repository

import com.virgo.mvvmlist.model.User
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface{

    @GET("users")
    fun getUserData() : Call<List<User>>
}