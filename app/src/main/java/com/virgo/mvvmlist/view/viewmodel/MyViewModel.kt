package com.virgo.mvvmlist.view.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.virgo.mvvmlist.model.User
import com.virgo.mvvmlist.repository.MyRepository

class MyViewModel : ViewModel() {

    var userData = MutableLiveData<List<User>>()
    fun getUser(): LiveData<List<User>>? {
        userData = MyRepository.getUserData()!!
        return userData
    }

}