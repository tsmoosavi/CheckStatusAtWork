package com.example.checkstatusatwork.ui.profile

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.checkstatusatwork.data.User.UserRepository
import com.example.checkstatusatwork.model.User

class ProfileViewModel(val repository: UserRepository): ViewModel() {

    var user = repository.userInfo
//        MutableLiveData<User> ()
//    init {
//        user.value = repository.userInfo
//    }

}