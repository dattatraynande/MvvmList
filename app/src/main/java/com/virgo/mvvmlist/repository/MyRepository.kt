package com.virgo.mvvmlist.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.virgo.mvvmlist.model.User
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object MyRepository {
    var mutableLiveData = MutableLiveData<List<User>>()

    fun getUserData() : MutableLiveData<List<User>>?{
        val call = RetrofitClient.apiInterface.getUserData()
        call.enqueue(object : Callback<List<User>>{
            override fun onFailure(call: Call<List<User>>, t: Throwable) {
                Log.v("DEBUG : ", t.message.toString())
            }

            override fun onResponse(call: Call<List<User>>, response: Response<List<User>>) {
                Log.v("DEBUG : ", response.body().toString())
                val  data = response.body()
                mutableLiveData.value = data
            }

        })
        return mutableLiveData
    }
}